package util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBconn {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@db.johnco.site:1521:xe", "JSPUSER", "JSPUSER"); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void main(String[] args) {
		getConnection();
	}
}
