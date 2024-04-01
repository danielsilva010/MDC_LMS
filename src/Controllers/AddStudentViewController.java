package Controllers;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import Models.Students;
import Utils.DataReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    private TextField tfMajorID;

    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfState;

    @FXML
    private TextField tfStuID;

    @FXML
    private TextField tfZipCode;



    @FXML
    void Submit(ActionEvent event) throws IOException {
        FileWriter fw = new FileWriter(new File("src/Data/Students.txt"), true);
        ArrayList<Students> studentList = new ArrayList<>();
        DataReader.readStudents(studentList);
        PrintWriter pw = new PrintWriter(fw);
        boolean isValid = true;
        if(tfStuID.getText().length() == ID_LENGTH) {
            for(Students student: studentList) {

                //Validate for duplicate fields on students, each field should be unique, except name, last name and major
                if(!student.getFirstName().equals(tfFirstName.getText()) && !student.getLastName().equals(tfLastName.getText()) && !student.getStudentID().equals(tfStuID.getText())){
                    
                    isValid = true;
                }
                else {
                    isValid = false;
                    break;
                }
            }
            if(isValid) {
                pw.print("\n" + tfStuID.getText() + ":" + tfFirstName.getText() + ":" + tfLastName.getText() + 
            ":"  + tfAddress.getText() + ":" + tfCity.getText() + ":" + tfState.getText() + ":" + 
            tfZipCode.getText() + ":" + tfPhone.getText() + ":" + tfEmail.getText() + ":" + tfMajorID.getText() + ":" + tfExpectedGrad.getText());
            Alert dialog = new Alert(AlertType.INFORMATION);
            dialog.showAndWait();
            }
            else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("This student already exists, or not all fields are valid.");
                alert.showAndWait();
            }

        }
        pw.close();
    }

}

