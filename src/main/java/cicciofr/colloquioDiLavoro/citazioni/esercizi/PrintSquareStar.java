package main.java.cicciofr.colloquioDiLavoro.citazioni.esercizi;

public class PrintSquareStar {
    static void printSquareStar(int number) {
        if (number < 5) System.out.println("Invalid number");
        else {
            for (int currentRow = 0; currentRow < number; currentRow++) {
                int rowCount = number - 1;
                for (int currentColumn = 0; currentColumn < number; currentColumn++) {
                    if (currentRow == 0 || currentRow == number - 1 || currentColumn == 0 || currentColumn == number - 1 || currentRow == currentColumn || currentColumn == rowCount - currentRow) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void numberToWords(int number) {

        if (number < 0) System.out.println("Invalid number");

        int rev = reverse(number);
        System.out.println("rev is: " + rev);

        int count = getDigitCount(number);
        System.out.println("count: " + count);
        int countRev = getDigitCount(rev);
        System.out.println("countRev: " + countRev);

        while (rev > 0) {
            int nr = rev % 10;
            rev /= 10;

            switch (nr) {
                case 0 -> System.out.println("zero");
                case 1 -> System.out.println("one");
                case 2 -> System.out.println("two");
                case 3 -> System.out.println("three");
                case 4 -> System.out.println("four");
                case 5 -> System.out.println("five");
                case 6 -> System.out.println("six");
                case 7 -> System.out.println("seven");
                case 8 -> System.out.println("eight");
                case 9 -> System.out.println("nine");
                default -> throw new IllegalStateException("Unexpected value: " + number);
            }
        }

        while (count-- > countRev) {
            System.out.println("Zero");
        }

    }

    public static int reverse(int number) {
        int rev = 0;

        while (number != 0) {
            rev = rev * 10 + number % 10;
            number /= 10;
        }
        // Integer.signum(number)
        return rev;
    }

    public static int getDigitCount(int number) {
        int count = 0;

        if (number < 0)
            return -1;

        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 100;
        printSquareStar(n);
        System.out.println(" ---");

        numberToWords(n);

        System.out.println(" ---");
        System.out.println(n);

        System.out.println(" ---");
    }
}
