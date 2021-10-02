
package schoolmanagementsystem.Database;

/**
 *
 * @author fahim
 */
public class Message {
    
    private String message;
    private String studentId;
    private String teacherId;
    private String teacherName;

 
    

    public Message() {
    }
    public Message(String teacherId,String message) {
        this.message = message;
       
        this.teacherId = teacherId;
        
    }
    
     public Message(String teacherName,String teacherId,String message) {
         this.teacherName=teacherName;
         this.message = message;
   
        this.teacherId = teacherId;
        
    }

    public String getTeacherName() {
        return teacherName; 
    }

    public String getMessage() {
        return message;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getTeacherId() {
        return teacherId; 
    }

    public Object getStudentName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

  
}
