package financemanagement;

public class Balance 
{
	public Balance (int accountno2,double balance2)
	{
		super();
		this.balance2 = balance2;
		this.accountno2 = accountno2;
	}
	
	public Balance () {
		
	}
	
	private int accountno2;
	private double balance2;
	public int getAccountno() {
		return accountno2;
	}
	
	public void setAccountno(int accountno2) {
		this.accountno2 =accountno2;
	}
	public double getBalance() {
		return balance2;
	}
	
	public void setBalance(double balance2) {
		this.balance2 =balance2;
	}
}
