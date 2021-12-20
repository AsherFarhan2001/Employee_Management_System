package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import Business_Logic.Employee;
import Business_Logic.Manager;

public class Update_Manager {

    public static void update_manager(Manager M)
    {
        update_manager_name(M);
        update_manager_address(M);
        update_mnager_email(M);
        update_manager_phone_no(M);
        update_manager_username(M);
        update_manager_password(M);

    }

    //update employee name
    public static void update_manager_name(Manager M) {
        try {

            String url="jdbc:mysql://localhost:3306/ap_project";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","qismat143@");
            Statement stmt=con.createStatement();


            String query="UPDATE manager set name='"+M.getPI().getName()+"' WHERE personel_id="+M.getPersonel_id();
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }


    //update employee email
    public static void update_mnager_email(Manager M) {
        try {

            String url="jdbc:mysql://localhost:3306/ap_project";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","qismat143@");
            Statement stmt=con.createStatement();


            String query="UPDATE manager set email='"+M.getPI().getEmail()+"' WHERE personel_id="+M.getPersonel_id();
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }

    }

    //update employee address
    public static void update_manager_address(Manager M) {
        try {

            String url="jdbc:mysql://localhost:3306/ap_project";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","qismat143@");
            Statement stmt=con.createStatement();


            String query="UPDATE manager set address='"+M.getPI().getAddress()+"' WHERE personel_id="+M.getPersonel_id();
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }

    }


    //update employee phone_no
    public static void update_manager_phone_no(Manager M)
    {
        try {

            String url="jdbc:mysql://localhost:3306/ap_project";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","qismat143@");
            Statement stmt=con.createStatement();


            String query="UPDATE manager set phone_no='"+M.getPI().getPhone_no()+"' WHERE personel_id="+M.getPersonel_id();
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }


    //update employee username
    public static void update_manager_username(Manager M)
    {
        try {

            String url="jdbc:mysql://localhost:3306/ap_project";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","qismat143@");
            Statement stmt=con.createStatement();


            String query="UPDATE manager_login_info set username='"+M.getLD().getUsername()+"' WHERE depart_id="+M.getDept_id();
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }


    //update employee password
    public static void update_manager_password(Manager M) {
        try {

            String url="jdbc:mysql://localhost:3306/ap_project";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","qismat143@");
            Statement stmt=con.createStatement();


            String query="UPDATE manager_login_info set password='"+M.getLD().getPassword()+"' WHERE depart_id="+M.getDept_id();
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
