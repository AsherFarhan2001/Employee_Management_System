package Business_Logic;

import DataBase.CRUD;
import DataBase.Load_Data;
import Exception_Handling.InvalidNumberException;

public class Driver {
	public static EMS ems;
	
	public static void main(String[] args) throws Exception {
		
		Login_Details managerDet=new Login_Details("hasnain","12345",3);
		Personel_Info managerInfo=new Personel_Info("hasnain","Islamabad","hasnain.tariq143","12345","11/11/2000","11/11/2021",12);
		Manager manager=new Manager(2,3,managerInfo,120000,managerDet);
		Department department=new Department("Building",3,manager,10);
		Personel_Info AdminInfo=new Personel_Info("Tariq","Islamabad","hasnain.tariq143","12345","11/11/2000","11/11/2021",12);
		Admin admin=new Admin(AdminInfo);
		ems=new EMS(admin,5);
		
		Load_Data.update_departments(ems);
		for(int i=0;i<ems.getRegistered_departments();i++) {
			System.out.println(ems.department[i].getDept_id()); 
		}
		for(int i=0;i<ems.getRegistered_departments();i++) {
			Load_Data.update_managers(ems.department[i]);
		}
		
		for(int i=0;i<ems.getRegistered_departments();i++) {
			Load_Data.update_employees(ems.department[i]);
		}
 		for(int i=0;i<ems.getRegistered_departments();i++) {
 			//System.out.println("---------");
			System.out.println(ems.department[i].getDept_id()); 
		}

		Personel_Info empInfo=new Personel_Info("Noman","Islamabad","hasnain.tariq143","12345","11/11/2000","11/11/2021",12);	
		Login_Details empDet=new Login_Details("noman","12345",5);
		Employee emp=new Employee(5,2,empInfo,3300,empDet);
		 
		//ems.addEployee(emp);
		//CRUD.add_employee(emp,ems);

		//ems.displayEmployees(2);
		ems.deleteEmployee(5, 2);
		CRUD.delete_employee(2, ems);
		
		
	}
}
