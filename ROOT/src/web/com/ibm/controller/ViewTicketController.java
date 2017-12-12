package web.com.ibm.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.com.ibm.dao.PnrDAO;

/**
 * Servlet implementation class ViewTicketController
 */
@WebServlet("/ViewTicketController")
public class ViewTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTicketController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PnrDAO pdao=new PnrDAO();
		PrintWriter p=response.getWriter();
		HttpSession session=request.getSession();
		StringBuilder builder=new StringBuilder();
		String s2=request.getParameter("s1");
		String loginname=(String) session.getAttribute("logname");
		String pnum=  (String) request.getParameter("pnrno");
	
		String sdate=(String) request.getParameter("date");
		ArrayList arrpnr=pdao.retrivePnr(loginname);	
		
		//System.out.println(arrpnr);
		
		
		session.setAttribute("array", arrpnr);
		if(s2.equals("view"))
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("View.jsp");
		    dispatcher.forward(request, response);
		}
		if(s2.equals("viewTicket"))
		{
		String  pnr=request.getParameter("pnrno");
	String path="C:/Users/Admin/Downloads/"+pnr+".txt";
    // System.out.println(path);
     String s=null;
		Scanner fileread=new Scanner(new File(path));
		while(fileread.hasNextLine())
		{
		String line=fileread.nextLine();
		String[] details=line.split("-->"); 
		p.println(fileread.nextLine());
		}
		} 	
		else if(s2.equals("cancel"))
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("Cancel.jsp");
		    dispatcher.forward(request, response);
		}
		if(s2.equals("cancelTicket"))
		{
			
		
			Date d1 = null;
			DateFormat df=new SimpleDateFormat("yyyy/MM/dd");
			String  pnr=request.getParameter("pnrno");
			System.out.println(pnr);
			String date=request.getParameter("date");
						try {
			           d1=df.parse(date);
			            } 
						catch (ParseException e) {
			
				         e.printStackTrace();
			               }
						//System.out.println("hello");
	    	Date d=new Date();
	    	
	           if(d1.before(d))
	    			{
	        	  
	        	// System.out.println(pnr);
					boolean result=new File("C:/Users/Admin/Downloads/"+pnr+".txt").delete();
					    if(result==true)
					    {
					    	
					    boolean delete=pdao.deletePnr(pnr);
					       if(delete=true)
					       {
				   p.println("Ticket Cancelled Successfully");
					       }
					    }
					    else
					    	p.println("Ticket Not Cancelled ");
	    			}   
		    else
		    {
		    	
		    p.println("Ticket Booked on Today Cannot be Cancelled");
   		    
	    	}	
		}    	
	}	
	 
	
}	