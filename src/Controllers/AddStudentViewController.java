package Controllers;

import java.util.ArrayList;

import Models.Major;
import Models.Students;
import Utils.DataReader;
import Utils.DataWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddStudentViewController {

    private static final int ID_LENGTH = 9;

    @FXML
    private TextField tfAddress;

    @FXML
    private TextField tfCity;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfExpectedGrad;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfLastName;

    @FXML
    private ComboBox<String> cbMajorID;

    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfState;

    @FXML
    private Button submitButton;

    @FXML
    private TextField tfStuID;

    @FXML
    private TextField tfZipCode;

    @FXML
    public void initialize() {
        ArrayList<Major> majors = DataReader.readMajor();
        for (Major major : majors) {
            cbMajorID.getItems().add(major.getMajorID()+ ": "+ major.getMajorName());
        }
    }

    /***
     * Submit the student information to the "database"
     * 
     * @param event the button click
     */
    @FXML
    void Submit(ActionEvent event) {
        submitButton.setDisable(true);
        if(isValid()) {
            String studentID = tfStuID.getText();
            String email = tfEmail.getText();
            String firstName = tfFirstName.getText();
            String lastName = tfLastName.getText();
            String address = tfAddress.getText();
            String city = tfCity.getText();
            String state = tfState.getText();
            String zipCode = tfZipCode.getText();
            String phone = tfPhone.getText();
            String expectedGrad = tfExpectedGrad.getText();
            String majorID = cbMajorID.getValue().split(":")[0].trim();

            if(DataWriter.writeNewStudent(studentID, firstName, lastName, address, city, state, zipCode, phone, email, Integer.parseInt(majorID), expectedGrad)) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Student added");
            alert.setContentText("Student " + studentID + " has been added");
            alert.showAndWait();
            }
            else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error adding student");
                alert.setContentText("An error occurred while adding student " + studentID);
                alert.showAndWait();
            }
        }

        submitButton.setDisable(false);
    }

    /***
     * Check if the student ID is unique
     * 
     * @param id the student ID
     * @return true if the student ID is unique, false otherwise
     */
    private boolean isUnique(String id) {
        ArrayList<Students> students = DataReader.readStudents();
        for (Students student : students) {
            if (student.getStudentID().equals(id)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid() {
        boolean isValid = false;

        String studentID = tfStuID.getText();
        String email = tfEmail.getText();
        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        String address = tfAddress.getText();
        String city = tfCity.getText();
        String state = tfState.getText();
        String zipCode = tfZipCode.getText();
        String phone = tfPhone.getText();
        String expectedGrad = tfExpectedGrad.getText();

        if (isUnique(studentID) && !studentID.isEmpty() && studentID.length() == ID_LENGTH && studentID.startsWith("Z") && validFormatID(studentID)) {
            if (email.contains("@my.mdc.edu") && !email.isEmpty()) {
                if (!firstName.isEmpty() && !lastName.isEmpty() && !address.isEmpty() && !city.isEmpty() && 
                    !state.isEmpty() && !zipCode.isEmpty() && !phone.isEmpty() && !expectedGrad.isEmpty()) {
                    isValid = true;
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Empty fields");
                    alert.setContentText("Please fill out all fields");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid email");
                alert.setContentText("Please enter a valid MDC email");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid student ID");
            alert.setContentText("Please enter a valid student ID");
            alert.showAndWait();
        }

        return isValid;
    }

    /***
     * Check if the student ID has the correct format
     * 
     * @param id the student ID
     * @return true if the student ID has the correct format, false otherwise
     */
    private boolean validFormatID(String id) {
        if (id.charAt(0) == 'Z') {
            for (int i = 1; i < id.length(); i++) {
                if(Character.isDigit(id.charAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

   

}
