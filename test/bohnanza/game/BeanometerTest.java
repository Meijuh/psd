package bohnanza.game;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BeanometerTest {

    private static final int ZERO_COINS = 0;

    private static final int ONE_CARD = 1;

    private Beanometer beanometer;

    private static final String TO_STRING = "2->1, 4->2, 6->3, 8->4";

    private static final String TO_STRING_NO_ONE_COIN = "x,   4->2, 6->3, 8->4";

    @Before
    public void setUp() {
        beanometer = new Beanometer();
    }

    @Test
    public final void testGetWorth() {
        beanometer.setCardsForOneCoin(Beanometer.TWO_CARDS);
        beanometer.setCardsForTwoCoins(Beanometer.FOUR_CARDS);
        beanometer.setCardsForThreeCoins(Beanometer.SIX_CARDS);
        beanometer.setCardsForFourCoins(Beanometer.EIGHT_CARDS);

        assertEquals(ZERO_COINS, beanometer.getWorth(ONE_CARD));
        assertEquals(Beanometer.ONE_COIN,
                beanometer.getWorth(Beanometer.TWO_CARDS));
        assertEquals(Beanometer.ONE_COIN,
                beanometer.getWorth(Beanometer.THREE_CARDS));
        assertEquals(Beanometer.TWO_COINS,
                beanometer.getWorth(Beanometer.FOUR_CARDS));
        assertEquals(Beanometer.TWO_COINS,
                beanometer.getWorth(Beanometer.FIVE_CARDS));
        assertEquals(Beanometer.THREE_COINS,
                beanometer.getWorth(Beanometer.SIX_CARDS));
        assertEquals(Beanometer.THREE_COINS,
                beanometer.getWorth(Beanometer.SEVEN_CARDS));
        assertEquals(Beanometer.FOUR_COINS,
                beanometer.getWorth(Beanometer.EIGHT_CARDS));
        assertEquals(Beanometer.FOUR_COINS,
                beanometer.getWorth(Beanometer.NINE_CARDS));
    }

    @Test
    public final void testSetNoCardsForOneCoin() {
        assertEquals(ZERO_COINS, beanometer.getWorth(Beanometer.TWO_CARDS));
    }

    @Test
    public final void testSetCardsForOneCoin() {
        beanometer.setCardsForOneCoin(Beanometer.TWO_CARDS);
        assertEquals(Beanometer.ONE_COIN,
                beanometer.getWorth(Beanometer.TWO_CARDS));
    }

    @Test
    public final void testSetCardsForTwoCoins() {
        beanometer.setCardsForTwoCoins(Beanometer.FOUR_CARDS);
        assertEquals(Beanometer.TWO_COINS,
                beanometer.getWorth(Beanometer.FOUR_CARDS));
    }

    @Test
    public final void testSetCardsForThreeCoins() {
        beanometer.setCardsForThreeCoins(Beanometer.SIX_CARDS);
        assertEquals(Beanometer.THREE_COINS,
                beanometer.getWorth(Beanometer.SIX_CARDS));
    }

    @Test
    public final void testSetCardsForFourCoins() {
        beanometer.setCardsForFourCoins(Beanometer.EIGHT_CARDS);
        assertEquals(Beanometer.FOUR_COINS,
                beanometer.getWorth(Beanometer.EIGHT_CARDS));
    }

    @Test
    public final void testToString() {
        beanometer.setCardsForOneCoin(Beanometer.TWO_CARDS);
        beanometer.setCardsForTwoCoins(Beanometer.FOUR_CARDS);
        beanometer.setCardsForThreeCoins(Beanometer.SIX_CARDS);
        beanometer.setCardsForFourCoins(Beanometer.EIGHT_CARDS);

        assertEquals(TO_STRING, beanometer.toString());
    }

    @Test
    public final void testToStringNoOneCoin() {
        beanometer.setCardsForTwoCoins(Beanometer.FOUR_CARDS);
        beanometer.setCardsForThreeCoins(Beanometer.SIX_CARDS);
        beanometer.setCardsForFourCoins(Beanometer.EIGHT_CARDS);

        assertEquals(TO_STRING_NO_ONE_COIN, beanometer.toString());
    }

}
