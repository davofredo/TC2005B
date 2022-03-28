package com.at.internship.poker;

import java.util.*;

public class PokerMain {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Set<PokerPlayer> playerSet = new LinkedHashSet<>();
        String nextPlayer = "";
        do {
            System.out.print("Enter player name (Leave blank to finish): ");
            nextPlayer = scanner.nextLine();
            if(!nextPlayer.isBlank()) {
                playerSet.add(new PokerPlayer(nextPlayer));
            }
        } while(!nextPlayer.isBlank());

        if(playerSet.isEmpty()) {
            System.err.println("The program cannot continue without players.");
            return;
        }

        play(playerSet);
    }

    static void play(Set<PokerPlayer> playerSet) {
        boolean keepPlaying = true;
        while(keepPlaying) {
            try {
                playerSet.forEach(player -> player.removeAllCards());
                PokerDeck deck = new PokerDeck();
                deck.shuffle();
                Iterator<PokerCard> cardIterator = deck.iterator();
                deal(playerSet, cardIterator);
                handleChange(playerSet, cardIterator);
                showCards(playerSet);
            } catch (NoSuchElementException e) {
                System.err.println("All the cards have been dealt.");
            }
            System.out.print("Play again? Y/N [N]: ");
            String answer = scanner.nextLine();
            keepPlaying = "Y".equalsIgnoreCase(answer.trim());
        }
    }

    static void deal(Set<PokerPlayer> playerSet, Iterator<PokerCard> cardIterator) {
        for(int i = 0; i < 5; i++)
            playerSet.forEach(player -> player.addCard(cardIterator.next()));
    }

    static void handleChange(Set<PokerPlayer> playerSet, Iterator<PokerCard> cardIterator) {
        for(PokerPlayer player : playerSet) {
            showPlayerCards(player);
            System.out.print("Enter card IDs to change separated by comma: ");
            String[] changeIds = scanner.nextLine().split(",");
            // Arrays.stream(changeIds).forEach();
            for(String id: changeIds) {
                player.removeCard(id);
                if(player.getCards().size() < 5)
                    player.addCard(cardIterator.next());
            }
        }
    }

    static void showCards(Set<PokerPlayer> playerSet) {
        for(PokerPlayer player : playerSet)
            showPlayerCards(player);
    }

    static void showPlayerCards(PokerPlayer player) {
        System.out.printf("%s has the following cards:%n", player);
        for(PokerCard card : player.getCards())
            System.out.println(" - " + card);
    }

}
