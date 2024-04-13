package com.paulhenstridge.blackjack.model;

import com.paulhenstridge.blackjack.DTOs.PlayerBetDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Session {
    private final String sessionId = UUID.randomUUID().toString();
    GameDeck gameDeck = new GameDeck(1);
    List<Player> players = new ArrayList<>();
    List<PlayerBetDTO> activePlayers = new ArrayList<>();
    List<Round> prevRounds = new ArrayList<>();

    Round currentRound;


    public Session(){}

    public String getSessionId() {
        return sessionId;
    }

    public Round createRound(){
        // check if there is not already an ongoing round...

        currentRound = new Round(activePlayers,gameDeck.shuffle());
        currentRound.dealCards();
        return currentRound;
//        currentRound.hitOrStand();
//        currentRound.dealersTurn();
//        currentRound.declareWinners();
//        prevRounds.add(currentRound);
    }

    public boolean canJoin(){
        return (players.size() < 4);
    }
    public String joinSession(Player player) {
        players.add(player);
        player.setSessionId(sessionId);
        return sessionId;
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


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<PlayerBetDTO> getActivePlayers() {
        return activePlayers;
    }

    public void setActivePlayers(List<PlayerBetDTO> activePlayers) {
        this.activePlayers = activePlayers;
    }


    public List<Round> getPrevRounds() {
        return prevRounds;
    }


}
