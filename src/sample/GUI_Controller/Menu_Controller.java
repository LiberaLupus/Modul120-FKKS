package sample.GUI_Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Functions.ResourceManager;
import sample.Functions.Seitenwechsel;

import javax.swing.*;

public class Menu_Controller {

    @FXML
    protected ImageView ighintergrund;

    @FXML
    protected Button btnueben;

    @FXML
    protected Button btnbearbeiten;

    @FXML
    protected Button btnbeenden;


    public Menu_Controller(){

    }

    Image image;

    public void sethintergrund(){
        image = ResourceManager.loadImage("hintergrund.png");
        this.ighintergrund.setImage(image);
    }

    @FXML
    private void btnuebenOA(javafx.event.ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("Ueben_Auswahl", btnbearbeiten);
    }

    @FXML
    private void btnbearbeitenOA(javafx.event.ActionEvent event) {
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("Bearbeiten_Auswaehlen", btnbearbeiten);
    }

    @FXML   //Fertig
    private void btnbeendenOA(javafx.event.ActionEvent event) {
        int eingabe = JOptionPane.showConfirmDialog(null,
                "Möchten Sie sich auslogen?",
                "",
                JOptionPane.YES_NO_OPTION);
        System.out.println(eingabe);
        if (eingabe == 0){
            Seitenwechsel sceneload = new Seitenwechsel();
            sceneload.wechsel("Login", btnbeenden);
        }else{
            System.out.println(eingabe);
        }
    }

}
