package sample.Functions;

import javafx.scene.control.Button;

public class Seitenwechsel extends BaseController {

    public void wechsel(String scene, Button buttonname){
        try {
            closeStage(buttonname);
            Sceneloader myloader = new Sceneloader();
            myloader.loader(scene +"_FKKS");
        } catch (Exception java) {
            System.out.println(scene + "_FKKS.fxml wurde nicht gefunden");
        }
    }
}
