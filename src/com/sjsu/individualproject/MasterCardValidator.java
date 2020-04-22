package com.sjsu.individualproject;

public class MasterCardValidator extends CardValidator {

    @Override
    public void validate(Card card) {
        int cardNumberLen = card.cardNumber.length();
        char firstChar = card.cardNumber.charAt(0);
        char secondChar = card.cardNumber.charAt(1);
        if (cardNumberLen == 16 && firstChar == '5' && secondChar >= '1' && secondChar <= '5') {
            card.type = "MasterCard";
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
