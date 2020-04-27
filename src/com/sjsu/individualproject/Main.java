package com.sjsu.individualproject;

import com.opencsv.exceptions.CsvValidationException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String inputFile = args[0];
        String inputExt = inputFile.substring(inputFile.lastIndexOf('.') + 1);
        String outputFile = args[1];
        CardIO cardIO;
        switch (inputExt) {
            case "csv": cardIO = new CsvIO(); break;
            case "json": cardIO = new JsonIO(); break;
            case "xml": cardIO = new XmlIO(); break;
            default: System.out.println("Invalid file"); return;
        }
        try {
            cardIO.read(inputFile);
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (CsvValidationException | ParserConfigurationException | SAXException e) {
            System.out.println("Invalid file");
        }
        try {
            cardIO.write(outputFile);
        } catch (IOException | TransformerException | ParserConfigurationException e) {
            System.out.println("Error creating file");
        }
    }
}
