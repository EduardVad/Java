package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;




public class DbConnection {

	public static void main(String[] args) throws SQLException {
		
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		String connectUrl = "jdbc:mysql://localhost:3306/sakila?user=root&password=Admin1";
		
				//"jdbc:mysql://localhost:1111/db?user=user&password=password
		Connection connection = null;
		Statement statement = null;
		ResultSet result;
		ResultSetMetaData data = null;
		
		//String deleteQuery = "DELETE from actor where actor_id = 1";
		String updateQuery = "UPDATE actor SET last_name = 'CRUZ' WHERE actor_id = 1";
		String insertQuery = "INSERT INTO actor (first_name, last_name, last_update) VALUES"
				+ "('THORA', 'TEMPLE', '2006-02-15 04:34:33')";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(connectUrl);
			statement = connection.createStatement();
			//int count = statement.executeUpdate(updateQuery);
			int count = statement.executeUpdate(insertQuery);
			System.out.println("Updated " + count + " rows");
			result = statement.executeQuery("SELECT * FROM actor");
			//statement.executeUpdate(deleteQuery); //delete Query
			
			data = result.getMetaData();
			String[] columnName = new String[data.getColumnCount()];
			
			for(int i=1; i<=data.getColumnCount(); i++) {
				columnName[i-1] = data.getColumnName(i);
			//	System.out.println(columnName[i]);
			}
			
			while(result.next()) {
				System.out.println(String.format("%d - %s, %s : %s", result.getInt(1), result.getString(2), result.getString(3), result.getString(4)));
			};
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			statement.close();
			connection.close();
		}
		
		
//		try {
//			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

	}

}
