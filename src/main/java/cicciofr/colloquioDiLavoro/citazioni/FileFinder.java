package main.java.cicciofr.colloquioDiLavoro.citazioni;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class FileFinder {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Missing mandatory argument pattern");
            return;
        }

        String nameFile = args[0];

        String root = ".";
        if (args.length >= 1) {
            root = args[1];
        }

        File pathname = new File(root);
        if (!pathname.isDirectory()) {
            System.out.println("Directory " + root + " not found");
            return;
        }

        System.out.println("Searcing for file including \"" + nameFile + "\" intro directory: " + root);

        FileFinder finder = new FileFinder();   // FileFinder interfaccia
        List<File> listaFile = new ArrayList();
        finder.find(nameFile, pathname, listaFile);

        for (File file : listaFile) {
            System.out.println("Lista dei File: " + file.getParent() + " --> " + file.getName());
        }
    }

    public FileFinder() {

    }

    public void find(String nameFile, File pathName, List<File> lista) {
        // aggiungiamo alla lista i file locali alla directory pathname
        // che matchano il pattern specificato
        File[] listaFile = pathName.listFiles(new FileFilter() {  // FileFilter  interfaccia -> Anonymous Inner Class
            @Override
            public boolean accept(File pathname) {
                if (pathname.isFile()) {
                    if (pathname.getName().indexOf(nameFile) >= 0) {
                        return true;
                    }
                }
                return false;
            }
        });
        if (listaFile != null) {
            lista.addAll(Arrays.asList(listaFile));
        }

        // scorriamo ricorsivamente le directory
        File[] listaDir = pathName.listFiles(new FileFilter() {  // FileFilter  interfaccia -> Anonymous Inner Class
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        }); //    File[] listaDir = pathName.listFiles(pathname -> pathname.isDirectory());

        lista.addAll(Arrays.asList(listaFile));

        for (File dir : listaDir) {
            find(nameFile, dir, lista);
        }

    }

}

//  ----------------


/**
 * Lettura di un file con FileReader e BufferedReader
 */
class snippet {
    public static void main(String[] args) {
        String fileName = "domande.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}

/**
 * Creazione di un file con File
 * Scrittura con FileWriter
 */
class CreazioneFile {
    public static void main(String[] args) {
        try {
            // Creazione dell'oggetto File
            File file = new File("file3.txt");

            // Verifica se il file esiste già e lo elimina se necessario
            if (file.exists()) {
                file.delete();
            }

            // Creazione del nuovo file
            if (file.createNewFile()) {
                System.out.println("Il file è stato creato con successo.");
            } else {
                System.out.println("Il file non è stato creato.");
            }

            // Scrittura del contenuto nel file
            FileWriter writer = new FileWriter(file);
            writer.write("Questo è il contenuto del file.");
            writer.close();

        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante la creazione del file.");
            e.printStackTrace();
        }
    }
}

/**
 * Lettura di un file con File e Scanner
 */
class LeggiFile {
    public static void main(String[] args) {
        try {
            // Creazione dell'oggetto File
            File file = new File("domande.txt");

            // Lettura del contenuto del file
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato.");
            e.printStackTrace();
        }
    }
}

class LeggiFile2 {
    public static void main(String[] args) {
        File file = new File("file33.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato.");
//            e.printStackTrace();
        }
    }
}

class carattere {
    static char X;

    static {
        X = 1;
    }

    public static void main(String[] args) {
        Character k = '\u0001';
        System.out.println(k == X);

    }
}

class sequence {
    public static void main(String[] args) {
        int[] nr = {800, 101, 102, 300, 0};
        int sum = 0;

        for (int j = 0; j < nr.length; j++) {
            if (nr[j] == 0 || nr[j] >= 1000 || sum + nr[j] > 1000) {
                if (sum + nr[j] > 1000) {
                    sum += nr[j] - 1000;
                }
                break;
            }
            sum += nr[j];
        }
        System.out.println(sum);
    }
}

class JavaBrushup {
    public static void main(String[] args) {
        try {
            throw new Exception("Hello ");
        } catch (IOException e) {
            System.out.print(e.getMessage());
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } finally {
            System.out.println("World");
        }
    }
}

class PredicateExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Eva");

        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> endsWithVowel = s -> "aeiou".contains(s.substring(s.length() - 1));

        for (String name : names) {
            if (startsWithA.and(endsWithVowel).test(name)) {
                System.out.println(name);
            }
        }
    }
}

class stampaHashMapConLambda {
    public static void main(String[] args) {

        HashMap<String, List<String>> javaBooksAuthorsMap = new HashMap<>();
        javaBooksAuthorsMap.put("Head First Java", Arrays.asList("Kathy Sierra", "Bert Bates"));
        javaBooksAuthorsMap.put("Head First Java", Arrays.asList("ciccio"));
        javaBooksAuthorsMap.put("Effective Java", Arrays.asList("Joshua Bloch"));
        javaBooksAuthorsMap.put("OCA Java SE 8",
                Arrays.asList("Kathy Sierra", "Bert Bates", "Elisabeth Robson"));

        System.out.println(" // - HashMap: stampa - // ");
        System.out.println(javaBooksAuthorsMap);

        System.out.println(" // - HashMap: stampa con .entrySet() - // ");
        System.out.println(javaBooksAuthorsMap.entrySet());

        System.out.println(" // - HashMap: stampa con uso forEach() - // ");
        javaBooksAuthorsMap.forEach(
                (key, value) -> System.out.println(key + " => " + value + " "));

        System.out.println(" // - HashMap: stampa con uso forEach() con .entrySet(); - // ");
        javaBooksAuthorsMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

        System.out.println(" // - TreeMap: stampa con uso forEach() - // ");
        Map<Integer, String> nr = new TreeMap();
        nr.put(5, "parola");
        nr.put(2, "parola");
        nr.put(5, "word");
        nr.put(1, "lettera");
        nr.forEach((x, y) -> System.out.println(x + " -> " + y));
    }
}

// ----------

class GFG {
    public static void main(String[] args) {

        FileReader reader;

        try {

            // A Reader that reads creates an input
            // character stream
            // and reads characters from it
            reader = new FileReader("domande.txt");

            // Creating a BufferedReader object (instance)
            //  that 16Kb in buffer in the memory
            BufferedReader buffer = new BufferedReader(reader);

            // Custom input
            // A string to store the lines
            String line = "";

            // Maintaining real time count using
            // currentTimeMillis() method to get time taken
            // to read the data
            long initialTime = System.currentTimeMillis();
            while (true) {

                try {
                    // readLine() method of BufferedReader
                    // returns
                    //  a whole line at a time
                    line = buffer.readLine();
                }
                // Catch block to handle exceptions
                catch (IOException e) {

                    // Print the line where exception
                    // occurred
                    e.printStackTrace();
                }

                // When the read head reaches the "End Of
                // File" the readLine method returns null
                if (line == null)
                    break;

                // Prints the line
                System.out.println(line);
            }

            // New line
            System.out.println();

            // Display the time taken to read the data
            System.out.println("Time taken : " + (System.currentTimeMillis() - initialTime));

            // Try block to check exceptions
            try {
                // Close all the streams
                buffer.close();
                reader.close();
            }

            // Catching only exceptions those occurred
            // only during closing streams
            catch (IOException e) {
                // Prints the line number where exception
                // occurred
                e.printStackTrace();
            }
        }
        // Catch block
        catch (FileNotFoundException e) {
            // print the exception only if
            // the file not found
            e.printStackTrace();
        }
    }
}