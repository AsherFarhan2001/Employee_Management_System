package GUI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Business_Logic.EMS;
import Business_Logic.Manager;
import DataBase.Update_Employee;
import DataBase.Update_Manager;
import MyThread.MyThreads;
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


public class ManagerViewEditPersonelInfoController implements Initializable {	

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

	
	    private Manager manager;
	    private EMS ems;

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			System.out.println("iiiii");
			ems=Main.get_ems();
			int id=loginController.id();
			manager=new Manager(0,0,0);
			
			for(int i=0;i<ems.getRegistered_departments();i++) {
				if(ems.department[i].getDept_id()==id) {
					manager=ems.department[i].getManager();
				}
			}
			
//			System.out.println("man "+manager.getDept_id());
//			System.out.println("ID - "+id);
			NidTxt.setText(String.valueOf(manager.getPersonel_id()));
            NnameTxt.setText(manager.getPI().getName());
            NaddressTxt.setText(manager.getPI().getAddress());
            NemailTxt.setText(manager.getPI().getEmail());
            NphoneTxt.setText(manager.getPI().getPhone_no());
            NdobTxt.setText(manager.getPI().getDob());
            NjoinDateTxt.setText(manager.getPI().getJoining_date());
            NgradeIdTxt.setText(String.valueOf(manager.getPI().getGrade()));
            NdeptIdTxt.setText(String.valueOf(manager.getDept_id()));
            
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
				manager.getPI().setName(nameTxt.getText());
				manager.getPI().setAddress(addressTxt.getText());
				manager.getPI().setEmail(emailTxt.getText());
				manager.getPI().setPhone_no(phoneTxt.getText());
				Main.get_ems().update_manager_info(manager);		//--------
				Update_Manager.update_manager(manager);
				NnameTxt.setText(manager.getPI().getName());
	            NaddressTxt.setText(manager.getPI().getAddress());
	            NemailTxt.setText(manager.getPI().getEmail());
	            NphoneTxt.setText(manager.getPI().getPhone_no());
	            
	            Alert alert = new Alert(Alert.AlertType.INFORMATION);
	            alert.initStyle(StageStyle.UTILITY);
	            alert.setTitle("Success");
	            alert.setHeaderText(null);
	            alert.setContentText("Info UPDATED!");
	            alert.showAndWait();
	            
	            MyThreads t=new MyThreads();
	            t.setEms(Main.get_ems());
	            t.start();
	            
			}
		}
	    
	    @FXML
		void back_button_clicked() throws IOException {
	    	System.out.println("REturn");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ManagerPanel.fxml"));
	        Parent root = loader.load();
	        Stage window = (Stage)retBt.getScene().getWindow();
	        window.setScene(new Scene(root));
	        window.setResizable(false);
	        
		}

}
