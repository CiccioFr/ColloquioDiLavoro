package main.java.cicciofr.colloquioDiLavoro;

import main.java.cicciofr.colloquioDiLavoro.controller.PosizioneLavorativa;
import main.java.cicciofr.colloquioDiLavoro.controller.SettaggioDomande;
import main.java.cicciofr.colloquioDiLavoro.entity.Candidato;
import main.java.cicciofr.colloquioDiLavoro.viewSwing.DomandaDialog;

public class ColloquioDiLavoro {
    public static void main(String[] args) {

        // settaggio del candidato (anagrafica e ruolo lavorativo)
        Candidato candidato = new Candidato();
        PosizioneLavorativa.setCandidatura(candidato);

        // TODO - Settaggio delle domande in base al ruolo scelto
        String domande = SettaggioDomande.setDomande(candidato.getRuolo(),"tutti", candidato.getNome());
        System.out.println("Domande settate dal main: " + domande);

        // TODO - impostare un ciclo per iterare tot domande

        String argomento = "", domanda = "";
        String risposta = DomandaDialog.poniDomanda(argomento, domanda);
        System.out.println("La risposta data: \n" + risposta);


    }
}
