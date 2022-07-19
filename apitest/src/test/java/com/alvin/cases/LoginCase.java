package com.alvin.cases;

import java.util.Arrays;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alvin.pojo.API;
import com.alvin.pojo.Case;
import com.alvin.utils.ExcelUtils;
import com.alvin.utils.HttpUtils;

public class LoginCase {
	
	
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
		HttpUtils.call(api.getUrl(), api.getMethod(), c.getParams(), api.getContentType());
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
		Object[][] datas = ExcelUtils.getAPIAndCaseByApiId("2");
		System.out.println("LoginCase datas:");
		for (Object[] objects : datas) {
			System.out.println(Arrays.toString(objects));
		}
		return datas;
	}
	
	//所以代码最先执行 初始化静态数据做准备
	@BeforeSuite
	public void init() {
		ExcelUtils.apiList = ExcelUtils.readExcel(0,1,API.class);
		ExcelUtils.caseList = ExcelUtils.readExcel(1,1,Case.class);
 
	}
}
