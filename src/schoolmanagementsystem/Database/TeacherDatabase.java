
package schoolmanagementsystem.Database;

import java.awt.HeadlessException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import schoolmanagementsystem.StudentProfile;

public class TeacherDatabase extends Accounts{
    private String teacherName;
    private String teacherSubject;
    private String designation;
    private String teacherPhoneNo;
    private String teacherEmail;
    private String passFromTDB;
    final JPanel panel = new JPanel();

    ResultSet rs = null;
    Statement st;
    
    //Constructor
    public TeacherDatabase() {
    }
    //Constructor (Polymorphism - Method Overloading)
    public TeacherDatabase(String id) {
        this.id = id;
//        conn=JConnection.connectdb();
        int len=id.length();
        int index = id.indexOf(".");
        String idString=id.substring(index+1, len);
        int intId = Integer.parseInt(idString);
        getTeacherData(intId);
    }
    private void getTeacherData(int id) {
        
        String sql = "select * from Teacher where TeacherID=" +id+ ";";
        System.out.println(id);
        try{
            rs=jConnection.getStatement().executeQuery(sql);
//(TeacherID,TeacherName,TeacherAddress,TeacherEmail,SubjectName,Designation,TeacherPassword)
            if (rs.next()) {
                setTeacherName(rs.getString("TeacherName"));
                setTeacherSubject(rs.getString("SubjectName"));
                setDesignation(rs.getString("Designation"));
//                setTeacherPhoneNo(rs.getString("phoneNo"));
                setTeacherEmail(rs.getString("TeacherEmail"));
                setPassFromTDB(rs.getString("TeacherPassword"));
            }
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(panel, "Database error","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    public void postHomework(String studentClass,String section,int totalMarks,String dueDate,String homeworkText){
//        Date datetime = new Date();
//        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
//        String postDateString=dateFormat.format(datetime);
//        String sql = "INSERT INTO homework(class, sec,teacher_name, subject, total_marks,post_date, due_date,homework_text) VALUES(?,?,?,?,?,?,?,?)";
//        try {
//            pst = conn.prepareStatement(sql);
//            pst.setString(1, studentClass);
//            pst.setString(2, section);
//            pst.setString(3, getTeacherName());
//            pst.setString(4, getTeacherSubject());
//            pst.setInt(5, totalMarks);
//            pst.setString(6,postDateString);
//            pst.setString(7, dueDate);
//            pst.setString(8,homeworkText);
//            pst.execute();
//            JOptionPane.showMessageDialog(null, "Homework have been posted Successfully");
//        } catch (HeadlessException | SQLException e) {
//            JOptionPane.showMessageDialog(panel, e,"Warning",JOptionPane.WARNING_MESSAGE);
//        }
        
    }
    public void postNotice(String studentClass,String notice){
        Date datetime = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
       // DateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
        String dateString=dateFormat.format(datetime);
      // String timeString=timeFormat.format(datetime);
        int len2=id.length();
        int index2 = id.indexOf(".");
        String idString2=id.substring(index2+1, len2);
        int intID2 = Integer.parseInt(idString2);
        
        int len=studentClass.length();
        int index = studentClass.indexOf(".");
        String idString=studentClass.substring(index+1, len);
        int intCls = Integer.parseInt(idString);
        
        
        
       String sql = "INSERT INTO Notice(Datee,TeacherID,Class,Notice)"
               +"VALUES("+dateString+","+intID2+","+intCls+",'"+notice+"');";
       try {
            jConnection.getStatement().executeUpdate(sql);
            
            

            JOptionPane.showMessageDialog(null, "Notice have been posted Successfully");
       } catch (HeadlessException | SQLException e) {
           System.out.println(e);
           JOptionPane.showMessageDialog(panel, "Database error","Warning",JOptionPane.WARNING_MESSAGE);
       }
    } 
    
    public void sendMessage(String message,String studentId){
        
        int len=studentId.length();
        int index = studentId.indexOf(".");
        String idString=studentId.substring(index+1, len);
        int intID = Integer.parseInt(idString);
        
        int len2=id.length();
        int index2 = id.indexOf(".");
        String idString2=id.substring(index2+1, len2);
        int intID2 = Integer.parseInt(idString2);
        
       String sql = "INSERT INTO Message(StudentID,TeacherID,MessageText) "
               + "VALUES ("+intID+","+intID2+",'"+message+"');";
      
              
               // 
               
        try {
            jConnection.getStatement().executeUpdate(sql);
    
           
          
           JOptionPane.showMessageDialog(null, "Message have been sent Successfully");
       } catch (HeadlessException | SQLException e) {
            System.out.println(e);   
           JOptionPane.showMessageDialog(panel, "Database error","Warning",JOptionPane.WARNING_MESSAGE);
       }
    }
    
    public void attendanceUpdate(String month,String studentId, int workingDays, int presentDays){
//        
//        
//        String sql = "INSERT INTO attendance(month, ID, working_days, present_days) VALUES(?,?,?,?)";
//        try {
//            pst = conn.prepareStatement(sql);
//     
//            pst.setString(1, month);
//            pst.setString(2, studentId);
//            pst.setInt(3,workingDays);
//            pst.setInt(4,presentDays);
//            pst.execute();
//            
//            JOptionPane.showMessageDialog(null, "Attendance have been updated Successfully");
//        } catch (HeadlessException | SQLException e) {
//            JOptionPane.showMessageDialog(panel, "Database error","Warning",JOptionPane.WARNING_MESSAGE);
//        }
    }
    
        public void marksSend(int marks,String studentId,String paper){
            
            
                int len=studentId.length();
        int index = studentId.indexOf(".");
        String idString=studentId.substring(index+1, len);
        int intID = Integer.parseInt(idString);   
        String tSubject2=getTeacherSubject().toLowerCase();
        String subpaper=paper.toLowerCase();
        String studentChecker = "select * From Result Where StudentID =" + intID+";";
        try {
            rs=jConnection.getStatement().executeQuery(studentChecker);
            if(rs.next()){  
            jConnection.getStatement().executeUpdate("update Result set "+tSubject2+subpaper+" = "+marks+" "
                    + "where StudentID = " + intID+";");
                    JOptionPane.showMessageDialog(null, "Marks("+tSubject2+subpaper+") have been updated Successfully");
            }else{ 
                String sql = "INSERT INTO Result(StudentID,"+tSubject2+subpaper+")"
                        + " VALUES ("+intID+","+marks+");";
                jConnection.getStatement().executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Marks("+tSubject2+subpaper+") have been added Successfully");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(panel, e,"Warning",JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
        }
             
    }
   public void marksSend(int marks,String studentId){
        int len=studentId.length();
        int index = studentId.indexOf(".");
        String idString=studentId.substring(index+1, len);
        int intID = Integer.parseInt(idString);
        
        String tSubject2=getTeacherSubject().toLowerCase();
        
        String studentChecker = "select * From Result Where StudentID =" + intID+";";
        try {
            rs=jConnection.getStatement().executeQuery(studentChecker);
            if(rs.next()){  
            jConnection.getStatement().executeUpdate("update Result set "+tSubject2+" = "+marks+" "
                    + "where StudentID = " + intID+";");
                    JOptionPane.showMessageDialog(null, "Marks("+tSubject2+") have been updated Successfully");
            }else{ 
                String sql = "INSERT INTO Result(StudentID,"+tSubject2+")"
                        + " VALUES ("+intID+","+marks+");";
                jConnection.getStatement().executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Marks("+tSubject2+") have been added Successfully");
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(panel, e,"Warning",JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
        }
    }
  public int updateTeacherAccount(String name,String subject,String designation,String Teacher_Id,String PhoneNo, String Email){
//        final JPanel panel = new JPanel();
        
        int len=Teacher_Id.length();
        int index = id.indexOf(".");
        String idString=id.substring(index+1, len);
        int intID = Integer.parseInt(idString);
//        int classID = Integer.parseInt(studentClass);
          String sql = "UPDATE Teacher "
                + "SET TeacherName ='"+name+"' , TeacherEmail='"+ Email+"',Designation='"+designation+"' ,SubjectName='"+subject+"'"
                + "where TeacherID= " + intID +";";
          try {
              jConnection.getStatement().executeUpdate(sql);
                System.out.println("success" + rs);  
                return 1;
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(panel, "Database error(Update Teacher", "Warning", JOptionPane.WARNING_MESSAGE);
                System.out.println(e);
                return 0;
            }
        
    }
    
  
  

  
    
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    
    
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public String getTeacherName() {
        return teacherName;
    }
    
    public String getTeacherSubject() {
        return teacherSubject;
    }

    public String getTeacherPhoneNo() {
        return teacherPhoneNo;
    }

    public void setTeacherPhoneNo(String teacherPhoneNo) {
        this.teacherPhoneNo = teacherPhoneNo;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getPassFromTDB() {
        return passFromTDB;
    }

    public void setPassFromTDB(String passFromTDB) {
        this.passFromTDB = passFromTDB;
    }
    
    public void setTeacherSubject(String teacherSubject) {
        this.teacherSubject = teacherSubject;
    }
    
    
    public String getDesignation() {
        return designation;
    }  
}
