package user;

import java.sql.Connection;

public interface UserValidation {
	public User login(Connection con,String email, String password);
}
