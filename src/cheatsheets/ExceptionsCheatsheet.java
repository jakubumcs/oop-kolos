package cheatsheets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionsCheatsheet {

    /*
     * SCIAGAWKA: EXCEPTIONS / TRY-CATCH
     *
     * Wyjatek to sytuacja bledna lub szczegolna,
     * np. brak pliku, dzielenie przez zero, brak zwyciezcy.
     *
     * Najwazniejsze slowa:
     * - try
     * - catch
     * - throw
     * - throws
     *
     * Kiedy uzywac:
     * - gdy blad ma przerwac normalne dzialanie metody
     * - gdy chcesz obsluzyc sytuacje wyjatkowa osobno
     */

    public static void basicTryCatch() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("plik.txt"));
            br.close();
        } catch (IOException e) {
            // Tu trafiasz, jesli np. plik nie istnieje
            e.printStackTrace();
        }
    }

    public static void tryWithResources() {
        // Najwygodniejszy wzor do pracy z plikami
        try (BufferedReader br = new BufferedReader(new FileReader("plik.txt"))) {
            String line = br.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void throwExample(int x) {
        // throw = reczne rzucenie wyjatku
        if (x < 0) {
            throw new IllegalArgumentException("x nie moze byc ujemne");
        }
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Nie wolno dzielic przez zero");
        }
        return a / b;
    }

    public static void throwsExample() throws IOException {
        // throws w sygnaturze oznacza:
        // "ta metoda moze rzucic wyjatek dalej"
        BufferedReader br = new BufferedReader(new FileReader("plik.txt"));
        br.close();
    }

    public static void catchingMethodThatThrows() {
        try {
            throwsExample();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyCustomException extends RuntimeException {
    public MyCustomException() {
        super("Moj wlasny wyjatek");
    }
}

class CustomExceptionExample {

    /*
     * Wlasny wyjatek tworzysz przez osobna klase:
     *
     * class NoWinnerException extends RuntimeException { ... }
     *
     * Potem rzucasz go przez:
     * throw new NoWinnerException();
     */

    public static void methodThatMayFail(boolean ok) {
        if (!ok) {
            throw new MyCustomException();
        }
    }

    public static void testCustomException() {
        try {
            methodThatMayFail(false);
        } catch (MyCustomException e) {
            System.out.println("Obsluzono wlasny wyjatek");
        }
    }
}
