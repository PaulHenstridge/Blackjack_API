package com.paulhenstridge.blackjack.DTOs;

public class PlayerHandDTO {
    int value;
    int numberOfCards;
    boolean isBust;

    public PlayerHandDTO(int value, int numberOfCards, boolean isBust){
        this.value = value;
        this.numberOfCards = numberOfCards;
        this.isBust = isBust;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    public boolean isBust() {
        return isBust;
    }

    public void setBust(boolean bust) {
        isBust = bust;
    }
}
