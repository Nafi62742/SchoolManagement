package schoolmanagementsystem.Database;


public class Homework {
    private String subject;
    private int hwClass;
    private int totalMarks;
   private String sec;
    private String dueDateString;
    private String postDate;
    private String homeworkText;
    private int teacherId;
    private String teacherName;

    public Homework() {
    }

    public Homework(int hwClass, String sec, int totalMarks, String dueDateString, String homeworkText,int teacherId,String teacherName) {
        this.hwClass = hwClass;
        this.totalMarks = totalMarks;
        this.sec = sec;
        this.dueDateString = dueDateString;
        this.homeworkText = homeworkText;
        this.teacherId=teacherId;
        this.teacherName=teacherName;
    }

   public int getTeacherId() {
        return teacherId;
    }
    public String getTeacherName() {
        return teacherName;
    }


    public String getSubject() {
        return subject;
    }

    public int getHwClass() {
        return hwClass;
    }

    public void setClass(int hwClass) {
        this.hwClass = hwClass;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public String getDueDateString() {
        return dueDateString;
    }

    public String getPostDate() {
        return postDate;
    }

    public String getHomeworkText() {
        return homeworkText;
    }
}
