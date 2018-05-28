package cubrid;

import java.sql.*;

public class cubrid_connectie{
	public static void main(String[] args) throws Exception {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {
		// Connect to CUBRID
		Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
		conn = DriverManager.getConnection("jdbc:CUBRID:localhost:30000:DP_database:dba:admin:");
		String sql = "SELECT postcode, huisnummer FROM adres";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			String name = rs.getString("postcode");
			String players = rs.getString("huisnummer");
			System.out.println("postcode ==> " + name);
			System.out.println("huisnummer==> " + players);
			
		}
		rs.close();
		stmt.close();
		conn.close();
		} catch ( SQLException e ) {
			System.err.println(e.getMessage());
		} catch ( Exception e ) {
			System.err.println(e.getMessage());
		} finally {
			if ( conn != null ) conn.close();
		}
	}
}
