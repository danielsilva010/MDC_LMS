package Main;

import java.io.IOException;

import Controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String mainViewPath = "/View/MainView.fxml";

    private static final String addStudentViewPath = "/View/AddStudentView.fxml";

    private static final String searchStudentViewPath = "/View/StudentSearchView.fxml";

    private static final String courseScheduleViewPath = "/View/CourseScheduleView.fxml";

    private static final String createCourseViewPath = "/View/CreateNewCourseView.fxml";

    private static final String courseListViewPath = "/View/CourseListView.fxml";

    private static final String addStudentToCourseView = "/View/AddStudentToCourseView.fxml";

    private static final String facultyCoursesView = "/View/FacultyCoursesView.fxml";

    private static final String createFacultyView = "/View/CreateFacultyView.fxml";

    private Stage secondaryStage = new Stage();

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Start the application
     * 
     * @param primaryStage the primary stage
     */
    @Override
    public void start(Stage primaryStage) {
        loadMainView(primaryStage);
    }

    /**
     * Load the main view
     * 
     * @param primaryStage the primary stage
     */
    public void loadMainView(Stage primaryStage) {
        try {
            MainController controller = new MainController();
            controller.setMain(this);
            Parent root = FXMLLoader.load(getClass().getResource(mainViewPath));
            primaryStage.setTitle("Course Registration System");
            primaryStage.setScene(new Scene(root, 650, 400));
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the main view");
            alert.showAndWait();
        }
    }

    /**
     * Load the create faculty view
     */
    public void loadCreateFacultyView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(createFacultyView));
            secondaryStage.setTitle("Create New Faculty");
            secondaryStage.setScene(new Scene(root, 650, 400));
            secondaryStage.setResizable(false);
            secondaryStage.setX(100);
            secondaryStage.setY(100);
            secondaryStage.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the create faculty view");
            alert.showAndWait();
        }
    }

    /**
     * Load the view courses by CRN view
     */
    public void loadViewCoursesByCRNView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/ViewCoursesByCRNView.fxml"));
            secondaryStage.setTitle("View Courses by CRN");
            secondaryStage.setScene(new Scene(root, 650, 400));
            secondaryStage.setResizable(false);
            secondaryStage.setX(100);
            secondaryStage.setY(100);
            secondaryStage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the view courses by CRN view");
            alert.showAndWait();
        }
    }

    /**
     * Load the add student view
     */
    public void loadAddStudentView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(addStudentViewPath));
            secondaryStage.setTitle("Course Registration System");
            secondaryStage.setScene(new Scene(root, 650, 400));
            secondaryStage.setResizable(false);
            secondaryStage.setX(100);
            secondaryStage.setY(100);
            secondaryStage.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the add student view");
            alert.showAndWait();
        }
    }

    /***
     * Load the student search view
     */
    public void loadStudentSearchView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(searchStudentViewPath));
            secondaryStage.setTitle("Student Information");
            secondaryStage.setScene(new Scene(root, 650, 458));
            secondaryStage.setResizable(true);
            secondaryStage.setX(100);
            secondaryStage.setY(100);
            secondaryStage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading student search view");
            alert.showAndWait();
        }
    }

    /***
     * Load the course schedule view
     */
    public void loadCourseScheduleView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(courseScheduleViewPath));
            secondaryStage.setTitle("Course List");
            secondaryStage.setScene(new Scene(root, 650, 480));
            secondaryStage.setResizable(false);
            secondaryStage.setX(100);
            secondaryStage.setY(100);
            secondaryStage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading course schedule view");
            alert.showAndWait();
        }
    }

    /**
     * Load the create course view
     */
    public void loadcreateCourseView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(createCourseViewPath));
            secondaryStage.setTitle("Create New Course");
            secondaryStage.setScene(new Scene(root, 650, 400));
            secondaryStage.setX(100);
            secondaryStage.setY(100);
            secondaryStage.setResizable(false);
            secondaryStage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the create course view");
            alert.showAndWait();
        }
    }

    /**
     * Load the course list view
     */
    public void loadCourseListView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(courseListViewPath));
            secondaryStage.setTitle("Course List for Student");
            secondaryStage.setScene(new Scene(root, 650, 400));
            secondaryStage.setX(100);
            secondaryStage.setY(100);
            secondaryStage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the course list view");
            alert.showAndWait();
        }
    }

    /**
     * Load the add student to course view
     */
    public void loadAddStudentToCourseView() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(addStudentToCourseView));
            secondaryStage.setTitle("Add Student to Course");
            secondaryStage.setScene(new Scene(root, 650, 430));
            secondaryStage.setX(100);
            secondaryStage.setY(100);
            secondaryStage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the add student to course view");
            alert.showAndWait();
        }
    }

    /**
     * Load the faculty courses view
     */
    public void loadFacultyCoursesView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(facultyCoursesView));
            secondaryStage.setTitle("Faculty Courses");
            secondaryStage.setScene(new Scene(root, 650, 430));
            secondaryStage.setX(100);
            secondaryStage.setY(100);
            secondaryStage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the faculty courses view");
            alert.showAndWait();
        }
    }
}
