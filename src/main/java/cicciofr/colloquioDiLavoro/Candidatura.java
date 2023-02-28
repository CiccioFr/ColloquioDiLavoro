package main.java.cicciofr.colloquioDiLavoro;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Candidatura {

    private static String[] possibleRole = {"Seleziona ruolo", "Impiegato/a d'ufficio", "Java Developer", "Python Developer"};

    public String[] getPossibleRole() {
        return possibleRole;
    }

    public void setPossibleRole(List<String> possibleRole) {
        List<String> newPossibleValues = new ArrayList();
        newPossibleValues.addAll(List.of(getPossibleRole()));
        newPossibleValues.addAll(possibleRole);
        this.possibleRole = newPossibleValues.toArray(new String[newPossibleValues.size()]);
    }

    public static String setCandidatura() {

        Object selectedValue;
        do {
            selectedValue = JOptionPane.showInputDialog(null,
                    "Seleziona il ruolo per il quale ti candidi", "Scelta del Ruolo",
                    JOptionPane.QUESTION_MESSAGE, null,
                    possibleRole, possibleRole[0]
            );
        } while (selectedValue.toString().equals(possibleRole[0]));

        return selectedValue.toString();
    }
}
