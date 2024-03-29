package Models;
public class Faculty {
    private String FacultyID;
    private String firstName;
    private String lastName;
    private String hireDate;
    private String title;
    private double salary;
    private String street;
    private String city;
    private String state;
    private int zipCode;
    private String phone;
    private String email;
    private int departmentID;
    
    
    public Faculty (String facultyID, String firstName, String lastName, String hireDate, String title, double salary,
            String street, String city, String state, int zipCode, String phone, String email, int departmentID) {
        FacultyID = facultyID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.title = title;
        this.salary = salary;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phone = phone;
        this.email = email;
        this.departmentID = departmentID;
    }

    public Faculty() {

    }

    public String getFacultyID() {
        return FacultyID;
    }

    public void setFacultyID(String facultyID) {
        FacultyID = facultyID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public String toString() {
        return "Faculty [FacultyID=" + FacultyID + ", firstName=" + firstName + ", lastName=" + lastName + ", hireDate="
                + hireDate + ", title=" + title + ", salary=" + salary + ", street=" + street + ", city=" + city
                + ", state=" + state + ", zipCode=" + zipCode + ", phone=" + phone + ", email=" + email
                + ", departmentID=" + departmentID + "]";
    }

    

}
