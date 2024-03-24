package com.paulhenstridge.blackjack.model;

public class Dealer {
    Hand dealersHand = new Hand();

    public Hand getDealersHand() {
        return dealersHand;
    }

    public void setDealersHand(Hand dealersHand) {
        this.dealersHand = dealersHand;
    }

    public Dealer(){


    };
}
