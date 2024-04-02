package Utils;

import java.util.ArrayList;
import java.util.HashMap;

import Models.CourseRoster;
import Models.Faculty;
import Models.Schedule;
import Models.StudentCourses;
import Models.Students;

public class DataUtil {
    /***
     * Get the courses for a student
     * @param studentID the student ID
     * @return an array list of schedules
     */
    public static ArrayList<Schedule> getStudentCourses(String studentID) {
        ArrayList<CourseRoster> courseRoster = new ArrayList<>();
        DataReader.readCourseRoster(courseRoster);
        for (int index = courseRoster.size() - 1; index >= 0; index--) {
            if (!courseRoster.get(index).getStudentID().equals(studentID)) {
                courseRoster.remove(index);
            }
        }
        ArrayList<Schedule> scheduleList = new ArrayList<>();
        DataReader.readSchedule(scheduleList);
        ArrayList<Schedule> classes = new ArrayList<>();
        for (int i = 0; i < scheduleList.size(); i++) {
            for (int j = 0; j < courseRoster.size(); j++) {
                if (courseRoster.get(j).getCRN() == scheduleList.get(i).getCRN()) {
                    classes.add(scheduleList.get(i));
                }
            }
        }
        return classes;

    }

    /***
     * Get the courses for a student
     * @param studentID the student ID
     * @return an array list of student courses
     */
    public static ArrayList<StudentCourses> getCourses(String studentID) {
        ArrayList<CourseRoster> courseRoster = new ArrayList<>();
        DataReader.readCourseRoster(courseRoster);
        ArrayList<Faculty> facultyList = new ArrayList<>();
        DataReader.readFaculty(facultyList);
        ArrayList<Schedule> scheduleList = new ArrayList<>();
        DataReader.readSchedule(scheduleList);

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
     * Map the classes to the course roster
     * @return a hash map of course roster and schedule
     */
    public static HashMap<CourseRoster, Schedule> mapClasses() {
        ArrayList<CourseRoster> courseRoster = new ArrayList<>();
        DataReader.readCourseRoster(courseRoster);
        ArrayList<Schedule> scheduleList = new ArrayList<>();
        DataReader.readSchedule(scheduleList);
        HashMap<CourseRoster, Schedule> map = new HashMap<>();
        for (int i = 0; i < scheduleList.size(); i++) {
            for (int j = 0; j < courseRoster.size(); j++) {
                if (courseRoster.get(j).getCRN() == scheduleList.get(i).getCRN()) {
                    map.put(courseRoster.get(j), scheduleList.get(i));
                }
            }
        }
        return map;
    }

    /***
     * Get the student name
     * @param studentID the student ID
     * @return the student name
     */

    public static String getStudentName(String studentID) {
        String name = null;
        ArrayList<Students> studentList = new ArrayList<>();
        DataReader.readStudents(studentList);
        for(Students student: studentList) {
            if(student.getStudentID().equals(studentID)) {
                name = student.getFirstName() + " " + student.getLastName();
                break;
            }
        }
        return name;
    }

    public static String getFacultyName(String facultyID) {
        String name = null;
        ArrayList<Faculty> facultyList = new ArrayList<>();
        DataReader.readFaculty(facultyList);
        for(Faculty faculty: facultyList) {
            if(faculty.getFacultyID().equals(facultyID)) {
                name = faculty.getFirstName() + " " + faculty.getLastName();
                break;
            }
        }
        return name;
    }

}