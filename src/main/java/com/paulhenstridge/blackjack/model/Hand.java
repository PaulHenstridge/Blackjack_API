package com.paulhenstridge.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private int value = 0;

    public Hand() {}

    public int calcValue(){
        for(Card card : cards){
            value += card.getValue();
        }
        return value;
    }

}
