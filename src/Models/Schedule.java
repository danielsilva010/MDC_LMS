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
package Models;

import Utils.DataUtil;

public class Schedule {
    private String courseID;
    private long CRN;
    private String courseName;
    private String term;
    private String facultyID;
    private String room;
    private int capacity;
    private int creditHours;

    public Schedule(Schedule otherSchedule) {
        this.courseID = otherSchedule.courseID;
        this.CRN = otherSchedule.CRN;
        this.courseName = otherSchedule.courseName;
        this.term = otherSchedule.term;
        this.facultyID = otherSchedule.facultyID;
        this.room = otherSchedule.room;
        this.capacity = otherSchedule.capacity;
        this.creditHours = otherSchedule.creditHours;
    }

    public Schedule() {
        
    }

    public String getFaculty() {
        return DataUtil.getFaculty(facultyID).getFirstName() + " " + DataUtil.getFaculty(facultyID).getLastName(); 
    }

    public String getTermFormatted() {
        String term = this.term;
        term = term.replaceAll("(?<=\\D)(?=\\d)", "$0#");
        String[] partsOfTerm = term.split("#");
        return partsOfTerm[0] + " " + partsOfTerm[1];
    }

    public Schedule(String courseID, long cRN, String courseName, String term, String facultyID, String room, int capacity,
            int creditHours) {

        this.courseID = courseID;
        CRN = cRN;
        this.courseName = courseName;
        this.term = term;
        this.facultyID = facultyID;
        this.room = room;
        this.capacity = capacity;
        this.creditHours = creditHours;
    }

    public String getCourseID() {
        return courseID;
    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    public long getCRN() {
        return CRN;
    }
    public void setCRN(long cRN) {
        CRN = cRN;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getTerm() {
        return term;
    }
    public void setTerm(String term) {
        this.term = term;
    }
    public String getFacultyID() {
        return facultyID;
    }
    public void setFacultyID(String facultyID) {
        this.facultyID = facultyID;
    }
    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getCreditHours() {
        return creditHours;
    }
    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    @Override
    public String toString() {
        return "Schedule [courseID=" + courseID + ", CRN=" + CRN + ", courseName=" + courseName + ", term=" + term
                + ", facultyID=" + facultyID + ", room=" + room + ", capacity=" + capacity + ", creditHours="
                + creditHours + "]";
    }

    
    
}
