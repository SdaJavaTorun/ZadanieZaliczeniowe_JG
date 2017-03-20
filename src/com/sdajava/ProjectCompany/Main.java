package com.sdajava.ProjectCompany;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        GUI firma = new GUI();
        firma.controller();
    }

}