package GUI;

import java.io.IOException;

import Business_Logic.Manager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ManagerPanelController {
    @FXML
    private Button edit_prsnl_info;

    @FXML
    private Button view_salary_btn;

    @FXML
    private Button chk_dept_btn;

    @FXML
    private Button update_login_btn;

    @FXML
    private Button logoutBt;

    @FXML
    private Text time;

    @FXML
    private Button mng_emp_btn;
    
    Manager manager;
    
    @FXML
    void view_edit_personel_info_button_clicked() throws IOException {
    	//manager=new Manager(0,0,0);
    	//manager=loginController.get_Manager();
    	//System.out.println("PERsonel info");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ManagerViewEditPersonelInfo.fxml"));
        Parent root = loader.load();
        Stage window = (Stage)edit_prsnl_info.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setResizable(false);
    }
    
    @FXML
    void check_depart_info_button_clicked() throws IOException {
    	System.out.println("department info");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ManagerDepartmentInfo.fxml"));
        Parent root = loader.load();
        Stage window = (Stage)chk_dept_btn.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setResizable(false);
    }
 
    @FXML
    void manage_employees_btn_clicked() throws IOException {
    	System.out.println("department info");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ManageEmployeesManager.fxml"));
        Parent root = loader.load();
        Stage window = (Stage)mng_emp_btn.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setResizable(false);
    }
    
    @FXML
    void manager_salary_button_clicked() throws IOException {
    	Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/GUI/ManagerSalaryInfo.fxml"));
		//primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Salary");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
    }
    
    @FXML
    void log_out_button_clicked() throws IOException {
    	System.out.println("log out");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/login.fxml"));
        Parent root = loader.load();
        Stage window = (Stage)logoutBt.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setResizable(false);
    }
    
}
