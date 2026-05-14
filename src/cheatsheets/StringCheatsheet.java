package cheatsheets;

public class StringCheatsheet {

    /*
     * SCIAGAWKA: OPERACJE NA STRINGACH
     *
     * String to tekst.
     *
     * Najczestsze operacje:
     * - split
     * - equals
     * - contains
     * - trim
     * - parseInt
     * - budowanie napisu
     */

    public static void splitExample() {
        String line = "Ala,ma,kota";
        String[] values = line.split(",");

        System.out.println(values[0]); // Ala
        System.out.println(values[1]); // ma
        System.out.println(values[2]); // kota
    }

    public static void equalsExample() {
        String a = "test";
        String b = "test";

        // Do porownywania tekstu uzywaj equals, nie ==
        if (a.equals(b)) {
            System.out.println("Napisy sa rowne");
        }
    }

    public static void containsExample() {
        String text = "Andrzej Sebastian DUDA";

        if (text.contains("DUDA")) {
            System.out.println("Tekst zawiera DUDA");
        }
    }

    public static void trimExample() {
        String text = "   kot   ";
        String cleaned = text.trim();

        System.out.println("[" + cleaned + "]");
    }

    public static void parseIntExample() {
        String text = "123";
        int number = Integer.parseInt(text);

        System.out.println(number + 1);
    }

    public static void toStringBuildingExample() {
        String result = "";

        result += "Linia 1\n";
        result += "Linia 2\n";
        result += "Linia 3\n";

        System.out.println(result);
    }

    public static void formatExample() {
        String name = "Jan Kowalski";
        double percentage = 54.3;

        String result = "Kandydat: " + name + ", procent: " + percentage;
        System.out.println(result);
    }
}
