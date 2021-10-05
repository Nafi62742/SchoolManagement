/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagementsystem.Database;


public class Attendance {
    
    private String monthName;
    private String teacherId;
    private String studentId;
    private int workingDays;
    private int presentDays;
    private int totalWorkingdays;
    private int totalPresentdays;
    public Attendance(){
    }

    public Attendance(int totalWorkingdays, int totalPresentdays) {
        this.totalWorkingdays = totalWorkingdays;
        this.totalPresentdays = totalPresentdays;
    }

    
    public Attendance(String monthName, String teacherId, String studentId, int workingDays, int presentDays, int totalWorkingdays, int totalPresentdays) {
        this.monthName = monthName;
        this.teacherId = teacherId;
        this.studentId = studentId;
        this.workingDays = workingDays;
        this.presentDays = presentDays;
        this.totalWorkingdays = totalWorkingdays;
        this.totalPresentdays = totalPresentdays;
    }

    
    public Attendance(String monthName, String teacherId, String studentId, int workingDays, int presentDays, int totalWorkingdays) {
        this.monthName = monthName;
        this.teacherId = teacherId;
        this.studentId = studentId;
        this.workingDays = workingDays;
        this.presentDays = presentDays;
        this.totalWorkingdays = totalWorkingdays;
    }

    public Attendance(String monthName, String teacherId, String studentId, int workingDays, int presentDays) {
        this.monthName = monthName;
        this.teacherId = teacherId;
        this.studentId = studentId;
        this.workingDays = workingDays;
        this.presentDays = presentDays;
    }
    
    
    public Attendance(String monthName, String studentId, int workingDays, int presentDays)
    {
        this.monthName = monthName;
        this.studentId = studentId;
        this.workingDays = workingDays;
        this.presentDays = presentDays;
        //System.out.println(getWorkingDays());
    }
    
    public String getMonthName() {
        return monthName;
    }

    public String getStudentId() {
        return studentId;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public int getPresentDays() {
        return presentDays;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public int getTotalWorkingdays() {
        return totalWorkingdays;
    }

    public void setTotalWorkingdays(int totalWorkingdays) {
        this.totalWorkingdays = totalWorkingdays;
    }

    public int getTotalPresentdays() {
        return totalPresentdays;
    }

    public void setTotalPresentdays(int totalPresentdays) {
        this.totalPresentdays = totalPresentdays;
    }
  
    
}
