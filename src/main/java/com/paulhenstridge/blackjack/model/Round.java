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
        System.out.println("Dealer's first card: " + dealer.getDealersHand().getCards().get(0).getValue());
        for (Player player : players) {
            for( Card card : player.getHand().getCards()){
                System.out.println(card.getValue());
            }
            System.out.println("Player " + player.getPlayerName() + ", your hand: " + player.getHand().calcValue());
            while (true) {
                System.out.print("Do you want to hit (H) or stand (S)? : ");
                String decision = scanner.nextLine().trim().toLowerCase();
//                String decision = "s";
                if ("s".equals(decision)) {
                    break;
                } else if ("h".equals(decision)) {
                    player.getHand().getCards().add(deck.remove(deck.size() - 1));
                    for( Card card : player.getHand().getCards()){
                        System.out.println(card.getValue());
                    }
                    System.out.println("New hand: " + player.getHand().calcValue());
                    if (player.getHand().calcValue() == 0) {
                        System.out.println("Bust!");
                        player.isActive = false;
                        player.setStake(0);
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
        for(Player player : players){
            if (player.isActive && player.getHand().calcValue() > dealerScore){
                winners.add(player);
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
