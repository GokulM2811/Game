package tik_tak_toe;

import java.sql.*;

public class DBHandler {
	
	Connection con;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYS as SYSDBA","Gokul@2811");
		return con;
	}
	
	public void closeConnection() throws SQLException {
		con.close();
	}

}
