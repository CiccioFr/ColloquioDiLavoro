package main.java.cicciofr.colloquioDiLavoro.controller;

import main.java.cicciofr.colloquioDiLavoro.entity.Ruolo;
import main.java.cicciofr.colloquioDiLavoro.model.gestioneFile.GestioneFile;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettaggioDomande {
    public static String setDomande(String ruolo,String argomento, String nomeCandidato) {

        record Questionario(String categoria, String domanda, String risposta) {
        }

        switch (ruolo) {
            case "Python Developer" -> {
                JOptionPane.showMessageDialog(null, "Molto interessante, Lei è qui per Python. La ringraziamo di essere passato " + nomeCandidato
                        + ".\nPurtroppo al momento il tecnico è fuori sede, se si vuol accomodare, \nla faremo rientrare appena torna dall'Andalusia." +
                        "\n...\nCarla, tieni, carta da riciclo.", ruolo, JOptionPane.WARNING_MESSAGE);
                System.out.println(Ruolo.PYTHON_DEVELOPER.getDescrizione());
                System.exit(-1);
            }
            default -> {
                System.out.println(ruolo);
                List<String> domande = GestioneFile.getInstance().caricaFile("Domande" + ruolo + ".txt");
                System.out.println("Domande settate da SettaggioDomande: " + domande);

                if (domande.isEmpty())
                    System.exit(-1);

                System.out.println("Domande settate da SettaggioDomande: " + domande);

                Map<String, Questionario> quests = new HashMap<>(3);
                String arg = null;


                quests.put(arg, new Questionario("a", "b", "c"));
            }
        }

        System.exit(0);

        return "parola";
    }
}

enum Level {
    LOW(1), MEDIUM(2), HIGH(3);

    // di default sono static e final
    private int descrizione;

    Level(int descrizione) {
        this.descrizione = descrizione;
    }

    public int getDescrizione() {
        return descrizione;
    }
}

class MyClass {
    public static void main(String[] args) {
        Level myVar = Level.MEDIUM;

        switch (myVar) {
            case LOW:
                System.out.println("Low level");
                break;
            case MEDIUM:
                System.out.println(Level.MEDIUM.getDescrizione());
                break;
            case HIGH:
                System.out.println("High level");
                break;
        }
    }

    public enum Mesi {
        GENNAIO,
        FEBBRAIO,
        MARZO,
        APRILE,
        MAGGIO,
        GIUGNO,
        LUGLIO,
        AGOSTO,
        SETTEMBRE,
        OTTOBRE,
        NOVEMBRE,
        DICEMBRE;

        public static Mesi valueOfIgnoreCase(String name) {
            for (Mesi mese : Mesi.values()) {
                if (mese.name().equalsIgnoreCase(name)) {
                    return mese;
                }
            }
            throw new IllegalArgumentException("Mese non valido: " + name);
        }
    }
}

