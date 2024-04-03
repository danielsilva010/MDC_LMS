/*
 * Copyright (c) [2024] [Daniel Silva]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
