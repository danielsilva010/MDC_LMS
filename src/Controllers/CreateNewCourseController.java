package Controllers;

import Main.Main;
import Utils.SceneManager;

public class CreateNewCourseController implements SceneManager{

    private Main main;

    @Override
    public void setMain(Main main) {
        this.main = main;
    }
}
