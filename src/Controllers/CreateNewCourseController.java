package Controllers;

import java.util.ArrayList;

import Models.Faculty;
import Models.Schedule;
import Utils.DataReader;
import Utils.DataWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CreateNewCourseController {

    @FXML
    private Button CreateButton;

    @FXML
    private TextField tfCapacity;

    @FXML
    private TextField tfCourseID;

    @FXML
    private TextField tfCreditHours;

    @FXML
    private TextField tfCRN;

    @FXML
    private ComboBox<String> cbFaculty;

    @FXML
    private TextField tfRoom;

    @FXML
    private TextField tfTerm;

    @FXML
    private TextField tfTitle;

    /***
     * Initialize the controller
     */
    @FXML
    public void initialize() {
        ArrayList<Faculty> faculties = DataReader.readFaculty();
        for (Faculty faculty : faculties) {
            cbFaculty.getItems().add(faculty.getFirstName() + " " + faculty.getLastName() + ": " + faculty.getFacultyID());
        } }

    /***
     * The ActionEvent for creating a new course
     * 
     * @param event the event
     */
    @FXML
    void CreateCourse(ActionEvent event) {
        if (validateCourse()) {
            CreateButton.setDisable(true);
            String courseId = tfCourseID.getText();
            String title = tfTitle.getText();
            String term = tfTerm.getText();
            long CRN = Long.parseLong(tfCRN.getText());
            String faculty = cbFaculty.getValue();
            String room = tfRoom.getText();
            int capacity = Integer.parseInt(tfCapacity.getText());
            int creditHours = Integer.parseInt(tfCreditHours.getText());

            boolean writeSuccess = DataWriter.writeNewCourse(courseId, CRN, title, term, faculty, room, capacity,
                    creditHours);
            if (writeSuccess) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Course Created");
                alert.setContentText("The course was successfully created.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Failed to Create Course");
                alert.setContentText("There was an error creating the course. Please try again.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid course");
            alert.setContentText("The course is invalid. Please check the course ID and faculty ID.");
            alert.showAndWait();
        }
        CreateButton.setDisable(false);
    }

    /***
     * Validate the course
     * 
     * @return true if the course is valid, false otherwise
     */
    public boolean validateCourse() {
        ArrayList<Schedule> courses = DataReader.readSchedule();
        ArrayList<Faculty> faculties = DataReader.readFaculty();

        String courseId = tfCourseID.getText();
        for (Schedule course : courses) {
            if (course.getCourseID().equals(courseId)) {
                return false;
            }
        }

        String facultyId = cbFaculty.getValue().split(": ")[1];
        boolean facultyExists = faculties.stream().anyMatch(faculty -> faculty.getFacultyID().equals(facultyId));
        if (!facultyExists) {
            return false;
        }

        // Check that the CRN is exactly 5 digits long
        String crn = tfCRN.getText();
        if (!crn.matches("^\\d{5}$")) {
            return false;
        }

        return true;
    }
}
