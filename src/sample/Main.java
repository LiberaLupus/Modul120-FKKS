package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Functions.DBConnector;
import sample.Functions.ResourceManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        DBConnector.databaseselect("select * from benutzer", "username");
        //DBConnector.databaseinsert("INSERT INTO benutzer(username, passwort) VALUES(?, ?)");
        Parent root = FXMLLoader.load(getClass().getResource("GUI_FXML/Login_FKKS.fxml"));
        primaryStage.setTitle("FKKS");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(1000);
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(1000);
        primaryStage.show();

        ResourceManager Ordner = new ResourceManager();
        Ordner.ordnerinhalt();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
