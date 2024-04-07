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
public class CourseRoster {
    private long CRN;
    private String studentID;
    private String grade;
    
    public CourseRoster() {
    }

    public CourseRoster(long cRN, String studentID, String grade) {
        CRN = cRN;
        this.studentID = studentID;
        this.grade = grade;
    }

    public CourseRoster(CourseRoster courseRoster) {
        this.CRN = courseRoster.getCRN();
        this.studentID = courseRoster.getStudentID();
        this.grade = courseRoster.getGrade();
    }

    public long getCRN() {
        return CRN;
    }

    public void setCRN(long cRN) {
        CRN = cRN;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "CourseRoster [CRN=" + CRN + ", studentID=" + studentID + ", grade=" + grade + "]";
    }

    

}
