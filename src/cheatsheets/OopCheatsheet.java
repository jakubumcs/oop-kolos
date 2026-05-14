package cheatsheets;

public class OopCheatsheet {

    /*
     * SCIAGAWKA OOP:
     * - abstrakcja
     * - interfejs
     * - dziedziczenie
     *
     * To nie jest kod do uruchamiania w projekcie.
     * To sa krotkie wzory i przyklady do przypomnienia na egzamin.
     */

    public static void main(String[] args) {
        // Przyklad dziedziczenia i polimorfizmu
        Animal dog = new Dog();
        dog.makeSound();

        // Przyklad interfejsu
        Printable document = new Report();
        document.print();

        // Przyklad klasy abstrakcyjnej
        Shape shape = new Circle();
        System.out.println(shape.description());
        System.out.println(shape.area());
    }
}

/*
 * 1. DZIEDZICZENIE
 *
 * Dziedziczenie oznacza, ze jedna klasa przejmuje pola i metody innej klasy.
 *
 * Slowo kluczowe:
 * extends
 *
 * Schemat:
 * class Dziecko extends Rodzic
 *
 * Klasa dziecko:
 * - dostaje to, co ma rodzic
 * - moze dodac cos nowego
 * - moze nadpisac metode rodzica przez @Override
 */
class Animal {
    public void makeSound() {
        System.out.println("Jakis dzwiek");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Hau hau");
    }
}

/*
 * Najwazniejsze rzeczy przy dziedziczeniu:
 *
 * 1. extends = dziedziczenie po klasie
 * 2. @Override = nadpisanie metody z klasy nadrzednej
 * 3. Obiekt klasy potomnej mozna przypisac do typu klasy nadrzednej:
 *
 * Animal dog = new Dog();
 *
 * To jest polimorfizm:
 * zmienna ma typ Animal,
 * ale realny obiekt to Dog.
 */

/*
 * 2. INTERFEJS
 *
 * Interfejs opisuje, CO obiekt ma umiec robic,
 * ale nie musi mowic JAK to robi.
 *
 * Slowo kluczowe:
 * interface
 *
 * Klasa wdraza interfejs przez:
 * implements
 */
interface Printable {
    void print();
}

class Report implements Printable {
    @Override
    public void print() {
        System.out.println("Drukuje raport");
    }
}

/*
 * Najwazniejsze rzeczy przy interfejsach:
 *
 * 1. interface tworzy "umowe"
 * 2. implements oznacza, ze klasa musi zrobic metody z interfejsu
 * 3. Dobra sytuacja do interfejsu:
 *    gdy wiele roznych klas ma umiec robic te sama rzecz
 *
 * Przyklad:
 * Printable x = new Report();
 *
 * Zmienna ma typ interfejsu,
 * ale obiekt moze byc dowolna klasa implementujaca ten interfejs.
 */

/*
 * 3. ABSTRAKCJA
 *
 * Abstrakcja polega na tym, ze pokazujesz tylko wazne rzeczy,
 * a ukrywasz szczegoly implementacji.
 *
 * W Javie czesto robi sie to przez:
 * - klasy abstrakcyjne
 * - interfejsy
 *
 * Klasa abstrakcyjna:
 * - nie mozna tworzyc jej obiektow bezposrednio
 * - moze miec zwykle metody
 * - moze miec metody abstrakcyjne, ktore trzeba dopisac w klasie potomnej
 */
abstract class Shape {

    // Zwykla metoda - juz ma implementacje
    public String description() {
        return "To jest jakis ksztalt";
    }

    // Metoda abstrakcyjna - klasa potomna MUSI ja zaimplementowac
    public abstract double area();
}

class Circle extends Shape {
    @Override
    public double area() {
        double r = 2.0;
        return Math.PI * r * r;
    }
}

/*
 * Najwazniejsze rzeczy przy klasie abstrakcyjnej:
 *
 * 1. abstract class Nazwa
 * 2. Mozesz miec:
 *    - zwykle metody
 *    - pola
 *    - metody abstract
 * 3. Klasa dziedziczaca musi zaimplementowac metody abstract
 *
 * Przyklad:
 * Shape shape = new Circle();
 *
 * Nie mozna zrobic:
 * new Shape()
 *
 * bo Shape jest abstrakcyjne.
 */

/*
 * KIEDY CZEGO UZYWAC?
 *
 * 1. DZIEDZICZENIE
 * Uzyj, gdy jedna klasa jest szczegolnym przypadkiem drugiej.
 * Przyklad:
 * Dog jest rodzajem Animal
 *
 * 2. INTERFEJS
 * Uzyj, gdy rozne klasy maja miec wspolne zachowanie.
 * Przyklad:
 * Report, Invoice, Summary moga byc Printable
 *
 * 3. KLASA ABSTRAKCYJNA
 * Uzyj, gdy chcesz dac wspolna baze
 * i czesc kodu juz dostarczyc,
 * ale czesc zostawic do uzupelnienia klasom potomnym.
 */

/*
 * NAJKROTSZE SZABLONY NA EGZAMIN
 *
 * DZIEDZICZENIE:
 * class B extends A { }
 *
 * INTERFEJS:
 * interface X { void test(); }
 * class Y implements X {
 *     public void test() { }
 * }
 *
 * ABSTRAKCJA:
 * abstract class A {
 *     public abstract void test();
 * }
 * class B extends A {
 *     public void test() { }
 * }
 */
