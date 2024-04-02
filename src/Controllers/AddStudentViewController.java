package Controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Models.Major;
import Models.Students;
import Utils.DataReader;
import Utils.DataUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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
        // Disable the submit button
        submitButton.setDisable(true);

        try (FileWriter fw = new FileWriter(new File("src/Data/Students.txt"), true)) {
            PrintWriter pw = new PrintWriter(fw);
            if (isValid()) {
                pw.print("\n" + tfStuID.getText() + ":" + tfFirstName.getText() + ":" + tfLastName.getText() +
                        ":" + tfAddress.getText() + ":" + tfCity.getText() + ":" + tfState.getText() + ":" +
                        tfZipCode.getText() + ":" + tfPhone.getText() + ":" + tfEmail.getText() + ":"
                        + (cbMajorID.getSelectionModel().getSelectedIndex() + 1) + ":" + tfExpectedGrad.getText());
            }
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error writing to file");
            alert.setContentText(
                    "The file exists but is a directory rather than a regular file, does not exist but cannot be created, or cannot be opened for any other reason");
            alert.showAndWait();
        }

        // Re-enable the submit button
        submitButton.setDisable(false);
    }

    public boolean isUnique(String id) {
        ArrayList<Students> students = DataReader.readStudents();
        for (Students student : students) {
            if (student.getStudentID().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid() {
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

    public boolean validFormatID(String id) {
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
