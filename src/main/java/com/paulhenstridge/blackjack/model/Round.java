package com.paulhenstridge.blackjack.model;

import java.util.List;

public class Round {
    List<Player> players;
    Hand dealerHand;
    List<Hand> playerHands;
    int prizePot;
    boolean roundIsComplete;
    List<Card> deck;

    public Round(List<Player> players, List<Card> deck){
        this.players = players;
        this.deck = deck;
    }

    // dealCards()

    // if a player in players is not on stick, ask them the question...
    // a method that loops over each player in turn until all are stuck.
}
