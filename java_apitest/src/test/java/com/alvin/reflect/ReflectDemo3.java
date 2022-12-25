package com.alvin.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.alvin.pojo.API;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class ReflectDemo3 {

	public static void main(String[] args) throws Exception {
		//反射API
		Class clazz1 = API.class;
		//1、创建对象
		//fastjson {id1:"1",name:"zs"} ->Student id=1 name=zs
		//newInstance()调用空参构造,空参构造是唯一
		Object object = clazz1.newInstance();
		System.out.println(object);
		//5、暴力反射 getXxx
		Field[] declaredFields = clazz1.getDeclaredFields();
		for (Field field : declaredFields) {
			field.setAccessible(true);
//			System.out.println(field);
			String name = field.getName();
			name = "set" + name.substring(0,1).toUpperCase() + name.substring(1);
//			System.out.println(name);
			Method method = clazz1.getMethod(name,field.getType());
			System.out.println(method.getName());
			//调用方法 传值
			method.invoke(object, "1");
		}
		System.out.println(object);
		//3、获取普通方法
		Method[] methods = clazz1.getMethods();
		for (Method method : methods) {
//			System.out.println(method);
		}
		
		
	}
}
