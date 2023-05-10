package main.java.cicciofr.colloquioDiLavoro.citazioni;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MySingleton implements Cloneable{
    private static MySingleton instance;
    private static int conta = 0;
    int nr;

    // Costruttore privato per evitare l'istanziazione diretta della classe.
    private MySingleton() {
        System.out.println("Invocazione costruttore");
        conta++;
    }

    public synchronized static MySingleton getInstance() {
        if (instance == null)
            instance = new MySingleton();
        System.out.println("Stampa Singleton n. " + conta + " del metodo getInstance()");
        return instance;
    }

    public void faQualcosa() {
        System.out.println("Singleton n. " + conta);
    }

    public static void main(String args[]) throws ClassNotFoundException {
        // Creazione dell'oggetto
        MySingleton obj = MySingleton.getInstance();
        obj.faQualcosa();
        MySingleton obj2 = MySingleton.getInstance();
        obj2.faQualcosa();
        obj.faQualcosa();
        obj.faQualcosa();

        Class.forName("main.java.cicciofr.colloquioDiLavoro.citazioni.MySingleton");
    }
}

// ----

class MainSingletonLazy {                        //per Class.forName
    public static void main(String[] args) throws ClassNotFoundException {

        SingletonNoLazy s1 = SingletonNoLazy.getInstance();
        // il costruttore verà invocato 1 sola volta
        SingletonLazy s2 = SingletonLazy.getInstance();

        Class.forName("main.java.cicciofr.colloquioDiLavoro.citazioni.SingletonLazy");

    }
}

class SingletonLazy {
    private SingletonLazy() {
        System.out.println("Invocato il costruttore");
    }

    public static SingletonLazy getInstance() {
        return ContenitoreIstanza.instance;
    }

    private static class ContenitoreIstanza {
        private static SingletonLazy instance = new SingletonLazy();
    }
}


// ------

class SingletonReflection {                        //per Class.forName
    public static void main(String[] args) throws ClassNotFoundException {

        //credits: Keval Patel on Medium
        SingletonLazy istanza1 = SingletonLazy.getInstance();

        //otteniamo una seconda istanza con la reflection
        SingletonLazy istanza2 = null;
        try {
            // ottiene riferimento alla classe
            Class<SingletonLazy> ref = SingletonLazy.class;
            // ottiene riferimento al costruttore
            Constructor<SingletonLazy> costruttore = ref.getDeclaredConstructor();
            // accessibilità
            costruttore.setAccessible(true);
            // uso
            istanza2 = costruttore.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } //fine reflection

        // per testare che le due istanze siano effettivamente diverse
        // facciamo riferimento al codice hash che è unico
        System.out.println("instance1 hashCode=" + istanza1.hashCode());
        System.out.println("instance2 hashCode=" + istanza2.hashCode());

        // output: due hash effettivamente diversi
    }
}


// ---

class MainSingletonNoLazy {                        //per Class.forName
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("main.java.cicciofr.colloquioDiLavoro.citazioni.SingletonNoLazy");
    }
}

class SingletonNoLazy {
    private SingletonNoLazy() {
        System.out.println("invocato costruttore no Lazy");
    }

    private static SingletonNoLazy instance = new SingletonNoLazy();

    public static SingletonNoLazy getInstance() {
        return instance;
    }
}



// ---

class MainSingletonSerializzazione {
    public static void main(String[] args) throws ClassNotFoundException {

        SingletonLazySerial istanza1 = SingletonLazySerial.getInstance();

        //otteniamo una seconda istanza con serializzazione / deserializzazione della prima
        //credits: Keval Patel on Medium
        try {
            ObjectOutput out = null;

            //  serializziamo
            out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
            out.writeObject(istanza1);
            out.close();

            //deserializziamo da file a un un oggetto
            // qui l'inghippo:
            // con questa operazione si va di fatto a creare un clone dell'istanza originale nell'oggetto istanza2
            ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
            SingletonLazySerial istanza2 = (SingletonLazySerial) in.readObject();
            in.close();

            System.out.println("instance1 hashCode=" + istanza1.hashCode());
            System.out.println("instance2 hashCode=" + istanza2.hashCode());

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}

class SingletonLazySerial implements Serializable {
    private SingletonLazySerial() {
        System.out.println("Invocato il costruttore");
    }

    public static SingletonLazySerial getInstance() {
        return ContenitoreIstanza.instance;
    }

    private static class ContenitoreIstanza {
        private static SingletonLazySerial instance = new SingletonLazySerial();
    }
}


// ---

class MainSingletonSerializzazioneEnum {
    public static void main(String[] args) throws ClassNotFoundException {

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;

        EnumSingleton istanza1 = EnumSingleton.INSTANCE;
        EnumSingleton istanza2 = EnumSingleton.INSTANCE;

        System.out.println("instance1 hashCode=" + istanza1.hashCode());
        System.out.println("instance2 hashCode=" + istanza2.hashCode());

        System.out.println(enumSingleton.getValue());
        enumSingleton.setValue(300);
        System.out.println(enumSingleton.getValue());

        EnumSingleton.f();
    }
}

enum EnumSingleton {
    INSTANCE;
    EnumSingleton() {
        System.out.println("ciao dal Costruttore Singleton dell'Enum");
    }

    public static void f() {}

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}