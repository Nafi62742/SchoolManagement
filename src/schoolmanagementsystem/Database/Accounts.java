
package schoolmanagementsystem.Database;

import java.awt.HeadlessException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.codejava.sql.JConnection;
import org.apache.commons.codec.binary.Base64;

public class Accounts {
    JConnection jConnection = new JConnection();
    public String id;
    private ResultSet rs = null;


    
    public Accounts() {

    }
    
 
    
    public int createStudentAccount(String name,String studentClass,String section,String id,String userPass){
          final JPanel panel = new JPanel();
       
        String pass;
        pass = EncryptPass(userPass);
         int len=id.length();
        int index = id.indexOf(".");
        String idString=id.substring(index+1, len);
        int intID = Integer.parseInt(idString);
        
        String sql="INSERT INTO Student(StudentID,StudentName,Class,Section,StudentPassword)"
                + " VALUES("+intID+" ,'"+name+"', '"+studentClass+"' , '"+section+"' , '"+pass+"' );";
        try {
            jConnection.getStatement().executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Inserted Successfully");
            return 1;
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(panel, "Your ID should be unique.", "Warning", JOptionPane.WARNING_MESSAGE);
            return 0;
        }
    }
    public int createTeacherAccount(String name,String subject,String designation,String id,String userPass){
        final JPanel panel = new JPanel();
       
        String pass;
        pass = EncryptPass(userPass);
         int len=id.length();
        int index = id.indexOf(".");
        String idString=id.substring(index+1, len);
        int intID = Integer.parseInt(idString);
        
        String sql="INSERT INTO Teacher(TeacherID,TeacherName,SubjectName,Designation,TeacherPassword)"
                + " VALUES("+intID+" ,'"+name+"', '"+subject+"' , '"+designation+"' , '"+pass+"');";
        try {
            jConnection.getStatement().executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Inserted Successfully");
            return 1;
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(panel, "Your ID should be unique.", "Warning", JOptionPane.WARNING_MESSAGE);
            return 0;
        }
    }
    
    public boolean accountLogin(String id,String password,boolean rememberUser) throws SQLException{
        final JPanel panel = new JPanel();
        String table = null;
        String sql =null;
        if(id.equals("")||password.equals("")){
            JOptionPane.showMessageDialog(panel, "Invalid Credentials","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }else{
            if (id.contains("100.")) {
                table = "Student";
            } else if(id.contains("400.")){
                table = "Teacher";
            }else{
                JOptionPane.showMessageDialog(panel, "User not valid", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            if(rememberUser == true){
                try{
                    if(userValid(id,password,table)){
                        InetAddress myIP=InetAddress.getLocalHost();

                        String sql2="SELECT ID from LoginInfo "
                                + "where ID='" + id + "' and IpAddress='" + myIP.getHostAddress() + "';";
                        rs=jConnection.getStatement().executeQuery(sql2);
                        if(rs.next()){  
                            jConnection.getStatement().executeUpdate("update LoginInfo set LoginSatus = 1 "
                                    + " where ID = '"+id+"' and IpAddress='"+myIP.getHostAddress()+"';");
                                    
                        }else{ 
                            sql = "INSERT INTO LoginInfo(ID,IpAddress,LoginSatus) "
                                + "VALUES('"+id+"','"+myIP.getHostAddress()+"',"+1+");";
                            jConnection.getStatement().executeUpdate(sql);
                        }
                        if(id.contains("100.")){
                            new schoolmanagementsystem.StudentProfile(id).setVisible(true);
                            return true;
                        }else if(id.contains("400.")){
                            new schoolmanagementsystem.TeacherProfile(id).setVisible(true);
                            return true;
                        }
                    }
                }
                catch(UnknownHostException e){
                    JOptionPane.showMessageDialog(panel, "Sorry, Can't get your IP Address."
                            ,"Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }catch(SQLException e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(panel, "Database error(Login)","Warning"
                            ,JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }else{
                if(userValid(id,password,table)){
                    
                    if(id.contains("100.")){
                        new schoolmanagementsystem.StudentProfile(id).setVisible(true);
                        return true;
                    }else if(id.contains("400.")){
                        new schoolmanagementsystem.TeacherProfile(id).setVisible(true);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void logout(){
        final JPanel panel = new JPanel();
        System.out.println(this.id);
        if(this.id==null){
            return;
        }
        try {
            InetAddress myIP=InetAddress.getLocalHost();
            System.out.println(this.id);
            int update_done = jConnection.getStatement().executeUpdate("update LoginInfo set LoginSatus = 0 "
                                    + " where IpAddress='"+myIP.getHostAddress()+"';");
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(panel, "Database error(Logout)","Warning",JOptionPane.WARNING_MESSAGE);
            
        } catch (UnknownHostException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(panel, "Sorry, Can't get your IP Address.","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    private String EncryptPass(String passwordString) {
        try {
            String originalInput = passwordString;
            Base64 base64 = new Base64();
            String encodedString = new String(base64.encode(originalInput.getBytes()));
            return encodedString;
        } catch (Exception e) {
            System.out.println("Password encryption failed");
        }
        return null;
    }
    private boolean userValid(String id,String pass,String table){
        String encryptedPass=EncryptPass(pass);
        final JPanel panel = new JPanel();
        
        int len=id.length();
        int index = id.indexOf(".");
        String idString=id.substring(index+1, len);
        int number = Integer.parseInt(idString);

       if (table.contains("Student")) {
           String sql = "select StudentID from " + table + " "
                +"where StudentID=" + number + " and StudentPassword= '" + encryptedPass + "';";
            try{
                rs=jConnection.getStatement().executeQuery(sql);
                if (rs.next()) {
                    return true;
                }else{
                    JOptionPane.showMessageDialog(panel, "User not valid", "Warning", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }catch(HeadlessException | SQLException e){
                System.out.println(e);
                JOptionPane.showMessageDialog(panel, "Database error(UserCheck)","Warning",JOptionPane.WARNING_MESSAGE);
            }    
        } else if(table.contains("Teacher")) {
          
           String sql = "select TeacherID from " + table + " "
                +"where TeacherID=" + number + " and TeacherPassword= '" + encryptedPass + "';";
            try{
                rs=jConnection.getStatement().executeQuery(sql);
                if (rs.next()) {
                    return true;
                }else{
                    JOptionPane.showMessageDialog(panel, "User not valid", "Warning", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }catch(HeadlessException | SQLException e){
                System.out.println(e);
                JOptionPane.showMessageDialog(panel, "Database error(UserCheck)","Warning",JOptionPane.WARNING_MESSAGE);
            }  
       }
             return false;
        
        
       
    }
    public String isUserLoggedIn(){
        final JPanel panel = new JPanel();

        try {
            InetAddress myIP=InetAddress.getLocalHost();

            String userCheck = "SELECT ID from LoginInfo "
                    + "where IpAddress= '" + myIP.getHostAddress() + "' and LoginSatus = 1;";
            try{
                rs=jConnection.getStatement().executeQuery(userCheck);
                if (rs.next()) {
                    return rs.getString(1);
                }else{
                    return null;
                }
            }catch(HeadlessException | SQLException e){
                System.out.println(e);
                JOptionPane.showMessageDialog(panel, "Database error. Auto login failed(User Check).","Warning",JOptionPane.WARNING_MESSAGE);
            }
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(panel, "Sorry, Can't get your IP Address.","Warning",JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
    public String getId(){
        return this.id;
    }

}