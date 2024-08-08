package financemanagement;

public class Widthraw 
{
	public Widthraw(int userid,int accountno,int atmpin,String process,double amount,double balance,String timestamp)
	{
		super();
		this.userid = userid;
		this.amount = amount;
		this.accountno = accountno;
		this.process = process;
		this.balance =  balance;
		this.atmpin = atmpin;
		this.timestamp = timestamp;
	}	
	public Widthraw() {
		
	}
	
	private int userid;
	private double amount;
	private int accountno;
	private String process;
	private double balance;
	private int atmpin;
	private String timestamp;

	
	
	public int getUserid() {
		return userid;
	}
	
	public void setUseridd(int userid) {
		this.userid = userid;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAccountno() {
		return accountno;
	}
	
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	
	public String getProcess() {
		return process;
	}
	
	public void setProcess(String process) {
		this.process = process;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalancce(double balance) {
		this.balance = balance;
	}
	
	public int getAtmpin() {
		return atmpin;
	}
	
	public void setAtmpin(int atmpin) {
		this.atmpin = atmpin;
	}

	
	public String getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
