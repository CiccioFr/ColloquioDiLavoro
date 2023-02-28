package main.java.cicciofr.colloquioDiLavoro;

import javax.swing.JOptionPane;

public class Candidato {

    private String nome = "";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Candidato(String nome) {
        setNome(nome);
    }


    public static void candidatura() {
        String nomeCandidato = JOptionPane.showInputDialog(null, "Inserisci il tuo nome");
        Candidato candidato = new Candidato(nomeCandidato);
        JOptionPane.showMessageDialog(null,"Benvenuto/a " + nomeCandidato, "CiccioFr s.r.l.", -1, null);

    }
}
