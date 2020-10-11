package com.toyshops.com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

	static private String driver = "com.mysql.jdbc.Driver";
	static private String url = "jdbc:mysql://localhost/toyshop";
	static private String uname = "root";
	static private String pass = "";
	
	private static Connection connection;
	
	private DAO() {
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		if(connection == null) {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, uname, pass);
		}
		return connection;
	}
	
	
	
}
