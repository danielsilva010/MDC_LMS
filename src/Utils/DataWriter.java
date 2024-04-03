package Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Models.FacultyCourses;
import Models.StudentCourses;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DataWriter {
    /***
     * Write the student courses to a file
     * 
     * @param studentID the student ID
     */
    public static boolean writeStudentCourses(String studentID) {
        ArrayList<StudentCourses> courses = DataUtil.getCourses(studentID);
        File file = new File("src/Data/Courses-" + studentID);
        if (file.exists()) {
            file.delete();
        }

        try (FileWriter fw = new FileWriter(file, true)) {
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Course list for Student " + studentID + ", " + DataUtil.getStudentName(studentID));
            for (StudentCourses course : courses) {
                if (course == courses.get(courses.size() - 1)) {
                    pw.print(String.format("%d\t%s\t%s\t%s\t%s\t%s", course.getCRN(), course.getCourseID(),
                            course.getCourseName(), course.getTerm(), course.getFaculty(), course.getGrade()));
                } else {
                    pw.println(String.format("%d\t%s\t%s\t%s\t%s\t%s", course.getCRN(), course.getCourseID(),
                            course.getCourseName(), course.getTerm(), course.getFaculty(), course.getGrade()));
                }

            }
            return true;

        } catch (IOException e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("Error writing to file");
            error.setContentText(
                    "The file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");
            error.showAndWait();
            return false;
        }
    }

    public static boolean writeCourseRoster(String studentID, long CRN) {
        File file = new File("src/Data/CourseRoster-" + studentID + "-" + CRN);

        try (FileWriter fw = new FileWriter(file, true)) {
            PrintWriter pw = new PrintWriter(fw);
            pw.print("\n" + studentID + ":" + CRN + ":A+");
            return true;

        } catch (IOException e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("Error writing to file");
            error.setContentText(
                    "The file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");
            error.showAndWait();
            return false;
        }
    }

    /***
     * Write the faculty courses to a file
     * 
     * @param facultyID the faculty
     */
    public static boolean writeFacultyCourses(String facultyID) {
        ArrayList<FacultyCourses> courses = DataUtil.getFacultyCourses(facultyID);

        File file = new File("src/Data/FacultyCourses-" + facultyID);

        if (file.exists()) {
            file.delete();
        }

        try (FileWriter fw = new FileWriter(file, true)) {
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Course list for Faculty " + facultyID + ", " + DataUtil.getFacultyName(facultyID));
            for (FacultyCourses course : courses) {
                if (course == courses.get(courses.size() - 1)) {
                    pw.print(String.format("%d\t%s\t%s\t%s\t%s", course.getCRN(), course.getCourseID(),
                            course.getCourseName(), course.getTerm(), course.getGrade()));
                } else {
                    pw.println(String.format("%d\t%s\t%s\t%s\t%s", course.getCRN(), course.getCourseID(),
                            course.getCourseName(), course.getTerm(), course.getGrade()));
                }
            }
            return true;

        } catch (IOException e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("Error writing to file");
            error.setContentText(
                    "The file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");
            error.showAndWait();
            return false;
        }
    }

    /***
     * Write a new course to the Schedule.txt file
     * 
     * @param courseID    the course ID
     * @param CRN         the course CRN
     * @param title       the course title
     * @param term        the course term
     * @param faculty     the course faculty
     * @param room        the course room
     * @param capacity    the course capacity
     * @param creditHours the course credit hours
     * @return true if the course was written successfully, false otherwise
     */
    public static boolean writeNewCourse(String courseID, long CRN, String title, String term, String faculty,
            String room, int capacity,
            int creditHours) {
        File file = new File("src/Data/Schedule.txt");
        try (FileWriter fw = new FileWriter(file, true)) {
            PrintWriter pw = new PrintWriter(fw);
            String[] parts = term.split(" ");
            term = parts[0] + parts[1];
            pw.print(String.format("\n%s:%d:%s:%s:%s:%s:%d:%d", courseID, CRN, title, term, faculty, room,
                    capacity, creditHours));
            return true;

        } catch (IOException e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("Error writing to file");
            error.setContentText(
                    "The file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");
            error.showAndWait();
            return false;
        }
    }

    /***
     * Write a new student to the Students.txt file
     * 
     * @param studentID    the student's ID
     * @param firstName    the student's first name
     * @param lastName     the student's last name
     * @param address      the student's address
     * @param city         the student's city
     * @param state        the student's state
     * @param zipCode      the student's zip code
     * @param phone        the student's phone number
     * @param email        the student's email
     * @param majorID      the major ID
     * @param expectedGrad the student's expected graduation date
     * @return true if the student was written successfully, false otherwise
     */
    public static boolean writeNewStudent(String studentID, String firstName, String lastName, String address,
            String city,
            String state, String zipCode, String phone, String email, int majorID, String expectedGrad) {
        try (FileWriter fw = new FileWriter(new File("src/Data/Students.txt"), true)) {
            PrintWriter pw = new PrintWriter(fw);
            pw.print(
                    "\n" + studentID + ":" + firstName + ":" + lastName + ":" + address + ":" + city + ":" + state + ":"
                            + zipCode + ":" + phone + ":" + email + ":" + majorID + ":" + expectedGrad);
            return true;
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error writing to file");
            alert.setContentText(
                    "The file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");
            alert.showAndWait();
            return false;
        }
    }

    /***
     * Write a new faculty to the Faculty.txt file
     * 
     * @param facultyID    the faculty ID
     * @param firstName    the faculty's first name
     * @param lastName     the faculty's last name
     * @param email        the faculty's email
     * @param phone        the faculty's phone number
     * @param hireDate     the faculty's hire date
     * @param salary       the faculty's salary
     * @param title        the faculty's title
     * @param street       the faculty's street
     * @param city         the faculty's city
     * @param state        the faculty's state
     * @param zipCode      the faculty's zip code
     * @param departmentID the faculty's department ID
     * @return true if the faculty was written successfully, false otherwise
     */
    public static boolean writeFaculty(String facultyID, String firstName, String lastName, String email, String phone,
            String hireDate, String salary, String title, String street, String city, String state, String zipCode,
            String departmentID) {
        try (FileWriter fw = new FileWriter(new File("src/Data/Faculty.txt"), true)) {
            PrintWriter pw = new PrintWriter(fw);
            pw.print("\n" + facultyID + ":" + firstName + ":" + lastName + ":" + hireDate + ":" + title + ":" + salary
                    + ":" + street + ":" + city + ":" + state + ":" + zipCode + ":" + phone + ":" + email + ":"
                    + departmentID);
            return true;
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error writing to file");
            alert.setContentText(
                    "The file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");
            alert.showAndWait();
            return false;
        }

    }
}
