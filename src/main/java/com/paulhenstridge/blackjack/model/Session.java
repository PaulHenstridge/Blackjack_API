package com.paulhenstridge.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Session {

    GameDeck gameDeck;
    List<Player> players;
    List<Player> activePlayers = new ArrayList<>();

    Round currentRound;

    List<Round> prevRounds = new ArrayList<>();

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
        List<Player> activePlayers = setActivePlayers();
        currentRound = new Round(activePlayers,gameDeck.shuffle());
        currentRound.dealCards();
        currentRound.hitOrStand();
        currentRound.declareWinners();
        prevRounds.add(currentRound);
    }

    public GameDeck getGameDeck() {
        return gameDeck;
    }

    public void setGameDeck(GameDeck gameDeck) {
        this.gameDeck = gameDeck;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Player> getActivePlayers() {
        return activePlayers;
    }

    public void setActivePlayers(List<Player> activePlayers) {
        this.activePlayers = activePlayers;
    }

    public Round getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(Round currentRound) {
        this.currentRound = currentRound;
    }

    public List<Round> getPrevRounds() {
        return prevRounds;
    }

    public void setPrevRounds(List<Round> prevRounds) {
        this.prevRounds = prevRounds;
    }
}
