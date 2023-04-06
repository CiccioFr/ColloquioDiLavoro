package main.java.cicciofr.colloquioDiLavoro.model.gestioneFile;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestioneFile implements IGestioneFile {

    private static GestioneFile instance = null;

    private GestioneFile() {
    }

    public static synchronized GestioneFile getInstance() {
        if (instance == null) {
            instance = new GestioneFile();
        }
        return instance;
    }

    @Override
    public List<String> caricaFile(String pathFile) {

        List<String> contenutoFile = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                contenutoFile.add(line);
//                System.out.println(line);
            }
        } catch (IOException e) {
//            System.err.format("IOException: %s%n", e);
            JOptionPane.showMessageDialog(null, "File non trovato", "File not found", JOptionPane.WARNING_MESSAGE);
            System.exit(-1);
        }

//        File file = null;
//        try{
//            file = new File(pathFile);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//        String nomeFile = file.getName();
////        String nomeFile = file != null ? file.getName() : null;
//
//        if (file.exists()) {
//            System.out.println("Trovato: " + nomeFile);
//        }
//        if (file.isFile() ) {
//            System.out.println(nomeFile + " è un file.");
//        }
//
//        if (file.isDirectory()) {
//            System.out.println("Inserita una directory: " + file);
//            System.out.println(nomeFile+ "Directory e File contenuti: " + Arrays.toString(file.list()));
//        }
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                contenutoFile.add(line);
//            }
//        } catch (Exception e) {
////            System.err.format("IOException: %s%n", e);
//            e.printStackTrace();
//        }

        return contenutoFile;
    }

    @Override
    public void salvaFile(String file) {
    }

    private void pulisciString(String file) {

    }
}
