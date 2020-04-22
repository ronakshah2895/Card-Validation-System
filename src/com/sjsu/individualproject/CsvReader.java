package com.sjsu.individualproject;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class CsvReader extends CardReader {

    @Override
    void read() throws IOException, CsvValidationException {
        CSVReaderHeaderAware cardValues = new CSVReaderHeaderAware(new FileReader("/Users/rony/Downloads/Sample.csv"));
        Map<String, String> cardValue = cardValues.readMap();
        while (cardValue != null) {
            Card card = new Card(cardValue);
            cardValue = cardValues.readMap();
            this.validateCard(card);
        }
    }
}
