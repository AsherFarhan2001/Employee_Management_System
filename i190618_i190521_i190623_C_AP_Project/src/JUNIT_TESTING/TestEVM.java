package JUNIT_TESTING;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Business_Logic.Admin;
import Business_Logic.Department;
import Business_Logic.EMS;
import Business_Logic.Employee;
import Business_Logic.Login_Details;
import Business_Logic.Manager;
import Business_Logic.Personel_Info;


public class TestEVM {
	
	
	private static final PrintStream Out = null;
	private EMS ems;
	private Department department;
	
	@Before
	public void setUp() throws Exception
	{
		Personel_Info AdminInfo=new Personel_Info("Tariq","Islamabad","hasnain.tariq143","12345","11/11/2000","11/11/2021",12);
		Login_Details managerDet=new Login_Details("hasnain","12345",1);
		Personel_Info managerInfo=new Personel_Info("hasnain","Islamabad","hasnain.tariq143","12345","11/11/2000","11/11/2021",12);
		Manager manager=new Manager(1,1,managerInfo,120000,managerDet);
		department=new Department("Construction",1,manager,10);
		Admin admin= new Admin(AdminInfo);
		ems = new  EMS(admin,5);					// 5 is total departments
	
	}
	
	@Test									
	public void testAddDepartment() throws Exception
	{		
		ems.addDepartment(department);
		ems.addDepartment(department);
		int expectedResult = 2;
		int NegativeResult = 6;
		assertEquals(expectedResult,ems.getRegistered_departments());					// positive test case
		assertNotEquals(NegativeResult,ems.getRegistered_departments());				// negative test case
	}
	
	@Test
	public void find_manager() {
		assertEquals(-1,ems.find_manager_login_details("hasnain", "12345"));
	}
	
	@Test
	public void testAddEmployee() throws Exception
	{
		Login_Details managerDet=new Login_Details("hasnain","12345",1);
		Personel_Info managerInfo=new Personel_Info("hasnain","Islamabad","hasnain.tariq143","12345","11/11/2000","11/11/2021",12);
		Manager manager=new Manager(1,1,managerInfo,120000,managerDet);
		Department dep = new Department("Construction",1,manager ,10);
		Personel_Info empInfo1=new Personel_Info("Talha","Islamabad","hasnain.tariq143","12345","11/11/2000","11/11/2021",12);	
		Login_Details empDet1=new Login_Details("Talha","12345",4);
		Employee emp1=new Employee(4,2,empInfo1,3300,empDet1);
		ems.addEployee(emp1);
		Employee expectedResult = emp1;
		
		for(int i=0;i<ems.getRegistered_departments();i++)
		{
			assertEquals(expectedResult,dep.getEmployees());
		}
		
	}
	
	@Test
	public void testDeleteEmployee() throws Exception
	{
		Personel_Info empInfo=new Personel_Info("Noman","Islamabad","hasnain.tariq143","12345","11/11/2000","11/11/2021",12);	
		Login_Details empDet=new Login_Details("noman","12345",3);
		Employee emp=new Employee(3,2,empInfo,3300,empDet);
		Personel_Info empInfo1=new Personel_Info("Talha","Islamabad","hasnain.tariq143","12345","11/11/2000","11/11/2021",12);	
		Login_Details empDet1=new Login_Details("Talha","12345",4);
		Employee emp1=new Employee(4,2,empInfo1,3300,empDet1);
		ems.addEployee(emp);
		ems.addEployee(emp1);
		ems.deleteEmployee(5, 1);
		int expectedResult = 0;
		int negativeResult = 2;
		assertEquals(expectedResult,department.getRegistered_employees());				// positive test case
		assertNotEquals(negativeResult,department.getRegistered_employees());			// negative test case
	}
	
	@Test
	public void testDeleteDepartment() throws Exception
	{
		ems.addDepartment(department);
		ems.addDepartment(department);
		ems.deleteDepartment(1);
		int expectedResult = 1;												// postive test case
		int negativeResult = 2;
		assertEquals(expectedResult,ems.getRegistered_departments());
		assertNotEquals(negativeResult,ems.getRegistered_departments());		// negative test case
	}
	
	@Test
	public void testDisplay() throws Exception
	{
		Personel_Info empInfo1=new Personel_Info("Talha","Islamabad","hasnain.tariq143","12345","11/11/2000","11/11/2021",12);	
		Login_Details empDet1=new Login_Details("Talha","12345",4);
		Employee emp1=new Employee(4,2,empInfo1,3300,empDet1);
		ems.addEployee(emp1);
		ems.displayEmployees(1);
		int expectedResult = 4;
		assertEquals(expectedResult,emp1.getPersonel_id());
	}
	
	@Test
	public void find_employee() throws Exception {
		Personel_Info empInfo1=new Personel_Info("Talha","Islamabad","hasnain.tariq143","12345","11/11/2000","11/11/2021",12);	
		Login_Details empDet1=new Login_Details("Talha","12345",4);
		Employee emp1=new Employee(4,2,empInfo1,3300,empDet1);
		ems.addEployee(emp1);
		ems.displayEmployees(1);
		assertEquals(false,ems.find_employee("Talha", "12345", emp1));
	}
	
	
	@Test
	public void get_registered_departments() throws Exception {
		ems.addDepartment(department);
		assertEquals(1,ems.getRegistered_departments());
	}
	
	@Test
	public void get_registeredEmployees() throws Exception {
		ems.addDepartment(department);
		assertEquals(1,ems.getRegistered_departments());
		Login_Details managerDet=new Login_Details("hasnain","12345",1);
		Personel_Info managerInfo=new Personel_Info("hasnain","Islamabad","hasnain.tariq143","12345","11/11/2000","11/11/2021",12);
		Manager manager=new Manager(1,1,managerInfo,120000,managerDet);
		Department dep = new Department("Construction",1,manager ,10);
		Personel_Info empInfo1=new Personel_Info("Talha","Islamabad","hasnain.tariq143","12345","11/11/2000","11/11/2021",12);	
		Login_Details empDet1=new Login_Details("Talha","12345",4);
		Employee emp1=new Employee(4,1,empInfo1,3300,empDet1);

		
		assertEquals(0,ems.department[0].getRegistered_employees());
	}
	
	@Test
	public void get_registeredEmployees1() throws Exception {
		ems.addDepartment(department);
		assertEquals(1,ems.getRegistered_departments());
		Login_Details managerDet=new Login_Details("hasnain","12345",1);
		Personel_Info managerInfo=new Personel_Info("hasnain","Islamabad","hasnain.tariq143","12345","11/11/2000","11/11/2021",12);
		Manager manager=new Manager(1,1,managerInfo,120000,managerDet);
		Department dep = new Department("Construction",1,manager ,10);
		Personel_Info empInfo1=new Personel_Info("Talha","Islamabad","hasnain.tariq143","12345","11/11/2000","11/11/2021",12);	
		Login_Details empDet1=new Login_Details("Talha","12345",4);
		Employee emp1=new Employee(4,1,empInfo1,3300,empDet1);
		ems.addEployee(emp1);
		
		assertEquals(1,ems.department[0].getRegistered_employees());
	}
	
	@After
	public void destroy()
	{
		System.setOut(Out);
		department = null;
		ems = null;
	}
	
	

}