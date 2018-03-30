package sample.GUI_Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import sample.Functions.DBConnector;
import sample.Functions.MessageBox;
import sample.Functions.ResourceManager;
import sample.Functions.Seitenwechsel;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Login_Controller {
    @FXML
    protected TextField txtfusername;

    @FXML
    protected TextField txtfpasswort;

    @FXML
    protected Button btnLogin;

    @FXML
    protected Button btnregistrieren;

    static String username;

    @FXML
    private void btnLoginOA(ActionEvent event) throws IOException {
        try{
            List<String> listpasswort = DBConnector.databaseselect("select * from benutzer where username = '" +txtfusername.getText() +"'","passwort");
            String passwort = listpasswort.get(0);
            String passwortA = txtfpasswort.getText();
            if (passwortA.equals(passwort)){
                username = txtfusername.getText();
                Seitenwechsel sceneload = new Seitenwechsel();
                sceneload.wechsel("Menu", btnLogin);
            }else {
                MessageBox MesBox = new MessageBox();
                MesBox.MessageBoxOK("Username oder Passwort falsch eingegeben.");
            }
        } catch (Exception java){
            MessageBox MesBox = new MessageBox();
            MesBox.MessageBoxOK("Username oder Passwort falsch eingegeben.");
        }


    }

    @FXML
    private void btnregistrierenOA(ActionEvent event) {
        try{
            Seitenwechsel sceneload = new Seitenwechsel();
            sceneload.wechsel("Register", btnregistrieren);
        }catch (Exception java){
            System.out.println("Register_FKKS.fxml wurde nicht gefunden");
        }

    }

}
