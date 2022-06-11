package user;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUserTable{
	public String createUserQuery = "CREATE TABLE IF NOT EXISTS Users ("
			+ "	user_id serial PRIMARY KEY,"
			+ "	username VARCHAR ( 50 ) UNIQUE NOT NULL,"
			+ "	password VARCHAR ( 50 ) NOT NULL,"
			+ "	email VARCHAR ( 255 ) UNIQUE NOT NULL);";

	public String execute(Connection conn) {
		// TODO Auto-generated method stub
		try {
			Statement statement = conn.createStatement();
			
			statement.execute(createUserQuery);
			return "Table Created";
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "An error has occured on Table Creation";
		}
	}

}
