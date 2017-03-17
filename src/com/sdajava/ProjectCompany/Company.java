package com.sdajava.ProjectCompany;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Company extends Employee {

    private List<Employee> list = new ArrayList<Employee>();

    public void longestLastName() throws IOException, ClassNotFoundException {
        String fileName = "C://Users//RENT//Desktop//output.txt";
        FileInputStream fileInput= new FileInputStream(fileName);
        InputStream bufferIn = new BufferedInputStream(fileInput);
        ObjectInputStream objectInput = new ObjectInputStream(bufferIn);

        Employee a =null;
        Employee longestLastName = new Employee();
        longestLastName.setLastName("");
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
       // Comparator<Employee> byLastName = (e1, e2) -> Float.compare(e1.getSalary(), e2.getSalary());
       // list2 = list.stream().sorted(bySalary).collect(Collectors.toList());;

    }

    public void objectExport() throws IOException {
        String fileName = "C://Users//RENT//Desktop//output.txt";

        OutputStream fileOutput = new FileOutputStream(fileName);
        OutputStream bufferOut  = new BufferedOutputStream(fileOutput);
        ObjectOutput objectOutput = new ObjectOutputStream(bufferOut);

        for (Employee p : list) {
            objectOutput.writeObject(p);
        }
        objectOutput.close();
    }

    public void salarySort(boolean order) throws FileNotFoundException {
        List<Employee> list2 = new ArrayList<Employee>();
        if (order == true) {
            Comparator<Employee> bySalary = (e1, e2) -> Float.compare(e1.getSalary(), e2.getSalary());
            list2 = list.stream().sorted(bySalary).collect(Collectors.toList());;
        }
        else if (order == false){
            Comparator<Employee> bySalary = (e1, e2) -> Float.compare(e2.getSalary(), e1.getSalary());
            list2 = list.stream().sorted(bySalary).collect(Collectors.toList());;
        }

        File output = new File( "C://Users//RENT//Desktop//output2.txt" );
        PrintWriter pw = new PrintWriter(output);
        for(Employee p : list2){
            pw.println (p);
        }
        pw.close();
    }

    public void lastNameSort(boolean order) throws FileNotFoundException {
        List<Employee> list2 = new ArrayList<Employee>();
        if (order == true) {
            Comparator<Employee> byLastName = (e1, e2) -> e1.getLastName().compareTo(e2.getLastName());
            list2 = list.stream().sorted(byLastName).collect(Collectors.toList());
        }
        else if (order ==false){
            Comparator<Employee> byLastName = (e1, e2) -> e2.getLastName().compareTo(e1.getLastName());
            list2 = list.stream().sorted(byLastName).collect(Collectors.toList());
            }
        File output = new File( "C://Users//RENT//Desktop//output2.txt" );
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

    public void salarySort(float threshold){
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
        System.out.println("Wybierz numer pracownika do edycji");
        int a = sc.nextInt();
        list.get(a).showSpecial();
        if (list.get(a).getGender() == 'F'){
            System.out.println("Wybierz co chcesz edytować");
            System.out.println("1 - Last Name");
            System.out.println("2 - Married ('Yes' or 'No')"); //tu cos nie halo
            System.out.println("3 - Dep Number");
            System.out.println("4 - Salary");
            System.out.println("5 - Age");
            System.out.println("6 - Number of Children");;
            switch (sc.nextInt()){
                case 1 : list.get(a).setLastName(sc.nextLine()); break;
                case 2 : if (sc.nextLine().charAt(0) == 'Y')
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
            System.out.println("1 - Married ('Yes' or 'No')"); //tu cos nie halo
            System.out.println("2 - Dep Number");
            System.out.println("3 - Salary");
            System.out.println("4 - Age");
            System.out.println("5 - Number of Children");;
            switch (sc.nextInt()){
                case 1 : if (sc.nextLine().charAt(0) == 'Y')
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
    }

    public void removeEmployee(){
        showList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Wybierz numer pracownika do usunięcia");
        list.remove(sc.nextInt());
    }

    public void export() throws FileNotFoundException{
        File output = new File( "C://Users//j.gutkowski//Desktop//output.txt" ); //reczne podawanie pliku
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
        System.out.println("Set Dep Number");
        worker.setDepNumber(sc.nextInt());
        System.out.println("Set Salary");
        worker.setSalary(sc.nextFloat());
        System.out.println("Set Age");
        worker.setAge(sc.nextInt());
        System.out.println("Set number of Children");
        worker.setChildNumber(sc.nextInt());

        this.list.add(worker);
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
