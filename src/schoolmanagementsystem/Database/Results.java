
package schoolmanagementsystem.Database;

public class Results {
   
    private String studentId;
    private String bangla1st;
    private String bangla2nd;
    private String english1st;
    private String english2nd;
    private String math;
    private String science;
    private String religion;
    
    public Results() {
          
    }
    
    public Results(String studentId, String bangla1st,String bangla2nd, String english1st, String english2nd,String math ,String science,String religion) {
        
        this.studentId = studentId;
        this.bangla1st = bangla1st;
        this.bangla2nd = bangla2nd;
        this.english1st = english1st;
        this.english2nd = english2nd;
        this.math = math;
        this.science = science;
        this.religion = religion;
  
    }
    
    public String getStudentId() {
        return studentId;
    }

   
    public String getBangla1st() {
        return bangla1st;
    }

    public String getBangla2nd() {
        return bangla2nd;
    }


    public String getEnglish1st() {
        return english1st;
    }

    public String getEnglish2nd() {
        return english2nd;
    }



    public String getMath() {
        return math;
    }

    public String getScience() {
        return science;
    }


    public String getReligion() {
        return religion;
    }    
}

