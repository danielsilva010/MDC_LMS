package Controllers;

import java.util.ArrayList;
import java.util.Random;

import Models.Department;
import Models.Faculty;
import Utils.DataReader;
import Utils.DataWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CreateFacultyController {

    @FXML
    private Button createButton;

    @FXML
    private TextField tfCity;

    @FXML
    private ComboBox<String> cbDepartmentID;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfFacultyID;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfHireDate;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfPhoneNumber;

    @FXML
    private TextField tfSalary;

    @FXML
    private TextField tfState;

    @FXML
    private TextField tfStreet;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfZipCode;

    /***
     * Initialize the form
     */
    @FXML
    public void initialize() {
        ArrayList<Department> departments = DataReader.readDepartment();
        for (Department department : departments) {
            cbDepartmentID.getItems()
                    .add(String.valueOf(department.getDepartmentID()) + " - " + department.getDepartmentName());
        }
    }

    /***
     * Create a new faculty member
     * @param event the button click event
     */
    @FXML
    void create(ActionEvent event) {

        if (!validate()) {
            return;
        }

        String facultyId = tfFacultyID.getText();
        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        String email = tfEmail.getText();
        String phoneNumber = tfPhoneNumber.getText();
        String hireDate = tfHireDate.getText();
        String salary = tfSalary.getText();
        String title = tfTitle.getText();
        String street = tfStreet.getText();
        String city = tfCity.getText();
        String state = tfState.getText();
        String zipCode = tfZipCode.getText();
        String departmentId = cbDepartmentID.getValue().split(" - ")[0].trim();

        if (DataWriter.writeFaculty(facultyId, firstName, lastName, email, phoneNumber, hireDate, salary, title, street,
                city, state, zipCode, departmentId)) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Faculty created successfully");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error creating faculty");
            alert.showAndWait();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Success");
        alert.setContentText("Faculty created successfully");
        alert.showAndWait();
    }

    /***
     * Validate the form
     * @return true if the form is valid, false otherwise
     */
    public boolean validate() {
        if (tfCity.getText().isEmpty() || cbDepartmentID.getSelectionModel().isEmpty() || tfEmail.getText().isEmpty()
                || tfFacultyID.getText().isEmpty() || tfFirstName.getText().isEmpty() || tfHireDate.getText().isEmpty()
                || tfLastName.getText().isEmpty() || tfPhoneNumber.getText().isEmpty() || tfSalary.getText().isEmpty()
                || tfState.getText().isEmpty() || tfStreet.getText().isEmpty() || tfTitle.getText().isEmpty()
                || tfZipCode.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Error");
            alert.setContentText("Please fill out all fields");
            alert.showAndWait();
            return false;
        }

        String facultyId = tfFacultyID.getText();
        if (!facultyId.startsWith("Z") || facultyId.length() != 9) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Error");
            alert.setContentText("Faculty ID must start with 'Z' and be 9 characters long");
            alert.showAndWait();
            return false;
        }

        if (!isUnique(facultyId)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Error");
            alert.setContentText("Faculty ID must be unique");
            alert.showAndWait();
            return false;
        }

        return true;
    }

    /***
     * Generate a random faculty ID
     * @param event the button click event
     */
    @FXML
    void generate(ActionEvent event) {
        Random rand = new Random();
        int number = rand.nextInt(88888889) + 11111111;
        tfFacultyID.setText("Z" + number);
    }

    /***
     * Check if the faculty ID is unique
     * @param facultyID the faculty ID
     * @return true if the faculty ID is unique, false otherwise
     */
    public boolean isUnique(String facultyID) {
        ArrayList<Faculty> facultyIDs = DataReader.readFaculty();
        for (Faculty faculty : facultyIDs) {
            if (faculty.getFacultyID().equals(facultyID)) {
                return false;
            }
        }
        return true;
    }

}
