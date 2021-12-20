package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Business_Logic.Department;
import Business_Logic.EMS;
import Business_Logic.Employee;
import Business_Logic.Manager;

public class CRUD {
	//Add new department into DB
	public static void add_departments(Department d) {
		//System.out.println("-=-=-=-");
		try {
			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();

			String query="insert into department (name,depart_id,registered_employees)" + " values ('"+d.getName()+"',"+d.getDept_id()+",'"+d.getRegistered_employees()+"')";

			stmt.executeUpdate(query);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	//---------------------------------------
	public static void add_employee_login_details(Employee emp) {
		try {
			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();

			String query="insert into employee_login_info (username, password, personel_id)" +
					" values ('"+emp.getLD().getUsername()+"','"+emp.getLD().getPassword()+"',"+emp.getLD().getPersonel_id()+")";
					//System.out.println(query);
			stmt.executeUpdate(query);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	//------------------------------===============
	public static void add_employee(Employee E,EMS ems) {
		//System.out.println("-=-=-=-");
		try {
			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();

			//System.out.println("999999999");
			String query="insert into employee (personel_id, depart_id, salary, name, address, email, phone_no, dob, joining_date, grade, extra_hours, extra_hours_rate)" +
					" values ("+ E.getPersonel_id()+","+E.getDept_id()+","+E.getSalary()+",'"+E.getPI().getName()+"','"+E.getPI().getAddress()+"','"+E.getPI().getEmail()+"','"+E.getPI().getPhone_no()+"','"+E.getPI().getDob()+"','"+E.getPI().getJoining_date()+"',"+E.getPI().getGrade()+","+E.getBonus().getExtra_hours()+","+E.getBonus().getHourly_rate()+")";
			//System.out.println(query);
			
			add_employee_login_details(E);
			
			stmt.executeUpdate(query);
			for(int i=0;i<ems.getRegistered_departments();i++) {
				if(ems.department[i].getDept_id()==E.getDept_id()) {
					int j=ems.department[i].getRegistered_employees();
					//System.out.println("oooo== "+j);

					update_registered_employee(E.getDept_id(), ems);
				}
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	//----------------------------------------------------------
	public static void add_manager_login_details(Manager emp) {
		try {
			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();

			//System.out.println("999999999");
			String query="insert into manager_login_info (username, password, depart_id)" +
					" values ('"+emp.getLD().getUsername()+"','"+emp.getLD().getPassword()+"',"+emp.getLD().getPersonel_id()+")";
			//System.out.println(query);
			stmt.executeUpdate(query);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	//------------------------------===============
	public static void add_manager(Manager E) {
		//System.out.println("-=-=-=-");
		try {
			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();

			//System.out.println("999999999");
			String query="insert into manager (personel_id, depart_id, salary, name, address, email, phone_no, dob, joining_date, grade, extra_hours, extra_hours_rate)" +
					" values ("+ E.getPersonel_id()+","+E.getDept_id()+","+E.getSalary()+",'"+E.getPI().getName()+"','"+E.getPI().getAddress()+"','"+E.getPI().getEmail()+"','"+E.getPI().getPhone_no()+"','"+E.getPI().getDob()+"','"+E.getPI().getJoining_date()+"',"+E.getPI().getGrade()+","+E.getBonus().getExtra_hours()+","+E.getBonus().getHourly_rate()+")";
			//System.out.println(query);
			add_manager_login_details(E);
			stmt.executeUpdate(query);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	//----------------------------------------------

	//-----------------------------------------------
	public static void delete_empployeeloginInfo_by_personel_id(int id) {
		try {
			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();

			
			System.out.println("------"+id);
			String query="delete from employee_login_info where personel_id="+id;
			//add_manager_login_details(E);
			stmt.executeUpdate(query);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	//---------------------------------
	public static void delete_employee_from_employee_login_info(int id) {
		try {
			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from employee");

			while(rs.next()) {
				if(rs.getInt(2)==id) {
					//System.out.println(rs.getInt(1));
					delete_empployeeloginInfo_by_personel_id(rs.getInt(1));
				}
			}

			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void delete_from_employee(int dept_id) {
		try {
			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();
			//ResultSet rs=stmt.executeQuery("select * from employee");
			String query="delete from employee where depart_id="+dept_id;
			stmt.executeUpdate(query);
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	//------------------------------------------------------------------
	public static void delete_from_manager(int dept_id) {
		try {
			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();
			//ResultSet rs=stmt.executeQuery("select * from employee");
			String query="delete from manager where depart_id="+dept_id;
			stmt.executeUpdate(query);
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	//-------------------------------------------------------------------
	public static void delete_manager_from_manager_login_info(int dept_id) {
		try {
			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();
			//ResultSet rs=stmt.executeQuery("select * from employee");
			String query="delete from manager_login_info where depart_id="+dept_id;
			stmt.executeUpdate(query);
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void delete_department(int dept_id) {
		try {
			delete_employee_from_employee_login_info(dept_id);
			delete_from_employee(dept_id);
			delete_manager_from_manager_login_info(dept_id);
			delete_from_manager(dept_id);
			
			String url="jdbc:mysql://localhost:3306/ap_project";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","qismat143@");
			Statement stmt=con.createStatement();

			
			String query="delete from department where depart_id="+dept_id;
			stmt.executeUpdate(query);
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	//---------------------------------------------------------------------
	public static void update_registered_employee(int deptT,EMS ems) {
		for(int i=0;i<ems.getRegistered_departments();i++) {
			if(deptT==ems.department[i].getDept_id()) {
				int k=ems.department[i].getRegistered_employees();
				Load_Data.update_registered_employees(k, deptT);
			}
		}
	}
	//---------------------------------------------------------------------
	public static void delete_employee(int dept_Id,EMS ems) {
		delete_employee_from_employee_login_info(dept_Id);
		delete_from_employee(dept_Id);
		//System.out.println(dept_Id);
		//System.out.println(ems.getRegistered_departments());
		for(int i=0;i<ems.getRegistered_departments();i++) {
			if(ems.department[i].getDept_id()==dept_Id) {
				int j=ems.department[i].getRegistered_employees();
				//System.out.println("oooo== "+j);
				update_registered_employee(dept_Id, ems);
			}
		}
		
	}
	//------------------------------------------------------------------------
	
}
