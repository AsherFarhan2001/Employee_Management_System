package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Business_Logic.EMS;
import Business_Logic.Employee;
import Business_Logic.Manager;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class loginController implements Initializable {

	public EMS ems;
    @FXML
    private Button loginBt;

    @FXML
    private Button resetBt;

    @FXML
    private TextField userText;

    @FXML
    private ComboBox<String> status_drp_btn;

    @FXML
    private PasswordField pass_field_btn;
    
    public static int p_id=0;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		status_drp_btn.getItems().addAll("Employee","Manager","Admin");
	}
	
	private static Employee emp;
    private static Manager manager;
	public static Employee get_emp() {
		return emp;
	}
	
	public static Manager get_Manager() {
		return manager;
	}
	
	public static int id() {
		return p_id;
	}
	
    @FXML
    void login_button_clicked() throws IOException {
    	System.out.println("LOGIN button clicked");
    	ems=Main.get_ems();
    	
    	emp=new Employee();
    	manager=new Manager();
    	String status=status_drp_btn.getValue();
    	//System.out.println(status);
    	//-----------------------------------------------------------------------------------
    	if(status.equals("Employee")) {
    		if(ems.find_employee(userText.getText(), pass_field_btn.getText(), emp)) {
    			System.out.println("TRUE");
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/EmployeePanel.fxml"));
                System.out.println("HELLO");
                Parent root = loader.load();
                Stage window = (Stage)loginBt.getScene().getWindow();
                window.setScene(new Scene(root));
                window.setResizable(false);
                p_id=emp.getPersonel_id();
    		}
    		else {
    			System.out.println("FALSE");
    			Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Record not Found!");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Credentials, Try Again");
                alert.showAndWait();
    		}
    	}
    	//------------------------------------------------------------------------------------
    	else if(status.equals("Manager")) {
    		if(ems.find_manager_login_details(userText.getText(), pass_field_btn.getText())>0) {
    			//System.out.println("TRUE");
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ManagerPanel.fxml"));
                //System.out.println("HELLO");
                Parent root = loader.load();
                Stage window = (Stage)loginBt.getScene().getWindow();
                window.setScene(new Scene(root));
                window.setResizable(false);
                p_id=ems.find_manager_login_details(userText.getText(), pass_field_btn.getText());
                //System.out.println("login  "+p_id);
    		}
    		else {
    			System.out.println("FALSE");
    			Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Record not Found!");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Credentials, Try Again");
                alert.showAndWait();
    		}
    	}
    	//------------------------------------------------------------------------------------
    	else if(status.equals("Admin")) {
    		
    	}
    	
    }
    
    @FXML
    void reset_buton_clicked() throws IOException {
    	System.out.println("main");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/login.fxml"));
        Parent root = loader.load();
        Stage window = (Stage)resetBt.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setResizable(false);
    }
}
