package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import Business_Logic.EMS;
import Business_Logic.Employee;
import Business_Logic.Manager;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class ManagerSalaryController implements Initializable {

	@FXML
	private Text salary;

	private EMS ems;
    private Employee emp=null;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ems=Main.get_ems();
		int id=loginController.id();
		System.out.println("----"+id);
		Manager m = new Manager();
		for(int i=0;i<ems.getRegistered_departments();i++) {
			if(ems.department[i].getDept_id()==id) {
				m=ems.department[i].getManager();
			}
		}
		
		String s=String.valueOf(m.getSalary());
		salary.setText("Your Salary is : "+s);
		
	}

}
