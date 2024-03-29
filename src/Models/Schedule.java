package Models;
public class Schedule {
    private String courseID;
    private long CRN;
    private String courseName;
    private String term;
    private String facultyID;
    private String room;
    private int capacity;
    private int creditHours;

    public Schedule() {
    }

    public Schedule(String courseID, long cRN, String courseName, String term, String facultyID, String room, int capacity,
            int creditHours) {

        this.courseID = courseID;
        CRN = cRN;
        this.courseName = courseName;
        this.term = term;
        this.facultyID = facultyID;
        this.room = room;
        this.capacity = capacity;
        this.creditHours = creditHours;
    }

    public String getCourseID() {
        return courseID;
    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    public long getCRN() {
        return CRN;
    }
    public void setCRN(long cRN) {
        CRN = cRN;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getTerm() {
        return term;
    }
    public void setTerm(String term) {
        this.term = term;
    }
    public String getFacultyID() {
        return facultyID;
    }
    public void setFacultyID(String facultyID) {
        this.facultyID = facultyID;
    }
    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getCreditHours() {
        return creditHours;
    }
    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    @Override
    public String toString() {
        return "Schedule [courseID=" + courseID + ", CRN=" + CRN + ", courseName=" + courseName + ", term=" + term
                + ", facultyID=" + facultyID + ", room=" + room + ", capacity=" + capacity + ", creditHours="
                + creditHours + "]";
    }

    
    
}
