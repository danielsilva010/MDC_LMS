package Controllers;

import Main.Main;
import Models.CourseRoster;
import Models.Students;
import Utils.DataReader;
import Utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.control.ListView;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CourseListController implements SceneManager{
    private Main main;

    @FXML
    private ListView<CourseRoster> ListView;

    @FXML
    private Button SearchButton;

    @FXML
    private Text textStudentName;

    @FXML
    private TextField tfStudentID;

    @FXML
    void Clear(MouseEvent event) {
        if(tfStudentID.getText().equals("Enter Student ID here...")) {
            tfStudentID.clear();
        }
    }

    @FXML
    void Search(ActionEvent event) throws FileNotFoundException {
        DataReader dataReader = new DataReader();
        ArrayList<Students> students = new ArrayList<>();
        dataReader.readStudents(students, "/Users/danielsilva/Desktop/code/java/MDC-LMS-GUI/MDC_LMS/src/Data/Students.txt");
        for(Students student : students) {
            if(student.getStudentID().equals(tfStudentID.getText())) {
                textStudentName.setText(student.getFirstName() + " " + student.getLastName());
            }
        }
        ArrayList<CourseRoster> courseRosters = new ArrayList<>();
        dataReader.readCourseRoster(courseRosters, "/Users/danielsilva/Desktop/code/java/MDC-LMS-GUI/MDC_LMS/src/Data/CourseRoster.txt");
        String id = tfStudentID.getText();
        ArrayList<CourseRoster> courses = new ArrayList<>();
        for (CourseRoster courseRoster : courseRosters) {
            if(courseRoster.getStudentID().equals(id)) {
                courses.add(courseRoster);
            }
        }
        ListView.getItems().addAll(courses);

    }

    public void setMain(Main main) {
        this.main = main;
    }
}
