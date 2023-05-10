package main.java.cicciofr.colloquioDiLavoro.viewSwing;

import javax.swing.*;

public class AnagraficaAskPannel {
    public static String[] anagraficaCandidatoAskPannel() {

        String nomeCandidato;
        do {
            nomeCandidato = JOptionPane.showInputDialog(null, "Inserisci il tuo nome");
        } while (nomeCandidato == null || nomeCandidato.trim().length() == 0 );

        String cognomeCandidato;
        do {
            cognomeCandidato = (JOptionPane.showInputDialog(null, "Inserisci il tuo cognome"));
        } while (cognomeCandidato == null || cognomeCandidato.trim().length() == 0);

        JOptionPane.showMessageDialog(null, "Benvenuto/a " + nomeCandidato, "CiccioFr s.r.l.", JOptionPane.PLAIN_MESSAGE, null);

        return new String[]{nomeCandidato, cognomeCandidato};
    }
}
