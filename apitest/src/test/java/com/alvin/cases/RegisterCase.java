package com.alvin.cases;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alvin.utils.ExcelUtils;
import com.alvin.utils.HttpUtils;
 
public class RegisterCase {

	@Test(dataProvider="datas")
	public void test(String url ,String method,String params,String contentType) {

			try {
				if (method.equalsIgnoreCase("post")) {
					if ("form".equalsIgnoreCase(contentType)) {
						params=jsonToKeyValue(params);
						System.out.println(params);
						HttpUtils.formPost(url, params);
					}else if("json".equalsIgnoreCase(contentType)) {
						HttpUtils.post(url, params);
					}
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
	
	private String jsonToKeyValue(String jsonstr) {
			//		{"mobilephone":"13877788811","pwd":"12345678"}   mobilephone=13877788811&pwd=12345678
			//        json          ->  key=value  
			//JSON->MAP->String
		Map<String,String> map1 = JSON.parseObject(jsonstr,Map.class);
			Set <String> keySet = map1.keySet();
			String result ="";
			for(String key:keySet) {
			String value = map1.get(key);
			result = result + key+ "=" + value + "&";
		}
		return result.substring(0,result.length()-1);
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
