/*
 * Copyright ©️ 2024 Daniel Silva
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

import Utils.DataUtil;
import Utils.DataWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class AddStudentToCourseController {

    @FXML
    private TextField tfCRN;

    @FXML
    private TextField tfStudentID;

    @FXML
    void add(ActionEvent event) {
        if(tfCRN.getText().isEmpty() || tfStudentID.getText().isEmpty()) {
            return;
        }
        if(DataUtil.studentExists(tfStudentID.getText()) && DataUtil.courseExists(Long.parseLong(tfCRN.getText()))) {
            if(DataWriter.writeCourseRoster(tfStudentID.getText(), Long.parseLong(tfCRN.getText()))) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Student added to course");
                alert.setContentText("The student has been added to the course");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Student or course does not exist");
            alert.setContentText("The student or course does not exist");
            alert.showAndWait();
        }
    }

}
