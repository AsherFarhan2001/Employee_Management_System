package GUI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Business_Logic.Bonus;
import Business_Logic.Department;
import Business_Logic.EMS;
import Business_Logic.Employee;
import Business_Logic.Login_Details;
import Business_Logic.Personel_Info;
import DataBase.CRUD;
import File_Handling.Write_to_File;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ManagerEmployeeManagerController implements Initializable {
	 @FXML
	    private TextField addressTxtN;

	    @FXML
	    private Button removeBt;

	    @FXML
	    private TextField joiningdate;

	    @FXML
	    private TextField grade;

	    @FXML
	    private Button addBt;

	    @FXML
	    private TableView<Personel_Info> view;

	    @FXML
	    private TableColumn<Personel_Info, String> col_name;

	    @FXML
	    private TableColumn<Personel_Info, String> col_addr;

	    @FXML
	    private TableColumn<Personel_Info, String> col_email;

	    @FXML
	    private TableColumn<Personel_Info, String> col_ph;

	    @FXML
	    private TableColumn<Personel_Info, String> dob;

	    @FXML
	    private TableColumn<Personel_Info, String> col_join;

	    @FXML
	    private TableColumn<Personel_Info, Integer> col_gradeID;

	    @FXML
	    private TextField nameTxt;

	    @FXML
	    private TextField idTxt;

	    @FXML
	    private TextField emailTxt;

	    @FXML
	    private TextField phTxt;

	    @FXML
	    private Button retBt;
	    
	    @FXML
	    private TextField DOB;
	    
	    @FXML
	    private TextField salary;

    ObservableList<Personel_Info> currEm;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		fillTables();
	}
	
	public static ObservableList<Personel_Info> getOnlyEmployeeDetail(){

		ObservableList<Personel_Info> list = FXCollections.observableArrayList();
		
		int id=loginController.id();
		
		EMS ems=Main.get_ems();
		Department d=null;
		for(int i=0;i<ems.getRegistered_departments();i++) {
			if(ems.department[i].getDept_id()==id){
				d=ems.department[i];
			}
		}
		
		Employee emp=null;
		Personel_Info pi=null;
		for(int i=0;i<d.getRegistered_employees();i++) {
			pi=d.getEmployees()[i].getPI();
			System.out.println(pi.getPhone_no());
			list.add(new Personel_Info(pi.getName(),pi.getAddress(),pi.getEmail(),pi.getPhone_no(),pi.getDob(),pi.getJoining_date(),pi.getGrade()));
		}
		
		//list.add(new Personel_Info(rs.getInt("emp_id"),rs.getInt("SSN"),rs.getInt("age"),rs.getInt("mgr_emp_id"), rs.getInt("grade_id"), rs.getInt("dept_id"), rs.getString("emp_name"),rs.getString("address"), rs.getString("email"), rs.getString("phone"), rs.getString("DOB"), rs.getString("joining_date")) );


		return list;

	}
	
	public void fillTables(){
        //col_id.setCellValueFactory(new PropertyValueFactory<Personel_Info, Integer>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<Personel_Info, String>("name"));
        col_addr.setCellValueFactory(new PropertyValueFactory<Personel_Info, String>("address"));
        col_email.setCellValueFactory(new PropertyValueFactory<Personel_Info, String>("email"));
        col_ph.setCellValueFactory(new PropertyValueFactory<Personel_Info, String>("phone"));
        dob.setCellValueFactory(new PropertyValueFactory<Personel_Info, String>("dob"));
        col_join.setCellValueFactory(new PropertyValueFactory<Personel_Info, String>("joinDate"));
        col_gradeID.setCellValueFactory(new PropertyValueFactory<Personel_Info, Integer>("gradeId"));
        currEm = getOnlyEmployeeDetail();
        view.setItems(currEm);

    }
	//-----------------------------------------------------------------------------------------------
	@FXML
	public void addEmployee_button_clicked() throws Exception {
		System.out.println("add employee");
		if(addressTxtN.getText().isEmpty() || joiningdate.getText().isEmpty() || grade.getText().isEmpty() || nameTxt.getText().isEmpty() || idTxt.getText().isEmpty() || phTxt.getText().isEmpty() || emailTxt.getText().isEmpty() || DOB.getText().isEmpty() || salary.getText().isBlank()) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Failure");
            alert.setHeaderText(null);
            alert.setContentText("One or more Text Fields are Empty!");
            alert.showAndWait();
		}
		else {
			String name=nameTxt.getText();
			String address=addressTxtN.getText();
			String email=emailTxt.getText();
			String phone=phTxt.getText();
			String dobb=DOB.getText();
			String jn=joiningdate.getText();
			int g=Integer.parseInt(grade.getText());
			Personel_Info p=new Personel_Info(name,address,email,phone,dobb,jn,g);
			int idd=Integer.parseInt(idTxt.getText());
			Login_Details ld=new Login_Details(name,"12345",1);
			Bonus b=new Bonus();
			int sal=Integer.parseInt(salary.getText());
			int id=loginController.id();
			
			Employee emp=new Employee(idd,id,p,sal,ld);
			EMS ems=Main.get_ems();
			Main.get_ems().addEployee(emp);
			CRUD.add_employee(emp, Main.get_ems());
			
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Employee Added!");
            alert.showAndWait();
			initialize(null, null);

			Write_to_File.CRUD_FILE(Main.get_ems());
		}
		
	}
	
	@FXML
	void remove_button_clicked() {
		System.out.println("remove");
		if(addressTxtN.getText().isEmpty() || joiningdate.getText().isEmpty() || grade.getText().isEmpty() || nameTxt.getText().isEmpty() || idTxt.getText().isEmpty() || phTxt.getText().isEmpty() || emailTxt.getText().isEmpty() || DOB.getText().isEmpty() || salary.getText().isBlank()) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Failure");
            alert.setHeaderText(null);
            alert.setContentText("One or more Text Fields are Empty!");
            alert.showAndWait();
		}
		else {
			
			EMS ems=Main.get_ems();

			int id=loginController.id();
			Department d=null;
			for(int i=0;i<ems.getRegistered_departments();i++) {
				if(ems.department[i].getDept_id()==id){
					d=ems.department[i];
				}
			}
			
			int idd=Integer.parseInt(idTxt.getText());
			ems.deleteEmployee(idd, id);
			
			CRUD.delete_employee(id,Main.get_ems());
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Employee Deleted!");
            alert.showAndWait();
			initialize(null, null);
		}
	}
	
	
	@FXML
	void return_button_clicked() throws IOException {
		System.out.println("remove");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ManagerPanel.fxml"));
        Parent root = loader.load();
        Stage window = (Stage)retBt.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setResizable(false);
	}
	
}
