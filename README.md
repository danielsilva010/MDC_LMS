## COP 2800 - Java Programming

This project is in no way shape or form professionally associated with Miami Dade College, this is a practice project for the COP 2800 course.

### Project Description [![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

This project is a Java application that simulates a basic college registration system. The system will allow students to register for courses, view their schedule, and view their grades. The system will also allow faculty to view their schedule, view their students, and enter grades. The system will also allow administrators to add, delete, and update courses, students, faculty, and departments. The system will also allow administrators to view the schedule of students and faculty.

- `src`: the folder to maintain sources
    - `View`: the folder to maintain the view classes
    - `Models`: the folder to maintain the model classes
        - `Models/CourseRoster.java`: the source java file for the CourseRoster class
        - `Models/Students.java`: the source java file for the Students class
        - `Models/StudentCourse.java`: the source java file for wrapper class for Schedule and CourseRoster
        - `Models/Faculty.java`: the source java file for the Faculty class
        - `Models/Schedule.java`: the source java file for the Schedule class
        - `Models/Major.java`: the source java file for the Major class
        -`Models/Department.java`: the source java file for the Department class
    - `Controller`: the folder to maintain the controller classes

    - `Main`: the folder to maintain the main class
        - `Main`: the main point of execution of the program
    - `Data`: the folder to maintain the data classes
        - `Data/Students.txt`: the source file for the Students data
        - `Data/Faculty.txt`: the source file for the Faculty data
        - `Data/Major.txt`: the source file for the Major data
        - `Data/Department.txt`: the source file for the Department data
        - `Data/CourseRoster.txt`: the source file for the CourseRoster data
        - `Data/Schedule.txt`: the source file for the Schedule data
    - `Util`: the folder to maintain the utility classes
        - `Util/DataReader.java`: the source java file for the DataReader class
        - `Util/DataUtil.java`: the source java file for the DataUtil class
- `lib`: the folder to maintain dependencies