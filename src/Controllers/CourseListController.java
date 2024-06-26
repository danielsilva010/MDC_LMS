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

import Models.StudentCourses;
import Utils.DataUtil;
import Utils.DataWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.control.TableView;
import java.util.ArrayList;

public class CourseListController{

    @FXML
    private TableColumn<StudentCourses, Long> CRNColumn;

    @FXML
    private TableColumn<StudentCourses, String> FacultyColumn;

    @FXML
    private TableColumn<StudentCourses, String> CourseIDColumn;

    @FXML
    private TableColumn<StudentCourses, String> GradeColumn;

    @FXML
    private Button SearchButton;

    @FXML
    private TableColumn<StudentCourses, String> TermColumn;

    @FXML
    private TableColumn<StudentCourses, String> courseNameColumn;

    @FXML
    private TableView<StudentCourses> tableView;

    @FXML
    private Text textStudentName;

    @FXML
    private TextField tfStudentID;


    /***
     * Clear the text field if the default text is present
     * @param event the mouse click
     */
    @FXML
    void Clear(MouseEvent event) {
        if(tfStudentID.getText().equals("Enter Student ID here...")) {
            tfStudentID.clear();
        }
    }

    /***
     * Search for a student by ID when the user clicks the search button
     * @param event the button click
     */
    @FXML
    void Search(ActionEvent event) {
        ArrayList<StudentCourses> schedule = DataUtil.getCourses(tfStudentID.getText());
        String name = DataUtil.getStudentName(tfStudentID.getText());
        textStudentName.setText(name);
        CRNColumn.setCellValueFactory(new PropertyValueFactory<>("CRN"));
        FacultyColumn.setCellValueFactory(new PropertyValueFactory<>("Faculty"));
        GradeColumn.setCellValueFactory(new PropertyValueFactory<>("Grade"));
        CourseIDColumn.setCellValueFactory(new PropertyValueFactory<>("CourseID"));
        TermColumn.setCellValueFactory(new PropertyValueFactory<>("Term"));
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        tableView.getItems().setAll(schedule);

        DataWriter.writeStudentCourses(tfStudentID.getText());
    }

}
