package com.scu.connecctions;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/testdb";
		String user = "admin";
		String password = "admin123";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		con = DriverManager.getConnection(url, user, password);
		System.out.println("connection done!");
		return con;
	}
}
