package Business_Logic;

import DataBase.CRUD;
import Exception_Handling.EmployeeSeatsFullException;

public class Department {
	
	private String name;
	private int dept_id;
	private Manager manager;
	private Employee[] employees;
	private int total_employees;
	private int registered_employees;
	
	// constructor
	public Department(String name, int dept_id, Manager manager,int te) {
		this.name = name;
		this.dept_id = dept_id;
		this.manager = manager;
		total_employees=te;
		employees = new Employee[total_employees];
		this.registered_employees = 0;
	}
	
	// another parameterized constructor
	public Department(String name,int dept_id,int te) {
		this.name = name;
		this.dept_id = dept_id;
		total_employees=te;
		employees = new Employee[total_employees];
		this.registered_employees = 0;
	}

	// function to add employee
	public void addEmployee(Employee emp) throws Exception {
		if(registered_employees<total_employees) {
			employees[registered_employees]=emp;
			registered_employees++;
			//CRUD.add_employee(emp);
		}
		else {
			System.out.println("No seats available.");
			throw new EmployeeSeatsFullException("Employee Capacity Full.");
		}
	}
	
	// function to delete employee
	public void deleteEmployee(int emp_id) {
		int j=0;
		for(int i=0;i<registered_employees;i++) {
			if(emp_id==employees[i].getPersonel_id()) {
				for(j=i;j<registered_employees-1;j++) {
					employees[j]=employees[j+1];
				}
				employees[j]=null;
				registered_employees--;
			}
		}
	}
	
	// function to dipslay employees
	public void displayEmployees() {
		for(int i=0;i<registered_employees;i++) {
			System.out.println(employees[i].getPI().getName());
		}
	}

	
	// setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Employee[] getEmployees() {
		return employees;
	}

	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}

	public int getTotal_employees() {
		return total_employees;
	}

	public void setTotal_employees(int total_employees) {
		this.total_employees = total_employees;
	}

	public int getRegistered_employees() {
		return registered_employees;
	}

	public void setRegistered_employees(int registered_employees) {
		this.registered_employees = registered_employees;
	}
	
	public boolean find_employee(String username,String password,Employee emp) {
		boolean a=false;
		for(int i=0;i<registered_employees;i++) {
			if(employees[i].getLD().getUsername().equals(username) && employees[i].getLD().getPassword().equals(password)) {
				a=true;
				emp.setPersonel_id(employees[i].getPersonel_id());
				emp=employees[i];
				break;
			}
		}
		return a;
	}
	
		
}
