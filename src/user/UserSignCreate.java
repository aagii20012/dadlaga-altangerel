package user;

import java.sql.Connection;

public interface UserSignCreate {
	public User signup(Connection conn, String username, String password, String email);
}
