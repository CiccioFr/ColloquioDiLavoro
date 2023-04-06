package main.java.cicciofr.colloquioDiLavoro.entity;

public enum Ruolo {
    SELEZIONA("Seleziona ruolo:"),
    IMPIEGATO(""),
    JAVA_DEVELOPER(""),
    PYTHON_DEVELOPER("");

    // di default sono static e final
    private String descrizione;

    // inizializzazione statica, in questo caso è proprio un di più
    static {
//        SELEZIONA.descrizione = "Seleziona ruolo:";
        IMPIEGATO.descrizione = "Impiegato/a d'ufficio";
        JAVA_DEVELOPER.descrizione = "Java Developer";
        PYTHON_DEVELOPER.descrizione = "Python Developer";
    }

    Ruolo(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * Ritorna il valore della Enum Costant
     * @return il valore associato alla Enum Costant
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Ritorna la Costante passandogli la descrizione
     * @param descrizione della enum constant
     * @return the enum constant
     */
    public static Ruolo getByDescrizione(String descrizione) {
        for (Ruolo ruolo : Ruolo.values()) {
            if (ruolo.getDescrizione().equals(descrizione)) {
                return ruolo;
            }
        }
        return null;
    }
}