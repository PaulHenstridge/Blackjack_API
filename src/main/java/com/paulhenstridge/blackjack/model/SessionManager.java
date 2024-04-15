package com.paulhenstridge.blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SessionManager {

    private List<Session> activeSessions;
    private List<Player> allPlayers;

    public SessionManager() {
        this.activeSessions = new ArrayList<>();
        this.allPlayers = new ArrayList<>();
    }

    public synchronized String joiOrCreateSession(Player player){
        allPlayers.add(player);
        for (Session session : activeSessions) {
            if (session.canJoin()) {
                return session.joinSession(player);
            }
        }
        // if no session available, create new one.
        Session newSession = new Session();
        activeSessions.add(newSession);
        return newSession.joinSession(player);
    }

    public Optional<Session> findSessionById(String sessionId) {
        return activeSessions.stream()
                .filter(session -> session.getSessionId().equals(sessionId))
                .findFirst();
    }

    public List<Player> getAllPlayers() {
        return allPlayers;
    }

    public List<Session> getActiveSessions() {
        return activeSessions;
    }
}

