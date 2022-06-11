package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserSignUp implements UserSignCreate {
	public String insertUser = " Insert into Users (username, password, email)"
		    + " values (?, ?, ?)";

	@Override
	public User signup(Connection conn, String username, String password, String email) {
		try {
			PreparedStatement statement = conn.prepareStatement(insertUser);
			statement.setString (1, username);
			statement.setString (2, password);
			statement.setString (3, email);
			if(statement.execute()) {
				return new User(username, password ,email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		return null;
	}

}
