package Controllers;

import java.util.ArrayList;

import Models.CourseRoster;
import Utils.DataReader;
import Utils.DataUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CalculateGPAController {

    @FXML
    private Text textGPA;

    @FXML
    private Text textName;

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfCRN;

    @FXML
    void calculate(ActionEvent event) {
        String ID = tfID.getText();
        if(DataUtil.isStudent(ID)) {
            ArrayList<CourseRoster> roster = DataReader.readCourseRoster();
            double score = 0;
            for(int i = roster.size() - 1; i >= 0; i--) {
                if(roster.get(i).getStudentID().equals(ID)) {
                    roster.remove(roster.get(i));
                }
            }

            for(CourseRoster oneRecord: roster) {
                score += getGrade(oneRecord.getGrade());
            }
            score /= roster.size();
            textName.setText(DataUtil.getStudentName(ID));
            textGPA.setText(String.format("%.2f", score));
        }
    }

    public static double getGrade(String grade) {
        if(grade.startsWith("A")) {
            return 4.00;
        }
        else if(grade.startsWith("B")) {
            return 3.00;
        }
        else if(grade.startsWith("C")) {
            return 2.00;
        }
        else if(grade.startsWith("D")) {
            return 1.00;
        }
        else if(grade.startsWith("F")) {
            return 0.00;
        }
        else {
            return -1;
        }
    }

}
