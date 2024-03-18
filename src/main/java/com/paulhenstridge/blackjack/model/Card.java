package com.paulhenstridge.blackjack.model;

public class Card {
    private String name;
    private int value;

    private boolean isFaceUp;

    public Card() {};

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }
}
