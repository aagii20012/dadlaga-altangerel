package project;

import java.sql.*;

import accounting.CreateAccountTable;

public class test {
	
	static Connection dbConnection = null;

	public static void main(String[] args) {
		DbConnection conn = new DbConnection();
		
		conn.connect();
		System.out.println(conn.hasError());
		
		CreateAccountTable table= new CreateAccountTable();
		
		table.execute(conn.dbConnection);
	}
}
