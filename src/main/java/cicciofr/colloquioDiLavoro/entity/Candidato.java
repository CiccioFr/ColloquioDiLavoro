package main.java.cicciofr.colloquioDiLavoro.entity;

import javax.swing.*;

public class Candidato {

    private static int conteggioCandidati;
    private int id;
    private String nome;
    private String cognome;
    private String ruolo;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public Candidato() {
        id = ++conteggioCandidati;
        setAnagraficaCandidato();
    }

    public Candidato(String nome, String cognome) {
        id = ++conteggioCandidati;
        setNome(nome);
        setCognome(cognome);
    }

    private void setAnagraficaCandidato() {

        String nomeCandidato = JOptionPane.showInputDialog(null, "Inserisci il tuo nome");
        setNome(nomeCandidato);

        String cognomeCandidato = JOptionPane.showInputDialog(null, "Inserisci il tuo cognome");
        setCognome(cognomeCandidato);

//        JOptionPane.showMessageDialog(null, "Benvenuto/a " + nomeCandidato, "CiccioFr s.r.l.", JOptionPane.PLAIN_MESSAGE, null);
    }

}