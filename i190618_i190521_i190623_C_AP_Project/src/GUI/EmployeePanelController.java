package GUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EmployeePanelController {

    @FXML
    private Button edit_dtls_btn;

    @FXML
    private Button chk_dept_info_btn;

    @FXML
    private Button salary_btn;

    @FXML
    private Button logoutBt;

    @FXML
    private Button prsn_info_btn;

    @FXML
    private Button prsn_logindet_btn;

    @FXML
    private Text time;
    
    @FXML
    void personel_info_btn_clicked() throws IOException {
    	System.out.println("PERsonel info");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/EmployeePersonalInfo.fxml"));
        Parent root = loader.load();
        Stage window = (Stage)prsn_info_btn.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setResizable(false);
    }
    
    @FXML
    void update_login_info() throws IOException {
    	System.out.println("Edit login detail button clicked.");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/EditLoginDetails.fxml"));
        Parent root = loader.load();
        Stage window = (Stage)prsn_logindet_btn.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setResizable(false);
    }
 
    @FXML
    void edit_info_button_clicked() throws IOException {
    	//System.out.println("Edit login detail button clicked.");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/EditPersonalInfo.fxml"));
        Parent root = loader.load();
        Stage window = (Stage)prsn_logindet_btn.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setResizable(false);
    }
    
    @FXML
    void check_depart_info_button_clicked() throws IOException {
    	//System.out.println("Edit login detail button clicked.");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/FromEmployeePanelDepartmentInfo.fxml"));
        Parent root = loader.load();
        Stage window = (Stage)prsn_logindet_btn.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setResizable(false);
    }
    
    @FXML
    void emp_salary_button_clicked() throws IOException {
    	Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/GUI/EmployeeSalary.fxml"));
		//primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Salary");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
    }
    
    @FXML
    void log_out_button_clicked() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/login.fxml"));
        Parent root = loader.load();
        Stage window = (Stage)logoutBt.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setResizable(false);
    }
}
