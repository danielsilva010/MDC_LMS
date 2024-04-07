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
import Models.Schedule;
import Utils.DataReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CourseScheduleController {


    @FXML
    private TableView<Schedule> tableView;

    @FXML
    private TableColumn<Schedule, Long> CRN;

    @FXML
    private TableColumn<Schedule, Integer> Capacity;

    @FXML
    private TableColumn<Schedule, Integer> CreditHours;

    @FXML
    private TableColumn<Schedule, String> FacultyID;

    @FXML
    private TableColumn<Schedule, String> Room;

    @FXML
    private TableColumn<Schedule, String> Term;

    @FXML
    private TableColumn<Schedule, String> Title;

    @FXML
    private TableColumn<Schedule, String> courseID;

    /***
     * Initialize the course schedule controller
     */
    public void initialize() {
            ArrayList<Schedule> scheduleList = DataReader.readSchedule();
            ObservableList<Schedule> scheduleObvList = FXCollections.observableArrayList(scheduleList);
            tableView.setItems(scheduleObvList);

            CRN.setCellValueFactory(new PropertyValueFactory<>("CRN"));
            Capacity.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
            CreditHours.setCellValueFactory(new PropertyValueFactory<>("CreditHours"));
            FacultyID.setCellValueFactory(new PropertyValueFactory<>("Faculty"));
            Room.setCellValueFactory(new PropertyValueFactory<>("Room"));
            Term.setCellValueFactory(new PropertyValueFactory<>("TermFormatted"));
            Title.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
            courseID.setCellValueFactory(new PropertyValueFactory<>("CourseID"));
    }

   
}
