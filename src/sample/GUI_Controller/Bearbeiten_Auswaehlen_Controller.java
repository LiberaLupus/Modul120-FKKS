package sample.GUI_Controller;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import sample.Functions.*;

import java.util.ArrayList;
import java.util.List;

public class Bearbeiten_Auswaehlen_Controller extends Login_Controller {

    @FXML
    protected TableView tblkartei;

    @FXML
    protected TableColumn  tclfrage, tclantwort;

    @FXML
    protected ComboBox cbxauswahl;

    @FXML
    protected Button btnladen, btnloeschen, btnabbrechen, btnerstellen, btnanzeigen;

    static String karteiname;

    @FXML
    public void btnanzeigenOA(ActionEvent event){
        ObservableList<Karten> data = FXCollections.observableArrayList();
        tblkartei.getItems().clear();
        tblkartei.getSelectionModel().clearSelection();

        List<String> listfrage = DBConnector.databaseselect("select * from karten as k inner join karteien as kn on k.karteienfk = kn.id where karteiname ='" + cbxauswahl.getValue() +"'" ,"frage");
        List<String> listantwort = DBConnector.databaseselect("select * from karten as k inner join karteien as kn on k.karteienfk = kn.id where karteiname ='" + cbxauswahl.getValue() +"'","antwort");
        for (int i = 0 ; listantwort.size() > i; i++) {
            String frage = listfrage.get(i);
            String antwort = listantwort.get(i);
            data.add(new Karten(frage,antwort));
        }

        tclfrage.setCellValueFactory(
                new PropertyValueFactory<Karten,String>("tclfrage")
        );
        tclantwort.setCellValueFactory(
                new PropertyValueFactory<Karten,String>("tclantwort")
        );
        tblkartei.setItems(data);
    }

    @FXML
    public void btnladenOA(ActionEvent event){
        String kartei = (String) cbxauswahl.getValue();
        try{
            karteiname = String.valueOf(cbxauswahl.getValue());
            Seitenwechsel sceneload = new Seitenwechsel();
            sceneload.wechsel("Bearbeiten_Bearbeiten", btnladen);
        }catch (Exception java){

        }
    }

    @FXML
    public void btnloeschenOA(ActionEvent event){
        String kartei = (String) cbxauswahl.getValue();
            try {
                List<String> listid = DBConnector.databaseselect("select * from karteien where karteiname = '" + cbxauswahl.getValue() + "'", "id");
                String karteienfk = listid.get(0);
                DBConnector.databasedelete("delete from karten where karteienfk =" + karteienfk);
                DBConnector.databasedelete("delete from benutzerkarteien where karteienfk =" + karteienfk);
                DBConnector.databasedelete("delete from karteien where id =" + karteienfk);
                comboboxanzeige();

                Seitenwechsel sceneload = new Seitenwechsel();
                sceneload.wechsel("Bearbeiten_Auswaehlen", btnloeschen);
            } catch (Exception Java) {
                System.out.println("Error");
            }
    }

    @FXML
    public void btnabbrechenOA(ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("Menu", btnabbrechen);
    }

    @FXML
    public void btnerstellenOA(ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("Erstellen_01", btnerstellen);
    }

    @FXML
    public void initialize() {
        cbxauswahl.setTooltip(new Tooltip("Wähle eine Kartei aus."));
        comboboxanzeige();

        ResourceManager loader = new ResourceManager();
        loader.ordnerinhalt();
    }

    public void comboboxanzeige(){
        //cbxauswahl.setValue("");
        cbxauswahl.getItems().removeAll();
        List<String> kaname = DBConnector.databaseselect("select * from karteien as k inner join benutzerkarteien as bk on k.id = bk.karteienfk inner join benutzer as b on bk.benutzerfk = b.id where b.username = '"+ username +"'","karteiname");
        for (String element : kaname) {
            cbxauswahl.getItems().add(element);
        }
    }








}
