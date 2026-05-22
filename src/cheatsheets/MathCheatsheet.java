package cheatsheets;

public class MathCheatsheet {

    /*
     * SCIAGAWKA: PODSTAWOWE FUNKCJE MATEMATYCZNE I OPERACJE NA LICZBACH
     *
     * Ta klasa jest zbiorem przykladow.
     * Kazda metoda pokazuje jedna rzecz.
     * Nic nie uruchomi sie samo, dopoki nie wywolasz danej metody.
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
        // int to typ liczbow calkowitych, czyli bez czesci po przecinku.
        int a = 10;
        int b = 3;

        System.out.println("Dodawanie: " + (a + b)); // Dodawanie: 13
        System.out.println("Odejmowanie: " + (a - b)); // Odejmowanie: 7
        System.out.println("Mnozenie: " + (a * b)); // Mnozenie: 30
        System.out.println("Dzielenie calkowite: " + (a / b)); // Dzielenie calkowite: 3
        System.out.println("Reszta z dzielenia: " + (a % b)); // Reszta z dzielenia: 1
    }

    public static void integerAndDoubleDivision() {
        int a = 10;
        int b = 3;

        // Gdy dzielisz int przez int, wynik tez jest int.
        int integerResult = a / b;

        // Rzutowanie na double pozwala zachowac czesc po przecinku.
        double doubleResult = a / (double) b;

        System.out.println("Wynik int: " + integerResult); // Wynik int: 3
        System.out.println("Wynik double: " + doubleResult); // Wynik double: 3.3333333333333335
    }

    public static void incrementAndDecrement() {
        int counter = 5;

        counter++;
        System.out.println("Po zwiekszeniu: " + counter); // Po zwiekszeniu: 6

        counter--;
        System.out.println("Po zmniejszeniu: " + counter); // Po zmniejszeniu: 5
    }

    public static void compoundAssignments() {
        // Te zapisy to skroty:
        // score += 5 oznacza score = score + 5
        int score = 10;

        score += 5;
        score -= 2;
        score *= 3;
        score /= 2;

        System.out.println("Wynik koncowy: " + score); // Wynik koncowy: 19
    }

    public static void minMaxAbs() {
        int a = -12;
        int b = 7;

        System.out.println("Mniejsza liczba: " + Math.min(a, b)); // Mniejsza liczba: -12
        System.out.println("Wieksza liczba: " + Math.max(a, b)); // Wieksza liczba: 7
        System.out.println("Wartosc bezwzgledna a: " + Math.abs(a)); // Wartosc bezwzgledna a: 12
    }

    public static void powersAndRoots() {
        double number = 16;

        System.out.println("Potega 2^5: " + Math.pow(2, 5)); // Potega 2^5: 32.0
        System.out.println("Pierwiastek z 16: " + Math.sqrt(number)); // Pierwiastek z 16: 4.0
    }

    public static void rounding() {
        double value = 12.67;

        System.out.println("round: " + Math.round(value)); // round: 13
        System.out.println("floor: " + Math.floor(value)); // floor: 12.0
        System.out.println("ceil: " + Math.ceil(value)); // ceil: 13.0
    }

    public static void percentageExample() {
        int part = 45;
        int whole = 60;

        double percent = (part / (double) whole) * 100;
        System.out.println("Procent: " + percent); // Procent: 75.0
    }

    public static void averageExample() {
        int a = 4;
        int b = 7;
        int c = 9;

        double average = (a + b + c) / 3.0;
        System.out.println("Srednia: " + average); // Srednia: 6.666666666666667
    }

    public static void randomExample() {
        // Math.random() zwraca liczbe od 0.0 do prawie 1.0.
        double random = Math.random();

        // Losowanie liczby od 1 do 10.
        int randomFrom1To10 = (int) (Math.random() * 10) + 1;

        System.out.println("Losowy double: " + random); // np. Losowy double: 0.42
        System.out.println("Losowy int 1-10: " + randomFrom1To10); // np. Losowy int 1-10: 7
    }

    public static void circleAreaExample() {
        double radius = 5;
        double area = Math.PI * radius * radius;

        System.out.println("Pole kola: " + area); // Pole kola: 78.53981633974483
    }
}
