/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagementsystem.Database;

/**
 *
 * @author Administrator
 */
public class Attendance {
    
    private String monthName;
    private String studentId;
    private int workingDays;
    private int presentDays;
    
    public Attendance(){
        
        
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
    
    
   
    
}
