package web.com.ibm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.com.ibm.bean.User;
import web.com.ibm.bo.RegistrationBo;
import web.com.ibm.exception.RegistrationBusinessException;
import web.com.ibm.exception.RegistrationException;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		String s2=request.getParameter("s1"); 
		User user=new User();
		if(s2.equals("SubmitRegister"))
		{
			
		RegistrationBo registerBo=new RegistrationBo();
		String ruser=request.getParameter("username");
		user.setUsername(ruser);
		String rpass=request.getParameter("password");
		user.setPassword(rpass);
		String remail=request.getParameter("emailid");
		user.setEmailid(remail);
		try {
			if(registerBo.registerUser(user))
			{

    			RequestDispatcher dispatcher=request.getRequestDispatcher("Login.jsp");
    			dispatcher.forward(request,response);
			}
			else
			{	
				request.setAttribute("error", "Invalid username or password or emailid !");
				RequestDispatcher dispatcher=request.getRequestDispatcher("RegistrationForm.jsp");
    			dispatcher.include(request, response);
			}
		}
		catch (RegistrationBusinessException e) {
		
			e.printStackTrace();
		} catch (RegistrationException e) {
		
			e.printStackTrace();
		}
				}
	}

}
