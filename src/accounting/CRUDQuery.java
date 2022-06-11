package accounting;

import java.sql.Connection;
import java.util.List;

public interface CRUDQuery {
	public List<Account> getAllRecord(Connection conn);
	public Account getRecord(Connection conn);
	public void createRecord(Connection conn, Account account);
	public int updateRecord(Connection conn, Account account);
	public int deleteRecord(Connection conn, int id);
}
