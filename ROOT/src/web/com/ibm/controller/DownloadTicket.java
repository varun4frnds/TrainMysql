package web.com.ibm.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

import web.com.ibm.bean.Passenger;

/**
 * Servlet implementation class DownloadTicket
 */
@WebServlet("/DownloadTicket")
public class DownloadTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadTicket() {
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
				sbf.append("-->");
	         }
			sbf.append("Total Price:"+tprice);
			System.out.println(tprice);
			session.setAttribute("sbf", sbf);
			
	        String stamp= Card.retpnr;
	        System.out.println(stamp);
	        BufferedWriter bwr=new BufferedWriter(new FileWriter(new File("D:", stamp + ".txt")));
	        bwr.write(sbf.toString());
	        bwr.flush();
	        bwr.close();
	        RequestDispatcher dispatcher=request.getRequestDispatcher("FinallyDone.jsp");
		    dispatcher.forward(request, response);
	        }

	}

}
