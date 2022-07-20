package com.alvin.cases;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONPath;
import com.alvin.constants.Constants;
import com.alvin.utils.EnvironmentUtils;

public class BaseCase {
	
	/**设置默认请求头
	 * @param headers  
	 * 
	 */
	public   void setDefaultHeaders(Map<String, String> headers ) {
 		headers.put("X-Lemonban-Media-Type", Constants.MEDIA_TYPE);
		headers.put("Content-Type", "application/json");
	}
	
	/**
	 * 设置变量到环境变量中
	 * @param body
	 * @param jsonPath
	 * @param envKey
	 */
	public void setVariableInEnv(String body,String jsonPath,String envKey) {
		Object token = JSONPath.read(body, jsonPath);
		// 防止只有member_id没有token值
 		if (token != null) {
			EnvironmentUtils.env.put(envKey,token.toString());
		}
	}
	/***
	 * 从环境变量获取token设置到Headers中
	 * @param headers
	 */
	public void getTokenToHeader(Map<String, String> headers) {
		String token = EnvironmentUtils.env.get("${token}");
		if (StringUtils.isNotBlank(token)) {
			//Bearer 后有空格 规则要求
			headers.put("Authorization", "Bearer "+token);
		}
	}
	
}
