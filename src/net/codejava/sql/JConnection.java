package net.codejava.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class JConnection {
    
    Statement statement;

    public JConnection() {
    String url = "jdbc:sqlserver://SWAP\\SQLEXPRESS:1433;databaseName=";
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

}
