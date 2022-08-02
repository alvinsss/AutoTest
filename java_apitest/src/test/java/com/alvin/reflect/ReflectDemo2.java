package com.alvin.reflect;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.alvin.pojo.API;

public class ReflectDemo2 {

	public static void main(String[] args) throws Exception {
		//反射API
		Class clazz1 = API.class;
		//1、创建对象
		//newInstance()调用空参构造,空参构造是唯一
		Object object = clazz1.newInstance();
		//2、获取构造方法
		Constructor[] constructors = clazz1.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor);
//			constructor.newInstance();
		}
		//3、获取普通方法
		Method[] methods = clazz1.getMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		//4、获取成员变量
		Field[] fields = clazz1.getFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		//5、暴力反射 getXxx
		Field[] declaredFields = clazz1.getDeclaredFields();
		for (Field field : declaredFields) {
			field.setAccessible(true);
			System.out.println(field);
		}
	}
}
