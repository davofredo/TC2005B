import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PokerPlayerTest {
    public static void main(String[] args) {
        Set<PokerPlayer> playerSet = new HashSet<>();
        playerSet.add(new PokerPlayer("Pablo"));
        playerSet.add(new PokerPlayer("David"));
        playerSet.add(new PokerPlayer("Marco"));
        playerSet.add(new PokerPlayer("Alberto"));
        playerSet.add(new PokerPlayer("Raul"));
        playerSet.add(new PokerPlayer("David"));

        for (PokerPlayer player : playerSet) {
            System.out.println("Player");
        }

        PokerPlayer newPlayer = new PokerPlayer("David");
        PokerCard card1 = new PokerCard(PokerCard.SUIT_DIAMONS, 4);
        PokerCard card2 = new PokerCard(PokerCard.SUIT_CLOVERS, 12);
        newPlayer.addCard(card1);
        newPlayer.addCard(card2);
        newPlayer.addCard(null);

        newPlayer.removeCard("s4");
        for (PokerCard card : newPlayer.getCards()) {
            System.out.println(card);
        }

    }
}
