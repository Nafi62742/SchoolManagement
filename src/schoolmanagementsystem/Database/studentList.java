/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagementsystem.Database;


public class studentList {
    
    private String studentName;
    private String studentClass;
    private String studentPhoneNo;
    private String studentEmail;
    private String section;
    
    

    public studentList() {
     }
    public studentList(String studentName, String studentClass, String studentPhoneNo, String studentEmail, String section) {
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentPhoneNo = studentPhoneNo;
        this.studentEmail = studentEmail;
        this.section = section;
    }

    public studentList(String studentName, String studentClass, String section) {
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.section = section;
    }

  

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentPhoneNo() {
        return studentPhoneNo;
    }

    public void setStudentPhoneNo(String studentPhoneNo) {
        this.studentPhoneNo = studentPhoneNo;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

}
