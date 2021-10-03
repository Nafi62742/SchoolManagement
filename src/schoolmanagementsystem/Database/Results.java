
package schoolmanagementsystem.Database;

public class Results {
   
    private int studentId;
    private int bangla1st;
    private int bangla2nd;
    private int english1st;
    private int english2nd;
    private int math;
    private int science;
    private int religion;
    private int bgs;
    private int ict;
     public Results() {
          
    }

    public Results(int studentId) {
        this.studentId = studentId;
    }

    public Results(int studentId, int bangla1st, int bangla2nd, int english1st, int english2nd, int math, int science, int religion) {
        this.studentId = studentId;
        this.bangla1st = bangla1st;
        this.bangla2nd = bangla2nd;
        this.english1st = english1st;
        this.english2nd = english2nd;
        this.math = math;
        this.science = science;
        this.religion = religion;
    }

    public Results(int studentId, int bangla1st, int bangla2nd, int english1st, int english2nd, int math, int science, int religion, int bgs, int ict) {
        this.studentId = studentId;
        this.bangla1st = bangla1st;
        this.bangla2nd = bangla2nd;
        this.english1st = english1st;
        this.english2nd = english2nd;
        this.math = math;
        this.science = science;
        this.religion = religion;
        this.bgs = bgs;
        this.ict = ict;
    }
    public int getBgs() {
        return bgs;
    }

    public void setBgs(int bgs) {
        this.bgs = bgs;
    }

    public int getIct() {
        return ict;
    }

    public void setIct(int ict) {
        this.ict = ict;
    }
   
	
   
 
    
//    public Results(String studentId, String bangla1st,String bangla2nd, String english1st, String english2nd,String math ,String science,String religion) {
//        
//        this.studentId = studentId;
//        this.bangla1st = bangla1st;
//        this.bangla2nd = bangla2nd;
//        this.english1st = english1st;
//        this.english2nd = english2nd;
//        this.math = math;
//        this.science = science;
//        this.religion = religion;
//  
//    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getBangla1st() {
        return bangla1st;
    }

    public void setBangla1st(int bangla1st) {
        this.bangla1st = bangla1st;
    }

    public int getBangla2nd() {
        return bangla2nd;
    }

    public void setBangla2nd(int bangla2nd) {
        this.bangla2nd = bangla2nd;
    }

    public int getEnglish1st() {
        return english1st;
    }

    public void setEnglish1st(int english1st) {
        this.english1st = english1st;
    }

    public int getEnglish2nd() {
        return english2nd;
    }

    public void setEnglish2nd(int english2nd) {
        this.english2nd = english2nd;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }
    


   
    
}

