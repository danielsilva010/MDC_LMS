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

import Main.Main;
import Utils.DataUtil;
import Utils.DataWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class RegisterController {

    private Main main;

    @FXML
    private RadioButton rbFaculty;

    @FXML
    private RadioButton rbStudent;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfPassword;

    private ToggleGroup group;

    @FXML
    void register(ActionEvent event) {
        String role = null;
        if(rbFaculty.isSelected()) {
            role = "Faculty";
        } else if(rbStudent.isSelected()) {
            role = "Student";
        }
        if(DataUtil.validateCredentials(tfEmail.getText(), tfPassword.getText())) {
            if(DataWriter.writeCredentials(tfEmail.getText(), tfPassword.getText(), role)) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Registration Successful");
                alert.setContentText("You have successfully registered");
                alert.showAndWait();
                main.loadMainView(new Stage(), DataUtil.getName(tfEmail.getText()));
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Registration Failed");
                alert.setContentText("Please try again");
                alert.showAndWait();
            }
        }
        else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("Please enter valid credentials");
            alert.showAndWait();
        }
    }

    @FXML
    void initialize() {
        main = new Main();
        group = new ToggleGroup();
        rbFaculty.setToggleGroup(group);
        rbStudent.setToggleGroup(group);
    }

}
