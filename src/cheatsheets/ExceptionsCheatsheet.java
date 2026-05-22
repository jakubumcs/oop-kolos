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
     * Gdy program trafia na wyjatek, normalny tok wykonania zostaje przerwany.
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
        // try to blok z kodem ryzykownym, a catch obsluguje blad, jesli wystapi.
        try {
            BufferedReader br = new BufferedReader(new FileReader("plik.txt"));
            br.close();
        } catch (IOException e) {
            // Tu trafiasz, jesli np. plik nie istnieje
            // Wtedy zobaczysz informacje o bledzie na konsoli.
            e.printStackTrace();
        }
    }

    public static void tryWithResources() {
        // try-with-resources sam zamyka zasob, np. plik, po zakonczeniu bloku.
        // Najwygodniejszy wzor do pracy z plikami
        try (BufferedReader br = new BufferedReader(new FileReader("plik.txt"))) {
            String line = br.readLine();
            System.out.println(line); // np. pierwsza linia pliku
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void throwExample(int x) {
        // throw = reczne rzucenie wyjatku
        if (x < 0) {
            throw new IllegalArgumentException("x nie moze byc ujemne");
        }
        // Dla x = -1 metoda przerwie dzialanie i rzuci blad.
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Nie wolno dzielic przez zero");
        }
        // Dla divide(10, 2) wynik to 5
        return a / b;
    }

    public static void throwsExample() throws IOException {
        // throws w sygnaturze oznacza:
        // "ta metoda moze rzucic wyjatek dalej", czyli nie obsluguje go tutaj.
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
    // Wlasny wyjatek pozwala nazwac konkretny problem biznesowy w kodzie.
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
            System.out.println("Obsluzono wlasny wyjatek"); // Obsluzono wlasny wyjatek
        }
    }
}
