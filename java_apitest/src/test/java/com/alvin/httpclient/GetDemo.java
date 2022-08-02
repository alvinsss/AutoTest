/**
* @Title: GetDemo
* @Description: 
* @author: alvin
* @date 2022年7月18日 上午9:07:20
*/
package com.alvin.httpclient;

import java.io.IOException;
import java.util.Arrays;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author:alvin
 *
 */
public class GetDemo {
	public static void main(String[] args) throws Exception, IOException {
		HttpGet get = new HttpGet("http://api.lemonban.com/futureloan/member/1/info");
		get.setHeader("X-Lemonban-Media-Type","lemonban.v1");
		HttpClient client = HttpClients.createDefault();
//		response = body + header + code ,execute多态
		HttpResponse response = client.execute(get);
		Header[] allHeaders = response.getAllHeaders();
		//数组工具类遍历
		System.out.println("响应头:"+Arrays.toString(allHeaders));
		HttpEntity entity = response.getEntity();
		String body = EntityUtils.toString(entity);
		System.out.println("响应体:"+body);
//		int statusCode = response.getStatusLine().getStatusCode();
//		int hashCode = response.getStatusLine().hashCode();
		StatusLine sl=response.getStatusLine();
		int statusCode2 = sl.getStatusCode();
		int hashCode2 = sl.hashCode();	
		System.out.println("状态码:"+statusCode2);
	}
 
}