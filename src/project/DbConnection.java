package project;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DbConnection {
	private String jdbcUrl = "jdbc:postgresql://localhost:5432/dadlaga" ;
	private String username = "postgres" ;
	private String password = "99201012" ;
	public Connection dbConnection = null;
	public String error = "";
	
	public void connect() {
		try {
			dbConnection = DriverManager.getConnection(jdbcUrl, username, password); 
		}
		catch (SQLException e){
			error = e.toString();
		}
		
	}
	
	public void close() {
		try {
			dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String hasError() {
		return error;
	}
	
}
