package File_Handling;

import java.io.FileWriter;
import java.io.IOException;

import Business_Logic.EMS;

public class Write_to_File {
	public static void saveManager(EMS ems)					// Writing Manager in File Manager.txt
	{
		try
		{
			FileWriter filewrite = new FileWriter("Manager.txt");
			for(int i=0;i<ems.getRegistered_departments();i++)
			{
				filewrite.write(ems.department[i].getManager().getPersonel_id() + "  " + ems.department[i].getManager().getSalary() + "  " + ems.department[i].getManager().getPI().getName() + "  " + 
						ems.department[i].getManager().getPI().getAddress() + "  " + ems.department[i].getManager().getPI().getEmail() + "  " + ems.department[i].getManager().getPI().getPhone_no() + "  " + ems.department[i].getManager().getPI().getDob() + "  " + ems.department[i].getManager().getPI().getJoining_date() + "  " + ems.department[i].getManager().getPI().getGrade() + "" );

			}

			filewrite.close();	
		}

		catch(IOException e)
		{
			System.out.println(e);
		}
	}

	public static void saveEmployee(EMS ems)				// Writing Employees in file Employee.txt
	{
		try
		{
			FileWriter filewrite = new FileWriter("Employee.txt");
			for(int i=0;i<ems.getRegistered_departments();i++)
			{
				for(int j=0;j<ems.department[i].getRegistered_employees();j++)
				{
					filewrite.write(ems.department[j].getEmployees()[j].getPersonel_id() + "  " + ems.department[j].getEmployees()[j].getSalary() + "  " + ems.department[j].getEmployees()[j].getPI().getName() + "  " + 
							ems.department[j].getEmployees()[j].getPI().getAddress() + "  " + ems.department[j].getEmployees()[j].getPI().getEmail() + "  " + ems.department[j].getEmployees()[j].getPI().getPhone_no() + "  " + ems.department[j].getEmployees()[j].getPI().getDob() + "  " + ems.department[j].getEmployees()[j].getPI().getJoining_date() + "  " + ems.department[i].getEmployees()[j].getPI().getGrade() + "" );
					filewrite.append('\n');
				}
			}
			filewrite.close();
		}

		catch(IOException e)
		{
			System.out.println(e);
		}
	}

	public static void saveDepartments(EMS ems)				// writing departments in departments.txt
	{
		try
		{
			FileWriter filewrite = new FileWriter("Departments.txt");
			for(int i=0;i<ems.getRegistered_departments();i++)
			{
				filewrite.write(ems.department[i].getName() + "  " + ems.department[i].getDept_id() + "  " + ems.department[i].getRegistered_employees() + "");
				filewrite.append('\n');
			}
			filewrite.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}

	public static void saveManagerLoginInfo(EMS ems)
	{
		try
		{
			FileWriter filewrite = new FileWriter("Manager_login_info.txt");
			for(int i=0;i<ems.getRegistered_departments();i++)
			{
				for(int j=0;j<ems.department[i].getRegistered_employees();j++)
				{
					filewrite.write(ems.department[j].getManager().getLD().getUsername() + "  " + ems.department[j].getManager().getLD().getPassword() + "  " + ems.department[j].getManager().getDept_id() + "");
					filewrite.append('\n');
				}
			}
			filewrite.close();
		}

		catch(IOException e)
		{
			System.out.println(e);
		}

	}

	public static void saveEmployeeLoginInfo(EMS ems)
	{
		try
		{
			FileWriter filewrite = new FileWriter("Employee_login_info.txt");
			for(int i=0;i<ems.getRegistered_departments();i++)
			{
				for(int j=0;j<ems.department[i].getRegistered_employees();j++)
				{
					filewrite.write(ems.department[j].getEmployees()[j].getLD().getUsername() + "  " + ems.department[j].getEmployees()[j].getLD().getPassword() + "  " + ems.department[j].getEmployees()[j].getLD().getPersonel_id() + "");
					filewrite.append('\n');
				}
			}
			filewrite.close();
		}

		catch(IOException e)
		{
			System.out.println(e);
		}
	}

	//---------------------------------------------------------------------------------------------------
	public static void CRUD_FILE(EMS ems) {
		saveManager(ems);
		saveEmployee(ems);
		saveDepartments(ems);
		saveManagerLoginInfo(ems);
		saveEmployeeLoginInfo(ems);
	}
}
