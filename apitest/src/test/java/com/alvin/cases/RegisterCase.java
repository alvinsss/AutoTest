package com.alvin.cases;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.alvin.utils.ExcelUtils;
import com.alvin.utils.HttpUtils;
 
public class RegisterCase {

	@Test(dataProvider="datas")
	public void test(String url ,String method,String params,String contentType) {
		HttpUtils.call(url, method, params, contentType);
	}

	
	@DataProvider
	public Object[][] datas() throws Exception, IOException, Exception {
		Object[][] datas = ExcelUtils.read();
		return datas;
	}
	
	@DataProvider
	public Object[][] datas2() {
		
		Object[][] datas= {
				{"http://api.lemonban.com/futureloan/member/register",
						"post",
						"{\"mobile_phone\": \"13221410113\",\"pwd\": \"12345678\"}"
				 },
				{"http://api.lemonban.com/futureloan/member/register",
					 "post",
					 "{\"mobile_phone\": \"13221420113\",\"pwd\": \"12345678\"}"
				},
				{"http://api.lemonban.com/futureloan/member/register",
					 "post",
					 "{\"mobile_phone\": \"13221430113\",\"pwd\": \"12345678\"}"
				}
				
		};
		return datas;
		
	}
	
}
