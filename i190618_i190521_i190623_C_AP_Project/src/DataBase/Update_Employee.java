package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import Business_Logic.Employee;

public class Update_Employee {
	
	public static void update_employee(Employee E)
	{
		update_employee_name(E);
		update_employee_address(E);
		update_employee_email(E);
		update_employee_phone_no(E);
		update_employee_username(E);
		update_employee_password(E);

	}

	//update employee name
	public static void update_employee_name(Employee E) {
		try {

			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();


			String query="UPDATE employee set name='"+E.getPI().getName()+"' WHERE personel_id="+E.getPersonel_id();
			stmt.executeUpdate(query);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}


	//update employee email
	public static void update_employee_email(Employee E) {
		try {

			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();


			String query="UPDATE employee set email='"+E.getPI().getEmail()+"' WHERE personel_id="+E.getPersonel_id();
			stmt.executeUpdate(query);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	//update employee address
	public static void update_employee_address(Employee E) {
		try {

			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();


			String query="UPDATE employee set address='"+E.getPI().getAddress()+"' WHERE personel_id="+E.getPersonel_id();
			stmt.executeUpdate(query);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}


	//update employee phone_no
	public static void update_employee_phone_no(Employee E) {
		try {

			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();


			String query="UPDATE employee set phone_no='"+E.getPI().getPhone_no()+"' WHERE personel_id="+E.getPersonel_id();
			stmt.executeUpdate(query);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}


	//update employee username
	public static void update_employee_username(Employee E) {
		try {

			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();


			String query="UPDATE employee_login_info set username='"+E.getLD().getUsername()+"' WHERE personel_id="+E.getPersonel_id();
			stmt.executeUpdate(query);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}


	//update employee password
	public static void update_employee_password(Employee E) {
		try {

			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();


			String query="UPDATE employee_login_info set password='"+E.getLD().getPassword()+"' WHERE personel_id="+E.getPersonel_id();
			stmt.executeUpdate(query);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
