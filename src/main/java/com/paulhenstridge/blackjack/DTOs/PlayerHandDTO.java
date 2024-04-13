package com.paulhenstridge.blackjack.DTOs;

import com.paulhenstridge.blackjack.model.Card;

import java.util.List;

public class PlayerHandDTO {
    int value;
    List<Card> cards;
    int numberOfCards = cards.size();
    boolean isBust;

    public PlayerHandDTO(int value, List<Card> cards, boolean isBust){
        this.value = value;
        this.cards = cards;
        this.isBust = isBust;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNumberOfCards() {
        return cards.size();
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = cards.size();
    }

    public boolean isBust() {
        return isBust;
    }

    public void setBust(boolean bust) {
        isBust = bust;
    }
}
