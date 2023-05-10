package main.java.cicciofr.colloquioDiLavoro.citazioni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AnnoBisestile {
    public static void main(String[] varargs) {
        Scanner scanner = new Scanner(System.in);

        int[] anni = {1900, 1990, 2000, 5000, 2010, 2050, 2040, 2010};
        int[] anni2 = {1800, 1890, 1980, 2000, 2500, 2050, 2040, 2010, 2030};

        boolean correctInput = false;
        String values;

        //chiedo se l'utente vuole inserire un range di valori con cui riempire l'oggetto Bisestile b
        System.out.println("Ciao! Vuoi darmi dei valori?");
        values = scanner.nextLine();
        if ((values.equalsIgnoreCase("si") || values.equalsIgnoreCase("no"))) {
            correctInput = true;
        }

        //finchè non mi risponde si o no, continuo a chiederlo
        while (!correctInput) {
            System.out.println("Per favore, rispondi solo si o no. Vuoi darmi dei valori?");
            values = scanner.nextLine();
            if ((values.equalsIgnoreCase("si") || values.equalsIgnoreCase("no"))) {
                correctInput = true;
            }
        }

        //l'utente ha risposto sì quindi analizziamo il primo array chiedendogli gli input
        if (values.equalsIgnoreCase("si")) {
            System.out.println("Ok, inserisci un minimo: ");
            int min = scanner.nextInt();
            System.out.println("Bene, adesso inserisci un massimo: ");
            int max = scanner.nextInt();
            System.out.println("valori inseriti:\n min = " + min + "\n Max = " + max);

            Bisestile bWithValues = Bisestile.getInstanceWithValues(min, max);

            for (int i = 0; i < anni.length; i++) {
                System.out.println(anni[i] + " " + bWithValues.returnValue(anni[i]));
            } //fine del controllo + salvataggio del primo array

            //inizio controllo secondo array

            //gli chiedo se vuole pulire la cache
            System.out.println("Vuoi pulire la cache prima di controllare il secondo array?");
            values = scanner.next();

            correctInput = false;
            if ((values.equalsIgnoreCase("si") || values.equalsIgnoreCase("no"))) {
                correctInput = true;
            }

            //continuo a chiederlo finchè non risponde sì o no
            while (!correctInput) {
                System.out.println("Per favore, rispondi solo si o no. Vuoi pulire la cache?");
                values = scanner.next();
                if ((values.equalsIgnoreCase("si") || values.equalsIgnoreCase("no"))) {
                    correctInput = true;
                }
            }
            //nel caso in cui l'utente voglia eliminare la cache, la eliminiamo e controllo il secondo array, aggiungendo a bWithoutValues anni e risulat
            Bisestile.clearMap();

            Bisestile bWithoutValues = Bisestile.getInstance();

            for (int i = 0; i < anni2.length; i++) {
                System.out.println(anni2[i] + " " + bWithoutValues.returnValue(anni2[i]));
            }
            //nel caso in cui l'utente non voglia eliminarla, controlliamo e, in caso, aggiungiamo i valori non presenti
            if (values.equalsIgnoreCase("no")) {
                for (int i = 0; i < anni2.length; i++) {
                    System.out.println(anni2[i] + " " + bWithValues.returnValue(anni2[i]));
                }
            }
            //se l'utente non vuole inserire dei valori, istanziamo un oggetto vuoto e controlliamo i valori del primo array, aggiungendoglieli
        } else if (values.equalsIgnoreCase("no")) {
            Bisestile bWithoutValues = Bisestile.getInstance();

            for (int i = 0; i < anni.length; i++) {
                System.out.println(anni[i] + " " + bWithoutValues.returnValue(anni[i]));
            }
            //inizio controllo secondo array

            //gli chiedo se vuole pulire la cache
            System.out.println("Vuoi pulire la cache prima di controllare il secondo array?");
            values = scanner.next();

            correctInput = false;
            if ((values.equalsIgnoreCase("si") || values.equalsIgnoreCase("no"))) {
                correctInput = true;
            }

            //continuo a chiederlo finchè non risponde sì o no
            while (!correctInput) {
                System.out.println("Per favore, rispondi solo si o no. Vuoi pulire la cache?");
                values = scanner.next();
                if ((values.equalsIgnoreCase("si") || values.equalsIgnoreCase("no"))) {
                    correctInput = true;
                }
            }

            //se l'utente vuole cancellare la cache
            if (values.equalsIgnoreCase("si")) {
                Bisestile.clearMap();

                Bisestile bWithoutValuesNew = Bisestile.getInstance();

                for (int i = 0; i < anni2.length; i++) {
                    System.out.println(anni2[i] + " " + bWithoutValuesNew.returnValue(anni2[i]));
                }
            }

            //se l'utente non vuole cancellare la cache
            if (values.equalsIgnoreCase("no")) {
                for (int i = 0; i < anni2.length; i++) {
                    System.out.println(anni2[i] + " " + bWithoutValues.returnValue(anni2[i]));
                }
            }


        }
    }
}

class Bisestile {

    private static Bisestile bisestile;
    private HashMap<Integer, Boolean> mapBisestile;

    private Bisestile(int min, int max) {
        mapBisestile = new HashMap<>();
        someYearsBetween(min, max);

    }

    private Bisestile() {
        mapBisestile = new HashMap<>();
    }

    private void someYearsBetween(int min, int max) {
        for (int i = min; i <= max; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean storeValue = isBisestile(i);
            mapBisestile.put(i, storeValue);
        }
    }

    public static Bisestile getInstance() {
        if (bisestile == null) {
            bisestile = new Bisestile();
        }
        return bisestile;
    }

    public static Bisestile getInstanceWithValues(int min, int max) {
        if (bisestile == null) {
            bisestile = new Bisestile(min, max);
        }
        return bisestile;
    }

    public boolean isBisestile(int i) {
        if (i % 4 != 0) {
            return false;
        }
        if (i % 100 == 0 && !(i % 1000 == 0)) {
            return false;
        }
        return true;
    }

    public boolean returnValue(int i) {
        boolean value;
        if (mapBisestile.containsKey(i)) {
            value = mapBisestile.get(i);
            System.out.println("Ci sono");
            return value;
        }
        System.out.println("Ci sto mettendo 5 secondi a partire");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean storeValue = isBisestile(i);
        mapBisestile.put(i, storeValue);
        value = storeValue;
        System.out.println("Non ci sono");
        return value;
    }

    public static void clearMap() {
        bisestile = null;
    }
}

class Finalizable {
    private BufferedReader reader;

    public Finalizable() {
        InputStream input = this.getClass()
                .getClassLoader()
                .getResourceAsStream("file.txt");
        this.reader = new BufferedReader(new InputStreamReader(input));
    }

    public String readFirstLine() throws IOException {
        String firstLine = reader.readLine();
        return firstLine;
    }

    // other class members
    @Override
    public void finalize() {
        try {
            reader.close();
            System.out.println("Closed BufferedReader in the finalizer");
        } catch (IOException e) {
            // ...
        }
    }
}