package main.java.cicciofr.colloquioDiLavoro;

import javax.swing.JOptionPane;

public class Candidato {

    private String nome = "";
    private String cognome = "";
    private String ruolo = "";

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
    }

    public Candidato(String nome, String cognome) {
        setNome(nome);
        setCognome(cognome);
    }

    public void setAnagraficaCandidato() {

        String nomeCandidato = JOptionPane.showInputDialog(null, "Inserisci il tuo nome");
        String cognomeCandidato = JOptionPane.showInputDialog(null, "Inserisci il tuo nome");

        setNome(nomeCandidato);
        setCognome(cognomeCandidato);

        JOptionPane.showMessageDialog(null, "Benvenuto/a " + nomeCandidato, "CiccioFr s.r.l.", JOptionPane.PLAIN_MESSAGE, null);
    }

    public void setCandidatura(){
        this.ruolo = Candidatura.setCandidatura(null);
    }
}