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
    public static void writeStudentCourses(String studentID) {
        ArrayList<StudentCourses> courses = DataUtil.getCourses(studentID);
        File file = new File("src/Data/Courses-" + studentID);
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
        } catch (IOException e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("Error writing to file");
            error.setContentText(
                    "The file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");
            error.showAndWait();
        }
    }

    public static void writeFacultyCourses(String facultyID) {
        ArrayList<FacultyCourses> courses = DataUtil.getFacultyCourses(facultyID);

        File file = new File("src/Data/FacultyCourses-" + facultyID);

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
        } catch (IOException e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("Error writing to file");
            error.setContentText(
                    "The file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");
            error.showAndWait();
        }
    }

}
