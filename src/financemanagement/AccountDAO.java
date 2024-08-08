package financemanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO 
{
	DBconnection dbconnection = new DBconnection();
    
    public List<Allcontact> getAllContacts() throws SQLException
	 {
		List<Allcontact> list = new ArrayList<>();
		Allcontact Allcontact = null;
		String sql = "SELECT * FROM register";
		
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql);) 
		{
//			preparedstatement.setInt(1, accountno);
			ResultSet resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) 
			{
				Allcontact = new Allcontact();
				
				Allcontact.setAccountno(resultSet.getInt("accountno"));
				Allcontact.setFirstn(resultSet.getString("firstn"));
				Allcontact.setLastn(resultSet.getString("lastn"));
				Allcontact.setFathern(resultSet.getString("fathern"));
				Allcontact.setGender(resultSet.getString("gender"));
				Allcontact.setDob(resultSet.getString("dob"));
				Allcontact.setMobileno(resultSet.getLong("mobileno"));
				Allcontact.setEmailid(resultSet.getString("email"));
				Allcontact.setAddr(resultSet.getString("addr"));
				Allcontact.setCity(resultSet.getString("city"));
				Allcontact.setState(resultSet.getString("state"));
				Allcontact.setPincode(resultSet.getInt("pincode"));
				Allcontact.setRole(resultSet.getString("role"));

				list.add(Allcontact);
			}
		}

		return list;
	}
    
    
    public List<UserRegistration> getContacts(int pin) throws SQLException
	{
			List<UserRegistration> list = new ArrayList<>();
			UserRegistration UserRegistration = null;
			String sql = "SELECT * FROM register where atmpin=?";
			
			try (Connection connection = dbconnection.getConnection();
					PreparedStatement preparedstatement = connection.prepareStatement(sql);) 
			{
				preparedstatement.setInt(1, pin);

				ResultSet resultSet = preparedstatement.executeQuery();
				while (resultSet.next()) 
				{
					UserRegistration = new UserRegistration();
					UserRegistration.setAccountno(resultSet.getInt("accountno"));
					UserRegistration.setFirstn(resultSet.getString("firstn"));
					UserRegistration.setLastn(resultSet.getString("lastn"));
					UserRegistration.setFathern(resultSet.getString("fathern"));
					UserRegistration.setGender(resultSet.getString("gender"));
					UserRegistration.setDob(resultSet.getString("dob"));
					UserRegistration.setMobileno(resultSet.getLong("mobileno"));
					UserRegistration.setEmailid(resultSet.getString("email"));
					UserRegistration.setAddr(resultSet.getString("addr"));
					UserRegistration.setCity(resultSet.getString("city"));
					UserRegistration.setState(resultSet.getString("state"));
					UserRegistration.setPincode(resultSet.getInt("pincode"));

					list.add(UserRegistration);
				}
			}

			return list;
	}
    
    public void widthraw( Widthraw Widthraw) throws SQLException 
    {	
    	String query = "insert into  transcation(userid,accountno,atmpin,process,amount,balance,timestamp) values(?,?,?,?,?,?,?)";
//		String query = "insert into  transcation values(?,?,?,?,?)";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);) 
		{
			statement.setInt(1, Widthraw.getUserid());
			statement.setInt(2, Widthraw.getAccountno());
			statement.setInt(3, Widthraw.getAtmpin());
			statement.setString(4, Widthraw.getProcess());
			statement.setDouble(5, Widthraw.getAmount());
			statement.setDouble(6, Widthraw.getBalance());
			statement.setString(7, Widthraw.getTimestamp());
			
			int rs = statement.executeUpdate();
			
			if (rs > 0) {
				System.out.println("AMOUNT "+" "+Widthraw.getAmount()+" "+"WIDTHRAW SUCCESSFULLY-----!!!!");
			} else {
				System.out.println("AMOUNT NOT WIDTHRAW PLEASE CHECK THE DETAILS----!!!!");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
    
   public void deposit( Deposite Deposite) throws SQLException 
    {	
	   
	   
	   //insert into transition
	   
	   String query1 = "insert into  transcation(userid,accountno,atmpin,process,amount,balance,timestamp) values(?,?,?,?,?,?,?)";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query1);) 
		{
			statement.setInt(1, Deposite.getuserid1());
			statement.setInt(2, Deposite.getAccountno());
			statement.setInt(3, Deposite.getAtmpin());
			statement.setString(4, Deposite.getProcess());
			statement.setDouble(5, Deposite.getAmount());
    		statement.setDouble(6, Deposite.getBalance());
    		statement.setString(7, Deposite.getTimestamp());
    
			
			int rs = statement.executeUpdate();
			
			if (rs > 0) {
				System.out.println("AMOUNT "+" "+Deposite.getAmount()+" "+"DEPOSIT SUCCESSFULLY-----!!!!");
			} else {
				System.out.println("AMOUNT NOT DEPOSIT PLEASE CHECK THE DETAILS----!!!!");
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
   
   public List<Transcation> getAllTranscation() throws SQLException
	{
			List<Transcation> list1 = new ArrayList<>();
			Transcation Transcation = null;

			String sql = "SELECT * FROM transcation";
			
			try (Connection connection = dbconnection.getConnection();
					PreparedStatement preparedstatement = connection.prepareStatement(sql);) 
			{

				ResultSet resultSet = preparedstatement.executeQuery();
				while (resultSet.next()) 
				{

					Transcation = new Transcation();
					
					Transcation.setAccountno(resultSet.getInt("accountno"));
					Transcation.setUserid(resultSet.getInt("userid"));
					Transcation.setProcess(resultSet.getString("process"));
					Transcation.setAmount(resultSet.getInt("amount"));
					Transcation.setBalance(resultSet.getInt("balance"));
					Transcation.setTimestamp(resultSet.getString("timestamp"));

					list1.add(Transcation);
				}
			}catch (Exception e) {
				System.out.println(e);
			}

			return list1;
	}
    public List<Transcation> getTranscation(int accountno) throws SQLException
	{
			List<Transcation> list1 = new ArrayList<>();
			Transcation Transcation = null;
			String sql = "SELECT * FROM transcation where accountno=?";
			
			try (Connection connection = dbconnection.getConnection();
					PreparedStatement preparedstatement = connection.prepareStatement(sql);) 
			{
				preparedstatement.setInt(1, accountno);

				ResultSet resultSet = preparedstatement.executeQuery();
				while (resultSet.next()) 
				{
					Transcation = new Transcation();					
					Transcation.setId(resultSet.getInt("id"));
					Transcation.setProcess(resultSet.getString("process"));
					Transcation.setAmount(resultSet.getInt("amount"));
					Transcation.setBalance(resultSet.getInt("balance"));
					Transcation.setTimestamp(resultSet.getString("timestamp"));

					list1.add(Transcation);
				}
			}catch (Exception e) {
				System.out.println(e);
			}

			return list1;
	}
    
    public List<Balance> getBalance(int accountno) throws SQLException
 	{
 			List<Balance> list2 = new ArrayList<>();
 			Balance Balance = null;
 			String sql = "SELECT * FROM transcation where accountno =?";
 	
 			try (Connection connection = dbconnection.getConnection();
					PreparedStatement preparedstatement = connection.prepareStatement(sql);) 
			{
				preparedstatement.setInt(1, accountno);
				
 				ResultSet resultSet = preparedstatement.executeQuery();
 				while (resultSet.next()) 
 				{
 					Balance = new Balance();					
 					Balance.setAccountno(resultSet.getInt("accountno"));
 					Balance.setBalance(resultSet.getInt("balance"));

 					list2.add(Balance);
 				}
 			}catch (Exception e) {
 				System.out.println(e);
 			}

 			return list2;
 	}
    public List<Balance> getAllBalance() throws SQLException
 	{
 			List<Balance> list2 = new ArrayList<>();
 			Balance Balance = null;
 			String sql = "SELECT * FROM transcation";
 			
 			try (Connection connection = dbconnection.getConnection();
 					PreparedStatement preparedstatement = connection.prepareStatement(sql);) 
 			{
 				

 				ResultSet resultSet = preparedstatement.executeQuery();
 				while (resultSet.next()) 
 				{
 					Balance = new Balance();					
 					Balance.setAccountno(resultSet.getInt("accountno"));
 					Balance.setBalance(resultSet.getInt("balance"));

 					list2.add(Balance);
 				}
 			}catch (Exception e) {
 				System.out.println(e);
 			}

 			return list2;
 	}
  
}
    
    
