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

import Models.Department;
import Models.Faculty;
import Utils.DataReader;
import Utils.DataUtil;
import Utils.DataWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EditFacultyController {

    @FXML
    private ComboBox<String> cbDepartment;

    @FXML
    private TextArea taStreet;

    @FXML
    private TextField tfCity;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfFacultyID;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfHireDate;

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfSalary;

    @FXML
    private TextField tfState;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfZipCode;

    @FXML
    public void initialize() {
        ArrayList<Department> departments = DataReader.readDepartment();
        for (Department department : departments) {
            cbDepartment.getItems().add(department.getDepartmentID() + ": " + department.getDepartmentName());
        }
    }

    @FXML
    void delete(ActionEvent event) {
        if (DataWriter.writeFacultyExceptThis(DataUtil.getFaculty(tfID.getText()))) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Faculty Deleted");
            alert.setContentText("Faculty has been deleted successfully");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Faculty Not Deleted");
            alert.setContentText("Faculty could not be deleted");
            alert.showAndWait();
        }
    }

    @FXML
    void modify(ActionEvent event) {
        if (DataWriter.writeUpdatedFacultyFile(tfFacultyID.getText(), tfFirstName.getText(), tfLastName.getText(),
                tfHireDate.getText(), tfTitle.getText(), Double.parseDouble(tfSalary.getText().substring(1)),
                taStreet.getText(), tfCity.getText(), tfState.getText(), Integer.parseInt(tfZipCode.getText()),
                tfPhone.getText(), tfEmail.getText(), getDepartmentID())) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Faculty Updated");
            alert.setContentText("Faculty has been updated successfully");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Faculty Not Updated");
            alert.setContentText("Faculty could not be updated");
            alert.showAndWait();
        }
    }

    @FXML
    void search(ActionEvent event) {
        ArrayList<Faculty> faculties = DataReader.readFaculty();
        for (Faculty faculty : faculties) {
            if (faculty.getFacultyID().equals(tfID.getText())) {
                tfFacultyID.setText(faculty.getFacultyID());
                tfFirstName.setText(faculty.getFirstName());
                tfLastName.setText(faculty.getLastName());
                tfCity.setText(faculty.getCity());
                tfEmail.setText(faculty.getEmail());
                tfHireDate.setText(faculty.getHireDate());
                tfPhone.setText(faculty.getPhone());
                tfState.setText(faculty.getState());
                tfTitle.setText(faculty.getTitle());
                tfZipCode.setText(String.valueOf(faculty.getZipCode()));
                tfSalary.setText(String.valueOf("$" + faculty.getSalary()));
                taStreet.setText(faculty.getStreet());

                for (String department : cbDepartment.getItems()) {
                    if (department.contains(faculty.getDepartmentID() + ":")) {
                        cbDepartment.getSelectionModel().select(department);
                    }
                }

            }
        }
    }

    private int getDepartmentID() {
        int departmentID = Integer.parseInt(cbDepartment.getSelectionModel().getSelectedItem().split(": ")[0]);
        return departmentID;
    }

}
