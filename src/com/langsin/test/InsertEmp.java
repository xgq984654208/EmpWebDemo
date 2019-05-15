package com.langsin.test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.langsin.utils.JdbcUtilis;


public class InsertEmp {
	public static void main(String[] args) {
		Connection connection = JdbcUtilis.getConnection();
		PreparedStatement pre = null;
		try {

			connection.setAutoCommit(false);
			String sql = "insert into user values(?,?)";
			pre = connection.prepareStatement(sql);

			for (int i = 0; i < 10; i++) {
				
				pre.setString(1, "li"+i);
				pre.setString(2, "root"+i);
		
				pre.executeUpdate();
				
				
			}

			connection.commit();

		} catch (Exception e) {
			// TODO: handle exception
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			JdbcUtilis.release(pre, null, connection);
		}
		
	}
}
