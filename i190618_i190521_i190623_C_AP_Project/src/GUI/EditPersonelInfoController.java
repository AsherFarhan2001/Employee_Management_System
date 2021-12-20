package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Business_Logic.EMS;
import Business_Logic.Employee;
import DataBase.Update_Employee;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EditPersonelInfoController implements Initializable {
	 @FXML
	    private Button updateBt;

	    @FXML
	    private TextField nameTxt;

	    @FXML
	    private TextField addressTxt;

	    @FXML
	    private TextField emailTxt;

	    @FXML
	    private TextField phoneTxt;

	    @FXML
	    private Button retBt;

	    @FXML
	    private TextField NidTxt;

	    @FXML
	    private TextField NnameTxt;

	    @FXML
	    private TextField NaddressTxt;

	    @FXML
	    private TextField NemailTxt;

	    @FXML
	    private TextField NphoneTxt;

	    @FXML
	    private TextField NdobTxt;

	    @FXML
	    private TextField NjoinDateTxt;

	    @FXML
	    private TextField NgradeIdTxt;

	    @FXML
	    private TextField NdeptIdTxt;

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
			
			NidTxt.setText(String.valueOf(emp.getPersonel_id()));
            NnameTxt.setText(emp.getPI().getName());
            NaddressTxt.setText(emp.getPI().getAddress());
            NemailTxt.setText(emp.getPI().getEmail());
            NphoneTxt.setText(emp.getPI().getPhone_no());
            NdobTxt.setText(emp.getPI().getDob());
            NjoinDateTxt.setText(emp.getPI().getJoining_date());
            NgradeIdTxt.setText(String.valueOf(emp.getPI().getGrade()));
            NdeptIdTxt.setText(String.valueOf(emp.getDept_id()));
            
            NidTxt.setEditable(false);
            NnameTxt.setEditable(false);
            NaddressTxt.setEditable(false);
            NemailTxt.setEditable(false);
            NphoneTxt.setEditable(false);
            NdobTxt.setEditable(false);
            NjoinDateTxt.setEditable(false);
            NgradeIdTxt.setEditable(false);
            NdeptIdTxt.setEditable(false);
            
		}

		@FXML
		void update_details_button_clicked() {
			if(nameTxt.getText().isBlank() || addressTxt.getText().isBlank() || emailTxt.getText().isBlank() || phoneTxt.getText().isBlank()) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.initStyle(StageStyle.UTILITY);
	            alert.setTitle("Failure");
	            alert.setHeaderText(null);
	            alert.setContentText("One or more Text Fields are Empty!");
	            alert.showAndWait();
			}
			else {
				emp.getPI().setName(nameTxt.getText());
				emp.getPI().setAddress(addressTxt.getText());
				emp.getPI().setEmail(emailTxt.getText());
				emp.getPI().setPhone_no(phoneTxt.getText());
				Main.get_ems().update_employee_info(emp);
				Update_Employee.update_employee(emp);
				NnameTxt.setText(emp.getPI().getName());
	            NaddressTxt.setText(emp.getPI().getAddress());
	            NemailTxt.setText(emp.getPI().getEmail());
	            NphoneTxt.setText(emp.getPI().getPhone_no());
	            
	            Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.initStyle(StageStyle.UTILITY);
	            alert.setTitle("Success");
	            alert.setHeaderText(null);
	            alert.setContentText("Info UPDATED!");
	            alert.showAndWait();
			}
		}
		@FXML
		void return_button_clicked() throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/EmployeePanel.fxml"));
	        Parent root = loader.load();
	        Stage window = (Stage)retBt.getScene().getWindow();
	        window.setScene(new Scene(root));
	        window.setResizable(false);
		}
}
