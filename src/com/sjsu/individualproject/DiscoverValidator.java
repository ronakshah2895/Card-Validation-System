package com.sjsu.individualproject;

public class DiscoverValidator extends CardValidator {

    @Override
    public void validate(Card card) {
        int cardNumberLen = card.cardNumber.length();
        String firstFour = card.cardNumber.substring(0, 4);
        if (cardNumberLen == 16 && firstFour.equals("6010")) {
            card.type = "Discover";
        }
        else {
            if (nextValidator != null)
                nextValidator.validate(card);
            else {
                card.type = "Invalid";
                card.error = "InvalidCardNumber";
            }
        }
    }
}
