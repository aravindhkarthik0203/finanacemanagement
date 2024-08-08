package financemanagement;

public class Transcation 
{
	public Transcation (int id2,int accountno2,int userid2,String process2,double amount2,int balance2,String timestamp2)
	{
		super();
		this.id2 = id2;
		this.amount2 = amount2;
		this.userid2 = userid2;
		this.process2 = process2;
		this.balance2 = balance2;
		this.timestamp2 = timestamp2;
		this.accountno2 = accountno2;
	}	
	public Transcation () {
		
	}
	
	private int id2;
	private double amount2;
	private int userid2;
	private String process2;
	private String timestamp2;
	private int balance2;
	private int accountno2;

	
	
	public int getId() {
		return id2;
	}
	
	public void setId(int id2) {
		this.id2 = id2;
	}
	
	public double getAmount() {
		return amount2;
	}
	
	public void setAmount(int amount2) {
		this.amount2 = amount2;
	}
	public int getUserid() {
		return userid2;
	}
	
	public void setUserid(int userid2) {
		this.userid2 = userid2;
	}
	
	public String getProcess() {
		return process2;
	}
	
	public void setProcess(String process2) {
		this.process2 = process2;
	}
	
	public int getBalance() {
		return balance2;
	}
	
	public void setBalance(int balance2) {
		this.balance2 = balance2;
	}
	
	public String getTimestamp() {
		return timestamp2;
	}
	
	public void setTimestamp(String timestamp2) {
		this.timestamp2 = timestamp2;
	}
	
	public int getAccountno() {
		return accountno2;
	}
	
	public void setAccountno(int accountno2) {
		this.accountno2 = accountno2;
	}
	
}
