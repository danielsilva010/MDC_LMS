package Models;
public class Major {
    private int majorID;
    private String majorName;
    private int departmentID;

    public Major(int majorID, String majorName, int departmentID) {
        this.majorID = majorID;
        this.majorName = majorName;
        this.departmentID = departmentID;
    }

    public Major() {

    }

    public Major(Major otherMajor) {
        this.majorID = otherMajor.majorID;
        this.majorName = otherMajor.majorName;
        this.departmentID = otherMajor.departmentID;
    }

    public int getMajorID() {
        return majorID;
    }

    public String getMajorName() {
        return majorName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setMajorID(int majorID) {
        this.majorID = majorID;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public String toString() {
        return "Major [majorID=" + majorID + ", majorName=" + majorName + ", departmentID=" + departmentID + "]";
    }

    
}
