package application;

import Business_Logic.Admin;
import Business_Logic.Department;
import Business_Logic.EMS;
import Business_Logic.Employee;
import Business_Logic.Login_Details;
import Business_Logic.Manager;
import Business_Logic.Personel_Info;
import DataBase.CRUD;
import DataBase.Load_Data;
import DataBase.Update_Employee;
import DataBase.Update_Manager;
import Exception_Handling.InvalidNumberException;
import File_Handling.Write_to_File;
import MyThread.MyThreads;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	private static EMS ems;
	private static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stage=primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("/GUI/login.fxml"));
			//primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Employee Management System");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static EMS get_ems() {
		return ems;
	}

	
	public static void main(String[] args) throws Exception {
		
		Login_Details managerDet=new Login_Details("hasnain","12345",3);
		Personel_Info managerInfo=new Personel_Info("hasnain","Islamabad","hasnain.tariq143","12345","11/11/2000","11/11/2021",12);
		Manager manager=new Manager(2,3,managerInfo,120000,managerDet);
		Department department=new Department("Building",3,manager,10);
		Personel_Info AdminInfo=new Personel_Info("Tariq","Islamabad","hasnain.tariq143","12345","11/11/2000","11/11/2021",12);
		Admin admin=new Admin(AdminInfo);
		ems=new EMS(admin,5);
		//----------------------------------------------------
		Load_Data.update_departments(ems);
		for(int i=0;i<ems.getRegistered_departments();i++) {
			Load_Data.update_managers(ems.department[i]);
		}
		for(int i=0;i<ems.getRegistered_departments();i++) {
			Load_Data.update_employees(ems.department[i]);
		}
		MyThreads t1 = new MyThreads();
		t1.setEms(ems);
		t1.start();
		launch(args);
	}
}
