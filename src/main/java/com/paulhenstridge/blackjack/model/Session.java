package com.paulhenstridge.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Session {

    GameDeck gameDeck;
    List<Player> players;
    List<Player> activePlayers;

    Round currentRound;

    List<Round> prevRounds;

    public Session(GameDeck gameDeck, List<Player> players){
        this.gameDeck = gameDeck;
        this.players = players;
    }

    public List<Player> setActivePlayers(){
        for (Player player : players){
            if (player.isActive){
                activePlayers.add(player);
            }
        }
        return activePlayers;
    }

    public void playRound(){
        currentRound = new Round(setActivePlayers(),gameDeck.shuffle());
        currentRound.dealCards();
        currentRound.hitOrStand();
    }

}
