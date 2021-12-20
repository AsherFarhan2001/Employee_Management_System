package Business_Logic;

import DataBase.CRUD;
import Exception_Handling.DpartmentCapacityFullException;
import Exception_Handling.InvalidNumberException;

public class EMS {
	
	private Admin admin;
	public Department[] department;
	private int total_departments;
	private int registered_departments;


	// constructor
	public EMS(Admin admin, int total_departments) throws InvalidNumberException {
		if(total_departments<0) {
			throw new InvalidNumberException("Invalid No. of Departments.");
		}
		this.setAdmin(admin);
		department=new Department[total_departments];
		this.setTotal_departments(total_departments);
		this.registered_departments = 0;
	}

	// function to add employee
	public void addEployee(Employee emp) throws Exception {
		for(int i=0;i<registered_departments;i++) {
			//System.out.println("employee added");
			if(emp.getDept_id()==department[i].getDept_id()) {
				department[i].addEmployee(emp);
			}
		}
	}

	// function to delete employee
	public void deleteEmployee(int employee_id,int dept_id) {
		for(int i=0;i<registered_departments;i++) {
			if(department[i].getDept_id()==dept_id) {
				department[i].deleteEmployee(employee_id);
			}
		}
	}
	
	// function to add department
	public void addDepartment(Department d) throws Exception {
		if(registered_departments<total_departments) {
			department[registered_departments]=d;
			registered_departments++;
			//CRUD.add_departments(d);
		}
		else {
			System.out.println("No department can be added more.");
			throw new DpartmentCapacityFullException("Departments Capacity full.");
		}
	}

	// function to delete department
	public void deleteDepartment(int dept_id) {
		int j=0;
		for(int i=0;i<registered_departments;i++) {
			if(department[i].getDept_id()==dept_id) {
				for(j=i;j<registered_departments-1;j++) {
					department[j]=department[j+1];
				}
				department[j]=null;
				registered_departments--;
			}
		}
	}

	// function to display all employees
	public void displayEmployees(int dept_id) {
		for(int i=0;i<registered_departments;i++) {
			if(dept_id==department[i].getDept_id()) {
				department[i].displayEmployees();
			}
		}
	}
	
	// function to find a certain employee in all departments
	public boolean find_employee(String username,String password,Employee emp) {
		boolean a=false;
		for(int i=0;i<registered_departments;i++) {
			if(department[i].find_employee(username, password, emp)) {
				a=true;
				break;
			}
		}
		return a;
	}
	
	// function to update employee in some department
	public void update_employee_info(Employee emp) {
		for(int i=0;i<registered_departments;i++) {
			if(department[i].getDept_id()==emp.getDept_id()) {
				for(int j=0;j<department[i].getRegistered_employees();j++) {
					if(department[i].getEmployees()[j].getPersonel_id()==emp.getPersonel_id()) {
						department[i].getEmployees()[j]=emp;
						//break;
					}
				}
			}
		}
	}
	
	// function to update a manager in some department
	public void update_manager_info(Manager m) {
		for(int i=0;i<registered_departments;i++) {
			if(department[i].getDept_id()==m.getDept_id()) {
				department[i].setManager(m);
			}
		}
		
	}
	
	
	// function to find a certain manager login details in all departments
	public int find_manager_login_details(String username, String pass) {
		int a=-1;
		for(int i=0;i<registered_departments;i++) {
			if(department[i].getManager().getLD().getUsername().equals(username) && department[i].getManager().getLD().getPassword().equals(pass)) {
				
				a=department[i].getDept_id();
				//break;
			}
		}
		return a;
	}
	
	// setters and getters
	public int getTotal_departments() {
		return total_departments;
	}


	public void setTotal_departments(int total_departments) {
		this.total_departments = total_departments;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public int getRegistered_departments() {
		return registered_departments;
	}


	public void setRegistered_departments(int registered_departments) {
		this.registered_departments = registered_departments;
	}

}
