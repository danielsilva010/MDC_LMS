package Controllers;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import Models.Students;
import Utils.DataReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class StudentController {

    @FXML
    private ListView<Students> list;


    @FXML
    public void initialize() throws FileNotFoundException {
        ObservableList<Students> students = FXCollections.observableArrayList();
        DataReader dataReader = new DataReader();
        String filePath = "src/Data/Students.txt";
        ArrayList<Students> studentArrList = new ArrayList<Students>(students);
        dataReader.readStudents(studentArrList, filePath);
        list.setItems(students);
    }


}
