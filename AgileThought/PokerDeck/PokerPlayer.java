import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokerPlayer {
    private String name;
    // private List<PokerCard> cards;
    private Map<String, PokerCard> cardMap;

    PokerPlayer(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Player name can not be null or blank");
        this.name = name;
        cardMap = new HashMap<>();
    }

    void addCard(PokerCard card) {
        if (card != null)
            cardMap.put(card.getCardId(), card);
    }

    void removeCard(String cardId) {
        PokerCard card = cardMap.get(cardId);
        if (card != null)
            cardMap.remove(cardId);
        /*
         * for(int i = 0; i<cards.size();i++){
         * if(cards.get(i).getCardId().equalsIgnoreCase(cardId)){
         * cards.remove(i);
         * break;
         * }
         * }
         * for (PokerCard card : cards) {
         * if(card.getCardId().equalsIgnoreCase(cardId)){
         * cards.remove(card);
         * break;
         * }
         * }
         */
    }

    List<PokerCard> getCards() {
        return new ArrayList<>(cardMap.values());
    }

    void removeAllCard() {
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
