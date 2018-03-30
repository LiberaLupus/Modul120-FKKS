package sample.GUI_Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import sample.Functions.DBConnector;
import sample.Functions.Seitenwechsel;

import java.util.List;

public class Auswertung_Controller extends Ueben_Auswahl_Controller{

    @FXML
    protected PieChart pcauswertung;

    @FXML
    protected Button btnbeenden;

    private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

    @FXML
    private void btnbeendenOA(ActionEvent event){
        Seitenwechsel sceneload = new Seitenwechsel();
        sceneload.wechsel("Ueben_Auswahl", btnbeenden);
    }

    public void initialize(){
        List<String> listrichtigcount = DBConnector.databaseselect("select count(richtig) as r from karten as k inner join karteien as ka on k.karteienfk = ka.id where richtig = 1 and ka.karteiname = '"+ karteiname +"'","r");
        int richtigcount = Integer.parseInt(listrichtigcount.get(0));

        List<String> listfalschcount = DBConnector.databaseselect("select count(richtig) as f from karten as k inner join karteien as ka on k.karteienfk = ka.id where richtig = 0 and ka.karteiname = '"+ karteiname +"'","f");
        int falschcount = Integer.parseInt(listfalschcount.get(0));

        pieChartData.add(new PieChart.Data("Richtig", richtigcount));
        pieChartData.add(new PieChart.Data("Falsch", falschcount));
        pcauswertung.getData().addAll(pieChartData);

    }

}
