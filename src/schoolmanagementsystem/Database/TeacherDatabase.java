
package schoolmanagementsystem.Database;

import java.awt.HeadlessException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JOptionPane;
import javax.swing.JPanel;
import schoolmanagementsystem.TeacherProfile;

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
       public void attendanceDelete(String month,String studentId){
        int monthNo=0;
        if(month.equals("January")){
            monthNo=1;
        }
        else if(month.equals("February")){
            monthNo=2;
        }
        else if(month.equals("March")){
            monthNo=3;
        }
         else if(month.equals("April")){
            monthNo=4;
        } else if(month.equals("May")){
            monthNo=5;
        } else if(month.equals("June")){
            monthNo=6;
        } else if(month.equals("July")){
            monthNo=7;
        } else if(month.equals("August")){
            monthNo=8;
        } else if(month.equals("September")){
            monthNo=9;
        }
         else if(month.equals("October")){
            monthNo=10;
        }
         else if(month.equals("November")){
            monthNo=11;
        }
        else if(month.equals("December")){
            monthNo=12;
        }
        String idString=studentId.substring(studentId.indexOf(".")+1, studentId.length());
        int intID = Integer.parseInt(idString);
        
        String sql = "Delete from Attendance where StudentID= "+intID+ " and MonthNo= "+monthNo+ ";";
        try {
             jConnection.getStatement().executeUpdate(sql); 
            
            JOptionPane.showMessageDialog(null, "Attendance has been Deleted Successfully");
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(panel, "Database error","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    public void postHomework(String studentClass,String section,int total_marks,String dueDate,String homeworkText){

        int len2=id.length();
        int index2 = id.indexOf(".");
        String idString2=id.substring(index2+1, len2);
        int intID2 = Integer.parseInt(idString2);
          String sqlHW = "INSERT INTO homework(TeacherID,class,sec,totalMark,dueDate,work) values('"+intID2+"','"+studentClass+"','"+section+"','"+total_marks+"','"+dueDate+"','"+homeworkText+"');";
        try {
        jConnection.getStatement().executeUpdate(sqlHW);
       }catch(SQLException e){
           e.printStackTrace();
            System.out.println(e);
        }
    }
    public void postNotice(String studentClass,String notice){
        int len2=id.length();
        int index2 = id.indexOf(".");
        String idString2=id.substring(index2+1, len2);
        int intID2 = Integer.parseInt(idString2);
        
        int len=studentClass.length();
        int index = studentClass.indexOf(".");
        String idString=studentClass.substring(index+1, len);
        int intCls = Integer.parseInt(idString);
       // DateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
       
        Date datePost=java.util.Calendar.getInstance().getTime();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dueDateString=dateFormat.format(datePost);

        DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        String formatDate;
        try {
            date = dateFormat.parse(dueDateString);
            formatDate = targetFormat.format(date);
            System.out.println(formatDate);
                String sql = "INSERT INTO Notice(Datee,TeacherID,Class,Notice)"
                        +"VALUES('"+formatDate+"',"+intID2+","+intCls+",'"+notice+"');";
                try {
                     jConnection.getStatement().executeUpdate(sql);



                     JOptionPane.showMessageDialog(null, "Notice have been posted Successfully");
                } catch (HeadlessException | SQLException e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(panel, "Database error","Warning",JOptionPane.WARNING_MESSAGE);
                }
        } catch (ParseException ex) {
            Logger.getLogger(TeacherProfile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
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
        int monthNo=0;
        if(month.equals("January")){
            monthNo=1;
        }
        else if(month.equals("February")){
            monthNo=2;
        }
        else if(month.equals("March")){
            monthNo=3;
        }
         else if(month.equals("April")){
            monthNo=4;
        } else if(month.equals("May")){
            monthNo=5;
        } else if(month.equals("June")){
            monthNo=6;
        } else if(month.equals("July")){
            monthNo=7;
        } else if(month.equals("August")){
            monthNo=8;
        } else if(month.equals("September")){
            monthNo=9;
        }
         else if(month.equals("October")){
            monthNo=10;
        }
         else if(month.equals("November")){
            monthNo=11;
        }
         else if(month.equals("December")){
            monthNo=12;
        }
        String idString=studentId.substring(studentId.indexOf(".")+1, studentId.length());
        int intID = Integer.parseInt(idString);
        
        String idString2=id.substring(id.indexOf(".")+1, id.length());
        int intID2 = Integer.parseInt(idString2);
        
        String sql = "INSERT INTO Attendance(MonthNo,TeacherID,StudentID,WorkingDays,PresentDays) "
                + "VALUES ("+monthNo+","+intID2+", "+intID+","+workingDays+","+presentDays+");";
        try {
             jConnection.getStatement().executeUpdate(sql); 
            
            JOptionPane.showMessageDialog(null, "Attendance have been updated Successfully");
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(panel, "Database error","Warning",JOptionPane.WARNING_MESSAGE);
        }
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
        final JPanel panel = new JPanel();
        
        int len=Teacher_Id.length();
        int index = id.indexOf(".");
        String idString=id.substring(index+1, len);
        int intID = Integer.parseInt(idString);
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
