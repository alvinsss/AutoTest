package com.alvin.utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
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

import com.alibaba.fastjson.JSON;

public class HttpUtils {

	private void HttpUtils() {
	}

	/**
	 * 静态方法这工具类的作用：方便调用 直接使用类名点的方法调用 不需要创建对象 静态:共享
	 * 
	 * @param args
	 * @throws IOException
	 * @throws Exception
	 */
	public static void main(String[] args) throws IOException, Exception {
//		get("http://api.lemonban.com/futureloan/member/1/info");
//		post("http://api.lemonban.com/futureloan/member/login","{\"mobile_phone\": \"13221400113\",\"pwd\": \"12345678\"}");
//		formPost("http://test.lemonban.com/futureloan/mvc/api/member/login","mobile_phone=13221400113&pwd=12345678");
	}

	public static String call(String url, String method, String params, String contentType,Map<String,String> headers) {
		String boby=null;
		try {
			if (method.equalsIgnoreCase("post")) {
				if ("form".equalsIgnoreCase(contentType)) {
					params = jsonToKeyValue(params);
//					System.out.println(params);
					boby=HttpUtils.formPost(url, params,headers);
				} else if ("json".equalsIgnoreCase(contentType)) {
					boby=HttpUtils.post(url, params,headers);
				}
			} else if (method.equalsIgnoreCase("patch")) {
				boby=HttpUtils.get(url,headers);
			} else if (method.equalsIgnoreCase("get")) {
				boby=HttpUtils.patch(url, params,headers);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(boby);
		return boby;
	}

	private static String jsonToKeyValue(String jsonstr) {
		// {"mobilephone":"13877788811","pwd":"12345678"}
		// mobilephone=13877788811&pwd=12345678
		// json -> key=value
		// JSON->MAP->String
		Map<String, String> map1 = JSON.parseObject(jsonstr, Map.class);
		Set<String> keySet = map1.keySet();
		String result = "";
		for (String key : keySet) {
			String value = map1.get(key);
			result = result + key + "=" + value + "&";
		}
		return result.substring(0, result.length() - 1);
	}

	/**
	 * 发送get请求
	 * 
	 * @param url
	 * @throws Exception
	 * @throws IOException
	 */
	private static String get(String url,Map<String,String> headers) throws Exception, IOException {

		HttpGet get = new HttpGet(url);
 		setHeaders(get,headers);
		HttpClient client = HttpClients.createDefault();
//		HttpHost proxy = new HttpHost("127.0.0.1", 8888);
//		HttpResponse response = client.execute(proxy,get);
		HttpResponse response = client.execute(get);
		return printRespAndReturnBody(response);
	}

	/**
	 * 发送post请求
	 * 
	 * @param url
	 * @param jsonParams 需要json格式的字符串
	 * @throws Exception
	 * @throws IOException
	 */
	private static String post(String url, String jsonParams,Map<String,String> headers) throws Exception, IOException {
		HttpPost post = new HttpPost(url);
		post.setEntity(new StringEntity(jsonParams, "utf-8"));
//		post.setHeader("Authorization", "Bearer ");
		setHeaders(post,headers);
		System.out.println("请求参数:"+jsonParams);
		System.out.println(post.getEntity().toString());
		Set<String> keySet =headers.keySet();
		for (String key : keySet) {
			String v = headers.get(key);
			System.out.println(key+"-->"+v);
		}
		HttpClient client = HttpClients.createDefault();
//		response = body + header + code ,execute多态
		HttpResponse response = client.execute(post);
		return printRespAndReturnBody(response);
	}

	/**
	 * 发送formPost请求
	 * 
	 * @param url
	 * @param formParams
	 * @throws Exception
	 * @throws IOException
	 */
	private static String formPost(String url, String formParams,Map<String,String> headers) throws Exception, IOException {
		HttpPost post = new HttpPost(url);
		post.setHeader("Content-Type", "application/x-www-form-urlencodeed");
		System.out.println("formPost requset before:"+post.getAllHeaders());
		post.setEntity(new StringEntity(formParams, "utf-8"));
		setHeaders(post,headers);
		HttpClient client = HttpClients.createDefault();
//		response = body + header + code ,execute多态
		HttpResponse response = client.execute(post);
		System.out.println("formPost requset after:"+post.getAllHeaders());
		return printRespAndReturnBody(response);
	}

	/**
	 * 发送patch请求
	 * 
	 * @param url
	 * @param jsonParams
	 * @throws Exception
	 * @throws IOException
	 */
	private static String patch(String url, String jsonParams,Map<String,String> headers) throws Exception, IOException {
		HttpPatch patch = new HttpPatch(url);
		patch.setEntity(new StringEntity(jsonParams, "utf-8"));
		setHeaders(patch,headers);
		HttpClient client = HttpClients.createDefault();
//		response = body + header + code ,execute多态
		HttpResponse response = client.execute(patch);
		return printRespAndReturnBody(response);
	}

	/**
	 * 打印响应内容并返回响应体
	 * 
	 * @param response
	 * @return 响应体
	 * @throws Exception
	 * @throws IOException
	 */
	private static String printRespAndReturnBody(HttpResponse response) throws Exception, IOException {
		Header[] allHeaders = response.getAllHeaders();
		System.out.println("响应头:" + Arrays.toString(allHeaders));
		HttpEntity entity = response.getEntity();
		String body = EntityUtils.toString(entity);
		System.out.println("响应体:" + body);
		StatusLine sl = response.getStatusLine();
		int statusCode2 = sl.getStatusCode();
		int hashCode2 = sl.hashCode();
		System.out.println("状态码:" + statusCode2);
		return body;
	}
	
	public static void setHeaders(HttpRequest request,Map<String,String> headers) {
		Set<String> keySet =headers.keySet();
		for (String string : keySet) {
			request.setHeader(string,headers.get(string));
		}
	}	
}
