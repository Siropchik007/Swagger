package model;

public class User{
	private String firstName;
	private String lastName;
	private String password;
	private int userStatus;
	private String phone;
	private int id;
	private String email;
	private String username;

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public User firstName (String firstName){
		this.firstName = firstName;
		return this;
	}


	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}
	public User lastName (String lastName){
		this.lastName = lastName;
		return this;
	}



	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}
	public User password (String password){
		this.password = password;
		return this;
	}


	public void setUserStatus(int userStatus){
		this.userStatus = userStatus;
	}

	public int getUserStatus(){
		return userStatus;
	}

	public User userStatus (int userStatus){
		this.userStatus = userStatus;
		return this;
	}


	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public User phone (String phone){
		this.phone = phone;
		return this;
	}


	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public User id (int id){
		this.id = id;
		return this;
	}


	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public User email (String email){
		this.email = email;
		return this;
	}


	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public User username (String username){
		this.username = username;
		return this;
	}
}
