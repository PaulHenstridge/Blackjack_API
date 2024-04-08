package com.paulhenstridge.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class SessionManager {

    private List<Session> activeSessions;

    public SessionManager() {
        this.activeSessions = new ArrayList<>();
    }

    public synchronized String joiOrCreateSession(Player player){

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
}

