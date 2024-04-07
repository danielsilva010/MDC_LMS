## COP 2800 - Java Programming

This project is in no way shape or form professionally associated with Miami Dade College, this is a practice project for the COP 2800 course.

### Project Description [![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

This project is a Java application that simulates a basic college registration system. The system will allow students to register for courses, view their schedule, and view their grades. The system will also allow faculty to view their schedule, view their students, and enter grades.

- `src`: the folder to maintain sources
    - `View`: the folder to maintain the view classes
    - `Models`: the folder to maintain the model classes
        - `CourseRoster.java`: the source java file for the CourseRoster class
        - `Students.java`: the source java file for the Students class
        - `StudentCourse.java`: the source java file for wrapper class for Schedule and CourseRoster
        - `Faculty.java`: the source java file for the Faculty class
        - `Schedule.java`: the source java file for the Schedule class
        - `Major.java`: the source java file for the Major class
        - `Department.java`: the source java file for the Department class
    - `Controller`: the folder to maintain the controller classes
    - `Main`: the folder to maintain the main class
        - `Main`: the main point of execution of the program
    - `Data`: the folder to maintain the data classes
        - `Students.txt`: the source file for the Students data
        - `Faculty.txt`: the source file for the Faculty data
        - `Major.txt`: the source file for the Major data
        - `Department.txt`: the source file for the Department data
        - `CourseRoster.txt`: the source file for the CourseRoster data
        - `Schedule.txt`: the source file for the Schedule data
    - `Util`: the folder to maintain the utility classes
        - `DataReader.java`: the source java file for the DataReader class
        - `DataUtil.java`: the source java file for the DataUtil class
        - `DataWriter.java`: the source java file for the DataWriter class
- `lib`: the folder to maintain dependencies