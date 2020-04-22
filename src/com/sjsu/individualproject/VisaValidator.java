package com.sjsu.individualproject;

public class VisaValidator extends CardValidator {

    @Override
    public void validate(Card card) {
        int cardNumberLen = card.cardNumber.length();
        char firstChar = card.cardNumber.charAt(0);
        if ((cardNumberLen == 13 || cardNumberLen == 16) && firstChar == '4') {
            card.type = "Visa";
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
