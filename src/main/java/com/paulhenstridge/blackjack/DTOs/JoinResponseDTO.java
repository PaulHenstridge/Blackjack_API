package com.paulhenstridge.blackjack.DTOs;

public class JoinResponseDTO {
    private String playerName;
    private String playerId;
    private String sessionId;

    public JoinResponseDTO(String playerName,String playerId, String sessionId){
        this.playerName = playerName;
        this.playerId = playerId;
        this.sessionId = sessionId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
