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

public class StudentCourses {
    private CourseRoster courseRoster;
    private Schedule schedule;
    private Faculty faculty;

    public String getGrade() {
        return courseRoster.getGrade();
    }

    public String getTerm() {
        String term = schedule.getTerm();
        term = term.replaceAll("(?<=\\D)(?=\\d)", "$0#");
        String[] partsOfTerm = term.split("#");
        return partsOfTerm[0] + " " + partsOfTerm[1];
    }

    public String getCourseName() {
        return schedule.getCourseName();
    }

    public String getCourseID() {
        return schedule.getCourseID();
    }

    public long getCRN() {
        return courseRoster.getCRN();
    }

    public String getFaculty() {
        return faculty.getLastName();
    }

    public CourseRoster getCourseRoster() {
        return courseRoster;
    }

    public void setCourseRoster(CourseRoster courseRoster) {
        this.courseRoster = courseRoster;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

}
