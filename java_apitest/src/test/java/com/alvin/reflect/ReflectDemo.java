package com.alvin.reflect;

import com.alvin.pojo.API;

public class ReflectDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		// 反射 API.class fastjson poi 
		// 运行时动态获取一个类，并可以创建对象调用方法
		API api = new API();
		Class clazz1 = API.class;
		Class clazz2 = api.getClass();
		Class clazz3 = Class.forName("com.alvin.pojo.API");
		System.out.println(clazz1);
		System.out.println(clazz2);
		System.out.println(clazz3);
		System.out.println(clazz1 == clazz2);
		System.out.println(clazz2 == clazz3);


	}
}
