package Controllers;

import Main.Main;
import Utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateNewCourseController implements SceneManager{

    private Main main;

    @FXML
    private Button CreateButton;

    @FXML
    private TextField tfCapacity;

    @FXML
    private TextField tfCourseID;

    @FXML
    private TextField tfCreditHours;

    @FXML
    private TextField tfFaculty;

    @FXML
    private TextField tfRoom;

    @FXML
    private TextField tfTerm;

    @FXML
    private TextField tfTitle;

    @Override
    public void setMain(Main main) {
        this.main = main;
    }

     @FXML
    void CreateCourse(ActionEvent event) {

    }
}
