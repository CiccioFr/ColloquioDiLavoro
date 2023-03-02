package main.java.cicciofr.colloquioDiLavoro;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public final class Candidatura {

    // private static String[] possibleRole = {"Seleziona ruolo", "Impiegato/a d'ufficio", "Java Developer", "Python Developer"};

    // costruttore vuoto PRIVATO per impedire l'istanza della classe
    private Candidatura() {
    }

    public static String setCandidatura(List<String> ruoliFonteEsterna) {

        List<String> ruoli = new ArrayList();

        // recupero l'elenco di ruoli dall'Enum Ruolo
        for (Ruolo ruolo : Ruolo.values()) {
            ruoli.add(ruolo.getDescrizione());
        }

        // recupero l'elenco di ruoli da una fonte esterna e li aggiungo alla mia lista già disponibile
        if (ruoliFonteEsterna != null) {
            ruoli.addAll(ruoliFonteEsterna);
        }

        // conversione elenco dei ruoli in Array da List
        String[] elencoRuoli = ruoli.toArray(new String[ruoli.size()]);

        // var contenitrice la scelta del candidato
        Object ruoloSelezionato;
        do {
            ruoloSelezionato = JOptionPane.showInputDialog(null,
                    "Seleziona il ruolo per il quale ti candidi", "Scelta del Ruolo",
                    JOptionPane.QUESTION_MESSAGE, null,
                    elencoRuoli, elencoRuoli[0]
            );
        }
        while (ruoloSelezionato.toString().equals(elencoRuoli[0]));

        return ruoloSelezionato.toString();
    }
}
