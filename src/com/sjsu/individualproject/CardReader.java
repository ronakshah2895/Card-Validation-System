package com.sjsu.individualproject;

import com.opencsv.exceptions.CsvValidationException;

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

    Card (Map<String, String> cardValue) {
        cardNumber = Long.toString(Double.valueOf(cardValue.get("CardNumber")).longValue());
        expirationDate = cardValue.get("ExpirationDate");
        nameOfCardHolder = cardValue.get("NameOfCardholder");
    }
}

public abstract class CardReader {

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

    abstract void read() throws IOException, CsvValidationException;
}
