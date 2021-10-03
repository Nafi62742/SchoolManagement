package net.codejava.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class JConnection {
    
    Statement statement;

    public JConnection() {
    String url = "jdbc:sqlserver://DESKTOP-55L7EUL\\SQLEXPRESS:1433;databaseName=";
    String dbName="SchoolManagement";
    String user = "sa";
    String password = "Ghum1234";
    
    try {
    Connection connection;
    connection = DriverManager.getConnection(url+dbName,user,password);
    statement = connection.createStatement();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "Connection failed");
    }   
}

 public Statement getStatement() {
        return statement;
 }


//    public static Connection connectdb() {
//        String url="jdbc:mysql://localhost/";
//        String dbName="school_management_system";
//        String username="root";
//        String pass="";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection(url+dbName, username, pass);
//            return connection;
//        } catch (ClassNotFoundException | SQLException sqle) {
//            JOptionPane.showMessageDialog(null, "Connection failed");
//            return null;
//        }
//
//    }

   
}
