package com.sjsu.individualproject;

import com.opencsv.exceptions.CsvValidationException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        CardIO cardIO = new CsvIO();
        try {
            cardIO.read();
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (CsvValidationException | ParserConfigurationException | SAXException e) {
            System.out.println("Invalid file");
        }
        try {
            cardIO.write();
        } catch (IOException | TransformerException | ParserConfigurationException e) {
            System.out.println("Error creating file");
        }
    }
}
