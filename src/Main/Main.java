package Main;

import java.io.IOException;

import Controllers.IdentificationController;
import Controllers.LogInController;
import Controllers.MainController;
import Controllers.SelectEditController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String mainViewPath = "/View/MainView.fxml";

    private static final String logInViewPath = "/View/LogInView.fxml";

    private static final String calculateGPAView = "/View/CalculateGPAView.fxml";

    private static final String addStudentViewPath = "/View/AddStudentView.fxml";

    private static final String searchStudentViewPath = "/View/StudentSearchView.fxml";

    private static final String courseScheduleViewPath = "/View/CourseScheduleView.fxml";

    private static final String createCourseViewPath = "/View/CreateNewCourseView.fxml";

    private static final String courseListViewPath = "/View/CourseListView.fxml";

    private static final String addStudentToCourseView = "/View/AddStudentToCourseView.fxml";

    private static final String facultyCoursesView = "/View/FacultyCoursesView.fxml";

    private static final String createFacultyView = "/View/CreateFacultyView.fxml";

    private static final String modifyGradesView = "/View/ModifyGradesView.fxml";

    private static final String editStudentView = "/View/EditStudentView.fxml";

    private static final String selectEditView = "/View/SelectEditView.fxml";

    private static final String registerViewPath = "/View/RegisterView.fxml";

    private static final String editFacultyViewPath = "/View/EditFacultyView.fxml";

    private static final String identificationPath = "/View/IdentificationView.fxml";

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

        loadIdentificationView();
    }

    /**
     * Load the main view
     * 
     * @param primaryStage the primary stage
     */
    public void loadMainView(Stage primaryStage, String name) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(mainViewPath));
            Parent root = loader.load();
            MainController controller = loader.getController();
            controller.setName(name);
            controller.setMain(this);
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

    public void loadIdentificationView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(identificationPath));
            Parent root = loader.load();
            IdentificationController controller = loader.getController();
            controller.setMain(this);
            secondaryStage.setTitle("Identificate yourself");
            secondaryStage.setScene(new Scene(root, 300, 240));
            secondaryStage.setResizable(false);
            secondaryStage.show();
        } catch(IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the identification view");
            alert.showAndWait();            
        }
    }

    /**
     * Load the register view
     */
    public void loadRegisterView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(registerViewPath));
            secondaryStage.setTitle("Register");
            secondaryStage.setScene(new Scene(root, 450, 425));
            secondaryStage.setResizable(false);
            secondaryStage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the register view");
            alert.showAndWait();
        }
    }

    public void loadEditFacultyView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(editFacultyViewPath));
            Parent root = loader.load();
            secondaryStage.setTitle("Select Student/Faculty");
            secondaryStage.setScene(new Scene(root, 650, 400));
            secondaryStage.setResizable(false);
            secondaryStage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the select edit view");
            alert.showAndWait();
        }
    }

    /**
     * Load the log in view
     */
    public void loadLogInView() {
        try {
            LogInController controller = new LogInController();
            controller.setMain(this);
            Parent root = FXMLLoader.load(getClass().getResource(logInViewPath));
            secondaryStage.setTitle("Log In");
            secondaryStage.setScene(new Scene(root, 400, 280));
            secondaryStage.setResizable(false);
            secondaryStage.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the log in view");
            alert.showAndWait();
        }
    }

    /**
     * Load the calculate GPA view
     */
    public void loadCalculateGPAView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(calculateGPAView));
            secondaryStage.setTitle("Calculate GPA");
            secondaryStage.setScene(new Scene(root, 650, 400));
            secondaryStage.setResizable(false);
            secondaryStage.setX(100);
            secondaryStage.setY(100);
            secondaryStage.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the Calculate GPA view");
            alert.showAndWait();
        }
    }

    /**
     * Load the edit student view
     */
    public void loadEditStudentView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(editStudentView));
            secondaryStage.setTitle("Edit Faculty/Student");
            secondaryStage.setScene(new Scene(root, 650, 400));
            secondaryStage.setResizable(false);
            secondaryStage.setX(100);
            secondaryStage.setY(100);
            secondaryStage.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the Edit Student/Faculty view");
            alert.showAndWait();
        }
    }

    /**
     * Load the modify grades view
     */
    public void loadModifyGradesView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(modifyGradesView));
            secondaryStage.setTitle("Modify Grades");
            secondaryStage.setScene(new Scene(root, 650, 400));
            secondaryStage.setResizable(false);
            secondaryStage.setX(100);
            secondaryStage.setY(100);
            secondaryStage.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the modify grades view");
            alert.showAndWait();
        }
    }

    /**
     * Load the select edit view
     */
    public void loadSelectEditView() {
        try {
            SelectEditController controller = new SelectEditController();
            controller.setMain(this);
            Parent root = FXMLLoader.load(getClass().getResource(selectEditView));
            secondaryStage.setTitle("Select Edit");
            secondaryStage.setScene(new Scene(root, 600, 400));
            secondaryStage.setResizable(false);
            secondaryStage.setX(100);
            secondaryStage.setY(100);
            secondaryStage.showAndWait();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error loading view");
            alert.setContentText("An error occurred while loading the select edit view");
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
