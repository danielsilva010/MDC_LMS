package Controllers;

import Main.Main;
import Utils.SceneManager;
import javafx.event.ActionEvent;

public class SelectEditController implements SceneManager {


    private Main main;

    @FXML
    void loadEditFaculty(ActionEvent event) {

    }

    @FXML
    void loadEditStudent(ActionEvent event) {
        main.loadEditStudentView();
    }

    public void setMain(Main main) {
        this.main = main;
    }

}
