package sample.Functions;

import javax.swing.*;

public class MessageBox {

    public void MessageBoxOK(String ausgabe){
        Object[] options = {"OK"};
        JOptionPane.showConfirmDialog(null,
                ausgabe,
                "",
                JOptionPane.DEFAULT_OPTION);
    }
}
