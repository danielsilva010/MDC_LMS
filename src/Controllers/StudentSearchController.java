package Controllers;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

import Main.Main;
import Models.Major;
import Models.Students;
import Utils.DataReader;
import Utils.SceneManager;

public class StudentSearchController implements SceneManager{

    private Main main;
    private DataReader dataReader = new DataReader();
    private Students student = new Students();
    private ArrayList<Students> students = new ArrayList<>();
    private String filePath = "/Users/danielsilva/Desktop/code/java/MDC-LMS-GUI/MDC_LMS/src/Data/Students.txt";

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

    @FXML
    void search(ActionEvent event) throws IOException {
        dataReader.readStudents(students, filePath);
        String id = tfStudentID.getText();
        for (Students student : students) {
            if(student.getStudentID().equals(id)) {
                this.student = new Students(student);
                break;
            }
        }
        String majorName = "";
        ArrayList<Major> majorList = new ArrayList<>();
        dataReader.readMajor(majorList, "/Users/danielsilva/Desktop/code/java/MDC-LMS-GUI/MDC_LMS/src/Data/Major.txt");
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

    @FXML
    void ClearIfDefaultText(MouseEvent event) {
        if(tfStudentID.getText().equals("Enter Student ID Here")) {
            tfStudentID.clear();
        }
    }

    @FXML
    void tfIDFieldClicked(MouseEvent event) {
        tfIDField.clear();
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void initialize() {
        main = new Main();
    }

}

