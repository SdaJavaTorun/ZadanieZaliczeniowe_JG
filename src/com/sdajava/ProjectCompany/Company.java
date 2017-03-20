package com.sdajava.ProjectCompany;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Company extends Employee {

    private List<Employee> list = new ArrayList<Employee>();

    public void exportToHTML(String file) throws IOException, ClassNotFoundException{
        String fileName = file;
        FileInputStream fileInput= new FileInputStream(fileName);
        InputStream bufferIn = new BufferedInputStream(fileInput);
        ObjectInputStream objectInput = new ObjectInputStream(bufferIn);
        Employee a =null;
        List<Employee> list2 = new ArrayList<Employee>();

        while (true) {
            try {
                a = (Employee)objectInput.readObject();
                list2.add(a);
            }
            catch (EOFException exc) {
                break;
            }
        }
        objectInput.close();
        File outputhtml = new File( "C://Users//RENT//Desktop//output.html" );
        PrintWriter pw = new PrintWriter(outputhtml);

        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("    <head>");
        pw.println("        <meta charset="+"utf-8"+">");
        pw.println("        <title>Company</title> ");
        pw.println("    </head>");
        pw.println("<body>");
        pw.println("<table>");
        pw.println("<thead>");
        pw.println("    <tr>");
        pw.println("        <th>Nazwisko</th>");
        pw.println("        <th>Imie</th>");
        pw.println("        <th>Plec</th>");
        pw.println("        <th>Numer Dzialu</th>");
        pw.println("        <th>Placa</th>");
        pw.println("        <th>Wiek</th>");
        pw.println("    </tr>");
        pw.println("</thead>");
        pw.println("<tbody>");

        for(Employee p : list2){

            pw.println("<tr>");

            pw.println("        <td>" + p.getLastName() + "</td>");
            pw.println("        <td>" + p.getName() + "</td>");
            pw.println("        <td>" + p.getGender() + "</td>");
            pw.println("        <td>" + p.getDepNumber() + "</td>");
            pw.println("        <td>" + p.getSalary() + "</td>");
            pw.println("        <td>" + p.getAge() + "</td>");

            pw.println("</tr>");
        }

        pw.println("</tbody>");
        pw.println("</table>");

        pw.close();
    }

    public void lastNameCoding(String file) throws ClassNotFoundException, IOException{
        String fileName = file;
        FileInputStream fileInput= new FileInputStream(fileName);
        InputStream bufferIn = new BufferedInputStream(fileInput);
        ObjectInputStream objectInput = new ObjectInputStream(bufferIn);
        Employee a =null; int n = 0; int suma = 0;
        List<Employee> list2 = new ArrayList<Employee>();

        while (true) {
            try {
                a = (Employee)objectInput.readObject();
                list2.add(a);
            }
            catch (EOFException exc) {
                break;
            }
        }

        for (Employee p : list2) {
            n++;
            suma += p.getSalary();
        }

        OutputStream fileOutput = new FileOutputStream(fileName);
        OutputStream bufferOut  = new BufferedOutputStream(fileOutput);
        ObjectOutput objectOutput = new ObjectOutputStream(bufferOut);

        for (Employee p : list2) {
            if (p.getSalary() > (float)(suma/n)){
                String nazwisko = "" + p.getLastName().charAt(0);
                for (int i = 1; i < p.getLastName().length() - 1; i++){
                    nazwisko += "*";
                }
                nazwisko += p.getLastName().charAt(p.getLastName().length()-1);
                p.setLastName(nazwisko);
            }
            objectOutput.writeObject(p);
        }

        objectOutput.close();
    }

    public void avegareAgeWhenHavingChild(String file) throws IOException, ClassNotFoundException{
        String fileName = file;
        FileInputStream fileInput= new FileInputStream(fileName);
        InputStream bufferIn = new BufferedInputStream(fileInput);
        ObjectInputStream objectInput = new ObjectInputStream(bufferIn);
        Employee a =null; int n = 0; int suma = 0;
        List<Employee> list2 = new ArrayList<Employee>();

        while (true) {
            try {
                a = (Employee)objectInput.readObject();
                list2.add(a);
            }
            catch (EOFException exc) {
                break;
            }
        }

        for (Employee p : list2) {
            if(p.getChildNumber() > 0){
                n++;
                suma += p.getAge();
            }
        }
        System.out.println("Średnia wieku osób posiadających dzieci to " + (suma/n) + " lat");
    }

    public void longestLastName(String file) throws IOException, ClassNotFoundException {
        String fileName = file;
        FileInputStream fileInput= new FileInputStream(fileName);
        InputStream bufferIn = new BufferedInputStream(fileInput);
        ObjectInputStream objectInput = new ObjectInputStream(bufferIn);

        Employee a =null;
        Employee longestLastName = new Employee();
        longestLastName.setLastName("a");
        List<Employee> list2 = new ArrayList<Employee>();

        while (true) {
            try {
                a = (Employee)objectInput.readObject();
                list2.add(a);
            }
            catch (EOFException exc) {
                break;
            }
        }

        Comparator<Employee> byLastNameLength = (e1, e2) -> Integer.compare(e1.getLastName().length(), e2.getLastName().length());
        System.out.println(list2.stream().max(byLastNameLength).get());

    }


    public void objectExport(String file) throws IOException {
        String fileName = file;

        OutputStream fileOutput = new FileOutputStream(fileName);
        OutputStream bufferOut  = new BufferedOutputStream(fileOutput);
        ObjectOutput objectOutput = new ObjectOutputStream(bufferOut);

        for (Employee p : list) {
            objectOutput.writeObject(p);
        }
        objectOutput.close();
    }

    public void salarySort(int order) throws FileNotFoundException {
        List<Employee> list2 = new ArrayList<Employee>();
        if (order == 0) {
            Comparator<Employee> bySalary = (e1, e2) -> Float.compare(e1.getSalary(), e2.getSalary());
            list2 = list.stream().sorted(bySalary).collect(Collectors.toList());;
        }
        else if (order == 1){
            Comparator<Employee> bySalary = (e1, e2) -> Float.compare(e2.getSalary(), e1.getSalary());
            list2 = list.stream().sorted(bySalary).collect(Collectors.toList());;
        }

        File output = new File( "C://Users//RENT//Desktop//output.txt" );
        PrintWriter pw = new PrintWriter(output);
        for(Employee p : list2){
            pw.println (p);
        }
        pw.close();
    }

    public void lastNameSort(int order) throws FileNotFoundException {
        List<Employee> list2 = new ArrayList<Employee>();
        if (order == 0) {
            Comparator<Employee> byLastName = (e1, e2) -> e1.getLastName().compareTo(e2.getLastName());
            list2 = list.stream().sorted(byLastName).collect(Collectors.toList());
        }
        else if (order == 1){
            Comparator<Employee> byLastName = (e1, e2) -> e2.getLastName().compareTo(e1.getLastName());
            list2 = list.stream().sorted(byLastName).collect(Collectors.toList());
        }
        File output = new File( "C://Users//RENT//Desktop//output.txt" );
        PrintWriter pw = new PrintWriter(output);
        for(Employee p : list2){
            pw.println (p);
        }
        pw.close();
    }

    public float salaryRiseForAll(float rise) {
        float riseTotal = 0; float riseTotalWoman = 0; float riseTotalMan = 0;
        for (Employee p : list){
            float a = p.getSalary();
            p.salaryRise(rise);
            float rise2 = p.getSalary() - a;
            riseTotal += rise2;
            if (p.getGender() == 'F') { riseTotalWoman += rise2;}
            else {riseTotalMan += rise2;}
        }
        System.out.println("Suma podwyżek = " + riseTotal);
        System.out.println("Stosunek podwyżek kobiet do podwyżek mężczyzn wynosi = " + (riseTotalWoman / riseTotalMan));
        return (riseTotalWoman / riseTotalMan);
    }

    public void showDep(){
        int n = 0; int m = 0; int k = 0;
        int woman1 = 0; int man1 = 0; int woman2 = 0; int man2 = 0; int woman3 = 0; int man3 =0;
        for (Employee p : list){
            switch (p.getDepNumber()){
                case 1 : n++;
                    if (p.getGender() == 'F') { woman1++; }
                    else {man1++;}
                    break;
                case 2 : m++;
                    if (p.getGender() == 'F') { woman2++; }
                    else {man2++;}
                    break;
                case 3 : k++;
                    if (p.getGender() == 'F') { woman3++; }
                    else {man3++;}
                    break;
            }
        }
        if (n > 0) {
            if (woman1 > man1){ System.out.println("W dziale 1 pracuje więcej kobiet");}
            else if (woman1 < man1){ System.out.println("W dziale 1 pracuje więcej mężczyzn");}
            else {System.out.println("W dziale 1 pracuje tyle kobiet co meżczyzn");}
            salaryAverage(1);
        }
        if (m > 0) {
            if (woman2 > man2){ System.out.println("W dziale 2 pracuje więcej kobiet");}
            else if (woman2 < man2){ System.out.println("W dziale 2 pracuje więcej mężczyzn");}
            else {System.out.println("W dziale 2 pracuje tyle kobiet co meżczyzn");}
            salaryAverage(2);
        }
        if (k > 0) {
            if (woman3 > man3){ System.out.println("W dziale 3 pracuje więcej kobiet");}
            else if (woman3 < man3){ System.out.println("W dziale 3 pracuje więcej mężczyzn");}
            else {System.out.println("W dziale 3pracuje tyle kobiet co meżczyzn");}
            salaryAverage(3);
        }

    }

    public void salaryRiseForAll(){
        for (Employee p : list){
            p.salaryRise((float) 0.1);
        }
    }

    public void salaryRatio(){
        float sumWoman = 0; float sumMan = 0;
        int n = 0; int m = 0;
        for (Employee p : list){
            if (p.getGender() == 'F'){
                sumWoman += p.getSalary();
                n++;
            }
            else if (p.getGender() == 'M'){
                sumMan += p.getSalary();
                m++;
            }
        }
        System.out.println("stosunku średniej płacy kobiet do średniej płacy mężczyzn= "
                + (sumWoman/n)/(sumMan/n));
    }

    public void salaryMax(){
        float maxMan = 0;  float maxWoman =0;
        for (Employee p : list){
            if (p.getGender() == 'M'){
                if (p.getSalary() > maxMan){
                    maxMan = p.getSalary();
                }
            }
            else if (p.getGender() == 'F'){
                if (p.getSalary() > maxWoman){
                    maxWoman = p.getSalary();
                }
            }

        }
        System.out.println("Penjsa Max Meżczyźni= " + maxMan);
        System.out.println("Penjsa Max Kobiety= " + maxWoman);
    }

    public void salaryAverage(int dep){

        double srednia; double suma = 0; int n = 0;
        for (Employee p : list){
            if (p.getDepNumber() == dep){
                suma += p.getSalary();
                n++;
            }
        }
        srednia = suma / n;
        System.out.println("Srednia pensja w dziale " + dep + " = " + srednia);
    }

    public void salarySort(){
        System.out.println("Podaj próg pensji");
        Scanner sc = new Scanner(System.in);
        float threshold = sc.nextFloat();
        int a = 0;
        for (Employee p : list){
            if (p.getSalary() >= threshold )
                a++;
        }
        System.out.println("Ilosc pracownikow z pensja powyżej " + threshold + " = " + a);
    }

    public void editEmployee(){
        showList();
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Wybierz numer pracownika do edycji");
        int a = sc.nextInt();
        list.get(a).showSpecial();
        if (list.get(a).getGender() == 'F'){
            System.out.println("Wybierz co chcesz edytować");
            System.out.println("1 - Last Name");
            System.out.println("2 - Married ('Yes' or 'No')");
            System.out.println("3 - Dep Number");
            System.out.println("4 - Salary");
            System.out.println("5 - Age");
            System.out.println("6 - Number of Children");;
            switch (sc.nextInt()){
                case 1 : list.get(a).setLastName(sc1.nextLine()); break;
                case 2 : if (sc1.nextLine().charAt(0) == 'Y')
                {list.get(a).setMarital(true); }
                else
                {list.get(a).setMarital(false);}
                    break;
                case 3 : list.get(a).setDepNumber(sc.nextInt()); break;
                case 4 : list.get(a).setSalary(sc.nextInt()); break;
                case 5 : list.get(a).setAge(sc.nextInt()); break;
                case 6 : list.get(a).setChildNumber(sc.nextInt()); break;
            }
        }
        else if (list.get(a).getGender() == 'M'){
            System.out.println("Wybierz co chcesz edytować");
            System.out.println("1 - Married ('Yes' or 'No')");
            System.out.println("2 - Dep Number");
            System.out.println("3 - Salary");
            System.out.println("4 - Age");
            System.out.println("5 - Number of Children");
            switch (sc.nextInt()){
                case 1 : if (sc1.nextLine().charAt(0) == 'Y')
                {list.get(a).setMarital(true); }
                else
                {list.get(a).setMarital(false);}
                    break;
                case 2 : list.get(a).setDepNumber(sc.nextInt()); break;
                case 3 : list.get(a).setSalary(sc.nextInt()); break;
                case 4 : list.get(a).setAge(sc.nextInt()); break;
                case 5 : list.get(a).setChildNumber(sc.nextInt()); break;
            }
        }
        System.out.println("Dane zostały zmienione");
    }

    public void removeEmployee(){
        showList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Wybierz numer pracownika do usunięcia");
        list.remove(sc.nextInt());
        System.out.println("Pracownik został usunięty");
    }

    public void export() throws FileNotFoundException{
        System.out.println("Plik zostanie zapisany na Pulpicie");
        System.out.println("Podaj nazwę pliku docelowego bez rozszerzenia");
        Scanner sc = new Scanner(System.in);
        File output = new File( "C://Users//RENT//Desktop//" + sc.nextLine()+ ".txt" );
        PrintWriter pw = new PrintWriter(output);
        for(Employee p : list){
            pw.println (p.getLastName() + " " + p.getName() + " " + p.getGender() + " " +
                    p.getDepNumber() + " " + p.getSalary() + " " + p.getAge() + " " + p.getChildNumber());
        }
        pw.close();

    }

    public void addEmployee(){
        Employee worker = new Employee();
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj dane pracownika");
        System.out.println("Set Name");
        worker.setName(sc.nextLine());
        System.out.println("Set Last Name");
        worker.setLastName(sc.nextLine());
        System.out.println("Set Gender ('F' for Female or 'M' for Male)");
        worker.setGender(sc.nextLine().charAt(0));
        System.out.println("Married ('Yes' or 'No')"); //tu cos nie halo
        if (sc.nextLine().charAt(0) == 'Y')
            setMarital(true);
        else
            setMarital(false);
        System.out.println("Set Dep Number [1 or 2 or 3]");
        worker.setDepNumber(sc.nextInt());
        System.out.println("Set Salary");
        worker.setSalary(sc.nextFloat());
        System.out.println("Set Age");
        worker.setAge(sc.nextInt());
        System.out.println("Set number of Children");
        worker.setChildNumber(sc.nextInt());

        this.list.add(worker);
        System.out.println("Pracownik został dodany");
    }

    public void showList(){
        int i = 0;
        for(Employee p : list){
            System.out.println(i + " " + p.toString());
            i++;
        }
    }

    public List<Employee> getList() {
        return list;
    }
    public void setList(List<Employee> list) {
        this.list = list;
    }


}

