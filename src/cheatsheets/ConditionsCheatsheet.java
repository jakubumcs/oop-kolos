package cheatsheets;

public class ConditionsCheatsheet {

    /*
     * SCIAGAWKA: WARUNKI
     *
     * Warunki pozwalaja podjac decyzje:
     * jesli cos jest prawda, wykonaj jeden kod,
     * a jesli nie, wykonaj inny.
     *
     * Najczestsze konstrukcje:
     * - if
     * - if else
     * - if else if else
     * - zlozone warunki
     * - switch
     * - operator warunkowy
     */

    public static void ifExample() {
        int age = 20;

        if (age >= 18) {
            System.out.println("Osoba pelnoletnia"); // Osoba pelnoletnia
        }
    }

    public static void ifElseExample() {
        int points = 45;

        if (points >= 50) {
            System.out.println("Zdane");
        } else {
            System.out.println("Niezdane"); // Niezdane
        }
    }

    public static void ifElseIfElseExample() {
        int score = 82;

        if (score >= 90) {
            System.out.println("Ocena: 5");
        } else if (score >= 75) {
            System.out.println("Ocena: 4"); // Ocena: 4
        } else if (score >= 50) {
            System.out.println("Ocena: 3");
        } else {
            System.out.println("Ocena: 2");
        }
    }

    public static void logicalOperatorsExample() {
        int age = 22;
        boolean hasId = true;

        if (age >= 18 && hasId) {
            System.out.println("Mozna wejsc"); // Mozna wejsc
        }

        if (age < 18 || !hasId) {
            System.out.println("Brakuje warunku");
        }
    }

    public static void compareStringsExample() {
        String answer = "tak";

        // Do porownywania String uzywaj equals, nie ==
        if (answer.equals("tak")) {
            System.out.println("Uzytkownik odpowiedzial tak"); // Uzytkownik odpowiedzial tak
        }
    }

    public static void switchExample() {
        int day = 3;

        switch (day) {
            case 1:
                System.out.println("Poniedzialek");
                break;
            case 2:
                System.out.println("Wtorek");
                break;
            case 3:
                System.out.println("Sroda"); // Sroda
                break;
            default:
                System.out.println("Inny dzien");
        }
    }

    public static void ternaryOperatorExample() {
        int points = 67;
        String result = points >= 50 ? "Zdane" : "Niezdane";

        System.out.println(result); // Zdane
    }

    public static void nullCheckExample() {
        String name = null;

        if (name == null) {
            System.out.println("Brak imienia"); // Brak imienia
        } else {
            System.out.println(name);
        }
    }
}
