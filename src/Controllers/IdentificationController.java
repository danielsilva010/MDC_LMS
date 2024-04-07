package Controllers;

import Main.Main;
import Utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IdentificationController implements SceneManager{

    private Main main;

    @FXML
    private TextField tfName;

    @FXML
    void go(ActionEvent event) {
        main.loadMainView(new Stage(), getName());
    }

    public String getName() {
        return tfName.getText();
    }

    @Override
    public void setMain(Main main) {
        this.main = main;
    }

}
