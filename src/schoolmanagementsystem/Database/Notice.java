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
    private String teacherName;
    private String studentClass;
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
    
    public Notice(String date, String time, String teacherName, String studentClass, String subject, String notice) {
        this.dateString = date;
        this.timeString = time;
        this.teacherName = teacherName;
        this.studentClass = studentClass;
        this.subject = subject;
        this.notice = notice;
    }
    
    public String getSubject(){
        return this.subject;
    }
    
    public String getTeacherName() {
        return teacherName;
    }
    
    public String getStudentClass() {
        return studentClass;
    }
    
    public String getNotice() {
        return notice;
    }
    
}
