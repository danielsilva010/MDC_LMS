package Controllers;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.util.ArrayList;

import Models.Major;
import Models.Students;
import Utils.DataReader;

public class StudentSearchController{

    private Students student = new Students();
    private ArrayList<Students> students = new ArrayList<>();

    @FXML
    private Button SearchButton;

    @FXML
    private Text tfAddress;

    @FXML
    private Text tfEmail;

    @FXML
    private Text tfExpectedGraduation;

    @FXML
    private Text tfMajor;

    @FXML
    private Text tfName;

    @FXML
    private Text tfPhone;

    @FXML
    private TextField tfStudentID;

    @FXML
    private Button searchButton;

    @FXML
    private Text tfIDField;

    /***
     * Search for a student by ID when the user clicks the search button
     */
    @FXML
    void search(ActionEvent event) {
        DataReader.readStudents(students);
        String id = tfStudentID.getText();
        for (Students student : students) {
            if(student.getStudentID().equals(id)) {
                this.student = new Students(student);
                break;
            }
        }
        String majorName = "";
        ArrayList<Major> majorList = new ArrayList<>();
        DataReader.readMajor(majorList);
        for(Major oneMajor: majorList) {
            if(oneMajor.getMajorID() == student.getMajorID()) {
                majorName = oneMajor.getMajorName();
                break;
            }
        }
        StringProperty name = new SimpleStringProperty(student.getFirstName() + " " + student.getLastName());
        StringProperty address = new SimpleStringProperty(student.getStreet() + ", "  + student.getCity() + ", " + student.getState() + ", " + student.getZipCode());
        StringProperty phoneNumber = new SimpleStringProperty(student.getPhone());
        StringProperty email = new SimpleStringProperty(student.getEmail());
        StringProperty expectedGrad = new SimpleStringProperty(student.getExpectedGraduationDate());
        StringProperty major = new SimpleStringProperty(majorName);
        tfName.textProperty().bind(name);
        tfAddress.textProperty().bind(address);
        tfPhone.textProperty().bind(phoneNumber);
        tfEmail.textProperty().bind(email);
        tfExpectedGraduation.textProperty().bind(expectedGrad);
        tfMajor.textProperty().bind(major);
    }

    /***
     * Clear the text field if the default text is present
     * @param event the mouse event
     */
    @FXML
    void ClearIfDefaultText(MouseEvent event) {
        if(tfStudentID.getText().equals("Enter Student ID Here")) {
            tfStudentID.clear();
        }
    }


}

