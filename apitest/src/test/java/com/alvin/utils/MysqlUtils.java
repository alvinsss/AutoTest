package com.alvin.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.alvin.pojo.Member;

 
public class MysqlUtils {
	
	
	public static void main(String[] args) throws Exception {
		queryBeanHander();
	}

	private static void queryObjects() throws SQLException {
		QueryRunner qr = new QueryRunner();
		Connection conn = JDBCUtils.getConnection();
		Object[] objects = qr.query(conn,"select * from xinxibiao x WHERE x.xuhao='1';", new ArrayHandler());
	
		for (Object object : objects) {
			System.out.println(object);
		}
		
		JDBCUtils.close(conn);
	}
	
	private static void queryBeanHander() throws SQLException {
		QueryRunner qr = new QueryRunner();
		Connection conn = JDBCUtils.getConnection();
		//new BeanHandler<Member>(Member.class) 结果及处理对象，使用BeanHandler需要pojo创建实体类对象
		Member member = qr.query(conn,"select * from member m WHERE m.id=1 ;", new BeanHandler<Member>(Member.class));
		System.out.println(member);
		JDBCUtils.close(conn);
	}
	
	
}
