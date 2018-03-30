package sample.Functions;

import javafx.beans.property.SimpleStringProperty;

public class Karten {
    private  SimpleStringProperty tclfrage;
    private  SimpleStringProperty tclantwort;

    public Karten(String frage1, String antwort1) {
        this.tclfrage = new SimpleStringProperty(frage1);
        this.tclantwort = new SimpleStringProperty(antwort1);
    }

    public String getTclfrage() {
        return tclfrage.get();
    }
    public void setTclfrage(String frage1) {
        tclfrage.set(frage1);
    }

    public String getTclantwort() {
        return tclantwort.get();
    }
    public void setTclantwort(String antwort1) {
        tclantwort.set(antwort1);
    }
}
