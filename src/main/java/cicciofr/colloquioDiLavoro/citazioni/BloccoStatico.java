package main.java.cicciofr.colloquioDiLavoro.citazioni;

public class BloccoStatico {

    static int finalValue = Integer.MAX_VALUE + 1;

    BloccoStatico() {
        System.out.println("costruttore ");
    }

    static void metodo() {
        System.out.println("Metodo statico");

    }

    public static void main(String[] args) {
        {
            System.out.println("NEL MAIN:");
        }
        BloccoStatico.metodo();
        BloccoStatico b = new BloccoStatico();

        System.out.println(" ---------- ");
        blocchetto:
        {
            System.out.println("blocchetto");
        }

        System.out.println("\n  ** SECONDO OGGETTO **");
        BloccoStatico b2 = new BloccoStatico();

        System.out.println(" - FINE main -");

        System.out.println("\n ---------- ");
        System.out.println("Integer.MAX_VALUE ->\t  " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE ->\t " + Integer.MIN_VALUE);
        System.out.println("Integer.MAX_VALUE + 1 -> " + finalValue);
    }

    {
        System.out.println("  --> Instance Initialization Block <--");
    }


    static {
        System.out.println("Blocco Statico");
    }


//    BloccoStatico b = new BloccoStatico();
}
