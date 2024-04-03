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

import Models.CourseRoster;
import Utils.DataReader;
import Utils.DataUtil;
import Utils.DataWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ModifyGradesController {

    @FXML
    private TextField tfCRN;

    @FXML
    private TextField tfGrade;

    @FXML
    private TextField tfStudentID;

    @FXML
    void modify(ActionEvent event) {
        String studentID = tfStudentID.getText();
        long crn = Long.parseLong(tfCRN.getText());
        String grade = tfGrade.getText();
        if(DataWriter.writeCourseRoster(crn, studentID, grade)) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Successfully changed grade.");
            alert.setContentText("Succesfully changed " + DataUtil.getStudentName(studentID) + "'s grade in course " + crn);
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error changing grade.");
            alert.setContentText("Error changing " + DataUtil.getStudentName(studentID) + "'s grade in course " + crn);
            alert.showAndWait();
        }
    }

    @FXML
    void search(ActionEvent event) {
        ArrayList<CourseRoster> courses = DataReader.readCourseRoster();
        for(CourseRoster course: courses) {
            if(course.getCRN() == Long.parseLong(tfCRN.getText()) && course.getStudentID().equals(tfStudentID.getText()) ) {
                tfGrade.setText(course.getGrade());
                tfCRN.setDisable(true);
                tfStudentID.setDisable(true);
                break;
            }
        }
        tfCRN.setDisable(true);
        tfStudentID.setDisable(true);
    }

}
