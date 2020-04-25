package com.sjsu.individualproject;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvIO extends CardIO {

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

    @Override
    void write() throws IOException {
        File outFile = new File("out.csv");
        outFile.createNewFile();
        CSVWriter csvWriter = new CSVWriter(new FileWriter(outFile, false), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
        String[] headerRecord = {"CardNumber", "CardType", "Error"};
        csvWriter.writeNext(headerRecord);
        for(Card card: validatedCards) {
            String cardNumber = String.format("%.2E", Double.valueOf(card.cardNumber));
            String[] record = {cardNumber, card.type, card.error};
            csvWriter.writeNext(record);
        }
        csvWriter.close();
    }
}
