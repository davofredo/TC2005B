import java.util.Set;

public class PokerCardTest {
    
    public static void main(String[] args) {
        Set<String> suiSet = PokerCard.suiSet();

        for (String suit : suiSet) {
            System.out.println(suit);
        }
    }
}
