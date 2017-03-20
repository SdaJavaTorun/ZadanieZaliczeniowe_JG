package com.sdajava.ProjectCompany;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GUI extends Company {

    private String fileName;


    public void controller() throws IOException, ClassNotFoundException{
        boolean flag = true;
        System.out.println("WITAMY W PROGRAMIE TWOJA FIRMA");
        while (flag){
            desktop();
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1 : showList(); break;
                case 2 : addEmployee(); break;
                case 3 : export(); break;
                case 4 : removeEmployee(); break;
                case 5 : editEmployee(); break;
                case 6 : additionalFunction(); break;
                case 7 : textFilesAdditionalFunction(); break;
                case 8 : programInfo(); break;
                case 9 : fileReName(); break;
                case 0 : System.out.println("KONIEC");flag = false; break;
            }
        }
    }
    public void programInfo(){
        System.out.println("Company Managment Turbo");
        System.out.println("Version 1.0");
        System.out.println("Author Jakub Gutkowski");
    }

    public void textFilesAdditionalFunction() throws IOException, ClassNotFoundException{
        objectExport(getFileName());
        System.out.println("PLIKI TEKSTOWE - FUNKCJE DODATKOWE");
        System.out.println("Ścieżka do pliku tekstowego to " + getFileName());
        System.out.println("WYBIERZ FUNKCJE Z KTÓREJ CHCESZ SKORZYSTAĆ");
        System.out.println("1 - Wyświetl pracownika o najdłuższym nazwisku");
        System.out.println("2 - Średnia płaca osób posiadających dzieci");
        System.out.println("3 - Zaszyfruj nazwiska osób o dochodzie powyżej średniej");
        System.out.println("4 - Stwórz tabele pracowników w pliku html");

        Scanner sc1 = new Scanner(System.in);
        int choice = sc1.nextInt();

        switch (choice) {
            case 1 : longestLastName(getFileName()); break;
            case 2 : avegareAgeWhenHavingChild(getFileName()); break;
            case 3 : lastNameCoding(getFileName()); break;
            case 4 : exportToHTML(getFileName()); break;
        }
    }


    public void additionalFunction() throws IOException{
        System.out.println("FUNKCJE DODATKOWE");
        System.out.println("WYBIERZ FUNKCJE Z KTÓREJ CHCESZ SKORZYSTAĆ");
        System.out.println("1 - Wyświetl listę pracowników o pensji powyżej podanej");
        System.out.println("2 - Średnia płaca w dziale");
        System.out.println("3 - Maksymalna pensja wśród kobiet oraz mężczyzn");
        System.out.println("4 - Średnia pensja w działach oraz stosunek ilości zatrudnionych kobiet do mężczyzn");
        System.out.println("5 - Stosunek ilości zatrudnionych kobiet do mężczyzn w całej firmie");
        System.out.println("6 - Zwiększ wszystkim pracownikom pensję o 10%");
        System.out.println("7 - Zwiększ wszystkim pracownikom pensję o podany procent [wpisz ułamek dziesiętny]");
        System.out.println("8 - Sortuj pracowników według Nazwiska");
        System.out.println("9 - Sortuj pracowników według wysokości pensji");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1 : salarySort() ; break;
            case 2 : System.out.println("Podaj numer działu"); Scanner sc1 = new Scanner(System.in); salaryAverage(sc.nextInt()); break;
            case 3 : salaryMax(); break;
            case 4 : showDep(); break;
            case 5 : salaryRatio(); break;
            case 6 : salaryRiseForAll(); break;
            case 7 : System.out.println("Podaj procent podyżki"); Scanner sc2 = new Scanner(System.in); salaryRiseForAll(sc2.nextFloat()); break;
            case 8 : System.out.println("Podaj sposób sortowania"); System.out.println("0 = rosnąco   1 = malejąco");Scanner sc3 = new Scanner(System.in);lastNameSort(sc3.nextInt()); break;
            case 9 : System.out.println("Podaj sposób sortowania"); System.out.println("0 = rosnąco   1 = malejąco");Scanner sc4 = new Scanner(System.in);salarySort(sc4.nextInt()); break;
        }
    }

    public void desktop(){

        System.out.println("WYBIERZ FUNKCJE Z KTÓREJ CHCESZ SKORZYSTAĆ");

        System.out.println("1 - Wyświetl listę pracowników");
        System.out.println("2 - Dodaj pracownika");
        System.out.println("3 - Eksport listy pracowników do pliku w postaci tekstu");
        System.out.println("4 - Usuń pracownika");
        System.out.println("5 - Edycja danych pracownika");
        System.out.println("6 - Funkcje dodatkowe");
        System.out.println("7 - Pliki tekstowe - dodatkowe funkcje");
        System.out.println("8 - Informacje o programie");
        System.out.println("9 - Zmień nazwę pliku docelowego");
        System.out.println("0 - Zakończ program");

    }
    public void fileReName(){
        System.out.println("Zmien nazwę pliku z którym będziemy pracować");
        System.out.println("Plik zostanie zapisany na Pulpicie");
        System.out.println("Podaj nazwę pliku docelowego bez rozszerzenia");
        Scanner sc = new Scanner(System.in);
        String file = sc.nextLine();
        setFileName("C://Users//RENT//Desktop//" +file+".txt");
    }

    public GUI(){
        this.fileName = "C://Users//RENT//Desktop//output.txt" ;
    }
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String filename) {
        this.fileName = filename;
    }


}

