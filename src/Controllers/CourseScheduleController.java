package Controllers;

import java.util.ArrayList;
import Models.Schedule;
import Utils.DataReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CourseScheduleController {


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

    /***
     * Initialize the course schedule controller
     */
    public void initialize() {
            ArrayList<Schedule> scheduleList = DataReader.readSchedule();
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

   
}
