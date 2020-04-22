package com.sjsu.individualproject;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        CardReader cardReader = new CsvReader();
        try {
            cardReader.read();
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (CsvValidationException e) {
            System.out.println("Invalid file");
        }
    }
}
