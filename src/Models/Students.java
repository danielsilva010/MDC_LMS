/*
 * Copyright ©️ 2024 Daniel Silva
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package Models;
public class Students {
    /*
     * Student ID,
     * First Name, Last Name, Street, City, State, Zip Code, Phone, Email, Major ID,
     * Expected
     * Graduation Date
     */

    private String studentID;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int zipCode;
    private String phone;
    private String email;
    private int majorID;
    private String expectedGraduationDate;

    public Students(String studentID, String firstName, String lastName, String street, String city, String state,
            int zipCode, String phone, String email, int majorID, String expectedGraduationDate) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phone = phone;
        this.email = email;
        this.majorID = majorID;
        this.expectedGraduationDate = expectedGraduationDate;

    }

    public Students() {

    }

    public Students(Students otherStudent) {
        this.studentID = otherStudent.studentID;
        this.firstName = otherStudent.firstName;
        this.lastName = otherStudent.lastName;
        this.street = otherStudent.street;
        this.city = otherStudent.city;
        this.state = otherStudent.state;
        this.zipCode = otherStudent.zipCode;
        this.phone = otherStudent.phone;
        this.email = otherStudent.email;
        this.majorID = otherStudent.majorID;
        this.expectedGraduationDate = otherStudent.expectedGraduationDate;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getMajorID() {
        return majorID;
    }

    public String getExpectedGraduationDate() {
        return expectedGraduationDate;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMajorID(int majorID) {
        this.majorID = majorID;
    }

    public void setExpectedGraduationDate(String expectedGraduationDate) {
        this.expectedGraduationDate = expectedGraduationDate;
    }

    @Override
    public String toString() {
        return "Students [studentID=" + studentID + ", firstName=" + firstName + ", lastName=" + lastName + ", street="
                + street + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", phone=" + phone
                + ", email=" + email + ", majorID=" + majorID + ", expectedGraduationDate=" + expectedGraduationDate
                + "]";
    }

    
    
}
