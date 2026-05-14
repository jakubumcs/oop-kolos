package cheatsheets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvCheatsheet {

    /*
     * SCIAGAWKA: jak wczytywac CSV w Javie
     *
     * CSV to zwykly plik tekstowy, gdzie:
     * - kazdy wiersz to jedna linia pliku
     * - dane w jednej linii sa rozdzielone przecinkami
     *
     * Przyklad linii:
     * m. Boleslawiec,boleslawiecki,dolnoslaskie,450,1131,6465
     *
     * Po split(",") dostajesz:
     * values[0] = "m. Boleslawiec"
     * values[1] = "boleslawiecki"
     * values[2] = "dolnoslaskie"
     * values[3] = "450"
     * values[4] = "1131"
     * values[5] = "6465"
     *
     * Czyli:
     * 1. Otwierasz plik
     * 2. Czytasz go linia po linii
     * 3. Kazda linie dzielisz przez split(",")
     * 4. Z tablicy values bierzesz potrzebne kolumny
     * 5. Jesli kolumna ma liczbe, zamieniasz ja przez Integer.parseInt(...)
     *
     * Typowy schemat:
     *
     * try (BufferedReader br = new BufferedReader(new FileReader("plik.csv"))) {
     *     String line;
     *     while ((line = br.readLine()) != null) {
     *         String[] values = line.split(",");
     *     }
     * } catch (IOException e) {
     *     e.printStackTrace();
     * }
     */

    public static void readWholeFile(String path) {
        // Ten wariant pokazuje absolutne minimum:
        // - otworz plik
        // - przeczytaj kazda linie
        // - podziel linie na kolumny
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // Zmienna line bedzie przechowywala aktualnie przeczytany wiersz pliku
            String line;

            // Petla dziala tak dlugo, jak w pliku sa kolejne linie
            // br.readLine() zwraca:
            // - tekst linii, jesli cos jeszcze jest
            // - null, jesli plik sie skonczyl
            while ((line = br.readLine()) != null) {
                // split(",") rozdziela jedna linie na osobne kolumny
                String[] values = line.split(",");

                System.out.println("Cala linia: " + line);
                System.out.println("Liczba kolumn: " + values.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readWithoutHeader(String path) {
        // W wielu plikach CSV pierwsza linia to naglowek,
        // czyli nazwy kolumn, a nie dane.
        // Np.:
        // Gmina,Powiat,Wojewodztwo,Kandydat1,Kandydat2
        //
        // Jesli chcesz czytac tylko dane, to pierwsza linie trzeba pominac.
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            // Pierwsze readLine() tylko pobiera naglowek i go wyrzuca
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println("Pierwsza kolumna: " + values[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readSelectedColumns(String path) {
        // Ten wariant pokazuje jak wyciagnac konkretne kolumny po indeksie.
        //
        // Jesli wiesz, ze:
        // values[0] = gmina
        // values[1] = powiat
        // values[2] = wojewodztwo
        //
        // to mozesz je od razu zapisac do zmiennych o czytelnych nazwach.
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                // Wyciaganie konkretnych kolumn po indeksie
                String gmina = values[0];
                String powiat = values[1];
                String wojewodztwo = values[2];

                System.out.println("Wojewodztwo: " + wojewodztwo);
                System.out.println("Powiat: " + powiat);
                System.out.println("Gmina: " + gmina);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void convertTextToNumber(String path) {
        // Wszystko z pliku CSV po split(",") jest Stringiem.
        // Nawet jesli w pliku widzisz 450, to po wczytaniu to jest "450".
        //
        // Zeby robic obliczenia, trzeba zamienic tekst na liczbe.
        // Dla int uzywasz Integer.parseInt(...)
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                // Zamiana tekstu na liczbe
                int firstCandidateVotes = Integer.parseInt(values[3]);
                int secondCandidateVotes = Integer.parseInt(values[4]);

                System.out.println("Glosy kandydata 1: " + firstCandidateVotes);
                System.out.println("Glosy kandydata 2: " + secondCandidateVotes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sumNumericColumns(String path) {
        // Bardzo czesty przypadek:
        // pierwsze kolumny opisuja lokalizacje,
        // a kolejne kolumny to liczby, ktore chcesz zsumowac.
        //
        // W tym przykladzie zakladamy, ze:
        // values[0], values[1], values[2] to tekst
        // values[3] do values[length - 1] to liczby
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int sum = 0;

                // Start od 3, bo pierwsze trzy kolumny nie sa liczbami do sumowania
                for (int i = 3; i < values.length; i++) {
                    sum += Integer.parseInt(values[i]);
                }

                System.out.println("Suma glosow w wierszu: " + sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void templateForObjects(String path) {
        // To jest najwazniejszy wzor na egzamin:
        // - czytasz jedna linie
        // - rozbijasz ja na kolumny
        // - wyciagasz potrzebne dane
        // - tworzysz obiekt na podstawie tych danych
        //
        // W realnym zadaniu zamiast println zwykle robisz:
        // Vote vote = new Vote(...);
        // list.add(vote);
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                // Dane tekstowe
                String gmina = values[0];
                String powiat = values[1];
                String wojewodztwo = values[2];

                // Dane liczbowe
                int votes = Integer.parseInt(values[3]);

                // W tym miejscu tworzysz obiekt z danych z jednego wiersza
                // Np.:
                // Candidate c = new Candidate(values[0]);
                // Vote vote = new Vote(...);
                //
                // Kazdy obrot petli = jeden rekord z pliku
                System.out.println(
                        "Tu tworzysz obiekt na podstawie danych: "
                                + wojewodztwo + ", "
                                + powiat + ", "
                                + gmina + ", "
                                + votes
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
