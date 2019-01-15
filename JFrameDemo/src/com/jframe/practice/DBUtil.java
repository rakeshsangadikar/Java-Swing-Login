package com.jframe.practice;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public static Connection getConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			System.out.println("Connecting to database...\nPlease Wait...");
			Connection conn = DriverManager.getConnection(url, "system", "system");
			if(conn!=null) System.out.println("CONNECTED!");
			else {
				System.out.println("Connection Failed!");
				System.out.println("<-PROGRAM TERMINATED->");
				System.exit(0);
			}
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection Failed");
			return null;
		} 
		
	}
}
