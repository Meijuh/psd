package bohnanza.game.shared;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DiscardPileStdTest {

    private DiscardPile discardPile;

    public static final String TO_STRING_MESSAGE = "discarded: 154";

    public static final int AMOUNT = 154;

    @Before
    public final void setUp() {
        discardPile = new DiscardPileStd();
    }

    @Test
    public final void testInitializeCollection() throws Exception {
        assertTrue(discardPile.hasCards());
        assertEquals(AMOUNT, discardPile.getSize());
    }

    @Test
    public final void testToString() throws Exception {
        assertEquals(TO_STRING_MESSAGE, discardPile.toString());
    }

}
