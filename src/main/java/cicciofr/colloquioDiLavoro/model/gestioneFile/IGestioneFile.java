package main.java.cicciofr.colloquioDiLavoro.model.gestioneFile;

import java.io.File;
import java.io.Reader;
import java.util.List;

public interface IGestioneFile {

    List<String> caricaFile(String file);
    void salvaFile(String file);

}
