package financemanagement;


import java.util.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminReg 
{
	public static boolean isValidUserFirstname(String firstn) 
	{
		String regex = "^(?=.*[a-zA-Z\s_.])[a-zA-Z\s_.]{3,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(firstn);
		return matcher.matches();
	}

	public static boolean isValidUserLastname(String lastn) 
	{
		String regex = "^(?=.*[a-zA-Z\s_.])[a-zA-Z\s_.]{1,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(lastn);
		return matcher.matches();
	}
	
	public static boolean 	isValidUserFathername(String fathern) 
	{
		String regex = "^(?=.*[a-zA-Z\s_.])[a-zA-Z\s_.]{3,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(fathern);
		return matcher.matches();
	}
	
    public static boolean isvalidateDateOfBirth(String dob) {
        String regexPattern =  "^(0[1-9]|[12][0-9]|3[01])[-/.](0[1-9]|1[0-2])[-/.](19|20)\\d{2}$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(dob);
        return matcher.matches();
    }
    
    public static boolean isvalidateGender(String gender) 
    {
        String pattern = "^(male|female|non-binary|other)$";
        Pattern genderPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = genderPattern.matcher(gender);
        return matcher.matches();
    }
      
    public static boolean isValidCity(String city) 
    {
        String regex = "^[A-Za-z]+(?:[\\s-][A-Za-z]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(city);
        return matcher.matches();
    }
	
    public static boolean isValidState(String state) 
    {
        String regex = "^[A-Za-z]+(?:[\\s-][A-Za-z]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(state);
        return matcher.matches();
    }
    public static boolean isValidUsername(String username) 
    {
        String regex = "^(?=.*[a-zA-Z0-9_.])[a-zA-Z0-9_.]{4,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
    
    public static boolean isValidPassword(String password)
    {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    public static boolean isValidSPassword(String password, String username, String firstn, String surename)
    {
        if (password.contains(username) || password.contains(firstn) || password.contains(surename)) 
        { 
        		return false;
        }

        return true;
    }
    public static boolean isValidEmptyPassword(String password) {
        
        return password != null && !password.isEmpty();
    }
    
    public static boolean isValidMobileNumber(long mobileno) 
    {
        String regex = "\\A[0-9]{10}\\z";
        String numberString = Long.toString(mobileno);
        return numberString.matches(regex);
    }
    
    public static boolean isValidPin(int atmpin) 
    {
        String regex = "\\A[0-9]{1,6}\\z";
        String numberString = Long.toString(atmpin);
        return numberString.matches(regex);
    }
    public static boolean isValidEmail(String emailid) 
    {
        String regex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
        return emailid.matches(regex);
    }
    
    public static boolean isValidPincode(long pincode) 
    {
        String regex = "^[0-9]{4,10}$";
        String numberString = Long.toString(pincode);
        return numberString.matches(regex);
    }

	public static void main(String[] args) throws Exception 
	{
		UserDAO ud=new UserDAO();
		Scanner sc= new Scanner(System.in);
		
		boolean option=true;
		while(option) 
		{
			System.out.println("--------------WELCOME TO FINANCE MANAGEMENT-----------------");
			System.out.println("1.ADMIN PAGE");
			System.out.println("2.USER PAGE");
			System.out.println("3.EXIT");
			System.out.println("------------------------ENTER THE OPTION------------------");
			
			int inneroption = Integer.parseInt(sc.nextLine());
			
			
			switch(inneroption) 
			{
			case 1:
				boolean option2=true;
				while(option2)
				{	
					System.out.println("--------------WELCOME TO ADMIN PAGE-----------------");
					System.out.println("1.ADMIN REGISTERATION");
					System.out.println("2.ADMIN LOGIN");
					System.out.println("3.EXIT");
					
					final String role = "ADMIN";
					
					int inneroption2 = Integer.parseInt(sc.nextLine());
					
					switch(inneroption2) 
					{
					case 1:
//						final String role = "ADMIN";
						
						System.out.println("--------ADMIN REGISTERATION DETAILS FORM------------------");
						System.out.println("Enter your Firstname:");
						String firstn = sc.nextLine();
						
						if(isValidUserFirstname(firstn)) 
						{
							System.out.println("Enter the Lastname:");
							String lastn = sc.nextLine();
							
							if(isValidUserLastname(lastn)) 
							{
								System.out.println("Enter the Fathername:");
								String fathern = sc.nextLine();
								
								if(isValidUserFathername(fathern)) 
								{
									System.out.println("Enter your Date-of-Birth:");
									String dob = sc.nextLine();
									
									if(isvalidateDateOfBirth(dob)) 
									{
										System.out.println("Enter your Gender:");
										String gender = sc.next();
										
										if(isvalidateGender(gender))
										{
											System.out.println("Enter your Mobile Number:");
											long mobileno = sc.nextLong();
											sc.nextLine();
											
											if(isValidMobileNumber(mobileno)) 
											{
												System.out.println("Enter your Email ID:");
												String emailid = sc.nextLine();
												
												if(isValidEmail(emailid)) 
												{
													System.out.println("Enter your Address:");
													String addr = sc.nextLine();
											
													System.out.println("Enter your City:");
													String city = sc.nextLine();
														
													if(isValidCity(city)) 
													{
														System.out.println("Enter Your State:");
														String state = sc.nextLine();
															
														if(isValidState(state)) 
														{
															System.out.println("Enter Your Pincode:");
															long pincode = sc.nextLong();
															sc.nextLine();

															if(isValidPincode(pincode)) 
															{
																System.out.println("---------SET A PASSCODE -------");
																System.out.println("SET Your PASSCODE:");
																int atmpin = sc.nextInt();
																sc.nextLine();
																	
																if (isValidPin(atmpin)) 
																{
																	Random random = new Random();
																	int accountno = random.nextInt(999999999);
																	
																	ud.RegisterUser(new UserRegistration(accountno,firstn,lastn,fathern,dob,gender,mobileno,emailid,addr,city,state,pincode,atmpin,role));
																	break;	
																		
																}
																else 
																{
																		System.out.println("INVALID PASSCODE.....Please enter a valid passcode(atleat 4 to 6 digit)\n");
																}
															
																
															}else 
															{
																System.out.println("INVALID PINCODE!!");
																break;
															}
																
														
															}else {
																System.out.println("INVALD STATE!!");
																break;
															}
										
														}else {
															System.out.println("INVALID CITY NAME!!");
															break;
														}
									
													
												}else 
												{
													System.out.println("Invalid email address format. Please enter a valid email address.\n");
													break;
												}
											
												
											}else {
												System.out.println("Invalid mobile number format. Please enter a 10-digit mobile number.\n");
												break;
											}

										}else 
										{
									
											System.out.println("INVALID GENDER!!..Please enter a valid Gender(Male,Female)");
											break;
										}
									

									}else {
										System.out.println("INVALID DOB!!....Please enter a valid DOB.\n");
										break;
									}
								
									
								}else {
									System.out.println("INVALID FATHER NAME!!..Please enter a valid Father Name.\n");
									break;
								}
							
								
							}else 
							{
								System.out.println("INVALID LAST NAME!!...Please enter a valid Last Name.\n");
								break;
							}
						
							
						}
						else 
						{
							System.out.println("INVALID FIRST NAME!!...Please enter a First Name.\n");
							break;
						}
					case 2:
						System.out.println("-----------ADMIN LOGIN PAGE-----------");
											
						System.out.println("Enter your Account NO:");
						int accountno =Integer.parseInt(sc.nextLine());
						
						System.out.println("Enter your Passcode:");
						int atmpin = sc.nextInt();
						sc.nextLine();
						
						ud.LoginUser(accountno,atmpin,role);
						break;
						
					case 3:
						option2 = false;
						break;
					default:
						System.out.println("INVALID OPTION");
						break;
						
					}//case 1 switch
				}
				break;
				
			case 2:
				
				boolean option3=true;
				while(option3) 
				{
					System.out.println("===========WELCOME TO USER LOGIN==========");
					System.out.println("1.USER REGISTERATION");
					System.out.println("2.USER LOGIN");
					System.out.println("3.EXIT");
					
					int inneroption3 = Integer.parseInt(sc.nextLine());
					
					final String role = "USER";
					
					switch(inneroption3) 
					{
					case 1:
					//	final String role = "USER";
						System.out.println("--------USER REGISTERATION DETAILS FORM------------------");
						System.out.println("Enter your Firstname:");
						String firstn = sc.nextLine();
						
						if(isValidUserFirstname(firstn)) 
						{
							System.out.println("Enter the Lastname:");
							String lastn = sc.nextLine();
							
							if(isValidUserLastname(lastn)) 
							{
								System.out.println("Enter the Fathername:");
								String fathern = sc.nextLine();
								
								if(isValidUserFathername(fathern)) 
								{
									System.out.println("Enter your Date-of-Birth:");
									String dob = sc.nextLine();
									
									if(isvalidateDateOfBirth(dob)) 
									{
										System.out.println("Enter your Gender:");
										String gender = sc.next();
										
										if(isvalidateGender(gender))
										{
											System.out.println("Enter your Mobile Number:");
											long mobileno = sc.nextLong();
											sc.nextLine();
											
											if(isValidMobileNumber(mobileno)) 
											{
												System.out.println("Enter your Email ID:");
												String emailid = sc.nextLine();
												
												if(isValidEmail(emailid)) 
												{
													System.out.println("Enter your Address:");
													String addr = sc.nextLine();
													
													System.out.println("Enter your City:");
													String city = sc.nextLine();
														
													if(isValidCity(city)) 
													{
														System.out.println("Enter Your State:");
														String state = sc.nextLine();
															
														if(isValidState(state)) 
														{
															System.out.println("Enter Your Pincode:");
															long pincode = sc.nextInt();
															sc.nextLine();
																	
															if(isValidPincode(pincode)) 
															{	
																System.out.println("---------SET A ATM PIN-------");
																System.out.println("SET Your ATM PIN:");
																int atmpin = sc.nextInt();
																sc.nextLine();
																	
																if (isValidPin(atmpin)) 
																{
																	Random random = new Random();
																	int accountno = random.nextInt(999999999);
																	ud.RegisterUser(new UserRegistration(accountno,firstn,lastn,fathern,dob,gender,mobileno,emailid,addr,city,state,pincode,atmpin,role));
																	break;
																			
																}else {
																		System.out.println("INVALID PIN.....Please enter a valid PIN(atleat 4 to 6 digit)\n");
																}
																	
																
															}else {
																System.out.println("INVALID PINCODE!!");
																break;
																}

														}else {
															System.out.println("INVALD STATE!!");
															break;
															}
										
													}else {
														System.out.println("INVALID CITY NAME!!");
														break;
														}												
												}else 
												{
													System.out.println("Invalid email address format. Please enter a valid email address.\n");
													break;
												}
											
												
											}else {
												System.out.println("Invalid mobile number format. Please enter a 10-digit mobile number.\n");
												break;
											}
										
											
										}else 
										{
									
											System.out.println("INVALID GENDER!!..Please enter a valid Gender(Male,Female).\n");
											break;
										}
									

									}else {
										System.out.println("INVALID DOB!!....Please enter a valid DOB.\n");
										break;
									}
								
									
								}else {
									System.out.println("INVALID FATHER NAME!!..Please enter a valid Father Name.\n");
									break;
								}
							
								
							}else 
							{
								System.out.println("INVALID LAST NAME!!...Please enter a valid Last Name.\n");
								break;
							}
						
							
						}
						else 
						{
							System.out.println("INVALID FIRST NAME!!...Please enter a First Name.\n");
							break;
						}
					case 2:
						System.out.println("-----------USER LOGIN PAGE-----------");
						
						System.out.println("Enter your Account Number:");
						int accountno =Integer.parseInt(sc.nextLine());
						
						System.out.println("Enter your ATM PIN:");
						int atmpin = sc.nextInt();
						sc.nextLine();
						
						ud.LoginUser(accountno,atmpin,role);
						break;
				
					case 3:
						option3 = false;
						break;
					
					default:
						System.out.println("INVALID OPTION");
						break;
					}//case 2 switch
				}//while 3
			break;	
			case 3:
				option = false;
				System.out.println("THANK YOU");
				break;

			default:
				System.out.println("INVALID OPTION");
				break;
	
	}
}
}
}


