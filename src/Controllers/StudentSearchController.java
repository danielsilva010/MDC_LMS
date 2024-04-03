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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.util.ArrayList;

import Models.Major;
import Models.Students;
import Utils.DataReader;

public class StudentSearchController{

    private Students student = new Students();
    private ArrayList<Students> students = new ArrayList<>();

    @FXML
    private Button SearchButton;

    @FXML
    private Text tAddress;

    @FXML
    private Text tEmail;

    @FXML
    private Text tExpectedGraduation;

    @FXML
    private Text tMajor;

    @FXML
    private Text tName;

    @FXML
    private Text tPhone;

    @FXML
    private TextField tfStudentID;

    @FXML
    private Button searchButton;

    @FXML
    private Text tfIDField;

    /***
     * Search for a student by ID when the user clicks the search button
     */
    @FXML
    void search(ActionEvent event) {
        students = DataReader.readStudents();
        String id = tfStudentID.getText();
        for (Students student : students) {
            if(student.getStudentID().equals(id)) {
                this.student = new Students(student);
                break;
            }
        }
        String majorName = "";
        ArrayList<Major> majorList = DataReader.readMajor();
        for(Major oneMajor: majorList) {
            if(oneMajor.getMajorID() == student.getMajorID()) {
                majorName = oneMajor.getMajorName();
                break;
            }
        }
        StringProperty name = new SimpleStringProperty(student.getFirstName() + " " + student.getLastName());
        StringProperty address = new SimpleStringProperty(student.getStreet() + ", "  + student.getCity() + ", " + student.getState() + ", " + student.getZipCode());
        StringProperty phoneNumber = new SimpleStringProperty(student.getPhone());
        StringProperty email = new SimpleStringProperty(student.getEmail());
        StringProperty expectedGrad = new SimpleStringProperty(student.getExpectedGraduationDate());
        StringProperty major = new SimpleStringProperty(majorName);
        tName.textProperty().bind(name);
        tAddress.textProperty().bind(address);
        tPhone.textProperty().bind(phoneNumber);
        tEmail.textProperty().bind(email);
        tExpectedGraduation.textProperty().bind(expectedGrad);
        tMajor.textProperty().bind(major);
    }

    /***
     * Clear the text field if the default text is present
     * @param event the mouse event
     */
    @FXML
    public void ClearIfDefaultText(MouseEvent event) {
        if(tfStudentID.getText().equals("Enter Student ID Here")) {
            tfStudentID.clear();
        }
    }


}

