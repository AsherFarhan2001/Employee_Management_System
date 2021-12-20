package Business_Logic;


public class Personel_Info {
	
	private String name;
	private String address;
	private String email;
	private String phone_no;
	private String dob;
	private String joining_date;
	private int grade;
	
	public Personel_Info(String name, String address, String email, String phone_no, String dob, String joining_date,
			int grade) {
		//super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone_no = phone_no;
		this.dob = dob;
		this.joining_date = joining_date;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void display() {
		System.out.println(name+"\t"+address+"\t"+email+"\t"+phone_no+"\t"+dob+"\t"+joining_date+"\t"+grade);
	}
}
