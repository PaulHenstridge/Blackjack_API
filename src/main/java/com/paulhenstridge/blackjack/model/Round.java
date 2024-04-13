package com.paulhenstridge.blackjack.model;

import com.paulhenstridge.blackjack.DTOs.PlayerBetDTO;
import com.paulhenstridge.blackjack.DTOs.PlayerHandDTO;
import org.aspectj.lang.annotation.Before;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Round {
    List<PlayerBetDTO> players;
    Dealer dealer = new Dealer();
    List<Hand> playerHands = new ArrayList<>();
    int prizePot;
    boolean roundIsComplete;
    List<Card> deck;
    List<Player> winners = new ArrayList<>();

    public Round(List<PlayerBetDTO> players, List<Card> deck) {
        this.players = players;
        this.deck = deck;
    }

    public void dealCards() {
        for (PlayerBetDTO playerDTO : players) {
            playerDTO.getPlayer().getHand().getCards().add(deck.remove(0));
            playerDTO.getPlayer().getHand().getCards().add(deck.remove(0));
        }
        dealer.getDealersHand().getCards().add(deck.remove(0));
        dealer.getDealersHand().getCards().add(deck.remove(0));
    }

    public PlayerHandDTO hit(PlayerBetDTO playerDTO){
        playerDTO.getPlayer().getHand().getCards().add(deck.remove(deck.size() - 1));
        return createPlayerHandDTO(playerDTO);
    };

    public PlayerHandDTO stand(PlayerBetDTO playerDTO){
        return createPlayerHandDTO(playerDTO);
    };

    private PlayerHandDTO createPlayerHandDTO(PlayerBetDTO playerDTO){
        int playerHandValue = playerDTO.getPlayer().getHand().calcValue();
        List<Card> cards = playerDTO.getPlayer().getHand().getCards();
        boolean isBust = playerDTO.getPlayer().getHand().getBust();

        PlayerHandDTO playerHand = new PlayerHandDTO(playerHandValue,cards,isBust);
        return playerHand;
    }

//    public void hitOrStand() {
//        System.out.println("Dealer's first card: " + dealer.getDealersHand().getCards().get(0).getValue());
//        for (PlayerBetDTO playerDTO : players) {
//            for (Card card : playerDTO.getPlayer().getHand().getCards()) {
//                System.out.println(card.getValue());
//            }
//            System.out.println("Player " + playerDTO.getPlayer().getPlayerName() + ", your hand: " + playerDTO.getPlayer().getHand().calcValue());
//            while (true) {
//                System.out.print("Do you want to hit (H) or stand (S)? : ");
//                String decision = scanner.nextLine().trim().toLowerCase();
////                String decision = "s";
//                if ("s".equals(decision)) {
//                    break;
//                } else if ("h".equals(decision)) {
//                    playerDTO.getPlayer().getHand().getCards().add(deck.remove(deck.size() - 1));
//                    for (Card card : playerDTO.getPlayer().getHand().getCards()) {
//                        System.out.println(card.getValue());
//                    }
//                    System.out.println("New hand: " + playerDTO.getPlayer().getHand().calcValue());
//                    if (playerDTO.getPlayer().getHand().calcValue() == 0) {
//                        System.out.println("Bust!");
//                        playerDTO.getPlayer().isActive = false;
//                        playerDTO.getPlayer().setStake(0);
//                        break;
//                    }
//                } else {
//                    System.out.println("Invalid input. Please type 'H' or 'S'.");
//                }
//            }
//        }
//    }

    public PlayerHandDTO dealersTurn() {

        while (dealer.getDealersHand().calcValue() < 16 && dealer.getDealersHand().calcValue() <21) {
            dealer.getDealersHand().getCards().add(deck.remove(deck.size() - 1));

            for (Card card : dealer.getDealersHand().getCards()) {
                System.out.println(card.getValue());
            }
            System.out.println("Dealers hand: " + dealer.getDealersHand().calcValue());
        }
        return new PlayerHandDTO(dealer.getDealersHand().calcValue(),dealer.getDealersHand().getCards(),dealer.getDealersHand().getBust());
    }

    public List<Player> declareWinners() {
        int dealerScore = dealer.getDealersHand().calcValue();
        for (PlayerBetDTO playerDTO : players) {
            if (playerDTO.getPlayer().isActive && playerDTO.getPlayer().getHand().calcValue() > dealerScore) {
                winners.add(playerDTO.getPlayer());
            }
        }
        if (winners.size() == 0) {
            System.out.println("No winners this round");
        } else {
            for (Player winner : winners) {
                System.out.println(winner.playerName + "wins!");
            }
        }
        return winners;
    }

    public List<PlayerBetDTO> getPlayers() {
        return players;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Hand> getPlayerHands() {
        return playerHands;
    }

    public int getPrizePot() {
        return prizePot;
    }

    public boolean isRoundIsComplete() {
        return roundIsComplete;
    }

    public List<Player> getWinners() {
        return winners;
    }
}
