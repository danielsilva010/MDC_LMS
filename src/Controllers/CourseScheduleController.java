package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import Main.Main;
import Models.Schedule;
import Utils.DataReader;
import Utils.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;

public class CourseScheduleController implements SceneManager{

    private Main main;

    @FXML
    private TableView<Schedule> tableView;

    @FXML
    private TableColumn<Schedule, Long> CRN;

    @FXML
    private TableColumn<Schedule, Integer> Capacity;

    @FXML
    private TableColumn<Schedule, Integer> CreditHours;

    @FXML
    private TableColumn<Schedule, String> FacultyID;

    @FXML
    private TableColumn<Schedule, String> Room;

    @FXML
    private TableColumn<Schedule, String> Term;

    @FXML
    private TableColumn<Schedule, String> Title;

    @FXML
    private TableColumn<Schedule, String> courseID;

    public void initialize() {
        try {
            DataReader dR = new DataReader();
            ArrayList<Schedule> scheduleList = new ArrayList<>();
            dR.readSchedule(scheduleList, "/Users/danielsilva/Desktop/code/java/MDC-LMS-GUI/MDC_LMS/src/Data/Schedule.txt");
            ObservableList<Schedule> scheduleObvList = FXCollections.observableArrayList(scheduleList);
            tableView.setItems(scheduleObvList);

            CRN.setCellValueFactory(new PropertyValueFactory<>("CRN"));
            Capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
            CreditHours.setCellValueFactory(new PropertyValueFactory<>("CreditHours"));
            FacultyID.setCellValueFactory(new PropertyValueFactory<>("FacultyID"));
            Room.setCellValueFactory(new PropertyValueFactory<>("Room"));
            Term.setCellValueFactory(new PropertyValueFactory<>("Term"));
            Title.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
            courseID.setCellValueFactory(new PropertyValueFactory<>("CourseID"));
            
            
        }
        catch(IOException e) {
            Alert fnfAlert = new Alert(AlertType.ERROR);
            fnfAlert.setContentText("File not found");
            fnfAlert.showAndWait();
        }
    }

    @Override
    public void setMain(Main main) {
        this.main = main;
    }
}
