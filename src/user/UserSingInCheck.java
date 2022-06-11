package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSingInCheck implements UserValidation {
	public String getUserByPassAndEmail = "SELECT * FROM Users WHERE email=? AND password=?";
	@Override
	public User login(Connection con, String email, String password) {
		try {
			PreparedStatement statement = con.prepareStatement(getUserByPassAndEmail,
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			if(rs.first())
			{
				int id = Integer.parseInt(rs.getString("user_id"));
				User user = new User(id,rs.getString("username"),rs.getString("password"),rs.getString("email"));
				return user;
			}
		} catch (SQLException e) {
			System.out.println("here error");
			e.printStackTrace();
		}
		return null;
	}

}
