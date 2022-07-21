package com.alvin.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang3.StringUtils;

import com.alvin.pojo.Member;

 
public class MysqlUtils {
	
	
	public static void main(String[] args) throws Exception {
		getSQLSingleReuslt("SELECT  name from member WHERE id=1");
	}

	/**
	 * 	根据sql语句执行查询单个结果集
	 * @param sql	sql语句
	 * @return
	 */
	public static Object getSQLSingleReuslt(String sql) {
		//1、如果sql语句为空，不执行sql查询
		if(StringUtils.isBlank(sql)) {
			return null;
		}
		//2、DBUtils操作sql语句核心类
		QueryRunner qr = new QueryRunner();
		//3、获取数据库连接
		Connection conn = JDBCUtils.getConnection();
		//3.1、定义返回值
		Object result = null;
		try {
			//4、执行sql语句
			result = qr.query(conn,sql,new ScalarHandler<Object>());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
	private static void getqueryArrayHandler(String sql) throws SQLException {
		QueryRunner qr = new QueryRunner();
		Connection conn = JDBCUtils.getConnection();
		Object[] objects = qr.query(conn,sql, new ArrayHandler());
	
		for (Object object : objects) {
			System.out.println(object);
		}
		
		JDBCUtils.close(conn);
	}
	private static void getqueryBeanHander(String sql) throws SQLException {
		QueryRunner qr = new QueryRunner();
		Connection conn = JDBCUtils.getConnection();
		//new BeanHandler<Member>(Member.class) 结果及处理对象，使用BeanHandler需要pojo创建实体类对象
		Member member = qr.query(conn,sql, new BeanHandler<Member>(Member.class));
		System.out.println(member);
		JDBCUtils.close(conn);
	}
	
	
}
