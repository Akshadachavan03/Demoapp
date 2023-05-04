package com.onlinetutorialspoint.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static Connection connection = null;
	
	public static Connection getConnection() throws SQLException{
		if(connection != null) {
		return connection;
		}
		else {
				String driver = "org.postgresql.Driver";
				String url = "jdbc:postgresql://localhost:5432/postgres?useSSL=false";
				String user= "postgres";
				String password= "123";
				try {
					Class.forName(driver);
					connection = DriverManager.getConnection(url, user, password);
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
		}
		
		return connection;
	}
}
