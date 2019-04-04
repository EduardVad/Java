package com.db.helper;

import java.sql.SQLException;
import java.util.LinkedHashMap;

public interface DataBaseHelper {
	public DataBaseHelper setConnectionString(String connectionString);
	
	public int executeUpdate(String sqlQuery) throws ClassNotFoundException, SQLException;
	
	//Outer map object will have data as <row#,  MapObject>
	//Inner MapObject will have a data as <column name, column value
	public LinkedHashMap<Integer, LinkedHashMap<String, String>> executeQuery(String sqlQuery) throws ClassNotFoundException, SQLException; 
	
// Sql data --> Sql helper class implements this DataBaseHelper and provides the implementation of 3 methods
// Oracle data --> Oracle helper class implements this DataBaseHelper and provides the implementation of 3 methods
	
	//The same set of methods but different implementation --> RUN-TIME POLYMORPHISM
}
