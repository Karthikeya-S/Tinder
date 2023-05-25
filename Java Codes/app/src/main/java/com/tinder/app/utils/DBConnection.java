package com.tinder.app.utils;

import java.sql.*;
public class DBConnection {
		static Connection conn;

		public static Connection createDBConnection() {
			try {
				// connection string
				String url = "jdbc:mysql://localhost:3306/tinder";
				String username = "root";
				String password = "Karthik1*";
				conn = DriverManager.getConnection(url, username, password);
//				System.out.println("Connection Success");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return conn;
		}
}