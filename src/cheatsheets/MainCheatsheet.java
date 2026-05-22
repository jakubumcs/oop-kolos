package cheatsheets;

import project.Candidate;

import java.util.ArrayList;
import java.util.List;

public class MainCheatsheet {

    /*
     * SCIAGAWKA: JAK URUCHAMIAC KOD W MAIN
     *
     * Metoda main to miejsce startu programu.
     * Gdy uruchamiasz program w Javie, to Java zaczyna od:
     *
     * public static void main(String[] args)
     *
     * W main najczesciej:
     * - tworzysz obiekty przez new
     * - wywolujesz metody obiektowe
     * - wywolujesz metody statyczne
     * - wypisujesz wynik przez System.out.println(...)
     */

    public static void main(String[] args) {
        objectCreationExample();
        objectMethodExample();
        staticMethodExample();
        listOfObjectsExample();
        projectClassExample();
    }

    public static void objectCreationExample() {
        // new tworzy nowy obiekt.
        SimpleStudent student = new SimpleStudent("Ania", 20);

        System.out.println(student); // Student{name='Ania', age=20}
    }

    public static void objectMethodExample() {
        // Po stworzeniu obiektu mozesz wywolac jego metody przez kropke.
        SimpleStudent student = new SimpleStudent("Jan", 19);

        student.sayHello(); // Czesc, mam na imie Jan
        System.out.println(student.getAge()); // 19
    }

    public static void staticMethodExample() {
        // Metody statyczne wywolujesz na klasie, bez tworzenia obiektu.
        int result = Calculator.add(4, 7);

        System.out.println(result); // 11
    }

    public static void listOfObjectsExample() {
        // Mozesz tez tworzyc wiele obiektow i trzymac je w liscie.
        List<SimpleStudent> students = new ArrayList<>();
        students.add(new SimpleStudent("Ola", 18));
        students.add(new SimpleStudent("Tomek", 21));

        for (SimpleStudent student : students) {
            System.out.println(student.getName()); // Ola, potem Tomek
        }
    }

    public static void projectClassExample() {
        // Tak samo dziala to dla klas z projektu.
        Candidate candidate = new Candidate("Jan Kowalski");

        System.out.println(candidate.name()); // Jan Kowalski
    }
}

class SimpleStudent {
    private String name;
    private int age;

    public SimpleStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Czesc, mam na imie " + name);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }
}
