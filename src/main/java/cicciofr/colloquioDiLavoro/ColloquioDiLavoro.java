package main.java.cicciofr.colloquioDiLavoro;

import javax.swing.*;

public class ColloquioDiLavoro {
    public static void main(String[] args) {

        Candidato candidato = new Candidato();
        candidato.setAnagraficaCandidato();
        candidato.setCandidatura();

        if (candidato.getRuolo().equals("Python Developer"))
            JOptionPane.showMessageDialog(null, "Tornatene a casa " + candidato.getNome(), "Ruolo scelto", JOptionPane.WARNING_MESSAGE);

        System.out.println(candidato.getRuolo());
    }
}
