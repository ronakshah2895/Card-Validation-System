package com.sjsu.individualproject.test;

import com.opencsv.exceptions.CsvValidationException;
import com.sjsu.individualproject.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CardIOTest {

    @TempDir
    File tempDir;

    @Test
    void csvParseTest() {
        CardIO csvParser = new CsvIO();
        try {
            csvParser.read("testResources/Sample.csv");
            csvParser.write(tempDir + "/out.csv");
            Path sampleFilePath = Path.of("testResources/SampleOut.csv");
            Path outputFilePath = Path.of(tempDir + "/out.csv");
            assertEquals(Files.readAllLines(sampleFilePath), Files.readAllLines(outputFilePath));
        } catch (IOException | CsvValidationException | ParserConfigurationException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

    @Test
    void jsonParseTest() {
        CardIO csvParser = new JsonIO();
        try {
            csvParser.read("testResources/Sample.json");
            csvParser.write(tempDir + "/out.json");
            Path sampleFilePath = Path.of("testResources/SampleOut.json");
            Path outputFilePath = Path.of(tempDir + "/out.json");
            assertEquals(Files.readAllLines(sampleFilePath), Files.readAllLines(outputFilePath));
        } catch (IOException | CsvValidationException | ParserConfigurationException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

    @Test
    void xmlParseTest() {
        CardIO csvParser = new XmlIO();
        try {
            csvParser.read("testResources/Sample.xml");
            csvParser.write(tempDir + "/out.xml");
            Path sampleFilePath = Path.of("testResources/SampleOut.xml");
            Path outputFilePath = Path.of(tempDir + "/out.xml");
            assertEquals(Files.readAllLines(sampleFilePath), Files.readAllLines(outputFilePath));
        } catch (IOException | CsvValidationException | ParserConfigurationException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
