package financemanagement;




public class Deposite 
{

	public Deposite(int userid1,int accountno1,int atmpin1,String process1,double amount1,double balance1,String timestamp1)
	{
		super();
		this.userid1=userid1;
		this.amount1 = amount1;
		this.accountno1 = accountno1;
		this.process1 = process1;
		this.balance1 = balance1;
		this.atmpin1 = atmpin1;
		this.timestamp1 = timestamp1;
	}	
	public Deposite() {
		
	}
	
	private int id1;
	private int userid1;
	
	private double amount1;
	private int accountno1;
	private String process1;
	private double balance1;
	private int atmpin1;
	private String timestamp1;

	
	
	public int getId() {

		return id1;
	}
	
	public int getuserid1() {

		return userid1;
	}
	
	public void setId(int id1) {
		this.id1 = id1;
	}
	
	public void setuserid1(int userid1) {
		this.userid1 = userid1;
	}
	
	public double getAmount() {
		return amount1;
	}
	
	public void setAmount(int amount1) {
		this.amount1 = amount1;
	}
	public int getAccountno() {
		return accountno1;
	}
	
	public void setAccountno(int accountno1) {
		this.accountno1 = accountno1;
	}
	
	public String getProcess() {
		return process1;
	}
	
	public void setProcess(String process1) {
		this.process1 = process1;
	}
	
	public double getBalance() {
		return balance1;
	}
	
	public void setProcess(double balance1) {
		this.balance1 = balance1;
	}
	
	public int getAtmpin() {
		return atmpin1;
	}
	
	public void setAtmpin(int atmpin1) {
		this.atmpin1 = atmpin1;
	}
	
	public String getTimestamp() {
		return timestamp1;
	}
	public void setTimestamp(String timestamp1) {
		this.timestamp1 = timestamp1;
	}
	
}
