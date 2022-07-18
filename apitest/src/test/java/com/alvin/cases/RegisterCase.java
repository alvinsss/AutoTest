package com.alvin.cases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alvin.utils.ExcelUtils;
import com.alvin.utils.HttpUtils;

public class RegisterCase {

	@Test(dataProvider="datas")
	public void test(String url ,String method,String params) {

			try {
				if (method.equalsIgnoreCase("post")) {
					HttpUtils.post(url, params);
				}else if(method.equalsIgnoreCase("patch")) {
					HttpUtils.get(url);
				}else if (method.equalsIgnoreCase("get")) {
					HttpUtils.patch(url, params);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
