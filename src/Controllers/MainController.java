package Controllers;
import java.io.IOException;
import Main.Main;
import Utils.SceneManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainController implements SceneManager{

    private Main main;

    private Stage stage = new Stage();

    @FXML
    private Button AddStudentToCourseButton;

    @FXML
    private VBox VBOX;

    @FXML
    private Button createNewCourseButton;

    @FXML
    private Button ExitButton;

    @FXML
    private Button createNewStudentButton;

    @FXML
    private Button printCourseListForStudentButton;

    @FXML
    private Button viewCourseScheduleButton;

    @FXML
    private Button viewStudentInformationButton;

    @FXML
    public void initialize() {
        VBOX.setAlignment(Pos.CENTER);
        main = new Main();
    }

    @FXML
    void ExitButton(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void AddStudentToCourse(ActionEvent event) throws IOException{
        main.loadAddStudentToCourseView();
    }

    @FXML
    void createNewCourse(ActionEvent event) throws IOException {
        main.loadcreateCourseView();
    }

    @FXML
    void createNewStudent(ActionEvent event) throws IOException {
        main.loadAddStudentView();
    }

    @FXML
    void printCourseListForStudent(ActionEvent event) throws IOException {
        main.loadCourseListView();
    }

    @FXML
    void viewCourseSchedule(ActionEvent event) throws IOException {
        main.loadCourseScheduleView();
    }

    @FXML
    void viewStudentInformation(ActionEvent event) throws IOException {
        main.loadStudentSearchView();
    }

    @Override
    public void setMain(Main main) {
        this.main = main;
    }


}

