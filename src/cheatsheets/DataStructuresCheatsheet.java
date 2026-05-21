package cheatsheets;

import project.Candidate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStructuresCheatsheet {

    /*
     * SCIAGAWKA: najwazniejsze struktury danych z projektu
     *
     * W tym projekcie najczesciej uzywalismy:
     * 1. List / ArrayList
     * 2. Map / HashMap
     *
     * LISTA:
     * - przechowuje wiele elementow w kolejnosci
     * - kazdy element ma indeks: 0, 1, 2, 3...
     * - dobra, gdy chcesz przechodzic po wszystkich elementach
     * - dobra, gdy kolejnosc ma znaczenie
     *
     * MAPA:
     * - przechowuje pary klucz -> wartosc
     * - np. Candidate -> liczba glosow
     * - dobra, gdy chcesz szybko znalezc wartosc dla konkretnego klucza
     *
     * Przyklady z projektu:
     * List<Candidate> candidates
     * List<Vote> votes
     * List<String> location
     * Map<Candidate, Integer> votesForCandidate
     */

    public static void listBasics() {
        // Lista to uporzadkowana kolekcja elementow dostepnych po indeksie.
        // Tworzenie pustej listy
        List<String> names = new ArrayList<>();

        // Dodawanie elementow na koniec listy
        names.add("Anna");
        names.add("Jan");
        names.add("Ola");

        // Wyswietlenie calej listy
        System.out.println(names);

        // Pobranie elementu po indeksie
        // Indeksy zaczynaja sie od 0
        System.out.println("Pierwszy element: " + names.get(0));

        // Rozmiar listy
        System.out.println("Liczba elementow: " + names.size());

        // Sprawdzenie, czy lista jest pusta
        System.out.println("Czy lista jest pusta: " + names.isEmpty());
    }

    public static void listLoop() {
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Jan");
        names.add("Ola");

        // Petla for-each sluzy do przejscia po wszystkich elementach kolekcji.
        // Najwygodniejsza petla do przejscia po wszystkich elementach
        for (String name : names) {
            System.out.println(name);
        }

        // Petla z indeksem jest przydatna, gdy liczy sie polozenie elementu.
        // Petla z indeksem, gdy indeks tez ma znaczenie
        for (int i = 0; i < names.size(); i++) {
            System.out.println("Indeks " + i + ": " + names.get(i));
        }
    }

    public static void listCopy() {
        List<String> original = new ArrayList<>();
        original.add("A");
        original.add("B");

        // Kopia listy daje nowa kolekcje, zeby nie pracowac na tym samym obiekcie listy.
        // Nowa lista, ale te same elementy
        List<String> copy = new ArrayList<>(original);

        System.out.println("Oryginal: " + original);
        System.out.println("Kopia: " + copy);
    }

    public static void listOfObjects() {
        List<Candidate> candidates = new ArrayList<>();

        candidates.add(new Candidate("Jan Kowalski"));
        candidates.add(new Candidate("Anna Nowak"));

        // Przejscie po obiektach na liscie
        for (Candidate candidate : candidates) {
            System.out.println(candidate.name());
        }
    }

    public static void mapBasics() {
        // Mapa przechowuje dane jako pary klucz -> wartosc.
        // Tworzenie pustej mapy
        Map<String, Integer> points = new HashMap<>();

        // Dodawanie par klucz -> wartosc
        points.put("Jan", 10);
        points.put("Anna", 20);
        points.put("Ola", 15);

        // Pobranie wartosci po kluczu
        System.out.println("Punkty Anny: " + points.get("Anna"));

        // Bezpieczne pobranie wartosci:
        // jesli klucza nie ma, zwraca wartosc domyslna
        System.out.println("Punkty Tomka: " + points.getOrDefault("Tomek", 0));

        // Rozmiar mapy
        System.out.println("Liczba wpisow: " + points.size());

        // Sprawdzenie czy mapa zawiera klucz
        System.out.println("Czy jest Anna: " + points.containsKey("Anna"));
    }

    public static void mapLoopByKeys() {
        Map<String, Integer> points = new HashMap<>();
        points.put("Jan", 10);
        points.put("Anna", 20);
        points.put("Ola", 15);

        // keySet() daje zbior kluczy, po ktorych mozna iterowac.
        // keySet() zwraca wszystkie klucze
        for (String name : points.keySet()) {
            System.out.println(name + " -> " + points.get(name));
        }
    }

    public static void mapLoopByValues() {
        Map<String, Integer> points = new HashMap<>();
        points.put("Jan", 10);
        points.put("Anna", 20);
        points.put("Ola", 15);

        // values() sluzy, gdy interesuja Cie same wartosci, np. do sumowania.
        // values() zwraca wszystkie wartosci
        int sum = 0;
        for (int value : points.values()) {
            sum += value;
        }

        System.out.println("Suma punktow: " + sum);
    }

    public static void mapLoopByEntries() {
        Map<String, Integer> points = new HashMap<>();
        points.put("Jan", 10);
        points.put("Anna", 20);
        points.put("Ola", 15);

        // entrySet() jest wygodne, bo masz od razu klucz i wartosc w jednym miejscu.
        // entrySet() daje od razu klucz i wartosc razem
        for (Map.Entry<String, Integer> entry : points.entrySet()) {
            System.out.println(entry.getKey() + " ma " + entry.getValue());
        }
    }

    public static void mapWithObjects() {
        Map<Candidate, Integer> votesForCandidate = new HashMap<>();

        Candidate c1 = new Candidate("Jan Kowalski");
        Candidate c2 = new Candidate("Anna Nowak");

        votesForCandidate.put(c1, 120);
        votesForCandidate.put(c2, 200);

        System.out.println("Glosy Jana: " + votesForCandidate.get(c1));
        System.out.println("Glosy Anny: " + votesForCandidate.get(c2));
    }

    public static void sumValuesFromMap() {
        Map<Candidate, Integer> votesForCandidate = new HashMap<>();

        Candidate c1 = new Candidate("Jan Kowalski");
        Candidate c2 = new Candidate("Anna Nowak");

        votesForCandidate.put(c1, 120);
        votesForCandidate.put(c2, 200);

        int sum = 0;
        for (int votes : votesForCandidate.values()) {
            sum += votes;
        }

        System.out.println("Suma wszystkich glosow: " + sum);
    }

    public static void findBiggestValue() {
        Map<String, Integer> points = new HashMap<>();
        points.put("Jan", 10);
        points.put("Anna", 20);
        points.put("Ola", 15);

        // To klasyczny wzor na wyszukanie najlepszego elementu w jednej petli.
        String bestName = null;
        int biggest = -1;

        for (String name : points.keySet()) {
            int current = points.get(name);
            if (current > biggest) {
                biggest = current;
                bestName = name;
            }
        }

        System.out.println("Najwieksza wartosc ma: " + bestName);
    }

    public static void typicalProjectPatterns() {
        /*
         * Najwazniejsze wzory z projektu:
         *
         * 1. Przejscie po liscie kandydatow:
         * for (Candidate candidate : candidates) { ... }
         *
         * 2. Suma wszystkich glosow z mapy:
         * int sum = 0;
         * for (int value : votesForCandidate.values()) {
         *     sum += value;
         * }
         *
         * 3. Pobranie glosow jednego kandydata:
         * votesForCandidate.get(candidate)
         *
         * 4. Bezpieczne pobranie, gdy klucza moze nie byc:
         * votesForCandidate.getOrDefault(candidate, 0)
         *
         * 5. Filtrowanie listy:
         * List<Vote> result = new ArrayList<>();
         * for (Vote vote : votes) {
         *     if (warunek) {
         *         result.add(vote);
         *     }
         * }
         *
         * 6. Szukanie maksimum:
         * Candidate best = null;
         * int biggest = -1;
         * for (Candidate candidate : candidates) {
         *     int current = summary.votes(candidate);
         *     if (current > biggest) {
         *         biggest = current;
         *         best = candidate;
         *     }
         * }
         */
    }
}
