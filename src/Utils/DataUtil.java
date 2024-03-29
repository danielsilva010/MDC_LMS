package Utils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Models.*;

public class DataUtil {
    
    public static void addStudentToCourse(String studentID, long crn) throws IOException {
        ArrayList<Students> studentList = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        boolean studentExists = false;
        DataReader dataReader = new DataReader();


        dataReader.readStudents(studentList, "/Users/danielsilva/Desktop/code/java/MDC-LMS-GUI/MDC_LMS/src/Data/Students.txt");

        for(Students oneStudent: studentList) {
            if(oneStudent.getStudentID().equals(studentID)) {
                studentExists = true;
            }
        }

        if(studentExists) {
            FileWriter fw = new FileWriter(new File("/Users/danielsilva/Desktop/code/java/MDC-LMS-GUI/MDC_LMS/src/Data/CourseRoster.txt"), true);
            PrintWriter pw = new PrintWriter(fw);
            
        }

    }
}
