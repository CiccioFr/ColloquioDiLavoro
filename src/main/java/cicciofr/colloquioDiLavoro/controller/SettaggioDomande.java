package main.java.cicciofr.colloquioDiLavoro.controller;

import main.java.cicciofr.colloquioDiLavoro.entity.Questionario;
import main.java.cicciofr.colloquioDiLavoro.model.gestioneFile.RicercaFile;

import javax.swing.*;
import java.util.Map;

public class SettaggioDomande {

    /**
     * Imposta le domande da porre al candidato
     *
     * @param ruolo         ruolo scelto dal candidato
     * @param argomento     Categorizzazione delle domande
     * @param nomeCandidato nome candidato
     * @return
     */
    public static Map<String, Questionario> setDomande(String ruolo, String argomento, String nomeCandidato) {
//        Ruolo role = Ruolo.getByDescrizione(ruolo);
//        Map<String, Questionario> quests = new HashMap<>();

        // In base al ruolo scelto dal candidato..
//        switch (role) {
        switch (ruolo) {
            case "Python Developer" -> {
                JOptionPane.showMessageDialog(null, "Molto interessante, Lei è qui per Python. La ringraziamo di essere passato " + nomeCandidato
                        + ".\nPerò purtroppo al momento il tecnico è fuori sede, se si vuol accomodare. \nLa faremo rientrare appena torna dall'Andalusia." +
                        "\n...\nCarla, tieni.. \ncarta da riciclo.", ruolo, JOptionPane.WARNING_MESSAGE);
//                System.out.println(PYTHON_DEVELOPER.getDescrizione());
                System.exit(-1);
            }
            case "Impiegato/a d'ufficio" -> {
                JOptionPane.showMessageDialog(null, "La ringraziamo di essere passato " + nomeCandidato
                        + ".\nPurtroppo al momento non ricerchiamo tale figura, \nCi deve essere stato un errore dell'uffiocio." +
                        "\nLa terremo comunque presente nel caso dovesse essere richiesta tale risorsa", ruolo, JOptionPane.WARNING_MESSAGE);
                System.exit(-1);
            }
            // Creazione del "Questionario"
            default -> {
                Map<String, Questionario> quests = RicercaFile.cercaFile(ruolo, argomento);

                return quests;
            }
        }

        // TODO - termine programma - Settare le domande
        System.exit(0);
        return null;
    }


}