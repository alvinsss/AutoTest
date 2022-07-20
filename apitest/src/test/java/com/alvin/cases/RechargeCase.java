package com.alvin.cases;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alvin.pojo.API;
import com.alvin.pojo.Case;
import com.alvin.utils.EnvironmentUtils;
import com.alvin.utils.ExcelUtils;
import com.alvin.utils.HttpUtils;
import com.ctc.wstx.util.StringUtil;

public class RechargeCase  extends BaseCase{
	
	
	/**
	 * 充值用例的测试方法
	 * @param url			接口请求地址
	 * @param method		接口请求方法
	 * @param params		接口请求参数
	 * @param contentType	接口类型
	 */
	@Test(dataProvider = "datas")
	public void test(API api,Case c) {

		Map<String, String> headers = new HashMap<String,String>();
		setDefaultHeaders(headers);
		getTokenToHeader(headers);
		Set<String> keySet = headers.keySet();
		for (String key : keySet) {
			String v = headers.get(key);
			System.out.println(key +"->"+v);
		}
		HttpUtils.call(api.getUrl(), api.getMethod(), c.getParams(), api.getContentType(),headers);

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