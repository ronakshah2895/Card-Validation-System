package com.sjsu.individualproject;

public class AmericanExpressValidator extends CardValidator {

    @Override
    public void validate(Card card) {
        int cardNumberLen = card.cardNumber.length();
        char firstChar = card.cardNumber.charAt(0);
        char secondChar = card.cardNumber.charAt(1);
        if (cardNumberLen == 15 && firstChar == '3' && (secondChar == '4' || secondChar == '7')) {
            card.type = "AmericanExpress";
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
