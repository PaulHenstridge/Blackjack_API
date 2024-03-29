package com.paulhenstridge.blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Session {

    GameDeck gameDeck;
    List<Player> players;
    List<Player> activePlayers = new ArrayList<>();

    Round currentRound;

    List<Round> prevRounds = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public Session(GameDeck gameDeck, List<Player> players){
        this.gameDeck = gameDeck;
        this.players = players;
         while (players.size()>0){
             takeBets();
             playRound();
         }

    }

    public void takeBets(){
        for(Player player : players){
            System.out.println("Player " + player.playerName + " do you want to play (Y/N)?");
            String response = scanner.nextLine().trim().toLowerCase();
            if("y".equals(response) ){
                player.isActive = true;
                player.setStake(5);
            }
            if("n".equals(response) ){
                System.out.println("Do you wish to exit the session? (press X to exit)");
                String exit = scanner.nextLine().trim().toLowerCase();
                if( "x".equals(exit)){
                    leaveSession(player);
                }
            }
        }
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
        currentRound.dealersTurn();
        currentRound.declareWinners();
        prevRounds.add(currentRound);
    }

    public void leaveSession(Player player){
        players.remove(player);
        if(players.size() == 0){
            endSession();
        }
    }

    private void endSession(){
        System.out.println("Session has ended.  print some scores, stats etc");
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
