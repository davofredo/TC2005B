package com.at.internship.poker;

import java.util.*;

public class PokerCard {
    static final String SUIT_SPADES = "SPADES";
    static final String SUIT_DIAMONDS = "DIAMONDS";
    static final String SUIT_CLOVERS = "CLOVERS";
    static final String SUIT_HEARTS = "HEARTS";

    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 13;

    static Set<String> suitSet() {
        return new LinkedHashSet<>(Arrays.asList(SUIT_SPADES, SUIT_DIAMONDS, SUIT_CLOVERS, SUIT_HEARTS));
    }

    private String suit;
    private int value;

    PokerCard(String suit, int value) {
        if(!suitSet().contains(suit) && !suit.isBlank())
            throw new IllegalArgumentException(String.format("Valid suits are: %s, %s, %s and %s. Blank suit is also allowed, which means Joker", SUIT_SPADES, SUIT_DIAMONDS, SUIT_CLOVERS, SUIT_HEARTS));
        if(value < MIN_VALUE || value > MAX_VALUE)
            throw new IllegalArgumentException(String.format("Only values between %s and %s are allowed", MIN_VALUE, MAX_VALUE));

        this.suit = suit.trim();
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String getValueName() {
        switch (value) {
            case 1: return "A";
            case 13: return "K";
            case 12: return "Q";
            case 11: return "J";
            default: return String.valueOf(value);
        }
    }

    public String getCardId() {
        return suit.isBlank() ? "JOK-" + value : suit.substring(0, 1) + value;
    }

    public String toString() {
        return suit.isBlank() ? String.format("Joker (%s)", getCardId())
                : String.format("%s of %s (%s)", getValueName(), suit.toLowerCase(), getCardId());
    }

    public int hashCode() {
        return getCardId().hashCode();
    }

    public boolean equals(Object other) {
        if(other instanceof PokerCard) {
            PokerCard otherCard = (PokerCard) other;
            return otherCard.value == value && otherCard.suit.equals(suit);
        }
        return false;
    }

}
