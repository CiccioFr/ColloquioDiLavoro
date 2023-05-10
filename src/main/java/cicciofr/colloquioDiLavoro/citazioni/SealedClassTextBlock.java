package main.java.cicciofr.colloquioDiLavoro.citazioni;

public final class SealedClassTextBlock extends Madre {
    public static void main(String[] args) {
        String textBlock = """
                "cosa"
                "ciao"               "ok"       
                """;

        System.out.println("---");
        System.out.println(textBlock);
        System.out.println("---");
        System.out.println(madre);
        System.out.println("---");
    }
}

/**
 * Classe "sigillata"
 */
sealed class Madre permits SealedClassTextBlock {
    static String madre = "Classe Madre";
}