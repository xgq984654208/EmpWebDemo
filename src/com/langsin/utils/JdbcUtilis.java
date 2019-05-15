package com.langsin.utils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtilis {


	public static Connection getConnection() {
		// TODO Auto-generated method stub
		// 创建数据库连接池实例对象
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		
		try {
			// 设置数据库连接所需要的驱动
			cpds.setDriverClass("com.mysql.jdbc.Driver");
			// 设置连接数据库的URL
			cpds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/e500?useUnicode=true&characterEncoding=UTF-8");
	//设置连接数据库的用户名
			cpds.setUser("root");
	//设置连接数据库的密码
			cpds.setPassword("984654208");
	
			return cpds.getConnection();
		} catch (Exception e) {  
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 获取数据库连接
		
		
		return null;

	}

	public static void release(PreparedStatement pre, ResultSet set, Connection conn) {
		try {
			if (set != null) {
				set.close();
			}
			if (pre != null) {
				pre.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
