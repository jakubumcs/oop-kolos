package cheatsheets;

public class MathCheatsheet {

    /*
     * SCIAGAWKA: PODSTAWOWE FUNKCJE MATEMATYCZNE I OPERACJE NA LICZBACH
     *
     * Najczestsze rzeczy:
     * - dodawanie, odejmowanie, mnozenie, dzielenie
     * - reszta z dzielenia
     * - dzielenie calkowite i dzielenie z wynikiem double
     * - zaokraglanie
     * - min, max, abs
     * - potegi, pierwiastki
     * - losowanie
     */

    public static void basicOperations() {
        int a = 10;
        int b = 3;

        System.out.println("Dodawanie: " + (a + b));
        System.out.println("Odejmowanie: " + (a - b));
        System.out.println("Mnozenie: " + (a * b));
        System.out.println("Dzielenie calkowite: " + (a / b));
        System.out.println("Reszta z dzielenia: " + (a % b));
    }

    public static void integerAndDoubleDivision() {
        int a = 10;
        int b = 3;

        // Gdy dzielisz int przez int, wynik tez jest int.
        int integerResult = a / b;

        // Rzutowanie na double pozwala zachowac czesc po przecinku.
        double doubleResult = a / (double) b;

        System.out.println("Wynik int: " + integerResult);
        System.out.println("Wynik double: " + doubleResult);
    }

    public static void incrementAndDecrement() {
        int counter = 5;

        counter++;
        System.out.println("Po zwiekszeniu: " + counter);

        counter--;
        System.out.println("Po zmniejszeniu: " + counter);
    }

    public static void compoundAssignments() {
        int score = 10;

        score += 5;
        score -= 2;
        score *= 3;
        score /= 2;

        System.out.println("Wynik koncowy: " + score);
    }

    public static void minMaxAbs() {
        int a = -12;
        int b = 7;

        System.out.println("Mniejsza liczba: " + Math.min(a, b));
        System.out.println("Wieksza liczba: " + Math.max(a, b));
        System.out.println("Wartosc bezwzgledna a: " + Math.abs(a));
    }

    public static void powersAndRoots() {
        double number = 16;

        System.out.println("Potega 2^5: " + Math.pow(2, 5));
        System.out.println("Pierwiastek z 16: " + Math.sqrt(number));
    }

    public static void rounding() {
        double value = 12.67;

        System.out.println("round: " + Math.round(value));
        System.out.println("floor: " + Math.floor(value));
        System.out.println("ceil: " + Math.ceil(value));
    }

    public static void percentageExample() {
        int part = 45;
        int whole = 60;

        double percent = (part / (double) whole) * 100;
        System.out.println("Procent: " + percent);
    }

    public static void averageExample() {
        int a = 4;
        int b = 7;
        int c = 9;

        double average = (a + b + c) / 3.0;
        System.out.println("Srednia: " + average);
    }

    public static void randomExample() {
        // Math.random() zwraca liczbe od 0.0 do prawie 1.0.
        double random = Math.random();

        // Losowanie liczby od 1 do 10.
        int randomFrom1To10 = (int) (Math.random() * 10) + 1;

        System.out.println("Losowy double: " + random);
        System.out.println("Losowy int 1-10: " + randomFrom1To10);
    }

    public static void circleAreaExample() {
        double radius = 5;
        double area = Math.PI * radius * radius;

        System.out.println("Pole kola: " + area);
    }
}
