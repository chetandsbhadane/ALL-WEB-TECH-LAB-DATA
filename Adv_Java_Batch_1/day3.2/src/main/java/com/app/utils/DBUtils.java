package com.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection connection;

	public static void openConnection(String dbURL, String userName, String pwd) throws SQLException {

		// get conneciton form DB : mandatory!
		connection = DriverManager.
				getConnection(dbURL, userName, pwd);// fixed connectivity

	}
	

	public static Connection getConnection() {
		return connection;
	}


	// add a static method to close connection
	public static void closeConnection() throws SQLException {
		if (connection != null)
			connection.close();
		System.out.println("db cn closed !");
	}
}
