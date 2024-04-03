package Controllers;

import java.util.ArrayList;

import Models.CourseRoster;
import Utils.DataReader;
import Utils.DataUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ModifyGradesController {

    @FXML
    private Text tCRNCourseName;

    @FXML
    private Text tGrade;

    @FXML
    private Text tStudentID;

    @FXML
    private TextField tfStudentID;

    @FXML
    void search(ActionEvent event) {
        ArrayList<CourseRoster> courseRoster = DataReader.readCourseRoster();
        if(courseRoster != null) {
            for(CourseRoster cr : courseRoster) {
                if(cr.getStudentID().equals(tfStudentID.getText())) {
                    tStudentID.setText(cr.getStudentID());
                    tGrade.setText(cr.getGrade());
                    tCRNCourseName.setText(cr.getCRN() + " " + DataUtil.getCourseName(cr.getCRN()));
                }
            }
        }
    }

}
