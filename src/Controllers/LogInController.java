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

import java.util.ArrayList;

import Main.Main;
import Models.Credentials;
import Utils.DataReader;
import Utils.DataUtil;
import Utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LogInController implements SceneManager {

    private Main main;

    @FXML
    private Button bLogIn;

    @FXML
    private Text textRegister;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfPassword;

    @FXML
    void loadRegisterView(MouseEvent event) {
        Stage primaryStage = (Stage) bLogIn.getScene().getWindow();
        primaryStage.close();
        main.loadRegisterView();
    }

    @FXML
    void initialize() {
        main = new Main();
    }

    @FXML
    void logIn(ActionEvent event) {
        ArrayList<Credentials> credentials = DataReader.readCredentials();
        if (matchesCredentials(credentials, tfEmail.getText(), tfPassword.getText())) {
            Stage primaryStage = (Stage) bLogIn.getScene().getWindow();
            String name = DataUtil.getName(tfEmail.getText());
            if (name != null) {
                main.loadMainView(primaryStage, name);
            }
        }
    }

    @Override
    public void setMain(Main main) {
        this.main = main;
    }

    public boolean matchesCredentials(ArrayList<Credentials> credentials, String email, String password) {
        for (Credentials c : credentials) {
            if (c.getEmail().equals(email) && c.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
