package Models;
public class CourseRoster {
    private long CRN;
    private String studentID;
    private String grade;
    
    public CourseRoster() {
    }

    public CourseRoster(long cRN, String studentID, String grade) {
        CRN = cRN;
        this.studentID = studentID;
        this.grade = grade;
    }

    public long getCRN() {
        return CRN;
    }

    public void setCRN(long cRN) {
        CRN = cRN;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "CourseRoster [CRN=" + CRN + ", studentID=" + studentID + ", grade=" + grade + "]";
    }

    

}
