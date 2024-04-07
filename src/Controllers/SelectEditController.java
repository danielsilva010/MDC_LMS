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
import Utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SelectEditController implements SceneManager {


    private Main main;

    @FXML
    void initialize() {
        main = new Main();
    }

    @FXML
    void loadEditFaculty(ActionEvent event) {
        main.loadEditFacultyView();
    }

    @FXML
    void loadEditStudent(ActionEvent event) {
        main.loadEditStudentView();
    }

    public void setMain(Main main) {
        this.main = main;
    }

}
