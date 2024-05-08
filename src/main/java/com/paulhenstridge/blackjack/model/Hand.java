package com.paulhenstridge.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private int value;

    private boolean bust = false;

    public Hand() {
        this.value = calcValue(); // if this causes issue, set back to 0 initially
    }

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

    public int addCard(Card card){
        cards.add(card);
        return calcValue();

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
        this.bust = bust;
    }
}

// fe8ced68-3cc5-49d1-8c18-e9a4a9cd2c7e , a8cfb382-677a-4242-929c-95a1275fe97d, ce2d1d44-108a-45bc-9e05-2533beaf8644