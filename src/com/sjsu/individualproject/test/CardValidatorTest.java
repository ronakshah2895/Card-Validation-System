package com.sjsu.individualproject.test;

import com.sjsu.individualproject.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CardValidatorTest {

    @Test
    void testMasterCard() {
        Map<String, String> cardValue = new HashMap<>();
        cardValue.put("CardNumber", "5410000000000000");
        cardValue.put("ExpirationDate", "3/20/2030");
        cardValue.put("NameOfCardholder", "Alice");
        Card card = new Card(cardValue);
        CardValidator validator = new MasterCardValidator();
        validator.validate(card);
        assertEquals("MasterCard",card.getCardType());
    }

    @Test
    void testVisa() {
        Map<String, String> cardValue = new HashMap<>();
        cardValue.put("CardNumber", "4120000000000");
        cardValue.put("ExpirationDate", "4/20/2030");
        cardValue.put("NameOfCardholder", "Bob");
        Card card = new Card(cardValue);
        CardValidator validator = new VisaValidator();
        validator.validate(card);
        assertEquals("Visa",card.getCardType());
    }

    @Test
    void testAmericanExpress() {
        Map<String, String> cardValue = new HashMap<>();
        cardValue.put("CardNumber", "341000000000000");
        cardValue.put("ExpirationDate", "5/20/2030");
        cardValue.put("NameOfCardholder", "Eve");
        Card card = new Card(cardValue);
        CardValidator validator = new AmericanExpressValidator();
        validator.validate(card);
        assertEquals("AmericanExpress",card.getCardType());
    }

    @Test
    void testDiscover() {
        Map<String, String> cardValue = new HashMap<>();
        cardValue.put("CardNumber", "6010000000000000");
        cardValue.put("ExpirationDate", "6/20/2030");
        cardValue.put("NameOfCardholder", "Richard");
        Card card = new Card(cardValue);
        CardValidator validator = new DiscoverValidator();
        validator.validate(card);
        assertEquals("Discover",card.getCardType());
    }
}