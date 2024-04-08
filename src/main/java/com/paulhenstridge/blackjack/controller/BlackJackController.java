package com.paulhenstridge.blackjack.controller;

import com.paulhenstridge.blackjack.model.Player;
import com.paulhenstridge.blackjack.model.SessionManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
public class BlackJackController {
    private SessionManager sessionManager;

    public BlackJackController() {
        this.sessionManager = new SessionManager();
    }

    @PostMapping("/join")
    public ResponseEntity<String> joinGame(@RequestBody Player player){
        System.out.println(player.getPlayerName() + "tried to join");
        String message = sessionManager.joiOrCreateSession(player);
        return ResponseEntity.ok(message);
    }
}
