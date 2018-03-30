package sample.GUI_Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Functions.DBConnector;
import sample.Functions.MessageBox;
import sample.Functions.Seitenwechsel;

import java.util.List;

public class Ueben_Controller extends Ueben_Auswahl_Controller{

    @FXML
    protected Label lblfrage;

    @FXML
    protected TextField txtfantwort;

    @FXML
    protected Button btnpruefen, btnabbrechen;

    Integer i = 0;

    private String frage;
    private String antwort;

    @FXML
    public void btnabbrechenOA(ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("Ueben_Auswahl", btnabbrechen);
    }

    @FXML
    public void btnpruefenOA(ActionEvent event){
        List<String> listkarteifk = DBConnector.databaseselect("select ka.id from karten as k inner join karteien as ka on k.karteienfk = ka.id where ka.karteiname = '"+ karteiname +"'","id");
        int karteifk = Integer.parseInt(listkarteifk.get(0));
        if (txtfantwort.getText().equals(antwort)){
            MessageBox MesBox = new MessageBox();
            MesBox.MessageBoxOK("Richtig");
            DBConnector.databaseupdaterichtigfalsch("update karten set richtig = (?) where frage ='" + frage + "' and karteienfk =" + karteifk, Boolean.TRUE);
        }else {
            MessageBox MesBox = new MessageBox();
            MesBox.MessageBoxOK("Falsch. Die richtige Antwort währe \""+ antwort +"\" gewesen.");
            DBConnector.databaseupdaterichtigfalsch("update karten set richtig = (?) where frage ='" + frage + "' and karteienfk =" + karteifk, Boolean.FALSE);
        }
        frageausgabe();
    }

    public void frageausgabe(){
        try{
            List<String> listfrage = DBConnector.databaseselect("select * from karten as k inner join karteien as ka on k.karteienfk = ka.id where ka.karteiname = '"+ karteiname +"'","frage");
            List<String> listantwort = DBConnector.databaseselect("select * from karten as k inner join karteien as ka on k.karteienfk = ka.id where ka.karteiname = '"+ karteiname +"'","antwort");
            frage = listfrage.get(i);
            antwort = listantwort.get(i);
            lblfrage.setText(frage);
            i++;
        }catch (Exception Java){
            Seitenwechsel sceneload = new Seitenwechsel();
            sceneload.wechsel("Auswertung", btnpruefen);
        }
        txtfantwort.setText("");
    }

    @FXML
    public void initialize(){
        frageausgabe();
    }
}
