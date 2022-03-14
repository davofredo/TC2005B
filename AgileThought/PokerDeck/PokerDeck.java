import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PokerDeck implements Iterable<PokerCard> {
    private List<PokerCard> cardList;

    PokerDeck() {
        collect();
    }

    private void collect() {
        cardList = new ArrayList<>();
        Set<String> suitSet = PokerCard.suitSet();
        // Add 13 cards for each suit
        for (String suit : suitSet)
            for (int i = PokerCard.MIN_VALUE; i <= PokerCard.MAX_VALUE; i++)
                cardList.add(new PokerCard(suit, i));

        // Add two jokers
        cardList.add(new PokerCard("", 1));
        cardList.add(new PokerCard("", 2));
    }

    void shuffle() {

    }

    private void shift(int i1, int i2) {

    }

    @Override
    public Iterator<PokerCard> iterator() {
        return cardList.iterator();
    }
}
