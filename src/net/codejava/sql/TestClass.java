
package net.codejava.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class TestClass {
    //DESKTOP-55L7EUL\SQLEXPRESS
    public static void main(String[] args) throws SQLException {
    String url = "jdbc:sqlserver://DESKTOP-55L7EUL\\SQLEXPRESS:1433;databaseName=";
    String dbName="SchoolManagement";
    String user = "sa";
    String password = "Ghum1234";
try {
    Connection connection;
    connection = DriverManager.getConnection(url+dbName,user,password);
    String sql = "INSERT INTO Test (ID, NAME, AGE,ADDRESS)" +"VALUES (5, 'Muid', 21, 'Dhaka')"; 

    Statement statement = connection.createStatement();
    int rows =statement.executeUpdate(sql);

    if (rows>0) { 
        JOptionPane.showMessageDialog(null, "Row has been inserted");
        System.out.println("Row has been inserted"); }
        connection.close();
    }catch(SQLException e){

    JOptionPane.showMessageDialog(null, "oops you are having a bad day,Connection failed");
    }
   }
 }
