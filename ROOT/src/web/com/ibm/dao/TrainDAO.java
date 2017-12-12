package web.com.ibm.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import web.com.ibm.bean.*;

import web.com.ibm.bean.*;

public class TrainDAO {
	
	private java.sql.Connection createConnection() throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection in userdao error");
		}  
		return DriverManager.getConnection("jdbc:mysql://mysql:3306/sampledb","user8ON","nQNaARi8ss6fTdhm");
		/*Driver driver=new oracle.jdbc.driver.OracleDriver();
		DriverManager.registerDriver(driver);
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","system","root");	*/	
	}
    public Train findTrain(String tno)
	{
    	String retreived=tno;
	    int no=Integer.parseInt(retreived);
    	boolean flag=false;
    	Train tr=new Train();
		try
		{
	        
			Connection con=createConnection();
			String queryString="select * from TRAINS where train_no=?";
			PreparedStatement ps=con.prepareStatement(queryString);
			ps.setInt(1, no);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		    int trainNo=rs.getInt(1);
		   // System.out.println(trainNo);
		    tr.setTrainNo(trainNo);
		    String trainName=rs.getString(2);
		    //System.out.println(trainName);
		    tr.setTrainName(trainName);
		   
	        String source=rs.getString(3);
		    tr.setSource(source);
		  //  System.out.println(source);
	        String destination=rs.getString(4);
		    tr.setDestination(destination);
		   // System.out.println(destination);
		    double ticketPrice=rs.getInt(5);
		    tr.setTicketPrice(ticketPrice);
		    //System.out.println(ticketPrice);
		    flag=true;
		    tr=new Train(trainNo,trainName,source,destination,ticketPrice);
		    con.commit();
		    }
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return tr;
			
	}
    
public boolean UpdateTrain(Train t)
	
	{
		boolean flag=false;	
			try
			{
				
			
				Connection con=createConnection();
				String queryString="update TRAINS set source=? , destination=? , ticket_price=?, train_name=? where train_no=?";
			
			    PreparedStatement prepStatement=con.prepareStatement(queryString);
		        prepStatement.setString(4,t.getTrainName());
		        prepStatement.setString(1, t.getSource());
		        prepStatement.setString(2, t.getDestination());
		       prepStatement.setDouble(3, t.getTicketPrice());
		        prepStatement.setInt(5,t.getTrainNo());
		        
		        
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

    public boolean insertTrain(Train t) {
		boolean flag=false;	
			try
			{
				
			
				Connection con=createConnection();
				String queryString="insert into TRAINS values(?,?,?,?,?)";
			
			    PreparedStatement prepStatement=con.prepareStatement(queryString);
		        prepStatement.setInt(1,t.getTrainNo());
		        prepStatement.setString(2,t.getTrainName());
		        prepStatement.setString(3, t.getSource());
		        prepStatement.setString(4, t.getDestination());
		        prepStatement.setDouble(5, t.getTicketPrice());
		        
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
	public ArrayList<Train> findTrains(String source, String destination) throws SQLException{
		
		String retreiveds=source;
		String retreivedd=destination;
		
		ArrayList<Train> mytrains = new ArrayList<Train>();
		try
		{
		boolean flag=false;
		Connection con=createConnection();
		String queryString="select * from TRAINS where source=? AND destination=?";
		PreparedStatement ps=con.prepareStatement(queryString);
		ps.setString(1,source);
		ps.setString(2,destination);
	    ResultSet rs=ps.executeQuery();
	    while(rs.next())
	    {
	    Train tr1=new Train();
	    tr1.setTrainNo(rs.getInt(1));
	    tr1.setTrainName(rs.getString("train_name"));
	    tr1.setSource(rs.getString("source"));
	    tr1.setDestination(rs.getString("destination"));
	    tr1.setTicketPrice(rs.getInt("ticket_price"));
	    
	    mytrains.add(tr1);
	    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	    return mytrains;     
		}
	
	public boolean deleteTrain(int t) {
		boolean flag=false;	
		try
		{
			
		
			Connection con=createConnection();
			String queryString="delete TRAINS where train_no=?";
		
		    PreparedStatement prepStatement=con.prepareStatement(queryString);
	        prepStatement.setInt(1,t);
	        
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
	public ArrayList<Train> source()
	{


		boolean flag=false;
		Train tr=new Train();
		ResultSet rs = null;
		ArrayList<Train> sourcers = new ArrayList<Train>();
		try
		{
	        
			Connection con=createConnection();
			String queryString="select distinct source from TRAINS";
			PreparedStatement ps=con.prepareStatement(queryString);
			
		    rs=ps.executeQuery();
		    while(rs.next())
		    {
		    	Train tr1=new Train();
		    	tr1.setSource(rs.getString("source"));
		    	
		        sourcers.add(tr1);
		    }
		    return sourcers;
		    
		    
		    }
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return sourcers;
			
	}


	public  ArrayList<Train> destination()
	{


		boolean flag=false;
		Train tr=new Train();
		ResultSet rs = null;
		ArrayList<Train> destinationrs = new ArrayList<Train>();
		try
		{
	        
			Connection con=createConnection();
			String queryString="select distinct destination from TRAINS";
			PreparedStatement ps=con.prepareStatement(queryString);
			
		    rs=ps.executeQuery();
		    while(rs.next())
		    {
		    	Train tr2=new Train();
		    	tr2.setDestination(rs.getString("destination"));
		    	System.out.println(tr2.getDestination());
		    	destinationrs.add(tr2);
		    }
		   }
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return destinationrs;
			
	}

	public ArrayList<Train> Trains()
	{


		boolean flag=false;
		Train tr=new Train();
		ResultSet rs = null;
		ArrayList<Train> alltrains = new ArrayList<Train>();
		try
		{
	        
			Connection con=createConnection();
			String queryString="select * from TRAINS";
			PreparedStatement ps=con.prepareStatement(queryString);
			
		    rs=ps.executeQuery();
		    while(rs.next())
		    {
		    	Train tr2=new Train();
		    	tr2.setTrainNo(rs.getInt(1));
		    	tr2.setTrainName(rs.getString(2));
		    	tr2.setSource(rs.getString(3));
		    	tr2.setDestination(rs.getString(4));
		    	tr2.setTicketPrice(rs.getDouble(5));
		        alltrains.add(tr2);
		    }
		   }
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return alltrains;
			
	}
		
	
	
		
		
	    
    
    
    
}    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
