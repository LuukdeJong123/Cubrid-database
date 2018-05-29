package cubrid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CubridBaseDAO {
	private static Connection conn;
	
	 protected static Connection getConnection() throws SQLException, ClassNotFoundException {
		 	Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
			conn = DriverManager.getConnection("jdbc:CUBRID:localhost:30000:DP_database:dba:admin:");
	        return conn;
	 }
}

