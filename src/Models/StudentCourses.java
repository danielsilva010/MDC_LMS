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
