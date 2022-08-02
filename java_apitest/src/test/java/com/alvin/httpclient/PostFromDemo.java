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
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.StringEntity;
/**
 * @author:alvin
 *
 */
public class PostFromDemo {
	public static void main(String[] args) throws Exception, IOException {
 	
		HttpPost post = new HttpPost("http://test.lemonban.com/futureloan/mvc/api/member/login");
		post.setHeader("X-Lemonban-Media-Type", "lemonban.v1");
		post.setHeader("Content-Type", "application/x-www-form-urlencoded");
		//key1=value1&key2=value2
		String json = "mobilephone=13221400113&pwd=12345678";
		post.setEntity(new StringEntity(json,"utf-8"));
		
		HttpClient client = HttpClients.createDefault();
//		response = body + header + code ,execute多态
		HttpResponse response = client.execute(post);
		Header[] allHeaders = response.getAllHeaders();
		//数组工具类遍历
		System.out.println("响应头:"+Arrays.toString(allHeaders));
		HttpEntity entity = response.getEntity();
		String body = EntityUtils.toString(entity);
		System.out.println("响应体:"+body);
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("状态码:"+statusCode);
	}
 
}