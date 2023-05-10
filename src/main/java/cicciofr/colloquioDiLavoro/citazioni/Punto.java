package main.java.cicciofr.colloquioDiLavoro.citazioni;

public class Punto {
    private int x = 0;
    private int y = 0;

    public Punto(int x, int y){
        setX(x);
        setY(y);
        System.out.println(getX() + " " + getY() + " " + getClass().getSimpleName());
    }

    // costruttore secondario OVERLOAD
    public Punto(int x){
        this(x, 1);
        setX(x * 2);
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void main(String[] args) {
        Punto p = new Punto(3);
        System.out.println(p.x + " " + p.y);
    }

}

class Doppio{

}