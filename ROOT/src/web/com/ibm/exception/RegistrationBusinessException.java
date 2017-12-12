package web.com.ibm.exception;

public class RegistrationBusinessException extends Exception
{

	private static final long serialVersionUID = 1L;

	public RegistrationBusinessException(String message) 
	{
		super(message);
	}

	public RegistrationBusinessException(Throwable t) 
	{
		super(t);
	}

}
