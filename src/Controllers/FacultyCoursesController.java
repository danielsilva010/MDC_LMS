package Controllers;

import java.util.ArrayList;

import Models.Faculty;
import Models.FacultyCourses;
import Utils.DataUtil;
import Utils.DataWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class FacultyCoursesController {

    @FXML
    private Text textFacultyCourses;

    @FXML
    private Text textInstructorName;

    @FXML
    private TableColumn<FacultyCourses, Long> CRNColumn;

    @FXML
    private TableColumn<FacultyCourses, String> CourseIDColumn;

    @FXML
    private TableColumn<FacultyCourses, String> TermColumn;

    @FXML
    private TableColumn<FacultyCourses, String> courseNameColumn;

    @FXML
    private TableView<FacultyCourses> tableView;

    @FXML
    private TextField tfFacultyID;

    @FXML
    private Button searchButton;

    @FXML
    void ClearIfDefaultText(MouseEvent event) {
        if (tfFacultyID.getText().equals("Faculty ID:")) {
            tfFacultyID.clear();
        }
    }

    @FXML
    void search(ActionEvent event) {
        Faculty instructor = DataUtil.getFaculty(tfFacultyID.getText());
        if(instructor != null) {
            textFacultyCourses.setText("Faculty Courses for: ");
            textInstructorName.setText(instructor.getFirstName() + " " + instructor.getLastName());
        }
        ArrayList<FacultyCourses> courses = DataUtil.getFacultyCourses(tfFacultyID.getText());
        CRNColumn.setCellValueFactory(new PropertyValueFactory<>("CRN"));
        CourseIDColumn.setCellValueFactory(new PropertyValueFactory<>("CourseID"));
        TermColumn.setCellValueFactory(new PropertyValueFactory<>("Term"));
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        tableView.getItems().setAll(courses);
        DataWriter.writeFacultyCourses(tfFacultyID.getText());
    }

}
