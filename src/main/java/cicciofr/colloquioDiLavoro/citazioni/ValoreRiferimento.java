package main.java.cicciofr.colloquioDiLavoro.citazioni;

public class ValoreRiferimento {

    public static void main(String[] args) {

        /*   Passaggio per valore:   */
        int num = 100;
        passaggioValore(num);
        System.out.println("num: " + num); // output: num: 100

        /*   Passaggio per riferimento:   */
        Cittadino cit = new Cittadino("Italiano");
        Cittadino cit2 = cit;               // <- passaggio per reference
        cit2.setNaz("Cittadino del Mondo");
        System.out.println(cit.getNaz());   // "Cittadino del Mondo"
        System.out.println(cit2.getNaz());   // "Cittadino del Mondo"
        passaggioReference(cit2);
        System.out.println(cit.getNaz());   // "Cittadino Europeo"
        System.out.println(cit2.getNaz());   // "Cittadino Europeo"
    }

    static void passaggioValore(int num) {
        num = 5;
    }

    static void passaggioReference(Cittadino cit) {
        cit.setNaz("Cittadino Europeo");    // usa la reference dell'oggetto passato come parametro
        cit = new Cittadino("Alieno");  // nuova allocazione in memoria del nuovo oggetto
    }
}

class Cittadino {
    String naz;

    public Cittadino(String naz) {
        this.naz = naz;
    }

    public String getNaz() {
        return naz;
    }

    public void setNaz(String naz) {
        this.naz = naz;
    }
}
