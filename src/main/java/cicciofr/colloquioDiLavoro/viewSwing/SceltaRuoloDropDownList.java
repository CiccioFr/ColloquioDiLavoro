package main.java.cicciofr.colloquioDiLavoro.viewSwing;

import javax.swing.*;
import java.util.List;

public class SceltaRuoloDropDownList {
    public static String sceltaRuolo(List<String> ruoli) {

        // conversione elenco dei ruoli da List in Array - perchè JOptionPane accetta solo Array..?
        String[] elencoRuoli = ruoli.toArray(new String[ruoli.size()]);

        Object ruoloScelto;
        do {
            ruoloScelto = JOptionPane.showInputDialog(null,
                    "Seleziona il ruolo per il quale ti candidi", "Scelta del Ruolo",
                    JOptionPane.QUESTION_MESSAGE, null,
                    elencoRuoli, elencoRuoli[0]
            );
        }
        while (ruoloScelto.toString().equals(elencoRuoli[0]));

        return ruoloScelto.toString();
    }
}
