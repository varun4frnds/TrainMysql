package web.com.ibm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.com.ibm.bean.Train;
import web.com.ibm.bean.User;
import web.com.ibm.bo.RegistrationBo;
import web.com.ibm.dao.TrainDAO;
import web.com.ibm.dao.UserDAO;
import web.com.ibm.exception.RegistrationBusinessException;
import web.com.ibm.exception.RegistrationException;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);	
    	}

    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		try
    		{
    			User user=new User();
    			HttpSession hs=request.getSession();
    			
    			UserDAO userdao=new UserDAO();
    			String s2=request.getParameter("s1");
    			user.setUsername(request.getParameter("username"));
    			user.setEmailid(request.getParameter("emailid"));
    			try
    			{
    			user.setPassword(request.getParameter("password"));
    			}catch(NumberFormatException e)
    			{
    				throw new RegistrationBusinessException("password should contain more than five characters");
    				
    			}
    			/*String auser=request.getParameter("LoginName");
    			String apass=request.getParameter("pwd");
    			if(auser.equals("admin")&& apass.equals("admin"))
    			{
    				HttpSession ads=request.getSession();
    				ads.setAttribute("logname",auser);
    				RequestDispatcher dispatcher=request.getRequestDispatcher("Admin.jsp");
        			dispatcher.forward(request, response);
    			}
    			*/
    		/*	else */if(s2.equals("SubmitLogin"))
    			{
    				
    				String auser=request.getParameter("LoginName");
        			String apass=request.getParameter("pwd");
        			if(auser.equals("admin")&& apass.equals("admin"))
        			{
        				TrainDAO td=new TrainDAO();
    	    			ArrayList<Train> alltrains=td.Trains();
    	    			
        				HttpSession ads=request.getSession();
        				ads.setAttribute("alltrains",alltrains);
        				ads.setAttribute("alogname",auser);
        				RequestDispatcher dispatcher=request.getRequestDispatcher("Admin.jsp");
            			dispatcher.forward(request, response);
        			}
                    User u = userdao.getUser(request.getParameter("LoginName"));
    				TrainDAO updatetrain=new TrainDAO();
    				if(((request.getParameter("LoginName")).equals(u.getUsername())) && (request.getParameter("pwd").equals(u.getPassword())))
    				{
    			    	String LoginName=request.getParameter("LoginName");
    			    	HttpSession my=request.getSession();
    			    	TrainDAO td=new TrainDAO();
    	    			ArrayList<Train> alltrains=td.Trains();
    	    			my.setAttribute("alltrains",alltrains);    	
    			    	my.setAttribute("logname",LoginName);
        				ArrayList<Train> destinationrs=updatetrain.destination();
    					my.setAttribute("destinationrs",destinationrs);
    				    
        				
        		    String ucaptcha=request.getParameter("ucaptcha");
    			    String ocaptcha=request.getParameter("hidden");
    			    
    			   if(ucaptcha.equals(ocaptcha))
    			    {
    				   
    				   HttpSession rs=request.getSession();
    					
    					ArrayList<Train> sourcers=updatetrain.source();
    				    rs.setAttribute("sourcers", sourcers);
    					
    				
    				RequestDispatcher dispatcher=request.getRequestDispatcher("Welcome.jsp");
        			dispatcher.forward(request, response);
    			    
    				}
    			
    			   else
					{request.setAttribute("errorr", "Invalid captcha!");
					RequestDispatcher dispatcher=request.getRequestDispatcher("Login.jsp");
       			    dispatcher.include(request, response);	
					}
    			  }
    				else
    				{
    					request.setAttribute("error", "Invalid username or password !");
    					RequestDispatcher dispatcher=request.getRequestDispatcher("Login.jsp");
            			dispatcher.include(request, response);		
    				}
    			}
    		}catch(RegistrationBusinessException e)
    		{
    		String message=e.getMessage();
    		request.setAttribute("message", message);
    		RequestDispatcher dispatcher=request.getRequestDispatcher("RegistrationForm.jsp");
    		dispatcher.forward(request, response);
    		}
    		catch(RegistrationException e)
    		{
            request.setAttribute("errMessage","Fatal Error");
            RequestDispatcher dispatcher=request.getRequestDispatcher("Error.jsp");
            dispatcher.forward(request, response);
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}

    }


