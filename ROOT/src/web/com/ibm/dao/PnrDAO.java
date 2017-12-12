package web.com.ibm.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import web.com.ibm.bean.Train;

public class PnrDAO {

	private java.sql.Connection createConnection() throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection in userdao error");
		}  
		/*Driver driver=new oracle.jdbc.driver.OracleDriver();
		DriverManager.registerDriver(driver);
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","system","root");	*/	
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","root");
	}
	public boolean insertPnr(String username,String pnr,Double price,String date) {
		boolean flag=false;	
			try
			{
				
				Connection con=createConnection();
				String queryString="insert into PNR values(?,?,?,?)";
			
			    PreparedStatement prepStatement=con.prepareStatement(queryString);
			    prepStatement.setString(1,username);
		        prepStatement.setString(2,pnr);
		       prepStatement.setDouble(3, price);
		        prepStatement.setString(4, date);
		          if(prepStatement.executeUpdate()>0)
			    {
			    	flag=true;
			    }
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		
		return flag;
	}
	public ArrayList<String> retrivePnr(String username)
	{
		String myuser=username;
		String pnr="";
	ArrayList<String> arr=new ArrayList<String>();
		try
		{
			System.out.println(myuser);
			Connection con=createConnection();
			String queryString="select * from  PNR where UNAME=?";
			PreparedStatement ps=con.prepareStatement(queryString);
			
			ps.setString(1, myuser);
		
		    ResultSet rs=ps.executeQuery();
		    //System.out.println(myuser);
		    
		    while(rs.next())
		    {
		   String  name=rs.getString(1);
		    //System.out.println(name);
		     pnr=rs.getString("pnrno");
		    // System.out.println(pnr);
		     String date=rs.getString("sdate");
		     String price=rs.getString("price");
		     
		     arr.add(pnr);
		     arr.add(date);
		    System.out.println(arr);
		    } 
		    return arr;
         }
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return arr;
	}		
	public boolean deletePnr(String pnrvalue)
	{
		boolean flag=false;
		String myuser=pnrvalue;
		String pnr="";
		try
		{
			System.out.println(myuser);
			Connection con=createConnection();
			String queryString="delete from  PNR where pnrno=?";
			PreparedStatement ps=con.prepareStatement(queryString);
			
			ps.setString(1, myuser);
		
		    if(ps.executeUpdate()>0){
		    return flag=true;
		    } 
		    else
		    	return flag=false;
         }
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return flag;
	}		
	}
