package com.db.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.LinkedHashMap;

public class SqlDataHelper implements DataBaseHelper {
	
	private String connectionString;
	
	private Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(connectionString);
	}
	
	private Statement getStatement() throws ClassNotFoundException, SQLException{
		return getConnection().createStatement();
	}

	@Override
	public DataBaseHelper setConnectionString(String connectionString) {
		this.connectionString = connectionString;
		return this;
	}

	@Override
	public int executeUpdate(String sqlQuery) throws ClassNotFoundException, SQLException {
		return getStatement().executeUpdate(sqlQuery);
	}

	@Override
	public LinkedHashMap<Integer, LinkedHashMap<String, String>> executeQuery(String sqlQuery) throws ClassNotFoundException, SQLException {
		ResultSet result = getStatement().executeQuery(sqlQuery);
		String[] columnName = getColumnName(result);
		getDbDate(columnName, result);
		return null;
	}

	private LinkedHashMap<String,String> getDbDate(String[] columnName, ResultSet result) throws SQLException {
		LinkedHashMap<String, String> columnData = new LinkedHashMap<>();
		for(int i =0; i < columnName.length; i++) {
			columnData.put(columnName[i], getColumnData(i, result));
		}
		
		return columnData;
		
	}

	private String getColumnData(int i, ResultSet result) throws SQLException {
		int type = result.getMetaData().getColumnType(i+1);
		switch (type) {
		case Types.VARCHAR:
			return result.getString(i+1);
		case Types.NUMERIC:
			return result.getInt(i+1) +"";
		}
		return null;
	}

	private String[] getColumnName(ResultSet result) throws SQLException {
		ResultSetMetaData data = result.getMetaData();
		String[] columnName = new String[data.getColumnCount()];
		
		for(int i = 1; i<=data.getColumnCount(); i++){
			columnName[i-1] = data.getColumnName(i);
		}
		return columnName;
		
	}
}
