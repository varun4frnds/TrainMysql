package web.com.ibm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;


import web.com.ibm.bean.Passenger;
import web.com.ibm.bean.Train;
import web.com.ibm.bo.RegistrationBo;
import web.com.ibm.bo.Ticket;
import web.com.ibm.dao.TrainDAO;

/**
 * Servlet implementation class TrainController
 */
@WebServlet("/TrainController")
public class TrainController extends HttpServlet {
	public static Date myDate;
	public static String retpnr;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainController() {
        super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String s2=request.getParameter("s1");
		if(s2.equals("FindTrain"))
		{
			String trainNo=request.getParameter("trainNo");
			int ptrainno=Integer.parseInt(trainNo);
			TrainDAO trainDAO=new TrainDAO();
			Train train=trainDAO.findTrain(trainNo);
			request.setAttribute("object", train);
			int no=train.getTrainNo();
			 if(ptrainno==no)
			 {
			RequestDispatcher dispatcher=request.getRequestDispatcher("TrainDetails.jsp");
		    dispatcher.forward(request, response);
			}
			 else
			 {
				 request.setAttribute("error1", "Invalid TrainNo:!");	
					RequestDispatcher dispatcher=request.getRequestDispatcher("Welcome.jsp");
				    dispatcher.include(request, response);
			 }
		}
		
		else if(s2.equals("udsubmit"))
		{
			Train t=new Train();
			int tno=Integer.parseInt(request.getParameter("tno"));
			t.setTrainNo(tno);
	        String tname=request.getParameter("tname");
	        t.setTrainName(tname);
			String source=request.getParameter("source");
			t.setSource(source);
			String destination=request.getParameter("destination");
			t.setDestination(destination);
			double price=Double.parseDouble(request.getParameter("price"));
			t.setTicketPrice(price);
			TrainDAO updatetrain=new TrainDAO();
			
			if(updatetrain.UpdateTrain(t))
			{
		    request.setAttribute("success","Successfully Updated" );
		    TrainDAO td=new TrainDAO();
			ArrayList<Train> alltrains=td.Trains();
			
			HttpSession ads=request.getSession();
			ads.setAttribute("alltrains",alltrains);
			
			
		    RequestDispatcher dispatcher=request.getRequestDispatcher("ViewTrainsAdmin.jsp");
			dispatcher.forward(request, response);
			}
				
			else
				{
					request.setAttribute("erroru", "Train Number does not exist!");
					RequestDispatcher dispatcher=request.getRequestDispatcher("UpdateTrain.jsp");
					dispatcher.include(request, response);	
				}
				
			}

		else if(s2.equals("asubmit"))
	    {
		Train t=new Train();
		int tno=Integer.parseInt(request.getParameter("tno"));
		t.setTrainNo(tno);
		String tname=request.getParameter("tname");
		t.setTrainName(tname);
		String source=request.getParameter("source");
		t.setSource(source);
		String destination=request.getParameter("destination");
		t.setDestination(destination);
		int price=Integer.parseInt(request.getParameter("price"));
		t.setTicketPrice(price);
		TrainDAO inserttrain=new TrainDAO();
		
		if(inserttrain.insertTrain(t))
		{
			TrainDAO td=new TrainDAO();
			ArrayList<Train> alltrains=td.Trains();
			
			HttpSession ads=request.getSession();
			ads.setAttribute("alltrains",alltrains);
			
		    request.setAttribute("success","Train details added successfully");
			request.getRequestDispatcher("AddTrain.jsp").include(request, response);
		}
		else
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);	
		}
	}
	else if(s2.equals("Find"))
	{
		HttpSession map=request.getSession();
		String source=request.getParameter("source");
		map.setAttribute("source",source);
		String destination=request.getParameter("destination");
		map.setAttribute("destination",destination);
		TrainDAO trainDAO=new TrainDAO();
		
			try {
				ArrayList<Train> train2=trainDAO.findTrains(source,destination);
				HttpSession session = request.getSession();
				session.setAttribute("train2", train2);
				if(train2.isEmpty())
				{
					request.setAttribute("error2", "Invalid source or destination!");		
					RequestDispatcher dispatcher=request.getRequestDispatcher("Welcome.jsp");
					dispatcher.include(request, response);
                }
				else
				{
					RequestDispatcher dispatcher=request.getRequestDispatcher("SourDest.jsp");
					dispatcher.forward(request, response);
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
	
	else if(s2.equals("PassVerify"))
	{
		Date todayDate = new Date();
		String d=request.getParameter("date");
		HttpSession st=request.getSession();
		st.setAttribute("date",d);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			myDate = sdf.parse(d);
			if(sdf.format(myDate).equals(sdf.format(todayDate))||myDate.before(todayDate))
			{
				request.setAttribute("error4", "Invalid Date!");
				RequestDispatcher dispatcher=request.getRequestDispatcher("Book.jsp");
				dispatcher.include(request, response);
	        }
			else{
				HttpSession s=request.getSession();
				s.setAttribute("tdate",d);
				int no=Integer.parseInt(request.getParameter("PassNo"));
				if(no<7)
				{
				RequestDispatcher dispatcher=request.getRequestDispatcher("FinalBook.jsp");
				request.setAttribute("no", no);
    			dispatcher.forward(request, response);
			}
				else
				{
					request.setAttribute("error3", "Passenger cannot be more than 6!");
					RequestDispatcher dispatcher=request.getRequestDispatcher("Book.jsp");
					dispatcher.include(request, response); 
				}
			}
		}catch (ParseException e) {
			e.printStackTrace();
		} 
	}
		
	else if(s2.equals("deletet"))
	{
		int t=Integer.parseInt(request.getParameter("id"));
		TrainDAO trainDAO=new TrainDAO();
		if(trainDAO.deleteTrain(t))
		{
			
			ArrayList<Train> alltrains=trainDAO.Trains();
			request.setAttribute("alltrains",alltrains);    	
	    	
		RequestDispatcher dispatcher=request.getRequestDispatcher("ViewTrainsAdmin.jsp");
	    dispatcher.forward(request, response);
	}
		else
		{
			
		}
	}
	else if(s2.equals("csubmit"))
	{
try {
			
			String emy=request.getParameter("date");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
		    Date expiry = simpleDateFormat.parse(emy);
			 boolean expired = expiry.before(new Date());
			    if (expired == true)
			    {
			        RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
			       rd.forward(request, response);
			    }
			    else
			    {
			    	Ticket pn=new Ticket();
			    	HttpSession pnr=request.getSession();
					double price=(double) pnr.getAttribute("tprice");
					String source=pnr.getAttribute("source").toString();
					System.out.println(source);
					String destination=pnr.getAttribute("destination").toString();
					System.out.println(destination);
				     Date date=	TrainController.myDate;
				     try {
						retpnr=pn.generatePNR(source,destination,date);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				     
			    	 RequestDispatcher rd=request.getRequestDispatcher("Tuccess.jsp");
				     rd.forward(request, response);
			    }
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	else if(s2.equals("psubmit"))
	{
		HttpSession session = request.getSession();
		
		Ticket t=new Ticket();
		String name[]=request.getParameterValues("name");
		String age[]=request.getParameterValues("age");
		String gender[]=request.getParameterValues("gender");
		double price=(double) session.getAttribute("tprice");
		try {
		    TreeMap<Passenger,Double> s= t.CalcFare(name,age,gender,price);
		    HttpSession x=request.getSession();
		    x.setAttribute("passenger",s);
		    request.getRequestDispatcher("Card.jsp").forward(request, response);
		    }catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
		}
	
