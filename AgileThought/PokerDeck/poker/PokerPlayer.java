package com.at.internship.poker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokerPlayer {
    private String name;
    private Map<String, PokerCard> cardMap;

    PokerPlayer(String name) {
        if(name == null || name.isBlank())
            throw new IllegalArgumentException("Player name cannot be null or blank");
        this.name = name;
        cardMap = new HashMap<>();
    }

    void addCard(PokerCard card) {
        if(card != null)
            cardMap.put(card.getCardId(), card);
    }

    void removeCard(String cardId) {
        cardMap.remove(cardId);
    }

    List<PokerCard> getCards() {
        return new ArrayList<>(cardMap.values());
    }

    void removeAllCards() {
        cardMap = new HashMap<>();
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof PokerPlayer && ((PokerPlayer) other).name.equals(name);
    }

    @Override
    public String toString() {
        return "Player - " + name;
    }
}
