package financemanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserDAO {
	
	static DBconnection dbconnection = new DBconnection();
	
	static AccountDAO ad = new AccountDAO();
	Deposite dp = new Deposite();
	Widthraw wd = new Widthraw();
	Transcation tt = new Transcation();
	

	public void RegisterUser(UserRegistration UserRegistration) throws SQLException {
		String Query = "Insert into  register (accountno,firstn,lastn,fathern,dob,gender,mobileno,email,addr,city,state,pincode,atmpin,role) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(Query);)
		{
			preparedstatement.setInt(1, UserRegistration.getAccountno());
			preparedstatement.setString( 2, UserRegistration.getFirstn());
			preparedstatement.setString( 3, UserRegistration.getLastn());
			preparedstatement.setString(4, UserRegistration.getFathern());
			preparedstatement.setString(5, UserRegistration.getDob());
			preparedstatement.setString(6, UserRegistration.getGender());
			preparedstatement.setLong(7, UserRegistration.getMobileno());
			preparedstatement.setString(8, UserRegistration.getEmailid());
			preparedstatement.setString(9, UserRegistration.getAddr());
			preparedstatement.setString(10, UserRegistration.getCity());
			preparedstatement.setString(11, UserRegistration.getState());
			preparedstatement.setLong(12, UserRegistration.getPincode());
			preparedstatement.setInt(13, UserRegistration.getAtmpin());
			preparedstatement.setString(14, UserRegistration.getRole());
		
			int rs = preparedstatement.executeUpdate();
			if (rs > 0) {
				System.out.println("REGISTER SUCCESSFULLY....!!");
				System.out.println("PLEASE SAVE REGISTRATION ACCOUNT NUMBER:" + UserRegistration.getAccountno());
			} else {
				System.out.println("SOMETHING WENT WRONG.....");
			}
		}
	}
	
	public void LoginUser(int accountno ,int atmpin ,String role) throws SQLException, Exception
	{
		String sql = "select * from register where accountno=? and atmpin=? and role=?";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql);) 
		{
			
			preparedstatement.setInt(1, accountno);
			preparedstatement.setInt(2, atmpin);
			preparedstatement.setString(3, role);
			
			ResultSet resultSet = preparedstatement.executeQuery();
			
		
			
			if (resultSet.next()) 
			{
				
				System.out.println("Login Successfully-----!!!.");
				boolean loginuser = true;
				while (loginuser) 
				{
					if (role=="ADMIN") 
					{
						System.out.println("----------------------WELCOME"+" " +resultSet.getString("lastn") +" "+ resultSet.getString("firstn")+ "("+ role +")"+":------------\n");
						System.out.println(" 1.VIEW ALL ACCOUTNT DETAILS");
						System.out.println(" 2.TO SEE AND UPDATE ALL ACCOUNT");
						System.out.println(" 3.CHECK ALL TRANCATION ACCOUNT ");
						System.out.println(" 4.AMOUNT CHECK ALL ACOOUNT");
						System.out.println(" 5.TO EXIT ");
						System.out.println("...................ENTER THE OPTION .....................");
						
						Scanner sc = new Scanner(System.in);
						int useroption = Integer.parseInt(sc.nextLine());

						switch(useroption) 
						{
							case 1:
								System.out.println("=============ACCOUNT DETAIL VIEW==========");
								List<Allcontact> list = ad.getAllContacts();
								for (Allcontact Allcontact : list) 
								{	System.out.println("");
									System.out.println("---------------------------REGISTERED ACCOUNT DETAILS---------------------------------");
									System.out.println("NAME :" + Allcontact.getFirstn()+" "+ Allcontact.getLastn());
									System.out.println("FATHER NAME :" + Allcontact.getFathern());
									System.out.println("GENDER :" + Allcontact.getGender());
									System.out.println("DATE OF BIRTH :" + Allcontact.getDob());
									System.out.println("MOBILE NUMBER:" + Allcontact.getMobileno());
									System.out.println("EMAIL ID :" + Allcontact.getEmailid());
									System.out.println("ADDRESS :" + Allcontact.getAddr()+" "+
											Allcontact.getCity()+" "+Allcontact.getState()+" "+Allcontact.getPincode());
									System.out.println("BRANCH CITY :" + Allcontact.getCity());
									System.out.println("ROLE :" + Allcontact.getRole());
									System.out.println("=====================================================================================");
									System.out.println("");
								}
								break;
							case 2:
								System.out.println("---------------WELCOME TO ACCOUNT MANAGEMENT!!!!----------------");
								int choice1;
//								do {
									System.out.println("1. Update First Name");
									System.out.println("2. Update Last Name");
									System.out.println("3. Update Father Name");
									System.out.println("4. Update Date-Of-Birth");
									System.out.println("5. Update Gender");
									System.out.println("6. Update Mobile Number");
									System.out.println("7. Update Email ID");
									System.out.println("8. Update Address");
									System.out.println("9. Update City");
									System.out.println("10. Update State");
									System.out.println("11. Update Pincode");
									System.out.println("12. View Updated Details");
									System.out.println("13. Exit");

									System.out.print("Enter your choice: ");
									choice1 = sc.nextInt();
									sc.nextLine();
									switch (choice1) {
									case 1:
										updateFirstn(connection);
										break;
									case 2:
										updateLastn(connection);
										break;
									case 3:
										updateFathern(connection);
										break;
									case 4:
										updateDob(connection);
										break;
									case 5:
										updateGender(connection);
										break;
									case 6:
										updateMobileno(connection);
										break;
									case 7:
										updateEmail(connection);
										break;
									case 8:
										updateAddress(connection);
										break;
									case 9:
										updateCity(connection);
										break;
									case 10:
										updateState(connection);
										break;
									case 11:
										updatePincode(connection);
										break;
									case 12:
										viewdetails(connection);
										break;
									case 13:
//										loginuser =false;
										System.out.println("EXIT TO ACCOUNT MANAGEMENT!!!!!");
										break;								
//										return;
									default:
										System.out.println("Invalid choice. Please try again.");
										break;
									}
//								} while (choice1 != 14);
								break;
							case 3:
								System.out.println("=============ALL TRANSCATION DETAIL VIEW==========");
								List<Transcation> list1 = ad.getAllTranscation();
								for (Transcation Transcation : list1)
								{	System.out.println("");
									System.out.println("--------------------------- TRANSCATION DETAILS---------------------------------");
									System.out.println("ACCOUNT NUMBER:" +Transcation.getAccountno());
									System.out.println("TIMESTAMP :" +Transcation.getTimestamp());
									System.out.println("PROCESS OF TRANSCATION:" +Transcation.getProcess());
									System.out.println("PROCESSED AMOUNT OF TRANSCATION:" +Transcation.getAmount());
									System.out.println("PROCESSED AMOUNT OF TRANSCATION:" +Transcation.getBalance());
									System.out.println("=====================================================================================");
									System.out.println("");
								}
								break;
							case 4:
								System.out.println("============= AVAILABLE BALANCE ==========");
								
								List<Balance> list2 = ad.getAllBalance();
								for (Balance Balance : list2)
								{	System.out.println("");
									System.out.println("--------------------------- BALANCE DETAILS---------------------------------");
									System.out.println("ACCOUNT NUMBER:" +Balance.getAccountno());
									System.out.println("TOTAL AVAILABLE BALANCE:" +Balance.getBalance());
									System.out.println("=====================================================================================");
									System.out.println("");
								}
								break;
							case 5:
								loginuser = false;
								System.out.println("exit");
								break;
							default:
								System.out.println("INVALID OPTION");
								break;
						}
					}
					else if(role=="USER") 
					{
						System.out.println("----------------------WELCOME"+ " "+resultSet.getString("lastn") +" "+ resultSet.getString("firstn") + "("+ role +")"+":------------\n");
						System.out.println(" 1.VIEW ACCOUTNT");
						System.out.println(" 2.WIDTHRAW");
						System.out.println(" 3.DEPOSITE");
						System.out.println(" 4.BALANCE CHECK");
						System.out.println(" 5.STATEMMENT CHECK");
						System.out.println(" 6.TO CHANGE ATM PIN");
						System.out.println(" 7.EXIT");
						System.out.println("...................ENTER THE OPTION .....................");
						
						Scanner sc = new Scanner(System.in);
						int useroption = Integer.parseInt(sc.nextLine());
						
						
						switch(useroption) 
						{
							case 1:
								
								System.out.println("ENTER THE ATM PIN:");
								int pin =sc.nextInt();
								sc.nextLine();

									System.out.println("=============ACCOUNT DETAIL VIEW==========");
									List<UserRegistration> list = ad.getContacts(pin);
									for (UserRegistration UserRegistration : list)
									{	System.out.println("");
										System.out.println("---------------------------REGISTERED CONTACT DETAILS---------------------------------");
										System.out.println("ACCOUNT NUMBER :" + UserRegistration.getAccountno());
										System.out.println("NAME :" + UserRegistration.getFirstn()+" "+ UserRegistration.getLastn());
										System.out.println("FATHER NAME :" + UserRegistration.getFathern());
										System.out.println("GENDER :" + UserRegistration.getGender());
										System.out.println("DATE OF BIRTH :" + UserRegistration.getDob());
										System.out.println("MOBILE NUMBER :" + UserRegistration.getMobileno());
										System.out.println("EMAIL ID :" + UserRegistration.getEmailid());
										System.out.println("ADDRESS :" + UserRegistration.getAddr()+" "+
										UserRegistration.getCity()+" "+UserRegistration.getState()+" "+"Pin -"+UserRegistration.getPincode());
										System.out.println("BRANCH CITY :" + UserRegistration.getCity());
										System.out.println("=====================================================================================");
										System.out.println("");
									}
									break;
					

							case 2:
								try {
									LocalDateTime now = LocalDateTime.now();

							        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

							        String timestamp = now.format(formatter);

							        
									final String process = "Widthraw";
									System.out.println("=============WIDTHRAW FROM ACCOUNT ==========");
									
									System.out.println("ENTER THE ACCOUNT NUMBER TO WIDTHRAW:");
									int accountno4 = sc.nextInt();
									sc.nextLine();
									
									if(accountno4 == accountno) 
									{
										System.out.println("ENTER THE ATM PIN TO WIDTHRAW:");
										int atmpin4 = sc.nextInt();
										sc.nextLine();
										
										if(atmpin4 == atmpin) 
										{
											System.out.println("ENTER THE AMOUNT TO WIDTHRAW:");
											double amount = sc.nextInt();
											sc.nextLine();
											
											
											int userid=resultSet.getInt("id");
											List<Transcation> list1 = ad.getAllTranscation();
											try {
												List<Transcation> filteredData = list1.stream()
														  .filter(u -> u.getUserid() == userid)
														  .collect(Collectors.toList());
								//
//														System.out.println(filteredData+"_"+filteredData.size());
														Transcation lastElement = filteredData.get(filteredData.size() - 1);
														double balance=lastElement.getBalance()-amount ;
														ad.widthraw(new Widthraw(userid,accountno4,atmpin4,process,amount,balance,timestamp));
											} catch (Exception e) {
//												ad.widthraw(new Widthraw(userid,atmpin,process,amount,amount));
												System.out.println("");
											}
										}else {
											System.out.println("Account Number is not Match!!");
										}
										}else {
											System.out.println("ATM Pin is not match!!");
										}
									
								} catch (Exception e) {
									System.out.println();
								}
								
//								updateWBalance(connection,resultSet.getInt("id"));
								break;
							case 3:
								try {
									LocalDateTime now = LocalDateTime.now();

							        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

							        String timestamp1 = now.format(formatter);
							        
									final String process1 = "Deposite";
									
									System.out.println("=============DEPOSIT TO ACCOUNT ==========");
									
									System.out.println("ENTER THE ACCOUNT NUMBER TO DEPOSIT:");
									int accountno1 = sc.nextInt();
									sc.nextLine();
									
									if(accountno1 == accountno) 
									{
										System.out.println("ENTER THE ATM PIN TO DEPOSIT:");
										int atmpin1 = sc.nextInt();
										sc.nextLine();
										
										if(atmpin1 == atmpin) 
										{
											System.out.println("ENTER THE AMOUNT TO DEPOSIT:");
											double amount1 = sc.nextInt();
											sc.nextLine();
												
												
											int userid1=resultSet.getInt("id");
//											Alltrancation();
											List<Transcation> list1 = ad.getAllTranscation();

												
											try 
											{
												List<Transcation> filteredData = list1.stream()
													.filter(u -> u.getUserid() == userid1)
													.collect(Collectors.toList());

//													System.out.println(filteredData+"_"+filteredData.size());
															Transcation lastElement = filteredData.get(filteredData.size() - 1);
															double balance1=amount1+lastElement.getBalance();
															ad.deposit(new Deposite(userid1,accountno1,atmpin1,process1,amount1,balance1,timestamp1));
											} catch (Exception e) 
											{
													ad.deposit(new Deposite(userid1,accountno1,atmpin1,process1,amount1,amount1,timestamp1));
													System.out.println();
											}
												
										}else
										{
											System.out.println("ATM Pin is not match!!");
											break;
										}	
										
									}else 
									{
										System.out.println("Account Number is not match!!");
										break;
									}
																	
								} catch (Exception e) {
									System.out.println();
								}
								
//								updateDBalance(connection,resultSet.getInt("id"));
								break;
							case 4:
								try 
								{	
									
									System.out.println("============= AVAILABLE BALANCE ==========");
									List<Balance> list2 = ad.getBalance(accountno);
									
									for (Balance Balance : list2)	
									{	System.out.println("");
										System.out.println("--------------------------- BALANCE DETAILS---------------------------------");
										System.out.println("ACCOUNT ID	TOTAL BALANCE");
										System.out.println(Balance.getAccountno()+"		"+Balance.getBalance());
										System.out.println("=====================================================================================");
										System.out.println("");
									}
				
									break;
								} catch (Exception e) {
									System.out.println(e);
								}
							
							case 5:
								try 
								{
									System.out.println("============STATEMENT CHECK ==========");
									List<Transcation> list1 = ad.getTranscation(accountno);
									for (Transcation Transcation : list1)
									{	System.out.println("");
										System.out.println("--------------------------- STATEMENT DETAILS ---------------------------------");
										System.out.println("TRANSCATION ID:" +Transcation.getId());
										System.out.println("PROCESS OF TRANSCATION:" +Transcation.getProcess());
										System.out.println("PROCESSED AMOUNT OF TRANSCATION:" +Transcation.getAmount());
										System.out.println("CURRENT BALANCE:" +Transcation.getBalance());
										System.out.println("TIMESTAMP:" +Transcation.getTimestamp());
										System.out.println("=====================================================================================");
										System.out.println("");
									}
									break;
								} catch (Exception e) {
									System.out.println(e);
								}
								
							
							case 6:
								updateAtmpin(connection);
								break;
								
							case 7:
								loginuser = false;
								System.out.println("exit");
								break;
							default:
								System.out.println("INVALID OPTION");
								break;
						}						
					}
					else {
						System.out.println("NOT A USER!!!");
					}	
				}
			}
			else 
			{
				System.out.println("LOGIN FAILED");
			}
		}
	}
	
	
	public static boolean isValidUpdateFirstname(String newFirstn) 
	{
		String regex = "^(?=.*[a-zA-Z\s_.])[a-zA-Z\s_.]{3,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(newFirstn);
		return matcher.matches();
	}

	public static boolean isValidUpdateLastname(String newLastn) 
	{
		String regex = "^(?=.*[a-zA-Z\s_.])[a-zA-Z\s_.]{1,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(newLastn);
		return matcher.matches();
	}
	
	public static boolean 	isValidUpdateFathername(String newFathern) 
	{
		String regex = "^(?=.*[a-zA-Z\s_.])[a-zA-Z\s_.]{3,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(newFathern);
		return matcher.matches();
	}
	
    public static boolean isvalidUpdateDateOfBirth(String newDob) {
        String regexPattern =  "^(0[1-9]|[12][0-9]|3[01])[-/.](0[1-9]|1[0-2])[-/.](19|20)\\d{2}$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(newDob);
        return matcher.matches();
    }
    
    public static boolean isvalidUpdateGender(String newGender) 
    {
        String pattern = "^(male|female|non-binary|Male|Female|M|F|other)$";
        Pattern genderPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = genderPattern.matcher(newGender);
        return matcher.matches();
    }
    
    public static boolean isValidUpdateCity(String newCity) 
    {
        String regex = "^[A-Za-z]+(?:[\\s-][A-Za-z]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(newCity);
        return matcher.matches();
    }
	
    public static boolean isValidUpdateState(String newState) 
    {
        String regex = "^[A-Za-z]+(?:[\\s-][A-Za-z]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(newState);
        return matcher.matches();
    }
    public static boolean isValidUpdateUsername(String newUsername) 
    {
        String regex = "^(?=.*[a-zA-Z0-9_.])[a-zA-Z0-9_.]{4,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(newUsername);
        return matcher.matches();
    }
    
    public static boolean isValidUsername(String username) 
    {
        String regex = "^(?=.*[a-zA-Z0-9_.])[a-zA-Z0-9_.]{4,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
    
    public static boolean isValidUpdatePassword(String newPassword)
    {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(newPassword);
        return matcher.matches();
    }

    public static boolean isValidEmptyPassword(String newPassword) {
        
        return newPassword != null && !newPassword.isEmpty();
    }
    
    public static boolean isValidUpdateMobileNumber(long newMobileno) 
    {
        String regex = "\\A[0-9]{10}\\z";
        String numberString = Long.toString(newMobileno);
        return numberString.matches(regex);
    }
    
    public static boolean isValidUpdatePin(int newAtmpin) 
    {
        String regex = "\\A[0-9]{1,6}\\z";
        String numberString = Long.toString(newAtmpin);
        return numberString.matches(regex);
    }
    public static boolean isValidUpdateEmail(String newEmailid) 
    {
        String regex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
        return newEmailid.matches(regex);
    }
    
    public static boolean isValidUpdatePincode(long newPincode) 
    {
        String regex = "^[0-9]{4,10}$";
        String numberString = Long.toString(newPincode);
        return numberString.matches(regex);
    }


	private static void updateEmail(Connection connection) throws SQLException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("=============================ENTER YOUR DETAILS==============================");
		System.out.println("Enter your Account ID: ");
		int accountno = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter new Email: ");
		String newEmailid = scanner.nextLine();
		if(isValidUpdateEmail(newEmailid)) 
		{
			System.out.println("=============================================================================");
			String SQL = "UPDATE register SET email = ? WHERE accountno = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
				preparedStatement.setString(1, newEmailid);
				preparedStatement.setInt(2, accountno);

				int rs = preparedStatement.executeUpdate();

				if (rs > 0) {
					System.out.println("Email ID updated successfully!");
					System.out.println("=============================================================================");
				} else {
					System.out.println("Failed to update Email Id....Please enter a valid Father Name.!");
					System.out.println("=============================================================================");
				}
			}
		}else {
			System.out.println("Invalid email address format. Please enter a valid email address.");
		}
	}
	
	private static void updateFirstn(Connection connection) throws SQLException 
	{	
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("=============================ENTER YOUR DETAILS==============================");
			System.out.println("Enter your Account Number: ");
			int accountno = scanner.nextInt();
			scanner.nextLine();
			
			System.out.print("Enter new First Name: ");
			String newFirstn = scanner.nextLine();
			if(isValidUpdateFirstname(newFirstn)) 
			{
				System.out.println("=============================================================================");
				
				String SQL = "UPDATE register SET firstn = ? WHERE accountno = ?";
				try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
					preparedStatement.setString(1, newFirstn);
					preparedStatement.setInt(2, accountno);

					int rs = preparedStatement.executeUpdate();

					if (rs > 0) {
						System.out.println("Firsr Name updated successfully!");
						System.out.println("=============================================================================");
					} else {
						System.out.println("Failed to update First Name....Please enter a valid Father Name.!");
						System.out.println("=============================================================================");
					}
				}
			}else {
				System.out.println("INVALID FIRST NAME!!...Please enter a First Name.\\n");
				
			}
			

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void updateLastn(Connection connection) throws SQLException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("=============================ENTER YOUR DETAILS==============================");
		System.out.println("Enter your Account ID: ");
		int accountno = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter new Last Name: ");
		String newLastn = scanner.nextLine();
		if(isValidUpdateLastname(newLastn)) 
		{
			System.out.println("=====================================================================================");
			String SQL = "UPDATE register SET lastn = ? WHERE accountno = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
				preparedStatement.setString(1, newLastn);
				preparedStatement.setInt(2, accountno);

				int rs = preparedStatement.executeUpdate();

				if (rs > 0) {
					System.out.println("Last Name updated successfully!");
					System.out.println("=====================================================================================");
				} else {
					System.out.println("Failed to update Last Name....Please enter a valid Father Name.!");
					System.out.println("=====================================================================================");
				}
			}
		}else {
			System.out.println("INVALID LAST NAME!!...Please enter a valid Last Name.\n");
		}

	}
	
	private static void updateFathern(Connection connection) throws SQLException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("=============================ENTER YOUR DETAILS==============================");
		System.out.println("Enter your Account ID: ");
		int accountno = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter new Father Name: ");
		String newFathern = scanner.nextLine();
		if(isValidUpdateFathername(newFathern)) 
		{
			System.out.println("=====================================================================================");
			String SQL = "UPDATE register SET fathern = ? WHERE accountno = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
				preparedStatement.setString(1, newFathern);
				preparedStatement.setInt(2, accountno);

				int rs = preparedStatement.executeUpdate();

				if (rs > 0) {
					System.out.println("Father Name updated successfully!");
					System.out.println("=====================================================================================");
				} else {
					System.out.println("Failed to update Father Name....Please enter a valid Father Name.!");
					System.out.println("=====================================================================================");
				}
			}
		}else {
			System.out.println("INVALID FATHER NAME!!..Please enter a valid Father Name.\n");
		}
		
	}
	
	private static void updateDob(Connection connection) throws SQLException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("=============================ENTER YOUR DETAILS==============================");
		System.out.println("Enter your Account ID: ");
		int accountno = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter new D-O-B: ");
		String newDob = scanner.nextLine();
		System.out.println("=====================================================================================");
		if(isvalidUpdateDateOfBirth(newDob)) 
		{
			String SQL = "UPDATE register SET dob = ? WHERE accountno = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
				preparedStatement.setString(1, newDob);
				preparedStatement.setInt(2, accountno);

				int rs = preparedStatement.executeUpdate();

				if (rs > 0) {
					System.out.println("DOB updated successfully!");
					System.out.println("=====================================================================================");
				} else {
					System.out.println("Failed to update DOB....Please enter a valid Father Name.!");
					System.out.println("=====================================================================================");
				}
			}
		}else {
			System.out.println("INVALID DOB!!....Please enter a valid DOB.\n");
		}

	}
	
	private static void updateGender(Connection connection) throws SQLException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("=============================ENTER YOUR DETAILS==============================");
		System.out.println("Enter your Account ID: ");
		int accountno = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter new Gender: ");
		String newGender = scanner.nextLine();
		System.out.println("=====================================================================================");
		
		if(isvalidUpdateGender(newGender)) 
		{
			String SQL = "UPDATE register SET gender = ? WHERE accountno = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
				preparedStatement.setString(1, newGender);
				preparedStatement.setInt(2, accountno);

				int rs = preparedStatement.executeUpdate();

				if (rs > 0) {
					System.out.println("Gender updated successfully!");
					System.out.println("=====================================================================================");
				} else {
					System.out.println("Failed to update Gender....Please enter a valid Father Name.!");
					System.out.println("=====================================================================================");
				}
			}
		}else {
			System.out.println("INVALID GENDER!!..Please enter a valid Gender(Male,Female).\n");
		}
		

	}
	
	private static void updateMobileno(Connection connection) throws SQLException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("=============================ENTER YOUR DETAILS==============================");
		System.out.println("Enter your Account Number: ");
		int accountno = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter new Mobile Number: ");
		long newMobileno = scanner.nextLong();
		scanner.nextLine();
		System.out.println("=====================================================================================");
		
		if(isValidUpdateMobileNumber(newMobileno))
		{
			String SQL = "UPDATE register SET mobileno = ? WHERE accountno = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
				preparedStatement.setLong(1, newMobileno);
				preparedStatement.setInt(2, accountno);

				int rs = preparedStatement.executeUpdate();

				if (rs > 0) {
					System.out.println("Mobile Number updated successfully!");
					System.out.println("=====================================================================================");
				} else {
					System.out.println("Failed to update Mobile Number....Please enter a valid Father Name.!");
					System.out.println("=====================================================================================");
				}
			}
		}else {
			System.out.println("Invalid mobile number format. Please enter a 10-digit mobile number.\n");
		}
		
	}
	
	
	private static void updateAddress(Connection connection) throws SQLException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("=============================ENTER YOUR DETAILS==============================");
		System.out.println("Enter your Account ID: ");
		int accountno = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter new Address: ");
		String newAddress = scanner.nextLine();
		System.out.println("=====================================================================================");
		String SQL = "UPDATE register SET addr = ? WHERE ID = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
			preparedStatement.setString(1, newAddress);
			preparedStatement.setInt(2, accountno);

			int rs = preparedStatement.executeUpdate();

			if (rs > 0) {
				System.out.println("Address updated successfully!");
				System.out.println("=====================================================================================");
			} else {
				System.out.println("Failed to update Address....Please enter a valid Father Name.!");
				System.out.println("=====================================================================================");
			}
		}
	}
	
	private static void updateCity(Connection connection) throws SQLException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("=============================ENTER YOUR DETAILS==============================");
		System.out.println("Enter your Account ID: ");
		int accountno = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter new City: ");
		String newCity = scanner.nextLine();
		System.out.println("=====================================================================================");
		
		if(isValidUpdateCity(newCity)) 
		{
			
			String SQL = "UPDATE register SET city = ? WHERE accountno = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
				preparedStatement.setString(1, newCity);
				preparedStatement.setInt(2, accountno);

				int rs = preparedStatement.executeUpdate();

				if (rs > 0) {
					System.out.println("City updated successfully!");
					System.out.println("=====================================================================================");
				} else {
					System.out.println("Failed to update City....Please enter a valid Father Name.!");
					System.out.println("=====================================================================================");
				}
			}
		}else {
			System.out.println("INVALID CITY NAME!!");
		}

	}
	
	private static void updateState(Connection connection) throws SQLException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("=============================ENTER YOUR DETAILS==============================");
		System.out.println("Enter your Account ID: ");
		int accountno = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter new State: ");
		String newState = scanner.nextLine();
		System.out.println("=====================================================================================");
		
		if(isValidUpdateState(newState))
		{
			
			String SQL = "UPDATE register SET state = ? WHERE ID = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
				preparedStatement.setString(1, newState);
				preparedStatement.setInt(2, accountno);

				int rs = preparedStatement.executeUpdate();

				if (rs > 0) {
					System.out.println("State updated successfully!");
					System.out.println("=====================================================================================");
				} else {
					System.out.println("Failed to update State.Please Check your Account Number");
					System.out.println("=====================================================================================");
				}
			}
		}else {
			System.out.println("INVALD STATE!!");
		}

	}
	
	
	private static void updatePincode(Connection connection) throws SQLException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("=============================ENTER YOUR DETAILS==============================");
		System.out.println("Enter your Account ID: ");
		int accountno = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter new Pincode: ");
		long newPincode = scanner.nextInt();
		scanner.nextLine();
		System.out.println("=====================================================================================");
		
		if(isValidUpdatePincode(newPincode)) 
		{
			String SQL = "UPDATE register SET pincode = ? WHERE accountno = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
				preparedStatement.setLong(1, newPincode);
				preparedStatement.setInt(2, accountno);

				int rs = preparedStatement.executeUpdate();

				if (rs > 0) {
					System.out.println("Pincode updated successfully!");
					System.out.println("=====================================================================================");
				} else {
					System.out.println("Failed to update Pincode....Please enter a valid Father Name.!");
					System.out.println("=====================================================================================");
				}
			}
		}else {
			System.out.println("INVALID PINCODE!!");
		}
		

	} 	
	private static void viewdetails(Connection connection) throws SQLException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your Account Number: ");
		int accountno = scanner.nextInt();
		scanner.nextLine();
		List<Allcontact> list = ad.getAllContacts();
		for (Allcontact Allcontact : list) 
		{	System.out.println("");
			System.out.println("---------------------------REGISTERED ACCOUNT DETAILS---------------------------------");
			System.out.println("NAME :" + Allcontact.getFirstn()+" "+ Allcontact.getLastn());
			System.out.println("FATHER NAME :" + Allcontact.getFathern());
			System.out.println("GENDER :" + Allcontact.getGender());
			System.out.println("DATE OF BIRTH :" + Allcontact.getDob());
			System.out.println("MOBILE NUMBER=" + Allcontact.getMobileno());
			System.out.println("EMAIL ID :" + Allcontact.getEmailid());
			System.out.println("ADDRESS :" +Allcontact.getAddr()+" "+
					Allcontact.getCity()+" "+Allcontact.getState()+" "+Allcontact.getPincode());
			System.out.println("BRANCH CITY :" + Allcontact.getCity());
			System.out.println("=====================================================================================");
			System.out.println("");
		}
	}
		
	private static void updateAtmpin(Connection connection) throws SQLException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("=============================ENTER YOUR DETAILS==============================");
		System.out.println("Enter your Account ID: ");
		int accountno = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter new ATM PIN: ");
		int newAtmpin = scanner.nextInt();
		scanner.nextLine();
		System.out.println("=====================================================================================");
		if(isValidUpdatePin(newAtmpin)) 
		{
			
			String SQL = "UPDATE register SET atmpin = ? WHERE accountno = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
				preparedStatement.setInt(1, newAtmpin);
				preparedStatement.setInt(2, accountno);

				int rs = preparedStatement.executeUpdate();

				if (rs > 0) {
					System.out.println("ATM PIN updated successfully!");
					System.out.println("=====================================================================================");
				} else {
					System.out.println("Failed to update ATM PIN....Please enter a valid Father Name.!");
					System.out.println("=====================================================================================");
				}
			}
		}else {
			System.out.println("INVALID PIN.....Please enter a valid PIN(atleat 4 to 6 digit)\n");
		}

	}
	
	
}