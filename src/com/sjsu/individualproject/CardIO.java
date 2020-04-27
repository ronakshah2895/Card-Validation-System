package com.sjsu.individualproject;

import com.opencsv.exceptions.CsvValidationException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class CardIO {

    List<Card> validatedCards = new ArrayList<>();

    final void validateCard(Card card) {
        CardValidator masterCardValidator = new MasterCardValidator();
        CardValidator visaValidator = new VisaValidator();
        CardValidator americanExpressValidator = new AmericanExpressValidator();
        CardValidator discoverValidator = new DiscoverValidator();
        masterCardValidator.setNextValidator(visaValidator);
        visaValidator.setNextValidator(americanExpressValidator);
        americanExpressValidator.setNextValidator(discoverValidator);
        masterCardValidator.validate(card);
        validatedCards.add(card);
    }

    public abstract void read(String inputFile) throws IOException, CsvValidationException, ParserConfigurationException, SAXException;
    public abstract void write(String outputFile) throws IOException, ParserConfigurationException, TransformerException;
}
