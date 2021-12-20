package Business_Logic;

import Exception_Handling.InvalidSalaryException;

public class Employee {
	private int personel_id;
	private int dept_id;
	private int salary;
	private Personel_Info PI;
	private Login_Details LD;
	private Bonus bonus;
	
	public Employee() {
		this.personel_id = -1;
		this.dept_id = -1;
		this.salary = -1;
	}
	
	public Employee(int personel_id, int dept_id, Personel_Info pI, int salary, Login_Details lD) throws Exception {
		this.personel_id = personel_id;
		this.dept_id = dept_id;
		PI = pI;
		if(salary<0) {
			throw new InvalidSalaryException("Salary cannot be negative.");
		}
		this.salary = salary;
		LD = lD;
		bonus=new Bonus();
	}

	public Employee(int personel_id,int dept_id,int salary) {
		this.personel_id = personel_id;
		this.dept_id = dept_id;
		this.salary = salary;
	}
	
	public int getPersonel_id() {
		return personel_id;
	}

	public void setPersonel_id(int personel_id) {
		this.personel_id = personel_id;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public Personel_Info getPI() {
		return PI;
	}

	public void setPI(Personel_Info pI) {
		PI = pI;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Login_Details getLD() {
		return LD;
	}

	public void setLD(Login_Details lD) {
		LD = lD;
	}

	public Bonus getBonus() {
		return bonus;
	}

	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}
	
}
