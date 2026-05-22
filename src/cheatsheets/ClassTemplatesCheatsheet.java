package cheatsheets;

import project.Candidate;

import java.util.ArrayList;
import java.util.List;

public class ClassTemplatesCheatsheet {

    /*
     * SCIAGAWKA: SZYBKIE SZABLONY KLAS OBIEKTOWYCH
     *
     * Te przyklady pokazuja, jak wygladaja podstawowe klasy w Javie.
     * To sa gotowe wzory, ktore mozna pozniej przerobic pod swoje zadanie.
     *
     * Tu masz najczestsze gotowce:
     * - rekord
     * - klasa z polami
     * - konstruktor
     * - getter
     * - metoda statyczna
     * - przeciazanie metod
     * - toString
     */
}

// 1. REKORD
// Record to krotki zapis klasy, ktora glownie przechowuje dane.
record PersonRecord(String name) {
}

// 2. PROSTA KLASA Z PRYWATNYM POLEM
class SimpleBox {
    private String name;

    public SimpleBox(String name) {
        this.name = name;
    }

    public String getName() {
        // Dla obiektu new SimpleBox("Kot") wynik to "Kot"
        return name;
    }
}

// 3. KLASA Z LISTA
// Pole typu lista pozwala obiektowi przechowywac wiele elementow naraz.
class TeamTemplate {
    private List<String> members = new ArrayList<>();

    public void addMember(String name) {
        members.add(name);
        // Po addMember("Anna") lista members zawiera "Anna"
    }

    public List<String> copyMembers() {
        // Zwraca kopie listy, np. [Anna, Jan]
        return new ArrayList<>(members);
    }
}

// 4. METODA STATYCZNA
// Metoda statyczna nalezy do klasy, a nie do konkretnego obiektu.
class ParseTemplate {
    public static int fromText(String text) {
        // Dla "123" wynik to 123
        return Integer.parseInt(text);
    }
}

// 5. PRZECIAZENIE METOD
// Przeciazenie to kilka metod o tej samej nazwie, ale innych parametrach.
class SummaryTemplate {
    public void summarize() {
        System.out.println("Wersja bez argumentu"); // Wersja bez argumentu
    }

    public void summarize(List<String> location) {
        System.out.println("Wersja z argumentem: " + location); // np. Wersja z argumentem: [Mazowieckie, Warszawa]
    }
}

// 6. NADPISANIE toString()
// toString sluzy do czytelnego zamieniania obiektu na tekst.
class ProductTemplate {
    private String name;
    private int amount;

    public ProductTemplate(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        // Dla new ProductTemplate("Mleko", 3) wynik to "Nazwa: Mleko, ilosc: 3"
        return "Nazwa: " + name + ", ilosc: " + amount;
    }
}

// 7. SZABLON KLASY PODOBNEJ DO TYCH Z PROJEKTU
// To wzor klasy, ktora trzyma dane i ma metode fabrykujaca przykladowy obiekt.
class VoteTemplate {
    private List<String> location = new ArrayList<>();

    public VoteTemplate(List<String> location) {
        this.location = location;
    }

    public List<String> getLocation() {
        return location;
    }

    public static VoteTemplate createExample() {
        List<String> location = new ArrayList<>();
        location.add("dolnoslaskie");
        location.add("boleslawiecki");
        location.add("m. Boleslawiec");
        // Tworzy przykladowy obiekt z trzema elementami lokalizacji.
        return new VoteTemplate(location);
    }
}
