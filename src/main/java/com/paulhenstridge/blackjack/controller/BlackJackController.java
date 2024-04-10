package com.paulhenstridge.blackjack.controller;

import com.paulhenstridge.blackjack.DTOs.PlayerBetDTO;
import com.paulhenstridge.blackjack.model.Player;
import com.paulhenstridge.blackjack.model.Session;
import com.paulhenstridge.blackjack.model.SessionManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/game")
public class BlackJackController {
    private SessionManager sessionManager;

    public BlackJackController() {
        this.sessionManager = new SessionManager();
    }

    @PostMapping("/join")
    public ResponseEntity<String> joinGame(@RequestBody Player player){
        System.out.println(player.getPlayerName() + " tried to join");
        String sessionId = sessionManager.joiOrCreateSession(player);
        return ResponseEntity.ok(player.getPlayerName() + "joined session " + sessionId);
    }

    @PostMapping("/session/{sessionId}/activePlayers")
    public ResponseEntity<List<PlayerBetDTO>> receiveActivePlayers(@PathVariable String sessionId, @RequestBody List<PlayerBetDTO> activePlayers){
        Optional<Session> optionalSession = sessionManager.findSessionById(sessionId);

        if (optionalSession.isPresent()) {
            Session session = optionalSession.get();
            session.setActivePlayers(activePlayers);
            return ResponseEntity.ok(activePlayers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
