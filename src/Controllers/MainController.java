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

import java.io.IOException;

import Main.Main;
import Utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainController implements SceneManager {

    @FXML
    private GridPane gridpane;

    @FXML
    private Text tName;

    private Main main;

    @FXML
    private Button viewFacultyCoursesButton;

    @FXML
    private Button modifyGradesButton;

    @FXML
    private Button calculateGPAButton;

    @FXML
    private Button AddStudentToCourseButton;

    @FXML
    private VBox VBOX;

    @FXML
    private Button createNewCourseButton;

    @FXML
    private Button createNewStudentButton;

    @FXML
    private Button printCourseListForStudentButton;

    @FXML
    private Button viewCourseScheduleButton;

    @FXML
    private Button viewStudentInformationButton;

    @FXML
    private Button createNewFacultyButton;

    @FXML
    private Button viewCoursesByCRNButton;
    @FXML
    private Button EditFacultyOrStudentButton;

    @FXML
    void EditFacultyOrStudent(ActionEvent event) {
        main.loadSelectEditView();
    }

    @FXML
    void createNewFaculty(ActionEvent event) {
        main.loadCreateFacultyView();
    }

    @FXML
    void viewCoursesByCRN(ActionEvent event) {
        main.loadViewCoursesByCRNView();
    }

    @FXML
    public void initialize() {
        main = new Main();
    }

    @Override
    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    void viewFacultyCourses(ActionEvent event) {
        main.loadFacultyCoursesView();
    }

    @FXML
    void modifyGrades(ActionEvent event) {
        main.loadModifyGradesView();
    }

    @FXML
    void calculateGPA(ActionEvent event) {
        main.loadCalculateGPAView();
    }

    @FXML
    void AddStudentToCourse(ActionEvent event) throws IOException {
        main.loadAddStudentToCourseView();
    }

    @FXML
    void createNewCourse(ActionEvent event) throws IOException {
        main.loadcreateCourseView();
    }

    @FXML
    void createNewStudent(ActionEvent event) throws IOException {
        main.loadAddStudentView();
    }

    @FXML
    void printCourseListForStudent(ActionEvent event) throws IOException {
        main.loadCourseListView();
    }

    @FXML
    void viewCourseSchedule(ActionEvent event) throws IOException {
        main.loadCourseScheduleView();
    }

    @FXML
    void viewStudentInformation(ActionEvent event) throws IOException {
        main.loadStudentSearchView();
    }

    public void setName(String name) {
        tName.setText("Welcome " + name);
    }

}
