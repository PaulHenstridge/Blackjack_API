package com.paulhenstridge.blackjack.controller;

import com.paulhenstridge.blackjack.DTOs.PlayerBetDTO;
import com.paulhenstridge.blackjack.DTOs.PlayerHandDTO;
import com.paulhenstridge.blackjack.model.Player;
import com.paulhenstridge.blackjack.model.Round;
import com.paulhenstridge.blackjack.model.Session;
import com.paulhenstridge.blackjack.model.SessionManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return ResponseEntity.ok(player.getPlayerName() + "PlayerId: "+ player.getPlayerId() + "joined session " + sessionId);
    }

    @PostMapping("/session/{sessionId}/activePlayers")
    public ResponseEntity<List<Player>> receiveActivePlayers(@PathVariable String sessionId, @RequestBody List<PlayerBetDTO> activePlayerDTOs){
        Optional<Session> optionalSession = sessionManager.findSessionById(sessionId);

        if (optionalSession.isPresent()) {
            Session session = optionalSession.get();

            // take a list of player Ids from req body, map to new List of Players
            List<Player> activePlayers = activePlayerDTOs.stream()
                            .map(PlayerBetDTO::getPlayerId)
                    .map(playerId -> session.getPlayerById(playerId))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());


            session.setActivePlayers(activePlayers);
            Round round = session.createRound();
            return ResponseEntity.ok(round.getPlayers());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/session/{sessionId}/hit/{playerId}")
    public ResponseEntity<PlayerHandDTO> hit( @PathVariable String sessionId, @PathVariable String playerId){

        Optional<Session> optionalSession = sessionManager.getActiveSessions().stream().filter(s -> s.getSessionId().equals(sessionId)).findFirst();
        if (optionalSession.isPresent()) {
            System.out.println("session present");
            Session session = optionalSession.get();

           Optional<Player> optionalPlayer = session.getPlayers().stream().filter(p -> p.getPlayerId().equals(playerId)).findFirst();
            if (optionalPlayer.isPresent()) {
                System.out.println("player present");
                Player player = optionalPlayer.get();

                return ResponseEntity.ok(session.getCurrentRound().hit(player));
            }
        }
            return ResponseEntity.notFound().build();
        }
}
