package com.sjsu.individualproject;

import java.util.Map;

public class Card {

    String cardNumber;
    String expirationDate;
    String nameOfCardHolder;
    String type;
    String error = "None";

    public Card (Map<String, String> cardValue) {
        cardNumber = Long.toString(Double.valueOf(cardValue.get("CardNumber")).longValue());
        expirationDate = cardValue.get("ExpirationDate");
        nameOfCardHolder = cardValue.get("NameOfCardholder");
    }

    public String getCardType() {
        return this.type;
    }
}
