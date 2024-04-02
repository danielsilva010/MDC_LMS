package Models;

public class FacultyCourses {
    private Schedule schedule;
    private CourseRoster courseRoster;
    private Faculty faculty;

    public FacultyCourses() {
        this.schedule = new Schedule();
        this.courseRoster = new CourseRoster();
        this.faculty = new Faculty();
    }

    public long getCRN() {
        return courseRoster.getCRN();
    }

    public String getCourseID() {
        return schedule.getCourseID();
    }

    public String getCourseName() {
        return schedule.getCourseName();
    }

    public String getTerm() {
        String term = schedule.getTerm();
        term = term.replaceAll("(?<=\\D)(?=\\d)", "$0#");
        String[] partsOfTerm = term.split("#");
        return partsOfTerm[0] + " " + partsOfTerm[1];
    }

    public String getGrade() {
        return courseRoster.getGrade();
    }

    public Schedule getSchedule() {
        return new Schedule(schedule);
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = new Schedule(schedule);
    }

    public CourseRoster getCourseRoster() {
        return new CourseRoster(courseRoster);
    }

    public void setCourseRoster(CourseRoster courseRoster) {
        this.courseRoster = new CourseRoster(courseRoster);
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = new Faculty(faculty);
    }

    public Faculty getFaculty() {
        return new Faculty(faculty);
    }

    

}
