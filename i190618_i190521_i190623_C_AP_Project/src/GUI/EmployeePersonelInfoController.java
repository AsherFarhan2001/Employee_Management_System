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

public class EmployeePersonelInfoController implements Initializable {
	
	private EMS ems;
	
	@FXML
    private Button logoutBt;

    @FXML
    private TextField show_name_fld;

    @FXML
    private TextField show_EMPID_fld;

    @FXML
    private TextField show_address_fld;

    @FXML
    private TextField show_email_fld;

    @FXML
    private TextField show_phone_fld;

    @FXML
    private TextField show_dob_fld;

    @FXML
    private TextField show_jngdate_fld;

    @FXML
    private TextField show_depart_id_fld;

    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ems=Main.get_ems();
		Employee emp=null;
		int id=loginController.id();
		//System.out.println(id);
		
		for(int i=0;i<ems.getRegistered_departments();i++) {
			for(int j=0;j<ems.department[i].getRegistered_employees();j++) {
				if(ems.department[i].getEmployees()[j].getPersonel_id()==id) {
					emp=ems.department[i].getEmployees()[j];
					break;
				}
			}
		}
		
		show_name_fld.setText(emp.getPI().getName());
        show_EMPID_fld.setText(String.valueOf(emp.getPersonel_id()));
        show_address_fld.setText(emp.getPI().getAddress());
        show_email_fld.setText(emp.getPI().getEmail());
        show_phone_fld.setText(emp.getPI().getPhone_no());
        show_dob_fld.setText(emp.getPI().getDob());
        show_jngdate_fld.setText(emp.getPI().getJoining_date());
        show_depart_id_fld.setText(String.valueOf(emp.getDept_id()));
		System.out.println("DETAILS");
		
		show_name_fld.setEditable(false);
        show_EMPID_fld.setEditable(false);
        show_address_fld.setEditable(false);
        show_email_fld.setEditable(false);
        show_phone_fld.setEditable(false);
        show_dob_fld.setEditable(false);
        show_jngdate_fld.setEditable(false);
        show_depart_id_fld.setEditable(false);
        
        

	}
    
	@FXML
	void back_button_clicked() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeePanel.fxml"));
        Parent root = loader.load();
        Stage window = (Stage)logoutBt.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setResizable(false);
	}
    
}
