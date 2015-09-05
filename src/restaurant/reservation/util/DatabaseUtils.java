package restaurant.reservation.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DatabaseUtils {

	private final static String DB_URL = "jdbc:mysql://localhost:3306/hema_restaurant";
	private final static String DB_USER = "root";
	private final static String DB_PASSWORD = "hema1988";
	
	static {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MySQL JDBC Driver loaded successfully.");
			
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
			System.err.println("Failed to load MySQL JDBC Driver. ");
		}
		
	}
	
	public static Connection connect(){
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			System.out.println("Connection Successful");
		}catch(SQLException e){
			e.printStackTrace();
			System.err.println("Connection failed! ");
		}
		return conn;
	}
	

	public static void closeResource (PreparedStatement ps, ResultSet rs, Connection conn) {
		try {
			if(ps != null) {
				ps.close();
			}
			if(rs != null) {
				rs.close();
			}
			
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		DatabaseUtils.connect();
	}
}
