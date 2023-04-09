package dataBase.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecutingQueryTest {
	
	
	@Test
	public void executingQueryTest() throws Throwable
	{
		Connection con = null;
		try {
			
			//step-1 register the driver
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);

			
			//step-2 connect to database
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			
			//step-3 create a statement
			Statement stmt = con.createStatement();
			
			//Step-4 execute our query
			ResultSet result = stmt.executeQuery("select * from students_info;");
			
			while(result.next())
			{
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		finally {
			//step-5 close db connection
			con.close();
		}		
	}
	}

