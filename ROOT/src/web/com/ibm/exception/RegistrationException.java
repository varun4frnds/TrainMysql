package web.com.ibm.exception;

public class RegistrationException extends Exception{
	   private static final long serialVersionUID = 1L;
		
	     public RegistrationException(String message)
	     {
	    	 super(message);
	     }

	     public RegistrationException(Throwable t)
	     {
	    	 super(t);
	     }

}
