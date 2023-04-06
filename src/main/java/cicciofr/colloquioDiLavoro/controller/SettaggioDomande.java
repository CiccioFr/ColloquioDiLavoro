package main.java.cicciofr.colloquioDiLavoro.controller;

import main.java.cicciofr.colloquioDiLavoro.entity.Questionario;
import main.java.cicciofr.colloquioDiLavoro.model.gestioneFile.GestioneFile;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
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
        Map<String, Questionario> quests = new HashMap<>();

        // In base al ruolo scelto dal candidato..
//        switch (role) {
        switch (ruolo) {
            case "Python Developer" -> {
                JOptionPane.showMessageDialog(null, "Molto interessante, Lei è qui per Python. La ringraziamo di essere passato " + nomeCandidato
                        + ".\nPurtroppo al momento il tecnico è fuori sede, se si vuol accomodare, \nla faremo rientrare appena torna dall'Andalusia." +
                        "\n...\nCarla, tieni, carta da riciclo.", ruolo, JOptionPane.WARNING_MESSAGE);
//                System.out.println(PYTHON_DEVELOPER.getDescrizione());
                System.exit(-1);
            }
            case "Impiegato/a d'ufficio" -> {
                JOptionPane.showMessageDialog(null, "La ringraziamo di essere passato " + nomeCandidato
                        + ".\nPurtroppo al momento non ricerchiamo tale figura, \nCi deve essere stato un errore dell'uffiocio." +
                        "\nLa terremo comunque presente nel caso dovesse essere richiesta tale risorsa", ruolo, JOptionPane.WARNING_MESSAGE);
//                System.out.println(PYTHON_DEVELOPER.getDescrizione());
                System.exit(-1);
            }
            // Creazione del "Questionario"
            default -> {
                List<String> domande = GestioneFile.getInstance().caricaFile("Questionari\\Domande" + ruolo + ".txt");

                if (domande.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Non sono state trovate domande preimpostate", "Questionario Assente", JOptionPane.WARNING_MESSAGE);
                    System.exit(-1);
                }

                System.out.println("Domande da settate: " + domande);

                quests = collezionaDomande(argomento, domande);

            }
        }

        // TODO - termine programma - Settare le domande
        System.exit(0);

        return quests;
    }

    private static Map<String, Questionario> collezionaDomande(String argomento, List<String> domande) {
        Map<String, Questionario> quests = new HashMap<>(3);

        String arg = null;
        // TODO - creazione di una Collection HashMap di domande relative al ruolo (oggetti Record)
        quests.put(arg, new Questionario("a", "b", "c"));
        return null;
    }
}