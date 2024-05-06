package com.paulhenstridge.blackjack.DTOs;

import com.paulhenstridge.blackjack.model.Player;

public class PlayerBetDTO {
    private String playerId;
    private int betValue;

    public PlayerBetDTO(String playerId, int betValue){
        this.playerId = playerId;
        this.betValue = betValue;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayer(Player player) {
        this.playerId = player.getPlayerId();
    }

    public int getBetValue() {
        return betValue;
    }

    public void setBetValue(int betValue) {
        this.betValue = betValue;
    }
}
