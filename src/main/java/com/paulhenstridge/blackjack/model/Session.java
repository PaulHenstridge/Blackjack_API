package com.paulhenstridge.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Session {

    GameDeck gameDeck;
    List<Player> players;

    Round currentRound;

    List<Round> prevRounds;

    public Session(GameDeck gameDeck, List<Player> players){
        this.gameDeck = gameDeck;
        this.players = players;
    }
}
