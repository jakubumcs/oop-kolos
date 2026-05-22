package cheatsheets;

import java.util.ArrayList;
import java.util.List;

public class LoopsCheatsheet {

    /*
     * SCIAGAWKA: PETLE
     *
     * Petla sluzy do wielokrotnego wykonania tego samego kodu.
     * Zamiast pisac ten sam kod wiele razy, uzywasz petli.
     *
     * Najczestsze rodzaje petli:
     * - for
     * - while
     * - do while
     * - for-each
     * - break
     * - continue
     * - petla po indeksach
     */

    public static void forLoopExample() {
        // Klasyczna petla for jest dobra, gdy wiesz ile razy wykonac kod.
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i); // i = 0, potem 1, 2, 3, 4
        }
    }

    public static void whileLoopExample() {
        // while dziala tak dlugo, jak warunek jest prawdziwy.
        int counter = 0;

        while (counter < 5) {
            System.out.println("counter = " + counter); // counter = 0, potem 1, 2, 3, 4
            counter++;
        }
    }

    public static void doWhileExample() {
        // do while wykona sie co najmniej raz, nawet gdy warunek bedzie falszywy.
        int number = 0;

        do {
            System.out.println("number = " + number); // number = 0, potem 1, potem 2
            number++;
        } while (number < 3);
    }

    public static void forEachExample() {
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Jan");
        names.add("Ola");

        // for-each jest najwygodniejszy do przejscia po wszystkich elementach kolekcji.
        for (String name : names) {
            System.out.println(name); // Anna, potem Jan, potem Ola
        }
    }

    public static void loopWithIndex() {
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Jan");
        names.add("Ola");

        // Petla z indeksem przydaje sie, gdy potrzebujesz pozycji elementu.
        for (int i = 0; i < names.size(); i++) {
            System.out.println("Indeks " + i + ": " + names.get(i)); // Indeks 0: Anna itd.
        }
    }

    public static void breakExample() {
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                break;
            }
            System.out.println(i); // 0, 1, 2, 3
        }
    }

    public static void continueExample() {
        for (int i = 0; i < 6; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println(i); // 0, 1, 2, 4, 5
        }
    }

    public static void sumNumbersInLoop() {
        int sum = 0;

        for (int i = 1; i <= 5; i++) {
            sum += i;
        }

        System.out.println("Suma: " + sum); // Suma: 15
    }

    public static void countEvenNumbers() {
        int evenCount = 0;

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                evenCount++;
            }
        }

        System.out.println("Liczby parzyste: " + evenCount); // Liczby parzyste: 5
    }

    public static void nestedLoopsExample() {
        // Zagniezdzone petle sa przydatne np. do tabel, plansz i porownywania kazdego z kazdym.
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                System.out.println("Pole: " + row + ", " + column); // np. Pole: 0, 0
            }
        }
    }
}
