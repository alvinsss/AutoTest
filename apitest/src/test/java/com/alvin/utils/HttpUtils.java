package com.alvin.utils;

import java.io.IOException;
import java.util.Arrays;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtils {
	
	private void HttpUtils() {}
	/**
	 * 静态方法这工具类的作用：方便调用 直接使用类名点的方法调用 不需要创建对象
	 * 静态:共享
	 * @param args
	 * @throws IOException
	 * @throws Exception
	 */
	public static void main(String[] args) throws IOException, Exception {
		get("http://api.lemonban.com/futureloan/member/1/info");
//		post("http://api.lemonban.com/futureloan/member/login","{\"mobile_phone\": \"13221400113\",\"pwd\": \"12345678\"}");
//		formPost("http://test.lemonban.com/futureloan/mvc/api/member/login","mobile_phone=13221400113&pwd=12345678");
	}
	
	/**
	 * 发送get请求
	 * @param url
	 * @throws Exception
	 * @throws IOException
	 */
	public static void get(String url) throws Exception, IOException {
		
		HttpGet get = new HttpGet(url);
		get.setHeader("X-Lemonban-Media-Type","lemonban.v1");
		HttpClient client = HttpClients.createDefault();
//		HttpHost proxy = new HttpHost("127.0.0.1", 8888);
//		HttpResponse response = client.execute(proxy,get);
		HttpResponse response = client.execute(get);
		printRespAndReturnBody(response);
	}
	
	/**
	 * 发送post请求
	 * @param url
	 * @param jsonParams 需要json格式的字符串
	 * @throws Exception
	 * @throws IOException
	 */
	public static void post(String url,String jsonParams) throws Exception, IOException {
		HttpPost post = new HttpPost(url);
		post.setHeader("X-Lemonban-Media-Type","lemonban.v1");
		post.setHeader("Content-Type","application/json");
		post.setEntity(new StringEntity(jsonParams,"utf-8"));
		HttpClient client = HttpClients.createDefault();
//		response = body + header + code ,execute多态
		HttpResponse response = client.execute(post);
		printRespAndReturnBody(response);
	}
	/**
	 *发送formPost请求
	 * @param url
	 * @param formParams
	 * @throws Exception
	 * @throws IOException
	 */
	public static void formPost(String url,String formParams) throws Exception, IOException {
		HttpPost post = new HttpPost(url);
		post.setHeader("Content-Type","application/x-www-form-urlencodeed");
		post.setEntity(new StringEntity(formParams,"utf-8"));
		HttpClient client = HttpClients.createDefault();
//		response = body + header + code ,execute多态
		HttpResponse response = client.execute(post);
		printRespAndReturnBody(response);
	}
	
	/**
	 * 发送patch请求
	 * @param url
	 * @param jsonParams
	 * @throws Exception
	 * @throws IOException
	 */
	public static void patch(String url,String jsonParams) throws Exception, IOException {
		HttpPatch patch = new HttpPatch(url);
		patch.setHeader("X-Lemonban-Media-Type","lemonban.v1");
		patch.setHeader("Content-Type","application/json");
		patch.setEntity(new StringEntity(jsonParams,"utf-8"));
		HttpClient client = HttpClients.createDefault();
//		response = body + header + code ,execute多态
		HttpResponse response = client.execute(patch);
		printRespAndReturnBody(response);
	}
	
	/**
	 * 打印响应内容并返回响应体
	 * @param response
	 * @return  响应体
	 * @throws Exception
	 * @throws IOException
	 */
	private static String  printRespAndReturnBody(HttpResponse response) throws Exception, IOException {
		Header[] allHeaders = response.getAllHeaders();
		System.out.println("响应头:"+Arrays.toString(allHeaders));
		HttpEntity entity = response.getEntity();
		String body = EntityUtils.toString(entity);
		System.out.println("响应体:"+body);
		StatusLine sl=response.getStatusLine();
		int statusCode2 = sl.getStatusCode();
		int hashCode2 = sl.hashCode();	
		System.out.println("状态码:"+statusCode2);
		return body;
	}
}
