package com.alvin.cases;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.alibaba.fastjson.JSONPath;
import com.alvin.constants.Constants;
import com.alvin.pojo.API;
import com.alvin.pojo.Case;
import com.alvin.pojo.Member;
import com.alvin.pojo.WriteBackData;
import com.alvin.utils.EnvironmentUtils;
import com.alvin.utils.ExcelUtils;
import com.alvin.utils.MysqlUtils;
 
public class BaseCase {
	
	
	/**设置默认请求头
	 * @param headers  
	 * 
	 */
	public   void setDefaultHeaders(Map<String, String> headers ) {
 		headers.put("X-Lemonban-Media-Type", Constants.MEDIA_TYPE);
		headers.put("Content-Type", Constants.CONTENT_TYPE);
	}
	
	/**
	 * 设置变量到环境变量中
	 * @param body
	 * @param jsonPath
	 * @param envKey
	 */
	public void setVariableInEnv(String body,String jsonPath,String envKey) {
		Object token = JSONPath.read(body, jsonPath);
		// 防止只有member_id没有token值
 		if (token != null) {
			EnvironmentUtils.env.put(envKey,token.toString());
		}
	}
	
	/***
	 * 从环境变量获取token设置到Headers中
	 * @param headers
	 */
	public void getTokenToHeader(Map<String, String> headers) {
		String token = EnvironmentUtils.env.get("${token}");
		if (StringUtils.isNotBlank(token)) {
			//Bearer 后有空格 规则要求
			headers.put("Authorization", "Bearer "+token);
		}
	}
	
	/**
	 * 添加wbd回写对象到wbdList集合中。
	 * @param sheetIndex		回写sheetIndex
	 * @param rowNum			回写行号
	 * @param cellNum			回写列号
	 * @param content			回写内容
	 */
	public void writeBackData(int sheetIndex,int rowNum,int cellNum, String content) {
		WriteBackData wbd = new WriteBackData(sheetIndex, rowNum, cellNum, content);
		ExcelUtils.wbdList.add(wbd);
	}
	
	
	/**
	 * 响应断言
	 * @param expect
	 * @param body
	 * @return
	 */
	public String responseAssert(String expect, String body) {
			//按照@@切割期望断言
			String[] expectArray = expect.split("@@");
			//定义返回值
			String reponseAssertFlag = " ";
			//循环期望值切割之后的数组
			for (String expectValue : expectArray) {
//				如果响应体包含期望值 断言为成功,flag为true
				boolean flag = body.contains(expectValue) ;
				System.out.println("responseAssert flag"+flag);
//				如果不包含期望值 判断断言失败flag为false
				if ( flag == false) {
					System.out.println("期望值"+expectValue +"不在相同体里");
					 reponseAssertFlag = "断言失败";
					 break;
				}
				reponseAssertFlag = "断言成功";
			}
			return reponseAssertFlag;
		}

	/**
	 * 	参数化替换方法
	 * @param params	需要替换的字符串
	 * @return			替换之后的字符串
	 */
	public String paramsReplace(String params) {
		//如果参数为null，返回参数本身
		if(StringUtils.isBlank(params)) {
			return params;
		}
		//1、从环境变量中获取所有的占位符
		Set<String> keySet = EnvironmentUtils.env.keySet();
		//2、遍历环境变量env
		for (String key : keySet) {
			//3、key就是参数化的占位符${xxxx} value参数化具体要替换的值。
			//4、把需要替换的字符串执行replace(key,value);
			String value = EnvironmentUtils.env.get(key);
			//5、替换并且重新接受
			params = params.replace(key, value);
		}
		return params;
	}
	
	//所以代码最先执行 初始化静态数据做准备,testng的注解属性特性
	@BeforeSuite
	public void init() {
		System.out.println("=======================项目初始化============================");
		Member randomMember = MysqlUtils.getRandomMember();
		ExcelUtils.apiList = ExcelUtils.readExcel(0, 1, API.class);
		ExcelUtils.caseList = ExcelUtils.readExcel(1, 1, Case.class);
		EnvironmentUtils.env.put(Constants.PARAM_MOBILE, EnvironmentUtils.getRegisterPhone());
		EnvironmentUtils.env.put(Constants.PARAM_PASSWORD,randomMember.getPassword());
//		EnvironmentUtils.env.put(Constants.PARAM_TOKEN,"aaabbb123");
//		EnvironmentUtils.env.put(Constants.PARAM_MEMBER_ID,"7795111");

	}
	
	@AfterSuite
	public void finish() {		
		System.out.println("=======================项目结束============================");
		ExcelUtils.batchWrite();
	}
}
