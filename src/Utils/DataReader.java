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
package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Models.CourseRoster;
import Models.Credentials;
import Models.Department;
import Models.Faculty;
import Models.Major;
import Models.Schedule;
import Models.Students;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DataReader {

    /*
     * Paths to data files
     */
    private static final String courseRosterPath = "src/Data/CourseRoster.txt";
    private static final String departmentPath = "src/Data/Department.txt";
    private static final String facultyPath = "src/Data/Faculty.txt";
    private static final String majorPath = "src/Data/Major.txt";
    private static final String schedulePath = "src/Data/Schedule.txt";
    private static final String studentsPath = "src/Data/Students.txt";

    /*
     * Instance ArrayList to hold all data
     */
    private ArrayList<CourseRoster> courseRoster;
    private ArrayList<Department> departments;
    private ArrayList<Faculty> faculty;
    private ArrayList<Major> majors;
    private ArrayList<Schedule> schedule;
    private ArrayList<Students> students;

    /*
     * Constructor to initialize the ArrayLists
     */
    public DataReader() {
        courseRoster = readCourseRoster();
        departments = readDepartment();
        faculty = readFaculty();
        majors = readMajor();
        schedule = readSchedule();
        students = readStudents();
    }

    /***
     * Read the course roster
     * 
     * @param courseRoster an arrayList to hold the courseRosters
     */
    public static ArrayList<CourseRoster> readCourseRoster() {
        ArrayList<CourseRoster> courseRoster = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(courseRosterPath))) {
            String line = null;
            String[] parts = null;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                parts = line.split(":");
                CourseRoster cr = new CourseRoster();
                cr.setCRN(Long.parseLong(parts[0]));
                cr.setStudentID(parts[1]);
                cr.setGrade(parts[2]);
                courseRoster.add(cr);
            }
        } catch (FileNotFoundException e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("File not found: " + courseRosterPath);
            error.showAndWait();
        }
        return courseRoster;
    }

    public static ArrayList<CourseRoster> readCourseRoster(long CRN, String studentID, String grade) {
        ArrayList<CourseRoster> courseRoster = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(courseRosterPath))) {
            String line = null;
            String[] parts = null;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                parts = line.split(":");
                if (CRN == Long.parseLong(parts[0]) && studentID.equals(parts[1]) && grade.equals(parts[2])) {
                    continue;
                } else {
                    CourseRoster cr = new CourseRoster();
                    cr.setCRN(Long.parseLong(parts[0]));
                    cr.setStudentID(parts[1]);
                    cr.setGrade(parts[2]);
                    courseRoster.add(cr);
                }
            }
        } catch (FileNotFoundException e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("File not found: " + courseRosterPath);
            error.showAndWait();
        }
        return courseRoster;
    }

    /***
     * Read the schedule
     * 
     * @param schedule an arrayList to hold the schedules
     */
    public static ArrayList<Schedule> readSchedule() {
        ArrayList<Schedule> schedule = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(schedulePath))) {
            String line = null;
            String[] parts = null;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                parts = line.split(":");
                Schedule sch = new Schedule();
                sch.setCourseID(parts[0]);
                sch.setCRN(Long.parseLong(parts[1]));
                sch.setCourseName(parts[2]);
                sch.setTerm(parts[3]);
                sch.setFacultyID(parts[4]);
                sch.setRoom(parts[5]);
                sch.setCapacity(Integer.parseInt(parts[6]));
                sch.setCreditHours(Integer.parseInt(parts[7]));
                schedule.add(sch);
            }
        } catch (FileNotFoundException e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("File not found: " + schedulePath);
            error.showAndWait();
        }
        return schedule;
    }

    /***
     * Read the department
     * 
     * @param departments an arrayList to hold the departments
     */
    public static ArrayList<Department> readDepartment() {
        ArrayList<Department> departments = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(departmentPath))) {
            String line = null;
            String[] parts = null;
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                parts = line.split(":");
                Department department = new Department();
                department.setDepartmentID(Integer.parseInt(parts[0]));
                department.setDepartmentName(parts[1]);
                departments.add(department);
            }
        } catch (FileNotFoundException e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("File not found: " + departmentPath);
            error.showAndWait();
        }
        return departments;
    }

    /***
     * Read the major
     * 
     * @param majors an arrayList to hold the majors
     */
    public static ArrayList<Major> readMajor() {
        ArrayList<Major> majors = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(majorPath))) {
            String line = null;
            String[] parts = null;
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                parts = line.split(":");
                Major major = new Major();
                major.setMajorID(Integer.parseInt(parts[0]));
                major.setMajorName(parts[1]);
                major.setDepartmentID(Integer.parseInt(parts[2]));
                majors.add(major);
            }
        } catch (FileNotFoundException e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("File not found: " + majorPath);
            error.showAndWait();
        }
        return majors;
    }

    /***
     * Read the faculty
     * 
     * @param faculty an arrayList to hold the faculty
     */
    public static ArrayList<Faculty> readFaculty() {
        ArrayList<Faculty> faculty = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(facultyPath))) {
            String line = null;
            String[] parts = null;
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                parts = line.split(":");
                Faculty fac = new Faculty();
                fac.setFacultyID(parts[0]);
                fac.setFirstName(parts[1]);
                fac.setLastName(parts[2]);
                fac.setHireDate(parts[3]);
                fac.setTitle(parts[4]);
                fac.setSalary(Double.parseDouble(parts[5]));
                fac.setStreet(parts[6]);
                fac.setCity(parts[7]);
                fac.setState(parts[8]);
                fac.setZipCode(Integer.parseInt(parts[9]));
                fac.setPhone(parts[10]);
                fac.setEmail(parts[11]);
                fac.setDepartmentID(Integer.parseInt(parts[12]));
                faculty.add(fac);
            }
        } catch (FileNotFoundException e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("File not found: " + facultyPath);
            error.showAndWait();
        }
        return faculty;
    }

    /**
     * Read the faculty in the faculty file
     * 
     * @param facultyID    the ID of the faculty that should not be included in the
     *                     arrayList
     * @param firstName    the first name of the faculty that should not be included
     *                     in the arrayList
     * @param lastName     the last name of the faculty that should not be included
     *                     in the arrayList
     * @param hireDate     the hire date of the faculty that should not be included
     *                     in the arrayList
     * @param title        the title of the faculty that should not be included in
     *                     the arrayList
     * @param salary       the salary of the faculty that should not be included in
     *                     the arrayList
     * @param street       the street of the faculty that should not be included in
     *                     the arrayList
     * @param city         the city of the faculty that should not be included in
     *                     the arrayList
     * @param state        the state of the faculty that should not be included in
     *                     the arrayList
     * @param zipCode      the zip code of the faculty that should not be included
     *                     in the arrayList
     * @param phone        the phone number of the faculty that should not be
     *                     included in the arrayList
     * @param email        the email of the faculty that should not be included in
     *                     the arrayList
     * @param departmentID the department ID of the faculty that should not be
     *                     included in the arrayList
     * @return an arrayList of faculty that do not match the parameters
     */
    public static ArrayList<Faculty> readFaculty(String facultyID, String firstName, String lastName, String hireDate,
            String title, double salary, String street, String city, String state, int zipCode, String phone,
            String email, int departmentID) {
        ArrayList<Faculty> faculty = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(facultyPath))) {
            String line = null;
            String[] parts = null;
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                parts = line.split(":");
                if (facultyID.equals(parts[0]) && firstName.equals(parts[1]) && lastName.equals(parts[2])
                        && hireDate.equals(parts[3]) && title.equals(parts[4]) && salary == Double.parseDouble(parts[5])
                        && street.equals(parts[6]) && city.equals(parts[7]) && state.equals(parts[8])
                        && zipCode == Integer.parseInt(parts[9]) && phone.equals(parts[10]) && email.equals(parts[11])
                        && departmentID == Integer.parseInt(parts[12])) {
                    continue;
                } else {
                    Faculty fac = new Faculty();
                    fac.setFacultyID(parts[0]);
                    fac.setFirstName(parts[1]);
                    fac.setLastName(parts[2]);
                    fac.setHireDate(parts[3]);
                    fac.setTitle(parts[4]);
                    fac.setSalary(Double.parseDouble(parts[5]));
                    fac.setStreet(parts[6]);
                    fac.setCity(parts[7]);
                    fac.setState(parts[8]);
                    fac.setZipCode(Integer.parseInt(parts[9]));
                    fac.setPhone(parts[10]);
                    fac.setEmail(parts[11]);
                    fac.setDepartmentID(Integer.parseInt(parts[12]));
                    faculty.add(fac);
                }
            }
        } catch (FileNotFoundException e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("File not found: " + facultyPath);
            error.showAndWait();
        }
        return faculty;
    }

    public static ArrayList<Credentials> readCredentials() {
        ArrayList<Credentials> credentials = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("src/Data/StudentsCredentials.txt"))) {
            String line = null;
            String[] parts = null;
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                parts = line.split(":");
                Credentials credential = new Credentials();
                credential.setEmail(parts[0]);
                credential.setPassword(parts[1]);
                credentials.add(credential);
            }
            try (Scanner scanner2 = new Scanner(new File("src/Data/FacultyCredentials.txt"))) {
                while (scanner2.hasNext()) {
                    line = scanner2.nextLine();
                    parts = line.split(":");
                    Credentials credential = new Credentials();
                    credential.setEmail(parts[0]);
                    credential.setPassword(parts[1]);
                    credentials.add(credential);
                }
            } catch (FileNotFoundException e) {
                Alert error = new Alert(AlertType.ERROR);
                error.setContentText("File not found: src/Data/FacultyCredentials.txt");
                error.showAndWait();
            }
        } catch (FileNotFoundException e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("File not found: src/Data/Credentials.txt");
            error.showAndWait();
        }
        return credentials;
    }

    public static ArrayList<Students> readStudents(String studentID, String firstName, String lastName, String street,
            String city, String state, int zipCode, String phone, String email, int majorID,
            String expectedGraduationDate) {
        ArrayList<Students> students = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(studentsPath))) {
            String line = null;
            String[] parts = null;
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                parts = line.split(":");
                if (studentID.equals(parts[0]) && firstName.equals(parts[1]) && lastName.equals(parts[2])
                        && street.equals(parts[3]) && city.equals(parts[4]) && state.equals(parts[5])
                        && zipCode == Integer.parseInt(parts[6]) && phone.equals(parts[7]) && email.equals(parts[8])
                        && majorID == Integer.parseInt(parts[9]) && expectedGraduationDate.equals(parts[10])) {
                    continue;
                } else {
                    Students student = new Students();
                    student.setStudentID(parts[0]);
                    student.setFirstName(parts[1]);
                    student.setLastName(parts[2]);
                    student.setStreet(parts[3]);
                    student.setCity(parts[4]);
                    student.setState(parts[5]);
                    student.setZipCode(Integer.parseInt(parts[6]));
                    student.setPhone(parts[7]);
                    student.setEmail(parts[8]);
                    student.setMajorID(Integer.parseInt(parts[9]));
                    student.setExpectedGraduationDate(parts[10]);
                    students.add(student);
                }
            }
        } catch (FileNotFoundException e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("File not found: " + studentsPath);
            error.showAndWait();
        }
        return students;
    }

    /***
     * Read the students
     * 
     * @param students an arrayList to hold the students
     */
    public static ArrayList<Students> readStudents() {
        ArrayList<Students> students = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(studentsPath))) {
            String line = null;
            String[] parts = null;
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                parts = line.split(":");
                Students student = new Students();
                student.setStudentID(parts[0]);
                student.setFirstName(parts[1]);
                student.setLastName(parts[2]);
                student.setStreet(parts[3]);
                student.setCity(parts[4]);
                student.setState(parts[5]);
                student.setZipCode(Integer.parseInt(parts[6]));
                student.setPhone(parts[7]);
                student.setEmail(parts[8]);
                student.setMajorID(Integer.parseInt(parts[9]));
                student.setExpectedGraduationDate(parts[10]);
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("File not found: " + studentsPath);
            error.showAndWait();
        }
        return students;
    }
}
