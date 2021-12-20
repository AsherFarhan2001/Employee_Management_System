package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Business_Logic.Bonus;
import Business_Logic.Department;
import Business_Logic.EMS;
import Business_Logic.Employee;
import Business_Logic.Login_Details;
import Business_Logic.Manager;
import Business_Logic.Personel_Info;

public class Load_Data {

	// function to load departments at the start of the program
	public static void update_departments(EMS ems) {
		try {
			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from department");


			while(rs.next()) {
				Department d=new Department(rs.getString(1),rs.getInt(2),10);
				ems.addDepartment(d);
			}

			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	// function to update manager login details at the start of the proram
	public static void update_manager_login_details(Manager manager) {
		try {

			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from manager_login_info");

			Login_Details ld;

			while(rs.next()) {
				if(rs.getInt(3)==manager.getDept_id()) {
					ld=new Login_Details(rs.getString(1),rs.getString(2),rs.getInt(3));
					manager.setLD(ld);
				}
			}

			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	// function to update managers in the departments at the start of the program
	public static void update_managers(Department d) {
		try {

			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from manager");

			Manager manager;
			Personel_Info pi;
			Login_Details ld;
			Bonus bonus;

			while(rs.next()) {
				if(rs.getInt(2)==d.getDept_id()) {
					manager=new Manager(rs.getInt(1),rs.getInt(2),rs.getInt(3));
					pi= new Personel_Info(rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
					pi.display();
					manager.setPI(pi);
					bonus=new Bonus(rs.getInt(11),rs.getInt(12));
					manager.setBonus(bonus);
					update_manager_login_details(manager);
					d.setManager(manager);
					break;
				}
			}

			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	// function to update no of regsitered employees in a department
	public static void update_registered_employees(int i,int deptId) {
		try {
			//System.out.println("I = "+i);
			//System.out.println(deptId);
			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();
			String query="update department set registered_employees="+i+" where depart_id="+deptId;
			//System.out.println(query);
			stmt.executeUpdate(query);

			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	// function to update employee login details at the start of the program
	public static void update_employee_login_details(Employee emp) {
		try {

			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from employee_login_info");

			Login_Details ld;

			while(rs.next()) {
				if(rs.getInt(3)==emp.getPersonel_id()) {
					ld=new Login_Details(rs.getString(1),rs.getString(2),rs.getInt(3));
					emp.setLD(ld);
					break;
				}
			}

			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	// function to update employees in the department at the start of the program
	public static void update_employees(Department d) {
		try {

			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from employee");
			Employee emp;
			Personel_Info pi;
			Login_Details ld;
			Bonus bonus;
			int i=0;
			while(rs.next()) {
				if(rs.getInt(2)==d.getDept_id()) {
					emp=new Employee(rs.getInt(1),rs.getInt(2),rs.getInt(3));
					pi= new Personel_Info(rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
					pi.display();
					emp.setPI(pi);
					bonus=new Bonus(rs.getInt(11),rs.getInt(12));
					emp.setBonus(bonus);
					update_employee_login_details(emp);
					d.addEmployee(emp);
					i=d.getRegistered_employees();
					update_registered_employees(i,rs.getInt(2));
					break;
				}
			}
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);

		}
	}
}
