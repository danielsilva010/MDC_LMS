package Controllers;

import Models.Schedule;
import Utils.DataUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.control.ListView;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CourseListController{

    @FXML
    private ListView<Schedule> ListView;

    @FXML
    private Button SearchButton;

    @FXML
    private Text textStudentName;

    @FXML
    private TextField tfStudentID;

    @FXML
    void Clear(MouseEvent event) {
        if(tfStudentID.getText().equals("Enter Student ID here...")) {
            tfStudentID.clear();
        }
    }

    @FXML
    void Search(ActionEvent event) throws FileNotFoundException {
        ArrayList<Schedule> schedule = DataUtil.getStudentCourses(tfStudentID.getText());
        String name = DataUtil.getStudentName(tfStudentID.getText());
        textStudentName.setText(name);
        ListView.getItems().addAll(schedule);
    }

}
