package com.alvin.cases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alvin.utils.ExcelUtils;
import com.alvin.utils.HttpUtils;

public class RegisterCase {
	
	
	/**
	 * 注册用例的测试方法
	 * @param url			接口请求地址
	 * @param method		接口请求方法
	 * @param params		接口请求参数
	 * @param contentType	接口类型
	 */
	@Test(dataProvider = "datas")
	public void test(String url,String method,String params,String contentType) {
//		1、参数化替换
//		2、数据库前置查询结果(数据断言必须在接口执行前后都查询)
//		3、调用接口
		HttpUtils.call(url, method, params, contentType);
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
		return null;
	}
	
	
}
