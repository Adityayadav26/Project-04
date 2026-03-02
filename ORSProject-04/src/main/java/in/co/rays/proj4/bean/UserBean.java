package in.co.rays.proj4.bean;

import java.util.Date;

public class UserBean  extends BaseBean{
	
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String confirmPassword;
	private Date dob;
	private String mobileNo;
	private long roleId;
	private String gender;
	
	public String getfirstName() {
		return firstName;
		
	}
	public void setfirstName (String firstName) {
		this.firstName = firstName;
	}
	
	public String getlastName() {
		return lastName;
		
	}
	
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getlogin() {
		return login;
	}
	
	public void setlogin(String login) {
		this.login = login;
	}
	
	public String getpassword() {
		return password;
		}
	
	public void setpassword(String password) {
		this.password = password;
	}
	
	public String getconfirmPassword() {
		return confirmPassword;
		
	}
	public void setconfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
		
	}
	public Date getdob() {
		return dob;
		
	}
	
	public void setdo(Date dob) {
		this.dob = dob;
		
	}
	
	public String getmobileNo() {
		return mobileNo;
		
	}
	
	public void setmobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
		
	}
	
	public long getroleId() {
		return roleId;
		
	}
	
	public void setroleId(long roleId) {
		this.roleId = roleId;
		
	}
	
	public String getgender() {
		return gender;
		
	}
	
	public void setgender(String gender) {
		this.gender = gender;
		
	}
	
	
	}
		
	


