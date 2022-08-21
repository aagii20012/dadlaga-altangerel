package accounting;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import user.User;

public class Accounting implements CRUDQuery {

	@Override
	public List<Account> getAllRecord(Connection conn, User user) {
		List<Account> accounts = new ArrayList<>();
		String query = "SELECT * FROM Account Where user_id = ?  order by id asc";
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, user.getId());;
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				double amount = rs.getDouble("amount");
				String type = rs.getString("type");
				Date date = rs.getDate("created_date");
				Account acc = new Account(id, amount, type, date);
				accounts.add(acc);
			}
			
			return accounts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateRecord(Connection conn, Account account) {
		try {
			String insertRescord = "update account set amount = ?, type = ? where id = ?";
			PreparedStatement statement = conn.prepareStatement(insertRescord);
			statement.setDouble(1, account.getAmount());
			statement.setString (2, account.getType());
			statement.setInt (3,account.getId());
			
			int i = statement.executeUpdate();
			System.out.println("acc id is " + account.getAmount() + " and i is " + i );
	        return i;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteRecord(Connection conn, int id) {
		try {
			String insertRescord = "delete from account where id = ?";
			PreparedStatement statement = conn.prepareStatement(insertRescord);
			statement.setInt (1,id);
			
			int i = statement.executeUpdate();
	        return i;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void createRecord(Connection conn, Account account, User user) {
		try {
			String insertRescord = " Insert into Account (amount, type, user_id)"
				    + " values (?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(insertRescord);
			statement.setDouble(1, account.getAmount());
			statement.setString (2, account.getType());
			statement.setInt(3, user.getId());
			statement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public double getTotalCost(Connection conn, int user_id) {
		try {
			double total = 0;
			String insertRescord = "SELECT Sum(amount) as total_cost FROM public.account where type='Cost' and user_id = ?;";
			PreparedStatement statement = conn.prepareStatement(insertRescord);
			statement.setDouble(1, user_id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				total = rs.getDouble("total_cost");
			}
			return total;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public double getTotalIcome(Connection conn, int user_id) {
		// TODO Auto-generated method stub
		try {
			double total = 0;
			String insertRescord = "SELECT Sum(amount) as total_income FROM public.account where type='Income' and user_id = ?;";
			PreparedStatement statement = conn.prepareStatement(insertRescord);
			statement.setDouble(1, user_id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				total = rs.getDouble("total_income");
			}
			return total;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
