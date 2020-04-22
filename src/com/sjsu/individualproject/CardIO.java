package com.sjsu.individualproject;

import com.opencsv.exceptions.CsvValidationException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Card {

    String cardNumber;
    String expirationDate;
    String nameOfCardHolder;
    String type;
    String error = "None";

    Card (Map<?, ?> cardValue) {
        if (cardValue.get("CardNumber") instanceof Long)
            cardNumber = Long.toString((Long) cardValue.get("CardNumber"));
        else
            cardNumber = Long.toString(Double.valueOf((String) cardValue.get("CardNumber")).longValue());
        expirationDate = (String) cardValue.get("ExpirationDate");
        nameOfCardHolder = (String) cardValue.get("NameOfCardholder");
    }
}

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
        System.out.println(card.type);
    }

    abstract void read() throws IOException, CsvValidationException, ParseException;
}
