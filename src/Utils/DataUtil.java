package Utils;

import java.util.ArrayList;
import Models.CourseRoster;
import Models.Faculty;
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
     * Get the student name
     * @param studentID the student ID
     * @return the student name
     */
    public static String getStudentName(String studentID) {
        String name = null;
        ArrayList<Students> studentList = DataReader.readStudents();
        for(Students student: studentList) {
            if(student.getStudentID().equals(studentID)) {
                name = student.getFirstName() + " " + student.getLastName();
                break;
            }
        }
        return name;
    }

    /***
     * Get the faculty name
     * @param facultyID the faculty ID
     * @return the faculty name
     */
    public static String getFacultyName(String facultyID) {
        String name = null;
        ArrayList<Faculty> facultyList = DataReader.readFaculty();
        for(Faculty faculty: facultyList) {
            if(faculty.getFacultyID().equals(facultyID)) {
                name = faculty.getFirstName() + " " + faculty.getLastName();
                break;
            }
        }
        return name;
    }

    /***
     * Get the course name
     * @param CRN the course registration number
     * @return the course name
     */
    public static String getCourseName(String CRN) {
        ArrayList<Schedule> scheduleList = DataReader.readSchedule();
        String className = null;
        for(Schedule oneClass: scheduleList) {
            if(oneClass.getCRN() == Long.parseLong(CRN)) {
                className = oneClass.getCourseName();
                break;
            }
        }
        return className;
    } 

    /***
     * Get the course name
     * @param CRN the course registration number
     * @return the course name
     */
    public static String getCourseName(long CRN) {
        ArrayList<Schedule> scheduleList = DataReader.readSchedule();
        String className = null;
        for(Schedule oneClass: scheduleList) {
            if(oneClass.getCRN() == CRN) {
                className = oneClass.getCourseName();
                break;
            }
        }
        return className;
    } 

}