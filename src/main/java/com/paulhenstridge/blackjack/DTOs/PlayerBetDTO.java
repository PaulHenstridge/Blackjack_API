package com.paulhenstridge.blackjack.DTOs;

import com.paulhenstridge.blackjack.model.Player;

public class PlayerBetDTO {
    private Player player;
    private int betValue;

    public PlayerBetDTO(Player player, int betValue){
        this.player = player;
        this.betValue = betValue;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getBetValue() {
        return betValue;
    }

    public void setBetValue(int betValue) {
        this.betValue = betValue;
    }
}
