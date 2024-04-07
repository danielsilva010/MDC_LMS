package Controllers;

import Main.Main;
import Utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SelectEditController implements SceneManager {


    private Main main;

    @FXML
    void initialize() {
        main = new Main();
    }

    @FXML
    void loadEditFaculty(ActionEvent event) {
        main.loadEditFacultyView();
    }

    @FXML
    void loadEditStudent(ActionEvent event) {
        main.loadEditStudentView();
    }

    public void setMain(Main main) {
        this.main = main;
    }

}
