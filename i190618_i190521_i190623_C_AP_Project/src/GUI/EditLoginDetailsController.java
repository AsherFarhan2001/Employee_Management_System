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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class EditLoginDetailsController implements Initializable {
	
	private EMS ems;
	
	@FXML
    private Button updateBt1;

    @FXML
    private TextField userTxt;

    @FXML
    private Button back;

    @FXML
    private Button updateBt;

    @FXML
    private PasswordField pass1Txt;

    @FXML
    private PasswordField pass2Txt;

    @FXML
    private TextField show_name_fld;

    @FXML
    private PasswordField currPassTxt;


	private Employee emp=null;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		System.out.println("Login Details");
		ems=Main.get_ems();
		int id=loginController.id();
		System.out.println(id);
		
		for(int i=0;i<ems.getRegistered_departments();i++) {
			for(int j=0;j<ems.department[i].getRegistered_employees();j++) {
				if(ems.department[i].getEmployees()[j].getPersonel_id()==id) {
					emp=ems.department[i].getEmployees()[j];
					break;
				}
			}
		}
		//-------------
		show_name_fld.setText(emp.getPI().getName());
		show_name_fld.setEditable(false);
	}
	
	@FXML
	void check_button_clicked() {
		if(currPassTxt.getText().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Failure");
            alert.setHeaderText(null);
            alert.setContentText("Current Password Field is Empty!");
            alert.showAndWait();
		}
		else if(currPassTxt.getText().equals(emp.getLD().getPassword())) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Password Matched");
            alert.showAndWait();
		}
	}
	//--------------------------------------------------------------------------------------------
	@FXML
	void update_credentials_button_clicked() {
		if(userTxt.getText().isEmpty() || pass1Txt.getText().isEmpty() || pass2Txt.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Failure");
            alert.setHeaderText(null);
            alert.setContentText("One or more Text Fields are Empty!");
            alert.showAndWait();
        }
		else {
			if(currPassTxt.getText().equals(emp.getLD().getPassword())) {
				if(!pass1Txt.getText().equals(pass2Txt.getText())) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
		            alert.initStyle(StageStyle.UTILITY);
		            alert.setTitle("Failure");
		            alert.setHeaderText(null);
		            alert.setContentText("New Passwords donot match!");
		            alert.showAndWait();
				}
				else {
					emp.getLD().setUsername(userTxt.getText());
					emp.getLD().setPassword(pass1Txt.getText());
					Main.get_ems().update_employee_info(emp);
					Update_Employee.update_employee(emp);
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
		            alert.initStyle(StageStyle.UTILITY);
		            alert.setTitle("Success");
		            alert.setHeaderText(null);
		            alert.setContentText("Updated!");
		            alert.showAndWait();
				}
			}
			else if(currPassTxt.getText().isEmpty()) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.initStyle(StageStyle.UTILITY);
	            alert.setTitle("Failure");
	            alert.setHeaderText(null);
	            alert.setContentText("Current Password field is Empty!");
	            alert.showAndWait();
			}
			else {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.initStyle(StageStyle.UTILITY);
	            alert.setTitle("Failure");
	            alert.setHeaderText(null);
	            alert.setContentText("Current Password is not Corrent!");
	            alert.showAndWait();
			}
			
		}
	}
    //------------------------------------------------------------------
	@FXML
	void back_button_clicked() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/EmployeePanel.fxml"));
        Parent root = loader.load();
        Stage window = (Stage)back.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setResizable(false);
	}
}
