package model.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnDB {

	public static Connection getConnection() {
		
		String url = "jdbc:mysql://localhost:3306/beduka";
		String user = "root";
		String pwd = "eli010612";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection(url,user,pwd);
			
		} 
		catch (ClassNotFoundException e) {e.printStackTrace();} 
		catch (SQLException e) {e.printStackTrace();}
		
		return null;
		
	}
	
	public static void closeConnection(Connection current_connection) {
		try {
			current_connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeStatement(Statement current_statement) {
		try {
			current_statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closePreparedStatement(PreparedStatement current_prepared_statement) {
		try {
			current_prepared_statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeResultSet(ResultSet current_result_set) {
		try {
			current_result_set.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
