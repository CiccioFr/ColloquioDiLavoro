package main.java.cicciofr.colloquioDiLavoro.citazioni;

public class Eredi {
    public static void main(String[] args) {
        Cane bau = new Cane("gigi"){
            @Override
            void movimento(){
                System.out.println("Si muove internamente");
            }
        };
        String nome = bau.nome;
        System.out.println(nome);
        bau.verso();
        bau.movimento();
    }
}

abstract class Animale {
    String nome = "senza nome";

    public Animale() {
    }

    Animale(String nome) {
        this.nome = nome;
    }

    void verso() {
        System.out.println("verso animale");
    }

    void movimento() {
        System.out.println("movimento");
    }

   abstract void abitazione();
}

class Cane extends Animale {

    public Cane(String nome) {
        this.nome = nome;
    }

    @Override
    void verso() {
        System.out.println("bau bau");
    }

    @Override
    void abitazione() {
        System.out.println("sono a casa");
    }
}