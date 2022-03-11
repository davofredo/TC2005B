import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class PokerCard {
    static final String SUIT_SPADES = "SPADES";
    static final String SUIT_DIAMONS = "DIAMONS";
    static final String SUIT_CLOVERS = "CLOVERS";
    static final String SUIT_HEARTS = "HEARTS";

    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 13;

    static Set<String> suitSet() {
        //return new HashSet<>(Arrays.asList(SUIT_SPADES, SUIT_DIAMONS, SUIT_CLOVERS, SUIT_HEARTS));
        //return new TreeSet<>(Arrays.asList(SUIT_SPADES,SUIT_DIAMONS,SUIT_CLOVERS,SUIT_HEARTS));
        return new LinkedHashSet<>(Arrays.asList(SUIT_SPADES,SUIT_DIAMONS,SUIT_CLOVERS,SUIT_HEARTS));
    }

    private String suit;
    private int value;

    PokerCard(String suit, int value) {
        if (!suitSet().contains(suit) && !suit.isBlank())
            throw new IllegalArgumentException(
                    String.format("Valid suits are: %s, %s, %s and %s. Blank suit is also allowed, wich is joker"));
        if (value < MIN_VALUE || value > MAX_VALUE)
            throw new IllegalArgumentException(
                    String.format("Only values between %s and %s are allowed", MIN_VALUE, MAX_VALUE));

        this.suit = suit.trim();
        this.value = value;
    }

    public String getSuit() { return suit; }


}
