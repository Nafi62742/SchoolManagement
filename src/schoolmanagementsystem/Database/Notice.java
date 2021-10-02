/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package schoolmanagementsystem.Database;
/**
 *
 * @author fahim
 */
public class Notice {
    private String dateString;
    private String timeString;
    private int teacherID;
    private int studentClass;
    private String teacherName;
    private String subject;
    private String notice;
    public Notice() {
    }

    public String getDateString() {
        return dateString;
    }

    public String getTimeString() {
        return timeString;
    }
    
    public Notice(String date, String time, int teacherName, int studentClass, String subject, String notice) {
        this.dateString = date;
        this.timeString = time;
        this.teacherID = teacherName;
        this.studentClass = studentClass;
        this.subject = subject;
        this.notice = notice;
    }
    
    public Notice(String date, int teacherID,String teacherName, int studentClass,String notice) {
        this.dateString = date;
        this.teacherName= teacherName;
        this.teacherID = teacherID;
        this.studentClass = studentClass;
      
        this.notice = notice;
    }
    public String getSubject(){
        return this.subject;
    }
    
    public int getTeacherID() {
        return teacherID;
    }
    
    public int getStudentClass() {
        return studentClass;
    }
    
    public String getNotice() {
        return notice;
    }
    public String getTeacherName() {
        return teacherName;
    }
    
}
