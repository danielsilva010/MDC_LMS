package Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Models.CourseRoster;
import Models.Faculty;
import Models.FacultyCourses;
import Models.StudentCourses;
import Models.Students;
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

    public static boolean writeFacultyToTempFile(String facultyID, String firstName, String lastName, String email,
            String phone, String hireDate, double salary, String title, String street, String city, String state,
            int zipCode, int departmentID) {
        ArrayList<Faculty> faculties = DataReader.readFaculty(facultyID, firstName, lastName, hireDate, title, salary,
                street, city, state, zipCode, phone, email, departmentID);
        File tempFile = new File("src/Data/temp.txt");
        File originalFile = new File("src/Data/Faculty.txt");
        try (FileWriter fw = new FileWriter(tempFile, true)) {
            PrintWriter pw = new PrintWriter(fw);
            for (Faculty faculty : faculties) {
                pw.print(
                        "\n" + faculty.getFacultyID() + ":" + faculty.getFirstName() + ":" + faculty.getLastName() + ":"
                                + faculty.getHireDate() + ":" + faculty.getTitle() + ":" + faculty.getSalary() + ":"
                                + faculty.getStreet() + ":" + faculty.getCity() + ":" + faculty.getState() + ":"
                                + faculty.getZipCode() + ":" + faculty.getPhone() + ":" + faculty.getEmail() + ":"
                                + faculty.getDepartmentID());
            }
            pw.print("\n" + facultyID + ":" + firstName + ":" + lastName + ":" + hireDate + ":" + title + ":" + salary
                    + ":" + street + ":" + city + ":" + state + ":" + zipCode + ":" + phone + ":" + email + ":"
                    + departmentID);
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error writing to file");
            alert.setContentText(
                    "The file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");
            alert.showAndWait();
            return false;
        }
        // Delete the original file and rename the temp file
        if (originalFile.delete()) {
            if (tempFile.renameTo(originalFile)) {
                return true;
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error renaming file");
                alert.setContentText("Could not rename temporary file to " + originalFile.getName());
                alert.showAndWait();
                return false;
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error deleting file");
            alert.setContentText("Could not delete original file " + originalFile.getName());
            alert.showAndWait();
            return false;
        }
    }

    public static boolean writeStudentExceptThis(String studentID, String firstName, String lastName, String address,
            String city,
            String state, int zipCode, String phone, String email, int majorID, String expectedGrad) {
        ArrayList<Students> students = DataReader.readStudents(studentID, firstName, lastName, address, city, state,
                zipCode, phone, email, majorID, expectedGrad);
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID().equals(studentID)) {
                students.remove(i);
                break;
            }
        }
        File tempFile = new File("src/Data/temp.txt");
        File originalFile = new File("src/Data/Students.txt");
        try (FileWriter fw = new FileWriter(tempFile, true)) {
            PrintWriter pw = new PrintWriter(fw);
            for (Students student : students) {
                if (!student.getStudentID().equals(studentID)) {
                    pw.print("\n" + student.getStudentID() + ":" + student.getFirstName() + ":" + student.getLastName()
                            + ":"
                            + student.getStreet() + ":" + student.getCity() + ":" + student.getState() + ":"
                            + student.getZipCode() + ":" + student.getPhone() + ":" + student.getEmail() + ":"
                            + student.getMajorID() + ":" + student.getExpectedGraduationDate());
                }
            }
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error writing to file");
            alert.setContentText(
                    "The file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");
            alert.showAndWait();
            return false;
        }
        // Delete the original file and rename the temp file
        if (originalFile.delete()) {
            if (tempFile.renameTo(originalFile)) {
                return true;
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error renaming file");
                alert.setContentText("Could not rename temporary file to " + originalFile.getName());
                alert.showAndWait();
                return false;
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error deleting file");
            alert.setContentText("Could not delete original file " + originalFile.getName());
            alert.showAndWait();
            return false;
        }
    }

    public static boolean writeStudents(String studentID, String firstName, String lastName, String address,
            String city,
            String state, int zipCode, String phone, String email, int majorID, String expectedGrad) {
        ArrayList<Students> students = DataReader.readStudents(studentID, firstName, lastName, address, city, state,
                zipCode, phone, email, majorID, expectedGrad);
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID().equals(studentID)) {
                students.remove(i);
                break;
            }
        }
        File tempFile = new File("src/Data/temp.txt");
        File originalFile = new File("src/Data/Students.txt");
        try (FileWriter fw = new FileWriter(tempFile, true)) {
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < students.size(); i++) {
                Students student = students.get(i);
                if (i > 0) {
                    pw.print("\n");
                }
                pw.print(student.getStudentID() + ":" + student.getFirstName() + ":" + student.getLastName() + ":"
                        + student.getStreet() + ":" + student.getCity() + ":" + student.getState() + ":"
                        + student.getZipCode() + ":" + student.getPhone() + ":" + student.getEmail() + ":"
                        + student.getMajorID() + ":" + student.getExpectedGraduationDate());
            }
            pw.print(
                    "\n" + studentID + ":" + firstName + ":" + lastName + ":" + address + ":" + city + ":" + state + ":"
                            + zipCode + ":" + phone + ":" + email + ":" + majorID + ":" + expectedGrad);
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error writing to file");
            alert.setContentText(
                    "The file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");
            alert.showAndWait();
            return false;
        }
        // Delete the original file and rename the temp file
        if (originalFile.delete()) {
            if (tempFile.renameTo(originalFile)) {
                return true;
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error renaming file");
                alert.setContentText("Could not rename temporary file to " + originalFile.getName());
                alert.showAndWait();
                return false;
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error deleting file");
            alert.setContentText("Could not delete original file " + originalFile.getName());
            alert.showAndWait();
            return false;
        }
    }

    public static boolean writeCourseRoster(long CRN, String studentID, String grade) {
        ArrayList<CourseRoster> course = DataReader.readCourseRoster(CRN, studentID, grade);
        File tempFile = new File("src/Data/temp.txt");
        File originalFile = new File("src/Data/CourseRoster.txt");
        try (FileWriter fw = new FileWriter(tempFile, true)) {
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < course.size(); i++) {
                CourseRoster roster = course.get(i);
                if (i != 0) {
                    pw.print("\n"); // Add newline character before the 2nd and subsequent lines
                }
                pw.print(roster.getCRN() + ":" + roster.getStudentID() + ":" + roster.getGrade());
            }
            // Write the new course roster
            if (!course.isEmpty()) {
                pw.print("\n"); // Add newline character before the new course roster if the list is not empty
            }
            pw.print(CRN + ":" + studentID + ":" + grade);
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error writing to file");
            alert.setContentText(
                    "The file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");
            alert.showAndWait();
            return false;
        }

        // Delete the original file
        if (originalFile.delete()) {
            // Rename the new file to the filename the original file had.
            if (tempFile.renameTo(originalFile)) {
                return true;
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error renaming file");
                alert.setContentText("Could not rename temporary file to " + originalFile.getName());
                alert.showAndWait();
                return false;
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error deleting file");
            alert.setContentText("Could not delete original file " + originalFile.getName());
            alert.showAndWait();
            return false;
        }
    }

    public static boolean writeFacultyExceptThis(Faculty faculty) {
        ArrayList<Faculty> faculties = DataReader.readFaculty();
        for (int i = 0; i < faculties.size(); i++) {
            if (faculties.get(i).getFacultyID().equals(faculty.getFacultyID())) {
                faculties.remove(i);
                break;
            }
        }
        File tempFile = new File("src/Data/temp.txt");
        File originalFile = new File("src/Data/Faculty.txt");
        try (FileWriter fw = new FileWriter(tempFile, true)) {
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < faculties.size(); i++) {
                Faculty f = faculties.get(i);
                if (i > 0) {
                    pw.print("\n");
                }
                pw.print(f.getFacultyID() + ":" + f.getFirstName() + ":" + f.getLastName() + ":" + f.getHireDate() + ":"
                        + f.getTitle() + ":" + f.getSalary() + ":" + f.getStreet() + ":" + f.getCity() + ":"
                        + f.getState() + ":" + f.getZipCode() + ":" + f.getPhone() + ":" + f.getEmail() + ":"
                        + f.getDepartmentID());
            }
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error writing to file");
            alert.setContentText(
                    "The file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");
            alert.showAndWait();
            return false;
        }
        // Delete the original file and rename the temp file
        if (originalFile.delete()) {
            if (tempFile.renameTo(originalFile)) {
                return true;
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error renaming file");
                alert.setContentText("Could not rename temporary file to " + originalFile.getName());
                alert.showAndWait();
                return false;
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error deleting file");
            alert.setContentText("Could not delete original file " + originalFile.getName());
            alert.showAndWait();
            return false;
        }
    }

    public static boolean writeUpdatedFacultyFile(String ID, String firstName, String lastName, String hireDate,
            String title, double salary, String street, String city, String state, int zipCode, String phone,
            String email, int departmentID) {
        ArrayList<Faculty> faculties = DataReader.readFaculty();
        for (int i = 0; i < faculties.size(); i++) {
            if (faculties.get(i).getFacultyID().equals(ID)) {
                faculties.remove(i);
                break;
            }
        }
        File tempFile = new File("src/Data/temp.txt");
        File originalFile = new File("src/Data/Faculty.txt");
        try (FileWriter fw = new FileWriter(tempFile, true)) {
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < faculties.size(); i++) {
                Faculty faculty = faculties.get(i);
                if (i > 0) {
                    pw.print("\n");
                }
                pw.print(faculty.getFacultyID() + ":" + faculty.getFirstName() + ":" + faculty.getLastName() + ":"
                        + faculty.getHireDate() + ":" + faculty.getTitle() + ":" + faculty.getSalary() + ":"
                        + faculty.getStreet() + ":" + faculty.getCity() + ":" + faculty.getState() + ":"
                        + faculty.getZipCode() + ":" + faculty.getPhone() + ":" + faculty.getEmail() + ":"
                        + faculty.getDepartmentID());
            }
            pw.print("\n" + ID + ":" + firstName + ":" + lastName + ":" + hireDate + ":" + title + ":" + salary + ":"
                    + street + ":" + city + ":" + state + ":" + zipCode + ":" + phone + ":" + email + ":"
                    + departmentID);
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error writing to file");
            alert.setContentText(
                    "The file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");
            alert.showAndWait();
            return false;
        }
        // Delete the original file and rename the temp file
        if (originalFile.delete()) {
            if (tempFile.renameTo(originalFile)) {
                return true;
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error renaming file");
                alert.setContentText("Could not rename temporary file to " + originalFile.getName());
                alert.showAndWait();
                return false;
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error deleting file");
            alert.setContentText("Could not delete original file " + originalFile.getName());
            alert.showAndWait();
            return false;
        }
    }

    public static boolean writeCredentials(String email, String password, String role) {
        if (role == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid role");
            alert.setContentText("Role cannot be null");
            alert.showAndWait();
            return false;
        }

        String filename = role.equals("Student") ? "src/Data/StudentsCredentials.txt"
                : "src/Data/FacultyCredentials.txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename, true))) {
            pw.print("\n" + email + ":" + password);
            return true;
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error writing to file");
            alert.setContentText(
                    e.getMessage()
                            + "\nThe file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");
            alert.showAndWait();
            return false;
        }
    }
}
