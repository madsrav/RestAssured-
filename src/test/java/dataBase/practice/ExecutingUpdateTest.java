package dataBase.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecutingUpdateTest {
	@Test
	public void executingUpdateTest() throws Throwable {
		Connection con = null;
		try {
			// step-1 register the driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// step-2 connect to database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");

			// step-3 create a statement
			Statement stmt = con.createStatement();

			// step-4 execute non select Query
			int result = stmt.executeUpdate("insert into students_info values(4,'sravan','kumar','mammula');");
			if (result == 1) {
				System.out.println("data added");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			// step-5 close db
			con.close();
		}
	}

}
