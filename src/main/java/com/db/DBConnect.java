package com.db;

import java.sql.DriverManager;
import java.sql.Connection;

public class DBConnect {
	private static Connection conn;
	
	public static Connection getConn()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_system","root","Tushar123789");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
