
package schoolmanagementsystem.Database;

/**
 *
 * @author fahim
 */
public class Message {
    
    private String message;
    private String studentId;
    private String teacherName;
    private String dateString;
    private String timeString;

    public String getDateString() {
        return dateString;
    }

    public String getTimeString() {
        return timeString;
    }
    

    public Message() {
    }
    public Message(String teacherName, String studentId,String message, String dateString, String timeString ) {
        this.message = message;
        this.studentId = studentId;
        this.teacherName = teacherName;
        this.dateString = dateString;
        this.timeString = timeString;
    }

    

    public String getMessage() {
        return message;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getTeacherName() {
        return teacherName; 
    }

    public Object getStudentName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

  
}
