package Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

import Main.Main;
import Models.Students;
import Utils.DataReader;
import Utils.SceneManager;

public class StudentSearchController implements SceneManager{

    private Main main;
    private DataReader dataReader = new DataReader();
    private Students student = new Students();
    private ArrayList<Students> students = new ArrayList<>();
    private String filePath = "src/Data/Students.txt";

    @FXML
    private Button searchButton;

    @FXML
    private TextField tfIDField;

    @FXML
    void search(ActionEvent event) throws IOException {
        dataReader.readStudents(students, filePath);
        String id = tfIDField.getText();
        for (Students student : students) {
            if (student.getStudentID().contains(id)) {
                System.out.println(student.getStudentID());
                Parent root = FXMLLoader.load(getClass().getResource("../View/StudentView.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Student Information");
                stage.setScene(new Scene(root, 600, 400));
                stage.show();
                break;
            }
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

