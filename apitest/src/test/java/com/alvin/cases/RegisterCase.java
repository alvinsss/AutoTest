package com.alvin.cases;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alvin.constants.Constants;
import com.alvin.pojo.API;
import com.alvin.pojo.Case;
import com.alvin.utils.ExcelUtils;
import com.alvin.utils.HttpUtils;
import com.alvin.utils.MysqlUtils;

public class RegisterCase extends BaseCase{
	
	
	/**
	 * 注册用例的测试方法
	 * @param url			接口请求地址
	 * @param method		接口请求方法
	 * @param params		接口请求参数
	 * @param contentType	接口类型
	 */
	@Test(dataProvider = "datas")
	public void test_RegisterCase(API api,Case c) {	
		
		String params = paramsReplace(c.getParams());
		c.setParams(params);
		String sql = paramsReplace(c.getSql());
		c.setSql(sql);
		System.out.println("test_RegisterCase"+c.getParams());
		
		Object beforeSQLReuslt = MysqlUtils.getSQLSingleReuslt(c.getSql());

		Map<String, String> headers = new HashMap<String, String>();
		
		//3.1、设置默认请求头
		setDefaultHeaders(headers);
		String body = HttpUtils.call(api.getUrl(), api.getMethod(), c.getParams(), api.getContentType(),headers);

//		4、断言响应结果
		String reponseAssert = responseAssert(c.getExpect(), body);

//		5、添加接口响应回写内容
		writeBackData(1, c.getId(), Constants.ACTUAL_RESPONSE_CELLNUM, body);
		
//		6、数据库后置查询结果
		Object afterSQLReuslt = MysqlUtils.getSQLSingleReuslt(c.getSql());
		System.out.println("test_RegisterCase  c.getSql() "+c.getSql());
		System.out.println("test_RegisterCase  beforeSQLReuslt---"+beforeSQLReuslt+"-->"+afterSQLReuslt);

//		7、据库断言
		if(StringUtils.isNotBlank(c.getSql())) {
			boolean sqlAssertFlag = sqlAssert(beforeSQLReuslt, afterSQLReuslt);
			System.out.println("数据库断言：" + sqlAssertFlag);
			writeBackData(1, c.getId(), Constants.SQL_ASSERT_CELLNUM, sqlAssertFlag?"断言成功":"断言失败");
		}
//		8、添加断言回写内容
		System.out.println("test_RegisterCase responseAssert 断言响应结果："+reponseAssert);
		writeBackData(1, c.getId(), Constants.RESPONSE_ASSERT_CELLNUM, reponseAssert);

//		9、添加日志
//		10、报表断言
	}
	
	/**
	 * 	数据库断言
	 * @param beforeSQLReuslt	接口执行之前的数据结果
	 * @param afterSQLReuslt	接口执行之后的数据结果
	 * @return
	 */
	public boolean sqlAssert(Object beforeSQLReuslt,Object afterSQLReuslt) {
		Long beforeValue = (Long)beforeSQLReuslt;
		Long afterValue = (Long)afterSQLReuslt;
		if(beforeValue != null && afterValue != null && beforeValue == 0 && afterValue == 1) {
			//接口执行之前手机号码统计为0，执行之后手机号码统计为1，断言成功
			return true;
		}
		return false;
	}

	
	@DataProvider
	public Object[][] datas() {
//		Object[][] datas = ExcelUtils.read();
//		return datas;  
		//1是注册
		Object[][] datas = ExcelUtils.getAPIAndCaseByApiId("1");
		return datas;
	}
	
	
}
