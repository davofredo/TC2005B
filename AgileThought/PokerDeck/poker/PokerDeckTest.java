package com.at.internship.poker;

public class PokerDeckTest {
    public static void main(String[] args) {
        PokerDeck deck = new PokerDeck();

        // Print all the cards
        for(PokerCard card : deck) {
            System.out.println(card);
        }

        // Now shuffle
        deck.shuffle();

        // Let's print them all again
        for(PokerCard card : deck) {
            System.out.println(card);
        }
    }
}
