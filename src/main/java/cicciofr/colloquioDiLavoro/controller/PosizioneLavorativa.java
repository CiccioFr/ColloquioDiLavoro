package main.java.cicciofr.colloquioDiLavoro.controller;

import main.java.cicciofr.colloquioDiLavoro.entity.Candidato;
import main.java.cicciofr.colloquioDiLavoro.entity.Ruolo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe per la scelta del ruolo, con caricamento da file di ulteriori posizioni
 */
public final class PosizioneLavorativa {

    // private static String[] possibleRole = {"Seleziona ruolo", "Impiegato/a d'ufficio", "Java Developer", "Python Developer"};

    // costruttore vuoto PRIVATO per impedire l'istanza della classe
    private PosizioneLavorativa() {
    }

    /**
     * <p> Selezione del ruolo lavorativo a cui il candidato si propone. </p>
     * Carica un elenco di ruoli da un Enum e lo arricchisce con quelli disponibili in file esterno,
     * successivamente chiede all'utente di selezionare il ruolo ambito
     * @param candidato L'oggetto utente arricchito del ruolo scelto
     */
    public static void setCandidatura(Candidato candidato) {
        List<String> ruoli = new ArrayList();

        // recupero l'elenco di ruoli di default dall'Enum Ruolo
        for (Ruolo ruolo : Ruolo.values()) {
            ruoli.add(ruolo.getDescrizione());
        }

        // Recupero l'elenco di ruoli aggiuntivi col metodo addListaFile(); e li aggiungo alla mia lista già disponibile
        List<String> ruoliFonteEsterna = addListaFile();
        if (ruoliFonteEsterna != null) {
            ruoli.addAll(ruoliFonteEsterna);
        }

        // conversione elenco dei ruoli da List in Array - perchè JOptionPane accetta solo Array..?
        String[] elencoRuoli = ruoli.toArray(new String[ruoli.size()]);

        // scelta del ruolo da tendina, con valori dell'array elencoRuoli
        // loop se la scelta dell'utente non è valida
        Object ruoloSelezionato;
        do {
            ruoloSelezionato = JOptionPane.showInputDialog(null,
                    "Seleziona il ruolo per il quale ti candidi", "Scelta del Ruolo",
                    JOptionPane.QUESTION_MESSAGE, null,
                    elencoRuoli, elencoRuoli[0]
            );
        }
        while (ruoloSelezionato.toString().equals(elencoRuoli[0]));

        candidato.setRuolo(ruoloSelezionato.toString());
    }

    /**
     * <p> Metodo privato di servizio al metodo PosizioneLavorativa() </p>
     * Preleva un elenco di posizioni lavorative da un file
     * @return list di ruoli da aggiungersi all'elenco di default
     */
    private static List<String> addListaFile() {
        List<String> ruoliFonteEsterna = new ArrayList<>();

        // todo - Caricare Elenco da file
        // todo ......

        if (ruoliFonteEsterna.isEmpty()) {
//            ruoliFonteEsterna.add("Desolati, al momento non è in corso una ricerca attiva di personale");
        }

        return ruoliFonteEsterna;
    }
}
