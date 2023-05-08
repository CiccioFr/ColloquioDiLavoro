package main.java.cicciofr.colloquioDiLavoro.controller;

import main.java.cicciofr.colloquioDiLavoro.entity.Questionario;
import main.java.cicciofr.colloquioDiLavoro.model.gestioneFile.GestioneFile;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
                        + ".\nPurtroppo al momento il tecnico è fuori sede, se si vuol accomodare. \nLa faremo rientrare appena torna dall'Andalusia." +
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
                // Cerca il file e ne inserisce il contenuto in una List, ponendo ogni riga in un bucket
                List<String> fileDomande = GestioneFile.getInstance().caricaFile("Questionari\\Domande" + ruolo + ".txt");

                if (fileDomande.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Non sono state trovate domande preimpostate", "Questionario Assente", JOptionPane.WARNING_MESSAGE);
                    System.exit(-1);
                }

                // test
                System.out.println("Domande da settate: " + fileDomande);
                // memo
                fileDomande.subList(2, 4);

                List<String> argomenti = fileDomande.stream().filter(text -> text.startsWith("##")).map(x -> x.substring(3)).toList();
                String arg = fileDomande.stream().filter(text -> text.startsWith("## ")).map(x -> x.substring(3)).findFirst().orElse("ciao");
                Map<Integer, String> argomentiMappati = fileDomande.stream().filter(text -> text.startsWith("##"))
                        .collect(Collectors.toMap(
                                fileDomande::indexOf,
                                text -> text.substring(3)
                        ));


                // creiamo variabili final, in quanto lo stream accetta solo tali tipi
                // la keyword final può essere omessa
                final List<String> finalFileDomande = fileDomande;
                String finalArgomento = argomento;
                List<Integer> indices = IntStream.range(0, fileDomande.size())
                        .filter(i -> Objects.equals(finalFileDomande.get(i), "## " + finalArgomento))
                        // .boxed() -> restituisce uno Stream costituito dagli elementi di questo stream, ciascuno racchiuso in un Integer
                        .boxed()
                        .toList();                //.collect(Collectors.toList());  // alias
                System.out.println("Indici: " + indices);

                List<String> coloriList = Arrays.asList("bianco", "rosso", "giallo", "blu", "verde");

                List<String> coloriStream = coloriList.stream().filter(colore -> {
//                    System.out.println("Colore: " + colore);
                    return colore.startsWith("g");
                }).toList();
                System.out.println(coloriStream);

                // verifico se esiste l'argomento, e catturo l'indice di posizione nella List
                int i;
                if ((i = fileDomande.indexOf("## " + argomento)) > 0) {
                    i++;
                    // ciclo List partendo dalla riga contente l'argomento
                    for (; i < fileDomande.size() - 1; i++) {
                        String domanda = String.valueOf(fileDomande.get(i).startsWith("1. "));

                        for (; i < fileDomande.size() - 1; i++) {

                            if (fileDomande.get(i).startsWith("---")) break;
                        }
                        if (fileDomande.get(i).startsWith("## ")) break;
                    }
                    cercaArgomento(argomento, fileDomande);
                } else {
                    argomento = "Argomento non trovato";
                    fileDomande = null;
                }

                quests = collezionaDomande(argomento, fileDomande);

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

    private static void cercaArgomento(String argomento, List<String> fileDomande) {
        System.out.println("Trovato Argomento " + argomento);
        for (int i = 0; i < fileDomande.size() - 1; i++) {
            if (fileDomande.get(i).startsWith("##")) {
                argomento = fileDomande.get(i);
//                line.

            }
        }
    }

}