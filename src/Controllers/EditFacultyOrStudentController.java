package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class EditFacultyOrStudentController {

    private ToggleGroup tgFacultyOrStudent;
    @FXML
    private RadioButton rbFaculty;

    @FXML
    private RadioButton rbStudent;

    @FXML
    private TextField tfID;

    @FXML
    public void initialize() {
        tgFacultyOrStudent = new ToggleGroup();
        rbFaculty.setToggleGroup(tgFacultyOrStudent);
        rbStudent.setToggleGroup(tgFacultyOrStudent);
    }

    @FXML
    void search(ActionEvent event) {

    }

}
