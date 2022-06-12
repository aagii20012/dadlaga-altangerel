package user;

public class User {
	public int userId;
	public String username;
	public String password;
	public String email;
	
	public User(String username, String password, String email) {
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public User(int userId, String username, String password, String email) {
		this.userId = userId;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return this.userId;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.password = username;
	}
}
