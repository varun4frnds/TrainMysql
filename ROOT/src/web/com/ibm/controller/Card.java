package web.com.ibm.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.PortableInterceptor.DISCARDING;



import web.com.ibm.bean.Passenger;
import web.com.ibm.bo.Ticket;
import web.com.ibm.dao.PnrDAO;

/**
 * Servlet implementation class Card
 */
@WebServlet("/Card")
public class Card extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public static String retpnr;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Card() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter p=response.getWriter();
		String s2=request.getParameter("s1");
		
		if(s2.equals("csubmit"))
		{
		try {
			
			String emy=request.getParameter("date");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");
		    Date expiry = simpleDateFormat.parse(emy);
			 boolean expired = expiry.before(new Date());
			    if (expired == true)
			    {
			    	request.setAttribute("error5","Date Expired!!!");
			        RequestDispatcher rd=request.getRequestDispatcher("Card.jsp");
			       rd.include(request, response);
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
				     retpnr=pn.generatePNR(source,destination,date);
	 SimpleDateFormat df=new SimpleDateFormat("yyyy/MM/dd");
	 String sdate=df.format(date);
				     String loginname=pnr.getAttribute("logname").toString();
				     PnrDAO pnrdao=new PnrDAO(); 
	 boolean flag= pnrdao.insertPnr(loginname, retpnr,price,sdate);
				     HttpSession pnrs=request.getSession();
					 pnrs.setAttribute("mypnr",retpnr);
				     System.out.println("My pnr is"+retpnr);
				     if(flag=true)
				     {
   RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
      rd.forward(request, response);
}}
		} catch(Exception e)
	     {
e.printStackTrace();
	     }
		}
		
		else if(s2.equals("Download"))
		{
			StringBuilder sbf=new StringBuilder();
			HttpSession session=request.getSession();
			String pnr=session.getAttribute("mypnr").toString();
			System.out.println(pnr);
			int tno=(int) session.getAttribute("trainNo");
			System.out.println(tno);
			String tname=session.getAttribute("trainName").toString();
			System.out.println(tname);
			String tsource=session.getAttribute("source").toString();
			System.out.println(tsource);
			String tdest=session.getAttribute("destination").toString();
			System.out.println(tdest);
			String date=session.getAttribute("date").toString();
			
			TreeMap<Passenger,Double> tm=(TreeMap<Passenger,Double>) session.getAttribute("passenger");
			double tprice=(double) session.getAttribute("totalprice");
			Set<Passenger> s=tm.keySet();
			Iterator<Passenger> itr=s.iterator();
			System.out.println("Name"+"\t"+"Age"+"\t"+"Gender"+"\t"+"Fare");
			sbf.append("Pnr       :  "+Card.retpnr);
			sbf.append(System.lineSeparator());
			
			
			sbf.append("Train no   :  "+tno);
			sbf.append(System.lineSeparator());
			
			
			sbf.append("Train name :  "+tname);
			sbf.append(System.lineSeparator());
			
			
			sbf.append("From       :  "+tsource);
			sbf.append(System.lineSeparator());
			
			
			sbf.append("To         :  "+tdest);
			sbf.append(System.lineSeparator());
			
			
			sbf.append("Travel Date:  "+date);
			sbf.append(System.lineSeparator());
			
			
			sbf.append("Passengers :  ");
			sbf.append(System.lineSeparator());
						
			sbf.append("Name"+"\t"+"Age"+"\t"+"Gender"+"\t"+"Fare");
			sbf.append(System.lineSeparator());
						
			
			for(int i=0;i<s.size();i++)
			{
				Passenger r=itr.next();
				Double y=tm.get(r);
				System.out.println(r.getName()+"\t"+r.getAge()+"\t"+r.getGender()+"\t"+"\t"+y);	
				sbf.append(r.getName()+"\t"+r.getAge()+"\t"+r.getGender()+"\t"+y);
				sbf.append(System.lineSeparator());
				
	         }
			sbf.append("Total Price:"+tprice);
			System.out.println(tprice);
			session.setAttribute("sbf", sbf);
			
	        String stamp= Card.retpnr;
	        System.out.println(stamp);
	        String home = System.getProperty("user.home");
	        BufferedWriter bwr=new BufferedWriter(new FileWriter(new File(home+"/Downloads/" +stamp + ".txt")));
	        bwr.write(sbf.toString());
	        bwr.flush();
	        bwr.close();
	        RequestDispatcher dispatcher=request.getRequestDispatcher("FinallyDone.jsp");
		    dispatcher.forward(request, response);
	        }
	}
}
		
