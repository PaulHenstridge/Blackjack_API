package com.paulhenstridge.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private int value = 0;

    private boolean bust = false;

    public Hand() {}

    public int calcValue(){
        value = 0;
        for(Card card : cards){
            value += card.getValue();
        }
        if (value >21){
            setBust(true);
        }
        return value;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean getBust() {
        return bust;
    }

    public void setBust(boolean bust) {
        bust = bust;
    }
}
