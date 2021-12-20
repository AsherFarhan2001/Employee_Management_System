module AP_Project {
	
	requires javafx.controls;
	requires java.xml;
	requires java.desktop;
	requires jdk.compiler;
	requires jdk.javadoc;
	requires java.sql;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires junit;
	
	
	opens application to javafx.graphics, javafx.fxml;
	opens GUI;
	opens Business_Logic;
	opens DataBase;
	opens File_Handling;
}
