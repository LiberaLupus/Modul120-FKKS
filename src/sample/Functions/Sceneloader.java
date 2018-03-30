package sample.Functions;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Sceneloader {
    public void loader(String sceneName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../GUI_FXML/" + sceneName + ".fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("FKKS");
        stage.setMaxHeight(600);
        stage.setMaxWidth(1000);
        stage.setMinHeight(600);
        stage.setMinWidth(1000);
        stage.setScene(new Scene(root1));
        stage.show();
    }


}
