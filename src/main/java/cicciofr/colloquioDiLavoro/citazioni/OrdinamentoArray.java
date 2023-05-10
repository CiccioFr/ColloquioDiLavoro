package main.java.cicciofr.colloquioDiLavoro.citazioni;

import java.util.Arrays;

public class OrdinamentoArray {
    public static void main(String[] args) {

        // Creazione dell'array di oggetti Persona da ordinare
        Persona[] persone = {
                new Persona("Mario", 20),
                new Persona("Luigi", 25),
                new Persona("Paolo", 18)
        };

        // Ordinamento dell'array di oggetti Persona in base al nome
        Arrays.sort(persone);

        // Stampa dell'array di oggetti Persona ordinato
        for (Persona persona : persone) {
            System.out.println(persona);
        }
    }
}

class Persona implements Comparable<Persona> {

    private String nome;
    private int eta;

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int compareTo(Persona altraPersona) {
        return this.nome.compareTo(altraPersona.nome);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", eta=" + eta +
                '}';
    }
}

class somma {

    public static void main(String[] args) {
        int x = 5;
        System.out.println(x++ + ++x - x-- - --x);
    }

}