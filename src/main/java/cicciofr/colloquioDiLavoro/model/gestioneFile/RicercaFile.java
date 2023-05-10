package main.java.cicciofr.colloquioDiLavoro.model.gestioneFile;

import main.java.cicciofr.colloquioDiLavoro.entity.Questionario;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RicercaFile {


    public static Map<String, Questionario> cercaFile(String ruolo, String argomento) {
        Map<String, Questionario> quests = new HashMap<>();

        // Cerca il file e ne inserisce il contenuto in una List, ponendo ogni riga in un bucket
        List<String> fileDomande = GestioneFile.getInstance().caricaFile("Questionari\\Domande " + ruolo + ".txt");

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


        // variabili final, in quanto lo stream accetta solo tali tipi
        // la keyword final può essere omessa
        final List<String> finalFileDomande = fileDomande;
        String finalArgomento = argomento;
        List<Integer> indices = IntStream.range(0, fileDomande.size())
                .filter(i -> Objects.equals(finalFileDomande.get(i), "## " + finalArgomento))
                // .boxed() -> restituisce uno Stream costituito dagli elementi di questo stream, ciascuno racchiuso in un Integer
                .boxed()
                .toList();                //.collect(Collectors.toList());  // alias
        System.out.println("Indici: " + indices);

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
