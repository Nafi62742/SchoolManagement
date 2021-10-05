/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package schoolmanagementsystem.Database;

import java.awt.HeadlessException;

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
        System.out.println(id);
//        conn=JConnection.connectdb();
        setId(id);
        
        int len=id.length();
        int index = id.indexOf(".");
        String idString=id.substring(index+1, len);
        int intId = Integer.parseInt(idString);
        
        getStudentData(intId);
        getResult();

    }

    public List<Notice> getNotice(){
         int len=getStudentClass().length();
        int index = getStudentClass().indexOf(".");
        String idString=getStudentClass().substring(index+1, len);
        int intCls = Integer.parseInt(idString);
       String sql = "SELECT * FROM Notice INNER JOIN Teacher ON Notice.TeacherID = Teacher.TeacherID and Notice.Class="+intCls+";"; 
       //String sql = "select * from Notice where Class="+intCls+";";
       List<Notice> list = new ArrayList<Notice>();
        try {
            rs = jConnection.getStatement().executeQuery(sql);
         
            while (rs.next()) {
               Notice noticeClass = new Notice(rs.getString("Datee"),rs.getInt("TeacherID"),rs.getString("TeacherName"),rs.getInt("Class"),rs.getString("Notice"));
                list.add(noticeClass);
            }
            return list;
       } catch (SQLException e) {
            System.out.println(e);
           JOptionPane.showMessageDialog(null, "Can't get notice from database.");
        }
        return null;
    }
    
    public void stuList(String Class ,String Section ,String StudentId ,String StudentName){
         sListClass = Class;
         sListSection =  Section;
         sListStudentID = StudentId;
         sListStudentname = StudentName;
    }
    
    
     public List<studentList> getStudentList(){
        
    String sql = "select * from Student where Class ='' or Section='B';";
        List<studentList> list = new ArrayList<>();
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

   public List<Homework> getHomework(){


        int len=getStudentClass().length();
        int index = getStudentClass().indexOf(".");
        String idString=getStudentClass().substring(index+1, len);
        int intCls = Integer.parseInt(idString);
String sql= "select t.Teachername , i.homeworkNo, i.class, i.TeacherID , i.sec,i.totalMark, i.dueDate,i.work from Teacher t join homework i on t.TeacherID=i.TeacherID where i.class="+intCls+" order by totalMark";

        List<Homework> list = new ArrayList<Homework>();
        Date today=new Date();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dueDateString=dateFormat.format(today);

        DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        String formatDate;

//        String dueDateString,dueMonthString,dueYearString;
        try {
            rs=jConnection.getStatement().executeQuery(sql);
            while (rs.next()) {
            String dueDate=rs.getString("dueDate");
//                dueMonthString=monthFormat.format(dueDate);
//                dueYearString=yearFormat.format(dueDate);

                date = dateFormat.parse(dueDateString);
                formatDate = targetFormat.format(date);

                if(formatDate.compareTo(dueDate) <0||formatDate.equals(dueDate)){
                    Homework homeworkClass=new Homework(rs.getInt("Class"),rs.getString("sec"),rs.getInt("totalMark"),rs.getString("dueDate"),rs.getString("work") ,rs.getInt("TeacherID"),rs.getString("Teachername"));
                    list.add(homeworkClass);
                }
            }
            return list;
        }catch(ParseException e){
            JOptionPane.showMessageDialog(null, "Can't Parse Date.");
            System.out.println(e);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Can't get homeworks from database.");
            System.out.println(e);
        }
      return null;
   }
    
    public List<Message> getMessage(){
        
        int len=getId().length();
        int index = getId().indexOf(".");
        String idString=getId().substring(index+1, len);
        int intID = Integer.parseInt(idString);
        
        String sql = "SELECT * FROM Message INNER JOIN Teacher ON Message.TeacherID = Teacher.TeacherID and Message.StudentID="+intID+";";
//       
        List<Message> list = new ArrayList<>();
        try {
            rs = jConnection.getStatement().executeQuery(sql);
           while (rs.next()) {
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
        int len=getId().length();
        int index = getId().indexOf(".");
        String idString=getId().substring(index+1, len);
        int intID = Integer.parseInt(idString);
//        System.out.println(intID);
        String sql = "select * from Attendance where StudentID=" +intID+ " and MonthNo = "+monthNo+ ";";
        List<Attendance> list = new ArrayList<>();
        try {
            rs = jConnection.getStatement().executeQuery(sql);
            while (rs.next()) {
                Attendance attend = new Attendance(rs.getString("MonthNo"),rs.getString("TeacherID"),rs.getString("StudentID"),rs.getInt("WorkingDays"), rs.getInt("PresentDays"));
                list.add(attend);
            }
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Can't get attendance from database.");
        }
        return null;
     
    }
    
    
    
    public void getStudentData(int id){

        String sql = "select * from Student where StudentID = " +id+ ";";
        try{

            rs=jConnection.getStatement().executeQuery(sql);
            if (rs.next()) {
                setStudentName(rs.getString("StudentName"));
                setStudentClass(rs.getString("Class"));
                setSection(rs.getString("Section"));
                setStudentPhoneNo(rs.getString("StudentPhoneNo"));
                setStudentEmail(rs.getString("StudentEmail"));
                setPassFromDB(rs.getString("StudentPassword"));
            }
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(panel, "Database error(Fetch Data)","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
        

    public List<Results> getResult(){
        
        int len=id.length();
        int index = id.indexOf(".");
        String idString=id.substring(index+1, len);
        int intID = Integer.parseInt(idString);
        
        String sql = "select *,(bangla1st + bangla2nd+english1st+english2nd+math+science+religion+bgs+ict) as 'Total Marks' from Result where StudentID = " +intID+ ";";
        List<Results> list2 = new ArrayList<Results>();
        try{
            rs=jConnection.getStatement().executeQuery(sql);
            if (rs.next()) {
               // rslt.setStudentId("ID");INSERT INTO Result(StudentID,bangla1st,bangla2nd,english1st,english2nd,math,science,religion)
//VALUES (1,50,60,10,40,90,80,70);
Results result=new Results(rs.getInt("StudentID"),rs.getInt("bangla1st"),rs.getInt("bangla2nd"),rs.getInt("english1st"),rs.getInt("english2nd"),rs.getInt("math"),rs.getInt("science"),rs.getInt("religion"),rs.getInt("bgs"),rs.getInt("ict"),rs.getInt("Total Marks"));
                 list2.add(result);
           }
            return list2;
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(panel, "Database error","Warning",JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }   
    public int updateStudentAccount(String name,String studentClass,String section,String Stu_Id,String phoneNo, String Email){
         final JPanel panel = new JPanel();

        String idString=id.substring(id.indexOf(".")+1, Stu_Id.length());
        int intID = Integer.parseInt(idString);
        
        int classID = Integer.parseInt(studentClass);

        String sql = "UPDATE Student "
                + "SET StudentName ='"+name+"' , StudentEmail='"+ Email+"',Class= "+classID+",Section='"+section+"',StudentPhoneNo='"+phoneNo+"'"
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

