package com.alvin.cases;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONPath;
import com.alvin.constants.Constants;
import com.alvin.pojo.API;
import com.alvin.pojo.Case;
import com.alvin.utils.EnvironmentUtils;
import com.alvin.utils.ExcelUtils;
import com.alvin.utils.HttpUtils;
import com.alvin.utils.MysqlUtils;

public class RechargeCase extends BaseCase {
	
	
	
	@Test(dataProvider = "datas")
	public void test_RechargeCase(API api,Case c) {	
		//1、参数化替换
		//2、数据库前置查询结果(数据断言必须在接口执行前后都查询)
		Object beforeSQLReuslt = MysqlUtils.getSQLSingleReuslt(c.getSql());
		//3、调用接口
		Map<String, String> headers = new HashMap<String, String>();
		//3.1、设置默认请求头
		setDefaultHeaders(headers);
		//3.2、获取token
		System.out.println(EnvironmentUtils.env);
		getTokenToHeader(headers);
		String body = HttpUtils.call(api.getUrl(), api.getMethod(), c.getParams(), api.getContentType(),headers);
		//4、断言响应结果
		String reponseAssert = responseAssert(c.getExpect(), body);
		//5、添加接口响应回写内容
		writeBackData(1, c.getId(), Constants.ACTUAL_RESPONSE_CELLNUM, body);
		//6、数据库后置查询结果
		Object afterSQLReuslt = MysqlUtils.getSQLSingleReuslt(c.getSql());
		//7、据库断言
		if(StringUtils.isNotBlank(c.getSql())) {
			boolean sqlAssertFlag = sqlAssert(beforeSQLReuslt, afterSQLReuslt,c);
			System.out.println("test_ RechargeCase数据库断言：" + sqlAssertFlag);
			writeBackData(1, c.getId(), Constants.SQL_ASSERT_CELLNUM, sqlAssertFlag?"断言成功":"断言失败");
		}
		//8、添加断言回写内容
		System.out.println("test_RechargeCase responseAssert 断言响应结果："+reponseAssert);
		writeBackData(1, c.getId(), Constants.RESPONSE_ASSERT_CELLNUM, reponseAssert);

		//9、添加日志
		//10、报表断言
	}

		
 

	/**
	 * 	数据库断言
	 * @param beforeSQLReuslt	接口执行之前的数据结果
	 * @param afterSQLReuslt	接口执行之后的数据结果
	 * @return
	 */
	public boolean sqlAssert(Object beforeSQLReuslt,Object afterSQLReuslt,Case c) {
		//1、从excel的getParams参数中获取amount的值
		String params = c.getParams();
		String amount = JSONPath.read(params, "$.amount").toString();
		//2、把amount转成 BigDecimal
		BigDecimal amountValue = new BigDecimal(amount);
		//3、beforeSQLReuslt和afterSQLReuslt 转成 BigDecimal
		BigDecimal beforeValue = (BigDecimal)beforeSQLReuslt;
		BigDecimal afterValue = (BigDecimal)afterSQLReuslt;
		//4、afterValue - beforeValue = 实际的充值金额
		BigDecimal subtractResult = afterValue.subtract(beforeValue);
		//5、参数amount（期望值） 和 subtractResult（实际值） 进行比较，如果是0说明相等
		System.out.println(subtractResult);
		System.out.println(amountValue);
		if(subtractResult.compareTo(amountValue) == 0) {
			return true;
		}
		return false;
	}

	@DataProvider
	public Object[][] datas() {
//		Object[][] datas = ExcelUtils.read();
//		return datas;
		Object[][] datas = ExcelUtils.getAPIAndCaseByApiId("3");
		return datas;
	}
	
	
}
