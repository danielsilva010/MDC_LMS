package Controllers;

import java.util.ArrayList;

import Models.Schedule;
import Utils.DataReader;
import Utils.DataUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ViewCoursesByCRNController {

    @FXML
    private Text tCRN;

    @FXML
    private Text tCapacity;

    @FXML
    private Text tCourseID;

    @FXML
    private Text tCourseName;

    @FXML
    private Text tCreditHours;

    @FXML
    private Text tFaculty;

    @FXML
    private Text tRoom;

    @FXML
    private Text tTerm;

    @FXML
    private TextField tfCRNField;

    @FXML
    void ClearIfDefaultText(MouseEvent event) {
        if (tfCRNField.getText().equals("Enter CRN")) {
            tfCRNField.clear();
        }
    }

    @FXML
    void submit(ActionEvent event) {
        ArrayList<Schedule> schedules = DataReader.readSchedule();
        long crn = Long.parseLong(tfCRNField.getText());

        for(Schedule schedule: schedules) {
            if(schedule.getCRN() == crn) {
                tCRN.setText(String.valueOf(schedule.getCRN()));
                tCapacity.setText(String.valueOf(schedule.getCapacity()));
                tCourseID.setText(schedule.getCourseID());
                tCourseName.setText(schedule.getCourseName());
                tCreditHours.setText(String.valueOf(schedule.getCreditHours()));
                tFaculty.setText(DataUtil.getFacultyName(schedule.getFacultyID()));
                tRoom.setText(schedule.getRoom());
                String term = schedule.getTerm();
                term = term.replaceAll("(?<=\\D)(?=\\d)", "$0#");
                String[] partsOfTerm = term.split("#");
                term = partsOfTerm[0] + " " + partsOfTerm[1];
                tTerm.setText(term);
            }
        }
    }

}
