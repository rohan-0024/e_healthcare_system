package e_healthcare.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;


public class Conn {

    Connection connection;

    Statement statement;

    public Conn(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_healthcare_management_system","root","2407");
            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
