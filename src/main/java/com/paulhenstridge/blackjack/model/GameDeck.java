package com.paulhenstridge.blackjack.model;

import com.paulhenstridge.blackjack.enums.CardData;

import java.util.ArrayList;
import java.util.List;


public class GameDeck {
    private List<Card> cards = new ArrayList<>();

    private int numberOfDecks = 0;

    public GameDeck(int numberOfDecks){
        this.numberOfDecks = numberOfDecks;
    }

    public void createGameDeck(){
        for( int i = 0; i< numberOfDecks; i++){
            for( CardData cardData : CardData.values()){
                System.out.println(cardData.getSuit());
                Card card = new Card(cardData.getSuit(), cardData.getValue());
                cards.add(card);
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getNumberOfDecks() {
        return numberOfDecks;
    }
}
