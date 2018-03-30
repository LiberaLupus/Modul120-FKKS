package sample.GUI_Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Functions.DBConnector;
import sample.Functions.Karten;
import sample.Functions.ResourceManager;
import sample.Functions.Seitenwechsel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Bearbeiten_Bearbeiten_Controller extends Bearbeiten_Auswaehlen_Controller{
    @FXML
    protected Button btnhinzufuegen, btnbildspeichern, btnfertig;

    @FXML
    protected ImageView ivbild;

    @FXML
    protected TableView tblkartei;

    @FXML
    protected TableColumn tclfrage, tclantwort;

    @FXML
    protected TextField txtffrage, txtfantwort;

    @FXML
    protected ComboBox cbxbild;

    private ObservableList<Karten> data = FXCollections.observableArrayList();

    @FXML
    public void btnhinzufuegenOA(ActionEvent event){
        List<String> listkarteienid = DBConnector.databaseselect("select * from karteien where karteiname = '" + karteiname + "'","id");
        String karteienid = listkarteienid.get(0);
        DBConnector.databaseinsert2("insert into karten (frage, antwort, karteienfk) values (?, ?, "+ karteienid +")", txtffrage.getText(), txtfantwort.getText());
        //tblkartei.getItems().clear();
        //tblkartei.getSelectionModel().clearSelection();

        String frage = txtffrage.getText();
        String antwort = txtfantwort.getText();
        data.add(new Karten(frage, antwort));

        anzeige();

        txtffrage.setText("");
        txtfantwort.setText("");
    }

    @FXML
    public void btnfertigOA(ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("Bearbeiten_Auswaehlen", btnfertig);
    }

    @FXML
    protected void btnbildspeichernOA(ActionEvent event){
        try{
            DBConnector.databaseupdatebild("update karteien set foto = (?) where karteiname = '" + karteiname +"'", "C:\\FKKS-Bilder\\" + cbxbild.getValue());

        }catch (Exception sql){

        }
    }

    public void anzeige(){
        tclfrage.setCellValueFactory(
                new PropertyValueFactory<Karten,String>("tclfrage")
        );
        tclantwort.setCellValueFactory(
                new PropertyValueFactory<Karten,String>("tclantwort")
        );
        tblkartei.setItems(data);
    }

    @FXML
    public void initialize(){
        List<String> listfrage = DBConnector.databaseselect("select * from karten as k inner join karteien as kn on k.karteienfk = kn.id where karteiname ='" + karteiname +"'" ,"frage");
        List<String> listantwort = DBConnector.databaseselect("select * from karten as k inner join karteien as kn on k.karteienfk = kn.id where karteiname ='" + karteiname +"'","antwort");
        for (int i = 0 ; listantwort.size() > i; i++) {
            String frage = listfrage.get(i);
            String antwort = listantwort.get(i);
            data.add(new Karten(frage,antwort));
        }
        anzeige();

        ResourceManager bilder = new ResourceManager();
        File[] fileArray = bilder.ordnerinhalt();
        for(File element : fileArray) {
            System.out.println(element);
            String bildname = String.valueOf(element);
            String [] parts = bildname.split("\\\\");
            System.out.println(parts[2]);
            cbxbild.getItems().add(parts[2]);
        }

    }

    public void Bild(){
        try{
            List<String> listbild = DBConnector.databaseselect("select * from karteien where karteiname = '" + karteiname +"'","foto");
            String karteibild = listbild.get(0);
            Image image = new Image("C:\\FKKS-Bilder\\file:te.jpg");
            //image = ResourceManager.loadImage(karteibild);
            ivbild.getImage();
        }catch (Exception sql){

        }

    }
}
