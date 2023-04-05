package main.java.cicciofr.colloquioDiLavoro.entity;

public enum Ruolo {
    SELEZIONA(""),
    IMPIEGATO(""),
    JAVA_DEVELOPER(""),
    PYTHON_DEVELOPER("");

    // di default sono static e final
    private String descrizione;

    // inizializzazione statica, in questo caso è proprio un di più
    static {
        SELEZIONA.descrizione = "Seleziona ruolo:";
        IMPIEGATO.descrizione = "Impiegato/a d'ufficio";
        JAVA_DEVELOPER.descrizione = "Java";
        PYTHON_DEVELOPER.descrizione = "Python Developer";
    }

    Ruolo(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}