
package web.com.ibm.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.com.ibm.bean.User;
import web.com.ibm.controller.RegistrationController;
import web.com.ibm.exception.RegistrationException;

public class UserDAO 
{
	private static java.sql.Connection createConnection() throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection in userdao error");
		}  
		  
		 
		
		/*Driver driver=new oracle.jdbc.driver.OracleDriver();
		DriverManager.registerDriver(driver);
		*/return DriverManager.getConnection("jdbc:mysql://mysql:3306/sampledb","user8ON","nQNaARi8ss6fTdhm");		
	}

	public boolean insertUser(User user) throws RegistrationException{
		boolean flag=false;
		try
		{
			Connection con=createConnection();
			String queryString="insert into REGD_USERS values(?,?,?)";
		
		    PreparedStatement prepStatement=con.prepareStatement(queryString);
		    prepStatement.setString(1,user.getUsername());
		    prepStatement.setString(2,user.getPassword());
		    prepStatement.setString(3,user.getEmailid());
		    
		    if(prepStatement.executeUpdate()>0)
		    {
		    	flag=true;
		    }
		    
		}catch(SQLException e)
		{
			throw new RegistrationException(e);
			
		}
		return flag;
	}
	
		

		public static User getUser(String username) throws RegistrationException{
			 User u=new User();
			 RegistrationController c=new RegistrationController();
			 
			try
			{
				Connection con=createConnection();
				String queryString="select * from  REGD_USERS  where username=? ";
			
			    PreparedStatement prepStatement=con.prepareStatement(queryString);
			    prepStatement.setString(1, username);
			    ResultSet rs=prepStatement.executeQuery();
			    if(rs.next())
			    {
			    	String name=rs.getString("username");
			    	u.setUsername(name);
			        String pass=rs.getString("password");
			        u.setPassword(pass);
			    	String email=rs.getString("emailid");
			        u.setEmailid(email);
                    return u;
			    }
			    else
			    {
			    	
			    	return u;
			    }
			 }catch(SQLException e)
			{
				throw new RegistrationException(e);
				
			}
			
		}


}
