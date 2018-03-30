package sample.GUI_Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import sample.Functions.DBConnector;
import sample.Functions.Seitenwechsel;

import java.util.List;

public class Ueben_Auswahl_Controller extends Login_Controller{

    @FXML
    protected ComboBox cbxauswahll;

    @FXML
    protected Button btnabbrechen, btnstart;

    static String karteiname;

    @FXML
    public void btnabbrechenOA(ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("Menu", btnabbrechen);
    }

    @FXML
    public void btnstartOA(ActionEvent event){
        String kartei = (String) cbxauswahll.getValue();
        try{
            karteiname = String.valueOf(cbxauswahll.getValue());
            Seitenwechsel sceneload = new Seitenwechsel();
            sceneload.wechsel("Ueben", btnstart);
        }catch (Exception java){

        }
    }

    @FXML
    public void initialize(){
        List<String> kaname = DBConnector.databaseselect("select * from karteien as k inner join benutzerkarteien as bk on k.id = bk.karteienfk inner join benutzer as b on bk.benutzerfk = b.id where b.username = '"+ username +"'","karteiname");
        for (String element : kaname) {
            cbxauswahll.getItems().add(element);
        }
    }
}
