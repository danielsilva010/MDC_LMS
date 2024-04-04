package Controllers;

import java.util.ArrayList;

import Models.Major;
import Models.Students;
import Utils.DataReader;
import Utils.DataUtil;
import Utils.DataWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EditStudentController {

    @FXML
    private ComboBox<String> cbMajor;

    @FXML
    private TextArea taStreet;

    @FXML
    private TextField tfCity;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfExpectGrad;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfState;

    @FXML
    private TextField tfStudentID;

    @FXML
    private TextField tfZipCode;

    @FXML
    void search(ActionEvent event) {
        if (DataUtil.studentExists(tfID.getText())) {
            Students student = DataUtil.getStudent(tfID.getText());
            setStudent(student);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Student not found");
            alert.setContentText("The student with ID " + tfID.getText() + " was not found.");
        }
    }

    @FXML
    void delete(ActionEvent event) {
        if(!tfStudentID.getText().isEmpty() && !tfFirstName.getText().isEmpty() && !tfLastName.getText().isEmpty() && !taStreet.getText().isEmpty() && !tfCity.getText().isEmpty() && !tfState.getText().isEmpty() && !tfZipCode.getText().isEmpty() && !tfPhone.getText().isEmpty() && !tfEmail.getText().isEmpty() && !tfExpectGrad.getText().isEmpty() && tfStudentID.getText().startsWith("Z") && tfStudentID.getText().length() == 9 && tfEmail.getText().endsWith("@my.mdc.edu")){
            for(int i = 1; i < tfStudentID.getText().length(); i++){
                if(!Character.isDigit(tfStudentID.getText().charAt(i))){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid Input");
                    alert.setContentText("Please make sure all fields are filled and the student ID starts with Z and is 8 digits long and the email ends with @my.mdc.edu");
                    alert.showAndWait();
                    return;
                }
            }
            if(DataWriter.writeStudentExceptThis(tfStudentID.getText(), tfFirstName.getText(), tfLastName.getText(), taStreet.getText(), tfCity.getText(), tfState.getText(), Integer.parseInt(tfZipCode.getText()), tfPhone.getText(), tfEmail.getText(), Integer.parseInt(cbMajor.getValue().split(" - ")[0]), tfExpectGrad.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Student Deleted");
                alert.setContentText("The student with ID " + tfStudentID.getText() + " was deleted.");
                alert.showAndWait();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Student not found");
                alert.setContentText("The student with ID " + tfStudentID.getText() + " was not found.");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please make sure all fields are filled and the student ID starts with Z and is 8 digits long and the email ends with @my.mdc.edu");
            alert.showAndWait();
        }
    }

    @FXML
    void modify(ActionEvent event) {
        if(!tfStudentID.getText().isEmpty() && !tfFirstName.getText().isEmpty() && !tfLastName.getText().isEmpty() && !taStreet.getText().isEmpty() && !tfCity.getText().isEmpty() && !tfState.getText().isEmpty() && !tfZipCode.getText().isEmpty() && !tfPhone.getText().isEmpty() && !tfEmail.getText().isEmpty() && !tfExpectGrad.getText().isEmpty() && tfStudentID.getText().startsWith("Z") && tfStudentID.getText().length() == 9 && tfEmail.getText().endsWith("@my.mdc.edu")){
            for(int i = 1; i < tfStudentID.getText().length(); i++){
                if(!Character.isDigit(tfStudentID.getText().charAt(i))){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid Input");
                    alert.setContentText("Please make sure all fields are filled and the student ID starts with z and is 8 digits long and the email ends with @my.mdc.edu");
                    alert.showAndWait();
                    return;
                }
            }
            if(DataWriter.writeStudents(tfStudentID.getText(), tfFirstName.getText(), tfLastName.getText(), taStreet.getText(), tfCity.getText(), tfState.getText(), Integer.parseInt(tfZipCode.getText()), tfPhone.getText(), tfEmail.getText(), Integer.parseInt(cbMajor.getValue().split(" - ")[0]), tfExpectGrad.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Student Modified");
                alert.setContentText("The student with ID " + tfStudentID.getText() + " was modified.");
                alert.showAndWait();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Student not found");
                alert.setContentText("The student with ID " + tfStudentID.getText() + " was not found.");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please make sure all fields are filled and the student ID starts with z and is 8 digits long and the email ends with @my.mdc.edu");
            alert.showAndWait();
        }
    }

    public void setStudent(Students student) {
        tfStudentID.setText(student.getStudentID());
        tfFirstName.setText(student.getFirstName());
        tfLastName.setText(student.getLastName());
        taStreet.setText(student.getStreet());
        tfCity.setText(student.getCity());
        tfState.setText(student.getState());
        tfZipCode.setText(String.valueOf(student.getZipCode()));
        tfPhone.setText(student.getPhone());
        tfEmail.setText(student.getEmail());
        ArrayList<Major> majors = DataReader.readMajor();
        for (Major major : majors) {
            cbMajor.getItems().add(major.getMajorID() + " - " +  major.getMajorName());
        }
        cbMajor.setValue(student.getMajorID() + " - " + DataUtil.getMajorName(String.valueOf(student.getMajorID())));
        tfExpectGrad.setText(student.getExpectedGraduationDate());
    }

}
