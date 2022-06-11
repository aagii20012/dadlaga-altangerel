package accounting;

import java.sql.Date;

public class Account {
	private int id;
	private double amount;
	private String type;
	private Date date;
	
	public Account(int id, double amount, String type, Date date){
		this.id = id;
		this.amount = amount;
		this.type = type;
		this.date = date;
	}
	
	public Account(double amount, String type){
		this.amount = amount;
		this.type = type;
	}

	public double getAmount() {
		return this.amount;
	}
	public int getId() {
		return this.id;
	}
	public String getType() {
		return this.type;
	}
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
}
