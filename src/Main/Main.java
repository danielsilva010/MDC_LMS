package Main;
import java.io.IOException;

import Controllers.AddStudentViewController;
import Controllers.StudentSearchController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage secondaryStage = new Stage();
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        loadMainView(primaryStage);
    }

    /**
     * Load the add student view
     * @throws IOException if the FXML file is not found
     */

    public void loadAddStudentView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/AddStudentView.fxml"));
        AddStudentViewController controller = new AddStudentViewController();
        controller.setMain(this);
        secondaryStage = new Stage();
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
        Parent root = FXMLLoader.load(getClass().getResource("/View/MainView.fxml"));
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
        StudentSearchController controller = new StudentSearchController();
        controller.setMain(this);
        Parent root = FXMLLoader.load(getClass().getResource("/View/StudentSearchView.fxml"));
        secondaryStage.setTitle("Student Information");
        secondaryStage.setScene(new Scene(root, 350, 200));
        secondaryStage.setResizable(false);
        secondaryStage.show();
    }

    
}
