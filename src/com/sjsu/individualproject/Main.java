package com.sjsu.individualproject;

import com.opencsv.exceptions.CsvValidationException;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        CardIO cardIO = new JsonIO();
        try {
            cardIO.read();
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (CsvValidationException | ParseException e) {
            System.out.println("Invalid file");
        }
    }
}
