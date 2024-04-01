package Main;
import java.io.IOException;

import Controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String mainViewPath = "/View/MainView.fxml";

    private static final String addStudentViewPath = "/View/AddStudentView.fxml";

    private static final String searchStudentViewPath = "/View/StudentSearchView.fxml";

    private static final String courseScheduleViewPath = "/View/CourseScheduleView.fxml";

    private static final String createCourseViewPath = "/View/CreateNewCourseView.fxml";

    private static final String courseListViewPath = "/View/CourseListView.fxml";

    private static final String addStudentToCourseView = "/View/AddStudentToCourseView.fxml";

    private Stage secondaryStage = new Stage();

    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Start the application
     * @param primaryStage the primary stage
     * @throws IOException if the FXML file is not found
     */

    @Override
    public void start(Stage primaryStage) throws IOException {
        loadMainView(primaryStage);
    }

    /**
     * Load the add student view
     * @throws IOException if the FXML file is not found
     */

    public void loadAddStudentView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(addStudentViewPath));
        secondaryStage.setTitle("Course Registration System");
        secondaryStage.setScene(new Scene(root, 650, 400));
        secondaryStage.setResizable(false);
        secondaryStage.showAndWait();
    }

    /**
     * Load the main view
     * @param primaryStage the primary stage
     * @throws IOException if the FXML file is not found
     */

    public void loadMainView(Stage primaryStage) throws IOException {
        MainController controller = new MainController();
        controller.setMain(this);
        Parent root = FXMLLoader.load(getClass().getResource(mainViewPath));
        primaryStage.setTitle("Course Registration System");
        primaryStage.setScene(new Scene(root, 650, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /***
     * Load the student search view
     * @throws IOException if the FXML file is not found
     */

    public void loadStudentSearchView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(searchStudentViewPath));
        secondaryStage.setTitle("Student Information");
        secondaryStage.setScene(new Scene(root, 650, 458));
        secondaryStage.setResizable(true);
        secondaryStage.show();
    }

    /***
     * Load the course schedule view
     * @throws IOException if the FXML file is not found
     */

    public void loadCourseScheduleView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(courseScheduleViewPath));
        secondaryStage.setTitle("Course List");
        secondaryStage.setScene(new Scene(root,650,280));
        secondaryStage.show();
    }

    /**
     * Load the create course view
     * @throws IOException if the FXML file is not found
     */
    public void loadcreateCourseView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(createCourseViewPath));
        secondaryStage.setTitle("Create New Course");
        secondaryStage.setScene(new Scene(root, 650, 400));
        secondaryStage.show();
    }

    /**
     * Load the course list view
     * @throws IOException if the FXML file is not found
     */

    public void loadCourseListView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(courseListViewPath));
        secondaryStage.setTitle("Course List for Student");
        secondaryStage.setScene(new Scene(root, 650,450));
        secondaryStage.show();
    }

    /**
     * Load the add student to course view
     * @throws IOException if the FXML file is not found
     */

    public void loadAddStudentToCourseView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(addStudentToCourseView));
        secondaryStage.setTitle("Add Student to Course");
        secondaryStage.setScene(new Scene(root, 650, 400));
        secondaryStage.show();
    }
}
