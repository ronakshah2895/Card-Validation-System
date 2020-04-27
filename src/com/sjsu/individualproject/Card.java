package com.sjsu.individualproject;

import java.util.Map;

public class Card {

    String cardNumber;
    String initialCardNumber;
    String expirationDate;
    String nameOfCardHolder;
    String type;
    String error = "None";

    public Card (Map<String, String> cardValue) {
        try {
            cardNumber = Long.toString(Double.valueOf(cardValue.get("CardNumber")).longValue());
        } catch (Exception e) {
            cardNumber = cardValue.get("CardNumber");
        }
        initialCardNumber = cardValue.get("CardNumber");
        expirationDate = cardValue.get("ExpirationDate");
        nameOfCardHolder = cardValue.get("NameOfCardholder");
    }

    public String getCardType() {
        return this.type;
    }
}
