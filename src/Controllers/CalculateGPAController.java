package Controllers;

import java.util.ArrayList;

import Models.CourseRoster;
import Utils.DataReader;
import Utils.DataUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

public class CalculateGPAController {

    private ToggleGroup toggleGroup;

    @FXML
    private RadioButton rbCRN;

    @FXML
    private RadioButton rbID;

    @FXML
    private Text textGPA;

    @FXML
    private Text textName;

    @FXML
    private TextField tfIDCRN;

    @FXML
    public void initialize() {
        toggleGroup = new ToggleGroup();
        rbCRN.setToggleGroup(toggleGroup);
        rbID.setToggleGroup(toggleGroup);
    }

    @FXML
    void calculate(ActionEvent event) {
        double score = 0;
        if(!rbCRN.isSelected() && !rbID.isSelected()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error processing");
            alert.setContentText("Make a selection from the radio buttons");
        }
        else if(rbCRN.isSelected() || rbID.isSelected()){
            if(rbCRN.isSelected() && DataUtil.courseExists(Long.parseLong(tfIDCRN.getText()))) {
                ArrayList<CourseRoster> roster = DataReader.readCourseRoster();
                for(int i = roster.size() - 1; i >= 0; i--) {
                    if(roster.get(i).getCRN() != Long.parseLong(tfIDCRN.getText())) {
                        roster.remove(roster.get(i));
                    }
                }

                for(CourseRoster oneRecord: roster) {
                    score += getGrade(oneRecord.getGrade());
                }
                score /= roster.size();
                textName.setText(DataUtil.getCourseName(Long.parseLong(tfIDCRN.getText())));
                
                textGPA.setText(String.format("%.2f", score));
            }
            else if(rbID.isSelected() && DataUtil.studentExists(tfIDCRN.getText())) {
                ArrayList<CourseRoster> roster = DataReader.readCourseRoster();
                for(int i = roster.size() - 1; i >= 0; i--) {
                    if(!roster.get(i).getStudentID().equals(tfIDCRN.getText())) {
                        roster.remove(roster.get(i));
                    }
                }
                for(CourseRoster oneRecord: roster) {
                    score += getGrade(oneRecord.getGrade());
                }
                score /= roster.size();
                textName.setText(DataUtil.getStudentName(tfIDCRN.getText()));
                textGPA.setText(String.format("%.2f", score));
            }
        }
    }

    public static double getGrade(String grade) {
        if (grade.startsWith("A")) {
            return 4.00;
        } else if (grade.startsWith("B")) {
            return 3.00;
        } else if (grade.startsWith("C")) {
            return 2.00;
        } else if (grade.startsWith("D")) {
            return 1.00;
        } else if (grade.startsWith("F")) {
            return 0.00;
        } else {
            return -1;
        }
    }

}
