package accounting;

import java.sql.Connection;
import java.util.List;

import user.User;

public interface CRUDQuery {
	public List<Account> getAllRecord(Connection conn, User user);
	public Account getRecord(Connection conn);
	public int updateRecord(Connection conn, Account account);
	public int deleteRecord(Connection conn, int id);
	public void createRecord(Connection conn, Account account, User user);
}
