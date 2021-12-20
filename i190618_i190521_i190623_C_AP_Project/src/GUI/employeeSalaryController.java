package GUI;
import java.net.URL;
import java.util.ResourceBundle;

import Business_Logic.EMS;
import Business_Logic.Employee;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class employeeSalaryController implements Initializable{

	@FXML
	private Text salary;

	private EMS ems;
    private Employee emp=null;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ems=Main.get_ems();
		int id=loginController.id();
		
		for(int i=0;i<ems.getRegistered_departments();i++) {
			for(int j=0;j<ems.department[i].getRegistered_employees();j++) {
				if(ems.department[i].getEmployees()[j].getPersonel_id()==id) {
					emp=ems.department[i].getEmployees()[j];
					break;
				}
			}
		}
		String s=String.valueOf(emp.getSalary());
		salary.setText("Your Salary is : "+s);
		
	}


}
