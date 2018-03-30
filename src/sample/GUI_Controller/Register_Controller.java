package sample.GUI_Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Functions.DBConnector;
import sample.Functions.MessageBox;
import sample.Functions.Seitenwechsel;

import java.util.List;

public class Register_Controller{

    @FXML
    protected TextField txtfusername;

    @FXML
    protected PasswordField txtfpasswort;

    @FXML
    protected PasswordField txtfpasswortW;

    @FXML
    protected Button btnabbrechen;

    @FXML
    protected Button btnregistrieren;

    @FXML
    private void btnabbrechenOA(javafx.event.ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("Login", btnabbrechen);
    }

    @FXML
    private void btnregistrierenOA(javafx.event.ActionEvent event){
        System.out.println(txtfusername.getText());
        if (!txtfusername.getText().matches("^[^\\d\\s]+$")) {
            MessageBox MesBox = new MessageBox();
            MesBox.MessageBoxOK("Sie müssen die Felder ausfüllen.");
        }else{
            try {
                List<String> listusername = DBConnector.databaseselect("select * from benutzer where username = '" + txtfusername.getText() + "'", "username");
                String username = listusername.get(0);
                MessageBox MesBox = new MessageBox();
                MesBox.MessageBoxOK("Dieser Username wird bereits gebraucht.");
            } catch (Exception Java) {
                if (txtfpasswort.getText().equals(txtfpasswortW.getText())) {
                    DBConnector.databaseinsert2("INSERT INTO benutzer(username, passwort) VALUES(?, ?)", txtfusername.getText(), txtfpasswort.getText());
                    Seitenwechsel sceneload = new Seitenwechsel();
                    sceneload.wechsel("Login", btnregistrieren);
                } else {
                    MessageBox MesBox = new MessageBox();
                    MesBox.MessageBoxOK("Passwörter müssen übereinstimmen.");
                }
            }
        }
    }

}








