package main.java.cicciofr.colloquioDiLavoro.citazioni.esercizi;

public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal) {

//        if (bigCount < 0 || smallCount < 0 || goal < 0) return false;

        if (smallCount >= goal % 5) {
            return bigCount * 5 + smallCount >= goal;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(FlourPacker.canPack(1, 0, 4));
        System.out.println("--");
    }
}