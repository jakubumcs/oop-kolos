package cheatsheets;

public class ParsingCheatsheet {

    /*
     * SCIAGAWKA: PARSING
     *
     * Parsing to zamiana tekstu na inny typ danych.
     * To bardzo czeste, gdy dane przychodza z pliku, klawiatury albo CSV.
     *
     * Najczestsze przypadki:
     * - String -> int
     * - String -> double
     * - String -> boolean
     * - rozbijanie tekstu przez split
     * - trim przed parsowaniem
     */

    public static void parseIntExample() {
        String text = "123";
        int number = Integer.parseInt(text);

        System.out.println(number + 1); // 124
    }

    public static void parseDoubleExample() {
        String text = "19.75";
        double value = Double.parseDouble(text);

        System.out.println(value * 2); // 39.5
    }

    public static void parseBooleanExample() {
        String text = "true";
        boolean flag = Boolean.parseBoolean(text);

        System.out.println(flag); // true
    }

    public static void trimBeforeParsing() {
        String text = "   42   ";

        int number = Integer.parseInt(text.trim());
        System.out.println(number); // 42
    }

    public static void splitAndParseNumbers() {
        String line = "10,20,30";
        String[] parts = line.split(",");

        int first = Integer.parseInt(parts[0]);
        int second = Integer.parseInt(parts[1]);
        int third = Integer.parseInt(parts[2]);

        System.out.println(first + second + third); // 60
    }

    public static void parseWithValidation() {
        String text = "150";

        if (text.matches("\\d+")) {
            int number = Integer.parseInt(text);
            System.out.println("Poprawna liczba: " + number); // Poprawna liczba: 150
        } else {
            System.out.println("To nie jest poprawna liczba calkowita");
        }
    }

    public static void parseCandidateLine() {
        String line = "Jan Kowalski;54;Warszawa";
        String[] parts = line.split(";");

        String name = parts[0];
        int age = Integer.parseInt(parts[1]);
        String city = parts[2];

        System.out.println("Imie i nazwisko: " + name); // Imie i nazwisko: Jan Kowalski
        System.out.println("Wiek: " + age); // Wiek: 54
        System.out.println("Miasto: " + city); // Miasto: Warszawa
    }
}
