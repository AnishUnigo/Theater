package com.anish.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/rt","root","");
		
		return conn;
	}
}
