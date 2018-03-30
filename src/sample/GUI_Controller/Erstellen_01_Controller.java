package sample.GUI_Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Functions.DBConnector;
import sample.Functions.Seitenwechsel;

import java.util.List;

public class Erstellen_01_Controller extends Login_Controller{

    @FXML
    protected Button btnabbrechen, btnweiter;

    @FXML
    protected TextField txtfname;

    static String karteiname;

    @FXML
    public void btnabbrechenOA(ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("Bearbeiten_Auswaehlen", btnabbrechen);
    }

    @FXML
    public void btnweiterOA(ActionEvent event){
        List<String> listuserid = DBConnector.databaseselect("select * from benutzer where username = '" + username +"'","id");
        String userid = listuserid.get(0);
        DBConnector.databaseinsert1("insert into karteien (karteiname) values (?)", txtfname.getText());
        List<String> listkarteienid = DBConnector.databaseselect("select * from karteien where karteiname = '" + txtfname.getText() + "'","id");
        String karteienid = listkarteienid.get(0);
        DBConnector.databaseinsert2("insert into benutzerkarteien (benutzerfk, karteienfk) values (?, ?)", userid, karteienid);
        karteiname = txtfname.getText();
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("Erstellen_02", btnabbrechen);
    }
}
