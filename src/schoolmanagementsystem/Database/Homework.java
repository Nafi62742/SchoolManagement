
package schoolmanagementsystem.Database;

/**
 *
 * @author fahim
 */
public class Homework {
    private String subject;
    private int totalMarks;
    private String dueDateString;
    private String postDate;
    private String homeworkText;

    public Homework() {
    }
    public Homework(String subject, int totalMarks, String postDate,String dueDateString, String homeworkText) {
        this.subject = subject;
        this.totalMarks = totalMarks;
        this.postDate=postDate;
        this.dueDateString = dueDateString;
        this.homeworkText = homeworkText;
    }

    public String getSubject() {
        return subject;
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
