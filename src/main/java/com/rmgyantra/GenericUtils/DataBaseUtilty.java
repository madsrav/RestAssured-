package com.rmgyantra.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtilty {
	
	public Connection con;

	public void createConnectionDB() throws SQLException
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	}
	
	public void closeCOnDB() throws Exception
	{
		con.close();
	}
	
	public ResultSet executeQuery(String Query) throws Throwable
	{
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery(Query);
		return result;
	}
}
