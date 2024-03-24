package com.paulhenstridge.blackjack.model;

import org.aspectj.lang.annotation.Before;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Round {
    List<Player> players;
    Dealer dealer = new Dealer();
    List<Hand> playerHands = new ArrayList<>();
    int prizePot;
    boolean roundIsComplete;
    List<Card> deck;
    private final Scanner scanner = new Scanner(System.in);
    List<Player> winners = new ArrayList<>();

    public Round(List<Player> players, List<Card> deck){
        this.players = players;
        this.deck = deck;
    }

    public void dealCards(){
        for( Player player : players){
            player.getHand().getCards().add(deck.remove(0));
            player.getHand().getCards().add(deck.remove(0));
        }
        dealer.getDealersHand().getCards().add(deck.remove(0));
        dealer.getDealersHand().getCards().add(deck.remove(0));
    }

    public void hitOrStand() {
        for (Player player : players) {
            System.out.println("Player " + player.getPlayerName() + ", your hand: " + player.getHand().calcValue());
            while (true) {
                System.out.print("Do you want to hit (H) or stand (S)? : ");
                String decision = scanner.nextLine().trim().toLowerCase();
//                String decision = "s";
                if ("s".equals(decision)) {
                    break;
                } else if ("h".equals(decision)) {
                    player.getHand().getCards().add(deck.remove(deck.size() - 1));
                    System.out.println("New hand: " + player.getHand().calcValue());
                    if (player.getHand().calcValue() > 21) {
                        System.out.println("Bust!");
                        break;
                    }
                } else {
                    System.out.println("Invalid input. Please type 'H' or 'S'.");
                }
            }
        }
    }
    public List<Player> declareWinners(){
        int dealerScore = dealer.getDealersHand().calcValue();
        for(Player player : players){
            if (player.getHand().calcValue() > dealerScore){
                winners.add(player);
            }
        }
        for( Player winner : winners) {
            System.out.println(winner.playerName);
        }
        return winners;
    }

    // a method that loops over each player in turn until all are stuck.
    // if a player in players is not on stick, ask them the question...

    // in session, create a round and call its methods.
}
