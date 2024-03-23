package com.paulhenstridge.blackjack.model;

public class Player {

    String playerName;
    private Hand hand = new Hand();
    private int wallet = 100;
    private int wins = 0;

    public boolean isActive;
    private int stake;

    public Player(String playerName){
        this.playerName = playerName;
    };

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
}
