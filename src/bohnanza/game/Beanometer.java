package bohnanza.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Beanometer {

    /**
     * 
     */
    private static final long serialVersionUID = 8307953604312955607L;

    private final Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    private static final int ONE_COIN = 1;

    private static final int TWO_COINS = 2;

    private static final int THREE_COINS = 3;

    private static final int FOUR_COINS = 4;

    public static final int TWO_CARDS = 2;

    public static final int THREE_CARDS = 3;

    public static final int FOUR_CARDS = 4;

    public static final int FIVE_CARDS = 5;

    public static final int SIX_CARDS = 6;

    public static final int SEVEN_CARDS = 7;

    public static final int EIGHT_CARDS = 8;

    public static final int NINE_CARDS = 9;

    public static final int TEN_CARDS = 10;

    public static final int ELEVEN_CARDS = 11;

    public static final int TWELVE_CARDS = 12;

    private static final String TO_STRING_MESSAGE = "%d->1, %d->2, %d->3, %d->4";

    public int getWorth(int cards) {

        Integer worth = null;

        int test = cards;

        while (worth == null && test > 1) {
            worth = map.get(test);
            test--;
        }

        return worth == null ? 0 : worth;

    }

    private void setCardsForCoins(int cards, int coins) {
        map.put(cards, coins);
    }

    public void setCardsForOneCoin(int cards) {
        setCardsForCoins(cards, ONE_COIN);
    }

    public void setCardsForTwoCoins(int cards) {
        setCardsForCoins(cards, TWO_COINS);
    }

    public void setCardsForThreeCoins(int cards) {
        setCardsForCoins(cards, THREE_COINS);
    }

    public void setCardsForFourCoins(int cards) {
        setCardsForCoins(cards, FOUR_COINS);
    }

    @Override
    public String toString() {

        Set<Integer> cards = map.keySet();

        return String.format(TO_STRING_MESSAGE, cards.iterator().next(), cards
                .iterator().next(), cards.iterator().next(), cards.iterator()
                .next());
    }
}
