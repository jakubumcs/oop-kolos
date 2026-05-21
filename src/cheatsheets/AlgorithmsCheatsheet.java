package cheatsheets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AlgorithmsCheatsheet {

    /*
     * SCIAGAWKA: ALGORYTMICZNE WZORY
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
        return sum;
    }

    public static int sumMapValues(Map<String, Integer> map) {
        // values() zwraca same wartosci z mapy, bez kluczy.
        int sum = 0;
        for (int value : map.values()) {
            sum += value;
        }
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

        return result;
    }

    public static List<String> copyList(List<String> original) {
        // Plytka kopia listy
        return new ArrayList<>(original);
    }

    public static double percentage(int part, int whole) {
        // Procent pokazuje, jaka czesc calosci stanowi dany fragment.
        if (whole == 0) {
            return 0;
        }
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

        return false;
    }
}
