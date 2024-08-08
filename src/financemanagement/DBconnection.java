package financemanagement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBconnection {
	private static final String driver_path = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/financemanagement";
	private static final String userName = "root";
	private static final String passWord = "root123";
	
	public  DBconnection() {
		try {
			Class.forName(driver_path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, userName, passWord);
	}

	public PreparedStatement prepareStatement(String query) {
		// TODO Auto-generated method stub
		return null;
	}
}
