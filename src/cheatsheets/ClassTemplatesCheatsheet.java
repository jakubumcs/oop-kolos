package cheatsheets;

import project.Candidate;

import java.util.ArrayList;
import java.util.List;

public class ClassTemplatesCheatsheet {

    /*
     * SCIAGAWKA: SZYBKIE SZABLONY KLAS OBIEKTOWYCH
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
record PersonRecord(String name) {
}

// 2. PROSTA KLASA Z PRYWATNYM POLEM
class SimpleBox {
    private String name;

    public SimpleBox(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// 3. KLASA Z LISTA
class TeamTemplate {
    private List<String> members = new ArrayList<>();

    public void addMember(String name) {
        members.add(name);
    }

    public List<String> copyMembers() {
        return new ArrayList<>(members);
    }
}

// 4. METODA STATYCZNA
class ParseTemplate {
    public static int fromText(String text) {
        return Integer.parseInt(text);
    }
}

// 5. PRZECIAZENIE METOD
class SummaryTemplate {
    public void summarize() {
        System.out.println("Wersja bez argumentu");
    }

    public void summarize(List<String> location) {
        System.out.println("Wersja z argumentem: " + location);
    }
}

// 6. NADPISANIE toString()
class ProductTemplate {
    private String name;
    private int amount;

    public ProductTemplate(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Nazwa: " + name + ", ilosc: " + amount;
    }
}

// 7. SZABLON KLASY PODOBNEJ DO TYCH Z PROJEKTU
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
        location.add("dolnośląskie");
        location.add("bolesławiecki");
        location.add("m. Bolesławiec");
        return new VoteTemplate(location);
    }
}
