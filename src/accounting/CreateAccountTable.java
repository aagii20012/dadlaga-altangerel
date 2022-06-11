package accounting;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAccountTable{
	public String createAccountQuery = "CREATE TABLE IF NOT EXISTS Account("
			+ "	id serial PRIMARY KEY,"
			+ "	amount DOUBLE precision  DEFAULT 0,"
			+ "	type VARCHAR(50) NOT NULL,"
			+ "	created_date date DEFAULT (CURRENT_DATE) );";

	public String execute(Connection conn) {
		// TODO Auto-generated method stub
		try {
			Statement statement = conn.createStatement();
			
			statement.execute(createAccountQuery);
			return "Table Created";
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "An error has occured on Table Creation";
		}
	}

}
