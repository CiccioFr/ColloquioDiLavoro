package main.java.cicciofr.colloquioDiLavoro;

public enum Ruolo {
    SELEZIONA("Seleziona ruolo"),
    IMPIEGATO("Impiegato/a d'ufficio"),
    JAVA_DEVELOPER("Java Developer"),
    PYTHON_DEVELOPER("Python Developer");

    // di default sono static e final
    private String descrizione;

    // inizializzazione statica, in questo caso è proprio un di più
    static {
        SELEZIONA.descrizione = "Seleziona ruolo";
        IMPIEGATO.descrizione = "Impiegato/a d'ufficio";
        JAVA_DEVELOPER.descrizione = "Java Developer";
        PYTHON_DEVELOPER.descrizione = "Python Developer";
    }

    Ruolo(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}