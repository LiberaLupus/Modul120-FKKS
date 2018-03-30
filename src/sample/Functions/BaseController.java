package sample.Functions;

import javafx.scene.control.Control;
import javafx.stage.Stage;

public class BaseController {

    protected void closeStage(Control guiElement){
        Stage stage = (Stage) guiElement.getScene().getWindow();
        stage.close();
    }

}
