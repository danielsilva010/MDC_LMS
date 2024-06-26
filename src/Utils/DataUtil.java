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

import java.util.ArrayList;

import Models.CourseRoster;
import Models.Credentials;
import Models.Department;
import Models.Faculty;
import Models.FacultyCourses;
import Models.Major;
import Models.Schedule;
import Models.StudentCourses;
import Models.Students;

public class DataUtil {

    /***
     * Get the courses for a student
     * @param studentID the student ID
     * @return an array list of student courses
     */
    public static ArrayList<StudentCourses> getCourses(String studentID) {
        ArrayList<CourseRoster> courseRoster = DataReader.readCourseRoster();
        ArrayList<Faculty> facultyList = DataReader.readFaculty();
        ArrayList<Schedule> scheduleList = DataReader.readSchedule();

        ArrayList<StudentCourses> studentCourses = new ArrayList<>();
        for (int index = courseRoster.size() - 1; index >= 0; index--) {
            if (!courseRoster.get(index).getStudentID().equals(studentID)) {
                courseRoster.remove(index);
            }
        }

        for (int i = 0; i < scheduleList.size(); i++) {
            for (int j = 0; j < courseRoster.size(); j++) {
                if (courseRoster.get(j).getCRN() == scheduleList.get(i).getCRN()) {
                    StudentCourses studentCourse = new StudentCourses();
                    studentCourse.setCourseRoster(courseRoster.get(j));
                    studentCourse.setSchedule(scheduleList.get(i));
                    for (Faculty faculty : facultyList) {
                        if (faculty.getFacultyID().equals(scheduleList.get(i).getFacultyID())) {
                            studentCourse.setFaculty(faculty);
                        }
                    }
                    studentCourses.add(studentCourse);
                }
            }
        }
        return studentCourses;
    }

    /***
     * Get the student
     * @param studentID the student ID
     * @return the student
     */
    public static Students getStudent(String studentID) {
        ArrayList<Students> studentList = DataReader.readStudents();
        for (Students student : studentList) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    /***
     * Get the schedule
     * 
     * @param CRN the course registration number
     * @return the schedule
     */
    public static Schedule getSchedule(long CRN) {
        ArrayList<Schedule> scheduleList = DataReader.readSchedule();
        for (Schedule schedule : scheduleList) {
            if (schedule.getCRN() == CRN) {
                return schedule;
            }
        }
        return null;
    }

    /***
     * Get the student name
     * 
     * @param studentID the student ID
     * @return the student name
     */
    public static String getStudentName(String studentID) {
        String name = null;
        ArrayList<Students> studentList = DataReader.readStudents();
        for (Students student : studentList) {
            if (student.getStudentID().equals(studentID)) {
                name = student.getFirstName() + " " + student.getLastName();
                break;
            }
        }
        return name;
    }

    /***
     * Check if a student exists
     * @param studentID the student ID
     * @return true if the student exists, false otherwise
     */
    public static boolean studentExists(String studentID) {
        ArrayList<Students> studentList = DataReader.readStudents();
        for (Students student : studentList) {
            if (student.getStudentID().equals(studentID)) {
                return true;
            }
        }
        return false;
    }

    public static String getName(String email) {
        if(email.endsWith("@my.mdc.edu")) {
            ArrayList<Students> studentList = DataReader.readStudents();
            for (Students student : studentList) {
                if (student.getEmail().equals(email)) {
                    return student.getFirstName() + " " + student.getLastName();
                }
            }
        }
        else if(email.endsWith("@mdc.edu")) {
            ArrayList<Faculty> facultyList = DataReader.readFaculty();
            for (Faculty faculty : facultyList) {
                if (faculty.getEmail().equals(email)) {
                    return faculty.getFirstName() + " " + faculty.getLastName();
                }
            }
        }
        return null;
    }


    /**
     * Check if a course exists
     * @param CRN the course registration number
     * @return true if the course exists, false otherwise
     */
    public static boolean courseExists(long CRN) {
        ArrayList<Schedule> scheduleList = DataReader.readSchedule();
        for (Schedule schedule : scheduleList) {
            if (schedule.getCRN() == CRN) {
                return true;
            }
        }
        return false;
    }

    /***
     * Get the faculty name
     * 
     * @param facultyID the faculty ID
     * @return the faculty name
     */
    public static String getFacultyName(String facultyID) {
        String name = null;
        ArrayList<Faculty> facultyList = DataReader.readFaculty();
        for (Faculty faculty : facultyList) {
            if (faculty.getFacultyID().equals(facultyID)) {
                name = faculty.getFirstName() + " " + faculty.getLastName();
                break;
            }
        }
        return name;
    }

    /**
     * Check if a student exists
     * 
     * @param ID the student ID
     * @return true if the student exists, false otherwise
     */
    public static boolean isStudent(String ID) {
        ArrayList<Students> studentList = DataReader.readStudents();
        for (Students student : studentList) {
            if (student.getStudentID().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    /***
     * Check if a faculty exists
     * 
     * @param ID the faculty ID
     * @return true if the faculty exists, false otherwise
     */
    public static boolean isFaculty(String ID) {
        ArrayList<Faculty> facultyList = DataReader.readFaculty();
        for (Faculty faculty : facultyList) {
            if (faculty.getFacultyID().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    /***
     * Get the course name
     * 
     * @param CRN the course registration number
     * @return the course name
     */
    public static String getCourseName(long CRN) {
        ArrayList<Schedule> scheduleList = DataReader.readSchedule();
        String className = null;
        for (Schedule oneClass : scheduleList) {
            if (oneClass.getCRN() == CRN) {
                className = oneClass.getCourseName();
                break;
            }
        }
        return className;
    }

    /***
     * Get the major name
     * 
     * @param majorID the major ID
     * @return the major name
     */
    public static String getMajorName(String majorID) {
        String majorName = null;
        ArrayList<Major> majorList = DataReader.readMajor();
        for (Major major : majorList) {
            if (major.getMajorID() == Integer.parseInt(majorID)) {
                majorName = major.getMajorName();
                break;
            }
        }
        return majorName;
    }

    /***
     * Get the department name
     * 
     * @param departmentID the department ID
     * @return the department name
     */
    public static String getDepartmentName(int departmentID) {
        ArrayList<Department> departments = DataReader.readDepartment();
        String departmentName = null;
        for (Department department : departments) {
            if (department.getDepartmentID() == departmentID) {
                departmentName = department.getDepartmentName();
                break;
            }
        }
        return departmentName;
    }

    /***
     * Get the faculty courses
     * 
     * @param FacultyID the faculty ID
     * @return an array list of faculty courses
     */
    public static ArrayList<FacultyCourses> getFacultyCourses(String FacultyID) {
        ArrayList<Schedule> schedule = DataReader.readSchedule();

        for (int index = schedule.size() - 1; index >= 0; index--) {
            if (!schedule.get(index).getFacultyID().equals(FacultyID)) {
                schedule.remove(index);
            }
        }

        ArrayList<Long> crnList = new ArrayList<>();

        for (Schedule oneClass : schedule) {
            crnList.add(oneClass.getCRN());
        }

        ArrayList<CourseRoster> courseRoster = DataReader.readCourseRoster();
        for (int index = courseRoster.size() - 1; index >= 0; index--) {
            if (!crnList.contains(courseRoster.get(index).getCRN())) {
                courseRoster.remove(index);
            }
        }

        Faculty faculty = getFaculty(FacultyID);
        ArrayList<FacultyCourses> facultyCourses = new ArrayList<>();
        for (Schedule oneSchedule : schedule) {
            for (CourseRoster oneCourseRoster : courseRoster) {
                if (oneCourseRoster.getCRN() == oneSchedule.getCRN()) {
                    FacultyCourses facultyCourse = new FacultyCourses();
                    facultyCourse.setSchedule(oneSchedule);
                    facultyCourse.setCourseRoster(oneCourseRoster);
                    facultyCourse.setFaculty(faculty);
                    facultyCourses.add(facultyCourse);
                    break;
                }
            }
        }
        return facultyCourses;
    }

    /***
     * Get the faculty
     * 
     * @param ID the faculty ID
     * @return the faculty
     */
    public static Faculty getFaculty(String ID) {
        ArrayList<Faculty> facultyList = DataReader.readFaculty();
        for (Faculty faculty : facultyList) {
            if (faculty.getFacultyID().equals(ID)) {
                return faculty;
            }
        }
        return null;
    }

    /***
     * Get the major ID
     * 
     * @param majorName the major name
     * @return the major ID
     */
    public static int majorNameToID(String majorName) {
        ArrayList<Major> majorList = DataReader.readMajor();
        for (Major major : majorList) {
            if (major.getMajorName().equals(majorName)) {
                return major.getMajorID();
            }
        }
        return -1;
    }

    public static boolean validateCredentials(String email, String password) {
        ArrayList<Credentials> credentials = DataReader.readCredentials();
        for (Credentials c : credentials) {
            if (c.getEmail().equals(email) && c.getPassword().equals(password)) {
                return false;  // return false when a match is found
            }
        }
        if(email != null && password != null && (email.endsWith("@my.mdc.edu") || email.endsWith("@mdc.edu")) && password.length() >= 8) {
            return true;  // return true when the email and password meet your validity conditions
        }
        return false;  // return false otherwise
    }

    public static boolean isCourse(String CRN) {
        ArrayList<CourseRoster> roster = DataReader.readCourseRoster();
        for(CourseRoster oneRecord: roster) {
            if(oneRecord.getCRN() == Long.parseLong(CRN)) {
                return true;
            }
        }
        return false;
    }
 }