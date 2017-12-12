package web.com.ibm.bean;

public class User 
{
	private String username;
	private String password;
	private String emailid;


	public User() {
		
	}
	public User(String username, String password, String emailid) {
		super();
		this.username = username;
		this.password = password;
		this.emailid = emailid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	
	
	
}
