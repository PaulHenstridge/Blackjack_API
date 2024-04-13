package com.paulhenstridge.blackjack.model;

import java.util.UUID;

public class Player {

    private final String playerId = UUID.randomUUID().toString();
    String playerName;
    String sessionId;
    private Hand hand = new Hand();
    private int wallet = 100;
    private int wins = 0;

    public boolean isActive = false;
    private int stake;

    public Player(String playerName){ this.playerName = playerName;}

    public Player(){};

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getStake() {
        return stake;
    }

    public void setStake(int stake) {
        this.stake = stake;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerId() {
        return playerId;
    }

    public boolean isActive() {
        return isActive;
    }
}
