package com.alvin.constants;

import java.util.ArrayList;

public class Constants {
	
	//常量=恒定不变 final修饰类不能被继承，修饰方法不能被重写 修饰变量变成常量
	// 常量只能赋值一次 基本类型不能改变 引用数据地址值不能改变 但是可以调用方法
	public static final String EXCEL_PATH="src/test/resources/cases_v5.xlsx";
 
	public static final String MEDIA_TYPE="lemonban.v2";
	public static final String CONTENT_TYPE="application/json";

	
	public static final int ACTUAL_RESPONSE_CELLNUM=5;
	public static final int RESPONSE_ASSERT_CELLNUM=6;
	public static final int SQL_ASSERT_CELLNUM=8;

	//jdbc:oracle:thin:@localhost:1521:orcl 
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/futureloan?useUnicode=true&characterEncoding=utf-8";
	public static final String JDBC_USERNAME = "qa";
	public static final String JDBC_PASSWORD = "qatest";
	
	public static final String PARAM_MOBILE = "${mobile_phone}";
	public static final String PARAM_PASSWORD = "${pwd}";

	
}
