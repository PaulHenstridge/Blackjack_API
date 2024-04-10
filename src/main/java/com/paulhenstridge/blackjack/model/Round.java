package com.paulhenstridge.blackjack.model;

import com.paulhenstridge.blackjack.DTOs.PlayerBetDTO;
import org.aspectj.lang.annotation.Before;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Round {
    List<PlayerBetDTO> players;
    Dealer dealer = new Dealer();
    List<Hand> playerHands = new ArrayList<>();
    int prizePot;
    boolean roundIsComplete;
    List<Card> deck;
    private final Scanner scanner = new Scanner(System.in);
    List<Player> winners = new ArrayList<>();

    public Round(List<PlayerBetDTO> players, List<Card> deck){
        this.players = players;
        this.deck = deck;
    }

    public void dealCards(){
        for( PlayerBetDTO playerDTO : players){
            playerDTO.getPlayer().getHand().getCards().add(deck.remove(0));
            playerDTO.getPlayer().getHand().getCards().add(deck.remove(0));
        }
        dealer.getDealersHand().getCards().add(deck.remove(0));
        dealer.getDealersHand().getCards().add(deck.remove(0));
    }

    public void hitOrStand() {
        System.out.println("Dealer's first card: " + dealer.getDealersHand().getCards().get(0).getValue());
        for (PlayerBetDTO playerDTO : players) {
            for( Card card : playerDTO.getPlayer().getHand().getCards()){
                System.out.println(card.getValue());
            }
            System.out.println("Player " + playerDTO.getPlayer().getPlayerName() + ", your hand: " + playerDTO.getPlayer().getHand().calcValue());
            while (true) {
                System.out.print("Do you want to hit (H) or stand (S)? : ");
                String decision = scanner.nextLine().trim().toLowerCase();
//                String decision = "s";
                if ("s".equals(decision)) {
                    break;
                } else if ("h".equals(decision)) {
                    playerDTO.getPlayer().getHand().getCards().add(deck.remove(deck.size() - 1));
                    for( Card card : playerDTO.getPlayer().getHand().getCards()){
                        System.out.println(card.getValue());
                    }
                    System.out.println("New hand: " + playerDTO.getPlayer().getHand().calcValue());
                    if (playerDTO.getPlayer().getHand().calcValue() == 0) {
                        System.out.println("Bust!");
                        playerDTO.getPlayer().isActive = false;
                        playerDTO.getPlayer().setStake(0);
                        break;
                    }
                } else {
                    System.out.println("Invalid input. Please type 'H' or 'S'.");
                }
            }
        }
    }

    public void dealersTurn() {
        System.out.println("Dealer's first card: " + dealer.getDealersHand().getCards().get(0).getValue());
        System.out.println("Dealer's second card: " + dealer.getDealersHand().getCards().get(1).getValue());
        int i =2;
        while (dealer.getDealersHand().calcValue() < 16 && dealer.getDealersHand().calcValue() > 0){
            dealer.getDealersHand().getCards().add(deck.remove(deck.size() - 1));
            System.out.println("Dealer's draws a: " + dealer.getDealersHand().getCards().get(i).getValue());
            i++;

            for( Card card : dealer.getDealersHand().getCards()){
                System.out.println(card.getValue());
            }
            System.out.println("Dealers hand: " + dealer.getDealersHand().calcValue());

        }
    }

    public List<Player> declareWinners(){
        int dealerScore = dealer.getDealersHand().calcValue();
        for(PlayerBetDTO playerDTO : players){
            if (playerDTO.getPlayer().isActive && playerDTO.getPlayer().getHand().calcValue() > dealerScore){
                winners.add(playerDTO.getPlayer());
            }
        }
        if(winners.size() == 0){
            System.out.println("No winners this round");
        } else {
            for (Player winner : winners) {
                System.out.println(winner.playerName + "wins!");
            }
        }
        return winners;
    }

    // a method that loops over each player in turn until all are stuck.
    // if a player in players is not on stick, ask them the question...

    // in session, create a round and call its methods.
}
