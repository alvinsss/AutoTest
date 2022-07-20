package com.alvin.cases;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alvin.pojo.API;
import com.alvin.pojo.Case;
import com.alvin.utils.EnvironmentUtils;
import com.alvin.utils.ExcelUtils;
import com.alvin.utils.HttpUtils;
import com.ctc.wstx.util.StringUtil;

public class RechargeCase {
	
	
	/**
	 * 注册用例的测试方法
	 * @param url			接口请求地址
	 * @param method		接口请求方法
	 * @param params		接口请求参数
	 * @param contentType	接口类型
	 */
	@Test(dataProvider = "datas")
	public void test(API api,Case c) {
//		1、参数化替换
//		2、数据库前置查询结果(数据断言必须在接口执行前后都查询)
//		3、调用接口
		Map<String, String> headers = new HashMap<String,String>();
		headers.put("X-Lemonban-Media-Type", "lemonban.v2");
		headers.put("Content-Type", "application/json");
		//取出环境全局变量值给token
		String token = EnvironmentUtils.env.get("${token}");
		if (StringUtils.isNotBlank(token)) {
			//Bearer 有空格
			headers.put("Authorization", "Bearer "+token);
		}
		HttpUtils.call(api.getUrl(), api.getMethod(), c.getParams(), api.getContentType(),headers);
//		4、断言响应结果
//		5、添加接口响应回写内容
//		6、数据库后置查询结果
//		7、据库断言
//		8、添加断言回写内容
//		9、添加日志
//		10、报表断言
	}

	
	@DataProvider
	public Object[][] datas() {
//		Object[][] datas = ExcelUtils.read();
//		return datas;
		System.out.println("RechargeCase datas:");
		Object[][] datas = ExcelUtils.getAPIAndCaseByApiId("3");
		for (Object[] objects : datas) {
			System.out.println(Arrays.toString(objects));
		}
		return datas;
	}
	
	
}
