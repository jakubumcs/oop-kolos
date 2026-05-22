package cheatsheets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsefulLibrariesCheatsheet {

    /*
     * SCIAGAWKA: PODSTAWOWE BIBLIOTEKI I KLASY, KTORE CZESTO SIE PRZYDAJA
     *
     * Biblioteka to gotowe narzedzia napisane przez kogos innego.
     * Ty nie musisz tworzyc wszystkiego od zera.
     * W Javie bardzo czesto korzysta sie z klas z pakietu java.util i java.lang.
     *
     * Najczesciej przydaja sie:
     * - Math
     * - Arrays
     * - Collections
     * - List / ArrayList
     * - Map / HashMap
     * - StringBuilder
     */

    public static void mathExample() {
        System.out.println(Math.max(8, 12)); // 12
        System.out.println(Math.sqrt(25)); // 5.0
        System.out.println(Math.round(4.6)); // 5
    }

    public static void arraysExample() {
        // Tablica przechowuje wiele elementow tego samego typu.
        int[] numbers = {5, 2, 9, 1};

        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers)); // [1, 2, 5, 9]
    }

    public static void collectionsExample() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(9);

        Collections.sort(numbers);
        System.out.println(numbers); // [2, 5, 9]

        System.out.println("Min: " + Collections.min(numbers)); // Min: 2
        System.out.println("Max: " + Collections.max(numbers)); // Max: 9
    }

    public static void listExample() {
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Jan");

        System.out.println(names.get(0)); // Anna
        System.out.println(names.size()); // 2
        System.out.println(names.contains("Jan")); // true
    }

    public static void mapExample() {
        Map<String, Integer> points = new HashMap<>();
        points.put("Anna", 12);
        points.put("Jan", 18);

        System.out.println(points.get("Anna")); // 12
        System.out.println(points.getOrDefault("Ola", 0)); // 0
        System.out.println(points.containsKey("Jan")); // true
    }

    public static void stringBuilderExample() {
        StringBuilder builder = new StringBuilder();

        builder.append("Linia 1");
        builder.append("\n");
        builder.append("Linia 2");

        System.out.println(builder.toString()); // Linia 1 \n Linia 2
    }

    public static void arraysAsListExample() {
        List<String> names = Arrays.asList("Anna", "Jan", "Ola");

        System.out.println(names); // [Anna, Jan, Ola]
    }

    public static void copyAndFillExample() {
        int[] values = new int[5];
        Arrays.fill(values, 7);

        System.out.println(Arrays.toString(values)); // [7, 7, 7, 7, 7]
    }
}
