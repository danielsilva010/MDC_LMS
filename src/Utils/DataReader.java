package Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import Models.CourseRoster;
import Models.Department;
import Models.Faculty;
import Models.Major;
import Models.Schedule;
import Models.Students;

public class DataReader {

    public void readCourseRoster(ArrayList<CourseRoster> courseRoster, String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        String line = null;
        String[] parts = null;
        while(scanner.hasNextLine())
        {
            line = scanner.nextLine();
            parts = line.split(":");
            CourseRoster cr = new CourseRoster();
            cr.setCRN(Long.parseLong(parts[0]));
            cr.setStudentID(parts[1]);
            cr.setGrade(parts[2]);
            courseRoster.add(cr);
        }
        scanner.close();
    }

    public void readSchedule(ArrayList<Schedule> schedule, String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        String line = null;
        String[] parts = null;
        while(scanner.hasNextLine())
        {
            line = scanner.nextLine();
            parts = line.split(":");
            Schedule sch = new Schedule();
            sch.setCourseID(parts[0]);
            sch.setCRN(Long.parseLong(parts[1]));
            sch.setCourseName(parts[2]);
            sch.setTerm(parts[3]);
            sch.setFacultyID(parts[4]);
            sch.setRoom(parts[5]);
            sch.setCapacity(Integer.parseInt(parts[6]));
            sch.setCreditHours(Integer.parseInt(parts[7]));
            schedule.add(sch);
        }
        scanner.close();
    }

    public void readDepartment(ArrayList<Department> departments, String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        String line = null;
        String[] parts = null;
        while(scanner.hasNext())
        {
            line = scanner.nextLine();
            parts = line.split(":");
            Department department = new Department();
            department.setDepartmentID(Integer.parseInt(parts[0]));
            department.setDepartmentName(parts[1]);
            departments.add(department);
        }
        scanner.close();
    }

    public void readMajor(ArrayList<Major> majors, String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        String line = null;
        String[] parts = null;
        while(scanner.hasNext())
        {
            line = scanner.nextLine();
            parts = line.split(":");
            Major major = new Major();
            major.setMajorID(Integer.parseInt(parts[0]));
            major.setMajorName(parts[1]);
            major.setDepartmentID(Integer.parseInt(parts[2]));
            majors.add(major);
        }
        scanner.close();
    }

    public void readFaculty(ArrayList<Faculty> faculty, String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        String line = null;
        String[] parts = null;
        while(scanner.hasNext())
        {
            line = scanner.nextLine();
            parts = line.split(":");
            Faculty fac = new Faculty();
            fac.setFacultyID(parts[0]);
            fac.setFirstName(parts[1]);
            fac.setLastName(parts[2]);
            fac.setHireDate(parts[3]);
            fac.setTitle(parts[4]);
            fac.setSalary(Double.parseDouble(parts[5]));
            fac.setStreet(parts[6]);
            fac.setCity(parts[7]);
            fac.setState(parts[8]);
            fac.setZipCode(Integer.parseInt(parts[9]));
            fac.setPhone(parts[10]);
            fac.setEmail(parts[11]);
            fac.setDepartmentID(Integer.parseInt(parts[12]));
            faculty.add(fac);
        }
        scanner.close();
    }




    public void readStudents(ArrayList<Students> students, String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        String line = null;
        String[] parts = null;
        while(scanner.hasNext())
        {
            line = scanner.nextLine();
            parts = line.split(":");
            Students student = new Students();
            student.setStudentID(parts[0]);
            student.setFirstName(parts[1]);
            student.setLastName(parts[2]);
            student.setStreet(parts[3]);
            student.setCity(parts[4]);
            student.setState(parts[5]);
            student.setZipCode(Integer.parseInt(parts[6]));
            student.setPhone(parts[7]);
            student.setEmail(parts[8]);
            student.setMajorID(Integer.parseInt(parts[9]));
            student.setExpectedGraduationDate(parts[10]);
            students.add(student);
        }
        scanner.close();
    }
}
