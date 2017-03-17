package com.sdajava.ProjectCompany;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Company sda = new Company();
        sda.addEmployee();
        sda.addEmployee();
        sda.showList();
        sda.objectExport();
        sda.longestLastName();

    }

}

