package cheatsheets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AlgorithmsCheatsheet {

    /*
     * SCIAGAWKA: ALGORYTMICZNE WZORY
     *
     * Algorytm to sposob rozwiazania zadania krok po kroku.
     * Te metody pokazuja najczestsze schematy, ktore wracaja w zadaniach.
     *
     * To sa najczestsze schematy zadan:
     * - suma
     * - maksimum
     * - dwa najwieksze
     * - filtrowanie
     * - kopiowanie
     * - procent
     */

    public static int sumList(List<Integer> numbers) {
        // Suma to dodanie wszystkich elementow do jednego wyniku.
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        // Dla listy [2, 4, 6] wynik to 12
        return sum;
    }

    public static int sumMapValues(Map<String, Integer> map) {
        // values() zwraca same wartosci z mapy, bez kluczy.
        int sum = 0;
        for (int value : map.values()) {
            sum += value;
        }
        // Dla mapy {A=2, B=3} wynik to 5
        return sum;
    }

    public static String findMaxKey(Map<String, Integer> map) {
        // Maksimum to najwieksza znaleziona wartosc podczas przejscia po danych.
        String bestKey = null;
        int biggest = -1;

        for (String key : map.keySet()) {
            int current = map.get(key);
            if (current > biggest) {
                biggest = current;
                bestKey = key;
            }
        }

        // Dla mapy {Jan=10, Anna=20, Ola=15} wynik to "Anna"
        return bestKey;
    }

    public static List<String> findTwoBiggest(List<String> names, Map<String, Integer> points) {
        // Tu szukasz dwoch najlepszych wynikow: pierwszego i drugiego miejsca.
        String first = null;
        String second = null;

        int biggest = -1;
        for (String name : names) {
            int current = points.get(name);
            if (current > biggest) {
                biggest = current;
                first = name;
            }
        }

        int secondBiggest = -1;
        for (String name : names) {
            int current = points.get(name);
            if (!name.equals(first) && current > secondBiggest) {
                secondBiggest = current;
                second = name;
            }
        }

        List<String> result = new ArrayList<>();
        result.add(first);
        result.add(second);
        // Dla punktow Jan=10, Anna=20, Ola=15 wynik to [Anna, Ola]
        return result;
    }

    public static List<Integer> filterGreaterThan(List<Integer> numbers, int threshold) {
        // Filtrowanie oznacza zostawienie tylko elementow spelniajacych warunek.
        List<Integer> result = new ArrayList<>();

        for (int number : numbers) {
            if (number > threshold) {
                result.add(number);
            }
        }

        // Dla [2, 7, 4, 9] i threshold = 5 wynik to [7, 9]
        return result;
    }

    public static List<String> copyList(List<String> original) {
        // Plytka kopia listy
        // Dla ["A", "B"] wynik tez wyglada jak ["A", "B"], ale to nowa lista.
        return new ArrayList<>(original);
    }

    public static double percentage(int part, int whole) {
        // Procent pokazuje, jaka czesc calosci stanowi dany fragment.
        if (whole == 0) {
            return 0;
        }
        // Dla 45 i 60 wynik to 75.0
        return (part / (double) whole) * 100;
    }

    public static boolean existsMoreThan50Percent(List<String> names, Map<String, Integer> points) {
        // To jest typowy wzor na sprawdzenie, czy ktos ma bezwzgledna wiekszosc.
        int sum = 0;
        for (int value : points.values()) {
            sum += value;
        }

        for (String name : names) {
            double percent = percentage(points.get(name), sum);
            if (percent > 50) {
                return true;
            }
        }

        // Zwraca true, jesli ktos ma ponad polowe wszystkich punktow.
        return false;
    }
}
