package web.com.ibm.bo;

import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;








import java.util.regex.Matcher;
import java.util.regex.Pattern;

import web.com.ibm.bean.User;
import web.com.ibm.controller.Card;
import web.com.ibm.dao.UserDAO;
import web.com.ibm.exception.RegistrationBusinessException;
import web.com.ibm.exception.RegistrationException;

public class RegistrationBo 
{
	public boolean registerUser(User user) throws RegistrationBusinessException,RegistrationException
	{
		boolean successFlag=false;
		String pass=user.getPassword();
				int n=pass.length();
		if(n<5||n>15)
		{
			successFlag=true;
		}
		
		else
		{
			UserDAO userDao=new UserDAO();
		    successFlag=userDao.insertUser(user);
		}
		return successFlag;		
	}
	
	
		
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	


