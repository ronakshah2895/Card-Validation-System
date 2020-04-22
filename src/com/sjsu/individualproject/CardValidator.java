package com.sjsu.individualproject;

public abstract class CardValidator {

    CardValidator nextValidator;

    final void setNextValidator(CardValidator nextValidator) {
        this.nextValidator = nextValidator;
    }

    public abstract void validate(Card card);
}
