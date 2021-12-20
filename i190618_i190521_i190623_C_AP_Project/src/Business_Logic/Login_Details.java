package Business_Logic;


public class Login_Details {

	private String username;
	private String password;
	private int personel_id;
	
	public Login_Details(String username, String password, int personel_id) {
		//super();
		this.username = username;
		this.password = password;
		this.personel_id = personel_id;
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

	public int getPersonel_id() {
		return personel_id;
	}

	public void setPersonel_id(int personel_id) {
		this.personel_id = personel_id;
	}
	
}
