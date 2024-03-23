package com.paulhenstridge.blackjack.model;

public class Card {
    private String suit;
    private int value;

    private boolean isFaceUp;
// TODO - only return suit/val if isFaceUp
    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    };

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }
}
