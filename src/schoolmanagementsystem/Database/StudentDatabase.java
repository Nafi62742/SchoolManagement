/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package schoolmanagementsystem.Database;

import java.awt.HeadlessException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import schoolmanagementsystem.logInPage;

/**
 *
 * @author fahim
 */
public class StudentDatabase extends Accounts{
    private String studentName;
    private String studentClass;
    private String studentPhoneNo;
    private String studentEmail;
    private String section;
    private String passFromDB;
    
    
    String sListClass;
    String sListSection;
    String sListStudentID ;
    String sListStudentname ;
    
           
    private String studentId;
    private int bangla1st;
    private int bangla2nd;
    private int english1st;
    private int english2nd;
    private int math;
    private int science;
    private int religion;
    private int ict;
    private int bgs;
    private int grandTotal;
    
    
    
    final JPanel panel = new JPanel();

    ResultSet rs = null;
    ResultSet rs2 = null;
    Statement st;
    
    
    //Constructor
    public StudentDatabase(){
        
    }

    StudentDatabase(String string, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void setId(String id) {
        this.id = id;
    }
    //Constructor (Polymorphism - Method Overloading)
    public StudentDatabase(String id){
//        conn=JConnection.connectdb();
        setId(id);
        
        int len=id.length();
        int index = id.indexOf(".");
        String idString=id.substring(index+1, len);
        int intId = Integer.parseInt(idString);
        
        getStudentData(intId);
//        getResult(id);
//        totalMarks();
    }
        /*public void resultfieldForStu(String id){
        final JPanel panel = new JPanel();
        
       String sql = "INSERT INTO results(ID) VALUES (?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.execute();

            //JOptionPane.showMessageDialog(null, "Marks(english2nd) have been added Successfully");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(panel, "Database error","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }*/
    public List<Notice> getNotice(){
//        String sql = "select * from notice_board where class=" + "\'" +getStudentClass()+ "\'";
//        List<Notice> list = new ArrayList<Notice>();
//        try {
////            pst = conn.prepareStatement(sql);
////            rs = pst.executeQuery();
//            while (rs.next()) {
//                Notice noticeClass=new Notice(rs.getString("date"),rs.getString("time"),rs.getString("teacher_name"),rs.getString("class"),rs.getString("subject"),rs.getString("notice"));
//                list.add(noticeClass);
//            }
//            return list;
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Can't get notice from database.");
//        }
        return null;
    }
    
    public void stuList(String Class ,String Section ,String StudentId ,String StudentName){
        
         sListClass = Class;
         sListSection =  Section;
         sListStudentID = StudentId;
         sListStudentname = StudentName;
        
    }
    
    
     public List<studentList> getStudentList(){
        
         int len=getId().length();
        int index = id.indexOf(".");
        String idString=id.substring(index+1, len);
        int intID = Integer.parseInt(idString);
    //String sql = "select * from Student where StudentID="  +intID+ ";";
    String sql = "select * from Student where Class ='' or Section='B';";
        List<studentList> list = new ArrayList<studentList>();
       try {
           rs=jConnection.getStatement().executeQuery(sql);
           
            while (rs.next()) {
                studentList stu=new studentList(rs.getString("StudentName"),rs.getString("Class"),rs.getString("Section"));
                list.add(stu);
            }
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Can't get notice from database.");
            System.out.println(e);
        }
      return null;
  }
//    String sql = "select StudentID from " + table + " "
//                +"where StudentID=" + number + " and StudentPassword= '" + encryptedPass + "';";
//     String sql2="SELECT ID from LoginInfo "
//                                + "where ID='" + id + "' and IpAddress='" + myIP.getHostAddress() + "';";
//                        rs=jConnection.getStatement().executeQuery(sql2);
//    
    
    public List<Homework> getHomework(){
//        DateFormat dateFormat = new SimpleDateFormat("dd");
//        DateFormat monthFormat = new SimpleDateFormat("MMMMM");
//        DateFormat yearFormat = new SimpleDateFormat("yyyy");
//        String sql = "select * from homework where class=\'"+getStudentClass()+ "\' and sec=\'"+getSection()+"\'";
//        List<Homework> list = new ArrayList<Homework>();
//        Date today=new Date();
//        String dateString=dateFormat.format(today);
//        String monthString=monthFormat.format(today);
//        String yearString=yearFormat.format(today);
//        String dueDateString,dueMonthString,dueYearString;
//        try {
////            pst = conn.prepareStatement(sql);
////            rs = pst.executeQuery();
//            while (rs.next()) {
//                Date dueDate=new SimpleDateFormat("dd.MM.yyyy").parse(rs.getString("due_date"));
//                dueDateString=dateFormat.format(dueDate);
//                dueMonthString=monthFormat.format(dueDate);
//                dueYearString=yearFormat.format(dueDate);
//                if(today.compareTo(dueDate) <0||(dateString.equals(dueDateString)&&monthString.equals(dueMonthString)&&yearString.equals(dueYearString))){
//                    Homework homeworkClass=new Homework(rs.getString("subject"),rs.getInt("total_marks"),rs.getString("post_date"),rs.getString("due_date"),rs.getString("homework_text"));
//                    list.add(homeworkClass);
//                }
//            }
//            return list;
//        }catch(ParseException e){
//            JOptionPane.showMessageDialog(null, "Can't Parse Date.");
//        }
//        catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Can't get homeworks from database.");
//        }
        return null;
    }
    
    public List<Message> getMessage(){
        
        int len=getId().length();
        int index = getId().indexOf(".");
        String idString=getId().substring(index+1, len);
        int intID = Integer.parseInt(idString);
        
        String sql = "SELECT * FROM Message INNER JOIN Teacher ON Message.TeacherID = Teacher.TeacherID and Message.StudentID="+intID+";";
//       
        List<Message> list = new ArrayList<Message>();
        try {
            rs = jConnection.getStatement().executeQuery(sql);
            
           while (rs.next()) {
              //int a= rs.getInt("TeacherID");
             // String sql2 = "SELECT Message.TeacherID, Teacher.TeacherName FROM Teacher INNER JOIN Message ON Message.TeacherID = Teacher.TeacherID and Message.TeacherID=" +a+"";
               //rs2 = jConnection.getStatement().executeQuery(sql2);
             int temp5 = rs.getInt("TeacherID");
             String lala= String.valueOf(temp5);
             Message messageId = new Message(lala,rs.getString("TeacherName"),rs.getString("MessageText"));
              list.add(messageId);
           }
            return list;
       } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Can't get message from database.","Warning",JOptionPane.WARNING_MESSAGE);
      }
        return null;
    }
    public List<Attendance> getAttendance(String month){
//        String sql = "select * from attendance where ID=" + "\'" +getId()+ "\' and month = \'"+ month+ "\'";
//        List<Attendance> list = new ArrayList<Attendance>();
//        try {
////            pst = conn.prepareStatement(sql);
////            rs = pst.executeQuery();
//            while (rs.next()) {
//                Attendance attend = new Attendance(rs.getString("month"),rs.getString("ID"),rs.getInt("working_days"), rs.getInt("present_days"));
//                list.add(attend);
//            }
//            return list;
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Can't get attendance from database.");
//        }
        return null;
//     
    }
    
    
    
    public void getStudentData(int id){

        String sql = "select * from Student where StudentID = " +id+ ";";
        try{

            rs=jConnection.getStatement().executeQuery(sql);
            if (rs.next()) {
                setStudentName(rs.getString("StudentName"));
                setStudentClass(rs.getString("Class"));
                setSection(rs.getString("Section"));
                setStudentPhoneNo(rs.getString("StudentAddress"));
                setStudentEmail(rs.getString("StudentEmail"));
                setPassFromDB(rs.getString("StudentPassword"));
            }
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(panel, "Database error(Fetch Data)","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
        
    public void  totalMarks(){
//        int b1;
//        int b2;
//        int e1;
//        int e2;
//        int m;
//        int s;
//        int r;
//        int bgs;
//        int ic;
//        
//            b1=getBangla1st();
//            b2= getBangla2nd();
//            b2= getBangla2nd();
//            e1 = getEnglish1st();
//             e2=getEnglish2nd();
//             m=getMath();
//            r=getReligion();
//             s=getScience();
//
//            ic=getIct();
//            bgs=getBgs();
//
//        int gt=b1+b2+e1+e2+m+r+s+ic+bgs;
//        setGrandTotal(gt);
    }
    public void getResult(String id){
//        String sql = "select * from results where ID=" + "\'" +id+ "\'";
//        
//        try {
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//            if (rs.next()) {
//               // rslt.setStudentId("ID");
//                setBangla1st(rs.getInt("bangla1st"));
//                setBangla2nd(rs.getInt("bangla2nd"));
//                setEnglish1st(rs.getInt("english1st"));
//                setEnglish2nd(rs.getInt("english2nd"));
//                setMath(rs.getInt("math"));
//                setReligion(rs.getInt("religion"));
//                setScience(rs.getInt("science"));
//                setBgs(rs.getInt("bgs"));
//                setIct(rs.getInt("ict"));
//                //Results messageId=new Results(rs.getString("ID"),rs.getString("bangla1st"),rs.getString("bangla2nd"),rs.getString("english1st"),rs.getString("english2nd"),rs.getString("math"),rs.getString("science"),rs.getString("religion"));
//            }
//        }catch(HeadlessException | SQLException e){
//            JOptionPane.showMessageDialog(panel, "Database error","Warning",JOptionPane.WARNING_MESSAGE);
//        }
    }   
    public int updateStudentAccount(String name,String studentClass,String section,String Stu_Id,String phoneNo, String Email){
//         final JPanel panel = new JPanel();
        
        int len=Stu_Id.length();
        int index = id.indexOf(".");
        String idString=id.substring(index+1, len);
        int intID = Integer.parseInt(idString);
        int classID = Integer.parseInt(studentClass);
//        ,  Class=6
        String sql = "UPDATE Student "
                + "SET StudentName ='"+name+"' , StudentEmail='"+ Email+"',Class= "+classID+",Section='"+section+"'"
                + "where StudentID= " + intID +";";
            try {
                jConnection.getStatement().executeUpdate(sql);
                System.out.println("success" + rs);  
                return 1;
            }catch (SQLException ex) {
                 JOptionPane.showMessageDialog(panel, "Database error(Update)", "Warning", JOptionPane.WARNING_MESSAGE);
                Logger.getLogger(StudentDatabase.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
        }
    }
    
    
    public String getId() {
        return id;
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public String getStudentClass() {
        return studentClass;
    }
    
    public String getSection() {
        return section;
    }
    
    public String getPassFromDB() {
        return passFromDB;
    }
    
    public void setPassFromDB(String passFromDB) {
        this.passFromDB = passFromDB;
    }
    
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
    
    public void setSection(String section) {
        this.section = section;
    }
    
    public String getStudentPhoneNo() {
        return studentPhoneNo;
    }
    
    public String getStudentEmail() {
        return studentEmail;
    }
    
    public void setStudentPhoneNo(String studentPhoneNo) {
        this.studentPhoneNo = studentPhoneNo;
    }
    
    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
    
    //result works

    public int getBangla1st() {
        return bangla1st;
    }

    public void setBangla1st(int bangla1st) {
        this.bangla1st = bangla1st;
    }

    public int getBangla2nd() {
        return bangla2nd;
    }

    public void setBangla2nd(int bangla2nd) {
        this.bangla2nd = bangla2nd;
    }

    public int getEnglish1st() {
        return english1st;
    }

    public void setEnglish1st(int english1st) {
        this.english1st = english1st;
    }

    public int getEnglish2nd() {
        return english2nd;
    }

    public void setEnglish2nd(int english2nd) {
        this.english2nd = english2nd;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public int getIct() {
        return ict;
    }

    public void setIct(int ict) {
        this.ict = ict;
    }

    public int getBgs() {
        return bgs;
    }

    public void setBgs(int bgs) {
        this.bgs = bgs;
    }

    

    public int getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(int grandTotal) {
        this.grandTotal = grandTotal;
    }
    
    
    
    
    
    
}

