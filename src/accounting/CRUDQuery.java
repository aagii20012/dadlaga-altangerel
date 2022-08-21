package accounting;

import java.sql.Connection;
import java.util.List;

import user.User;

public interface CRUDQuery {
	public List<Account> getAllRecord(Connection conn, User user);
	public double getTotalCost(Connection conn, int user_id);
	public double getTotalIcome(Connection conn, int user_id);
	public int updateRecord(Connection conn, Account account);
	public int deleteRecord(Connection conn, int id);
	public void createRecord(Connection conn, Account account, User user);
}
