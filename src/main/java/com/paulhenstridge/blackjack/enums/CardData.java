package com.paulhenstridge.blackjack.enums;

public enum CardData {
    HEARTS_ACE("Hearts", 11),
    HEARTS_TWO("Hearts", 2),
    HEARTS_THREE("Hearts", 3),
    HEARTS_FOUR("Hearts", 4),
    HEARTS_FIVE("Hearts", 5),
    HEARTS_SIX("Hearts", 6),
    HEARTS_SEVEN("Hearts", 7),
    HEARTS_EIGHT("Hearts", 8),
    HEARTS_NINE("Hearts", 9),
    HEARTS_TEN("Hearts", 10),
    HEARTS_JACK("Hearts", 10),
    HEARTS_QUEEN("Hearts", 10),
    HEARTS_KING("Hearts", 10),
    DIAMONDS_ACE("Diamonds", 11),
    DIAMONDS_TWO("Diamonds", 2),
    DIAMONDS_THREE("Diamonds", 3),
    DIAMONDS_FOUR("Diamonds", 4),
    DIAMONDS_FIVE("Diamonds", 5),
    DIAMONDS_SIX("Diamonds", 6),
    DIAMONDS_SEVEN("Diamonds", 7),
    DIAMONDS_EIGHT("Diamonds", 8),
    DIAMONDS_NINE("Diamonds", 9),
    DIAMONDS_TEN("Diamonds", 10),
    DIAMONDS_JACK("Diamonds", 10),
    DIAMONDS_QUEEN("Diamonds", 10),
    DIAMONDS_KING("Diamonds", 10),
    CLUBS_ACE("Clubs", 11),
    CLUBS_TWO("Clubs", 2),
    CLUBS_THREE("Clubs", 3),
    CLUBS_FOUR("Clubs", 4),
    CLUBS_FIVE("Clubs", 5),
    CLUBS_SIX("Clubs", 6),
    CLUBS_SEVEN("Clubs", 7),
    CLUBS_EIGHT("Clubs", 8),
    CLUBS_NINE("Clubs", 9),
    CLUBS_TEN("Clubs", 10),
    CLUBS_JACK("Clubs", 10),
    CLUBS_QUEEN("Clubs", 10),
    CLUBS_KING("Clubs", 10),
    SPADES_ACE("Spades", 11),
    SPADES_TWO("Spades", 2),
    SPADES_THREE("Spades", 3),
    SPADES_FOUR("Spades", 4),
    SPADES_FIVE("Spades", 5),
    SPADES_SIX("Spades", 6),
    SPADES_SEVEN("Spades", 7),
    SPADES_EIGHT("Spades", 8),
    SPADES_NINE("Spades", 9),
    SPADES_TEN("Spades", 10),
    SPADES_JACK("Spades", 10),
    SPADES_QUEEN("Spades", 10),
    SPADES_KING("Spades", 10);

    private final String suit;
    private final int value;

    CardData(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

}

