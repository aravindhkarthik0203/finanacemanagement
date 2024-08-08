package financemanagement;

public class Allcontact 
{
	public Allcontact(int accountno,String firstn,String lastn,String fathern,String dob,
			String gender,long mobileno,String emailid,String addr,String city,String state,long pincode,String role) 
	{
		super();
		this.accountno = accountno;
		this.firstn = firstn;
		this.lastn = lastn;
		this.fathern = fathern;
		this.dob = dob;
		this.gender = gender;
		this.mobileno = mobileno;
		this.emailid = emailid;
		this.addr = addr;
		this.city = city;
		this.state = state;
		this.accountno = accountno;
		this.role = role;
		this.pincode = pincode;
	}
	
	
	public Allcontact() {
		
	}
	private String firstn;
	private String lastn;
	private String fathern;
	private String dob;
	private String gender;
	private long mobileno;
	private String emailid;
	private String addr;
	private String city;
	private String state;
	
	private int accountno;
	
	private String role;
	private long pincode;
	
	
	public String getFirstn() {
		return firstn;
	}
	
	public void setFirstn(String firstn) {
		this.firstn = firstn;
	}
	
	public String getLastn() {
		return lastn;
	}
	
	public void setLastn(String lastn) {
		this.lastn = lastn;
	}
	
	public String getFathern() {
		return fathern;
	}
	
	public void setFathern(String fathern) {
		this.fathern = fathern;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
		
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	
	public int getAccountno() {
		return accountno;
	}	
	public void setAccountno(int accountno)
	{
		this.accountno = accountno;
	}
	
}
