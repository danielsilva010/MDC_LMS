package Utils;

import java.util.ArrayList;
import Models.CourseRoster;
import Models.Schedule;
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

}