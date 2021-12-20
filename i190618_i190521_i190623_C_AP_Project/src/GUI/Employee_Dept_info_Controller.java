package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Business_Logic.EMS;
import Business_Logic.Employee;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Employee_Dept_info_Controller implements Initializable{
	@FXML
    private Button go_back_btn;

    @FXML
    private TextField name_fld;

    @FXML
    private TextField dpt_id_fld;

    @FXML
    private TextField dpt_name_fld;
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
		
		String name = null;
		String did = null;
		String te = null;
		
		for(int i=0;i<ems.getRegistered_departments();i++) {
			if(ems.department[i].getDept_id()==emp.getDept_id()) {
				name=ems.department[i].getName();
				did=String.valueOf(ems.department[i].getDept_id());
				te=String.valueOf(ems.department[i].getRegistered_employees());
				break;
			}
		}
		
		name_fld.setEditable(false);
		dpt_id_fld.setEditable(false);
		dpt_name_fld.setEditable(false);
		
		name_fld.setText(te);
		dpt_id_fld.setText(did);
		dpt_name_fld.setText(name);
		
	}
	
	@FXML
	void back() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/EmployeePanel.fxml"));
        Parent root = loader.load();
        Stage window = (Stage)go_back_btn.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setResizable(false);
	}
}
