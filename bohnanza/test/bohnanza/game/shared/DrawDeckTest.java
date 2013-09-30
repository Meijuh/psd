package bohnanza.game.shared;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class DrawDeckTest {

    private DrawDeck drawDeck;

    public static final String TO_STRING_MESSAGE = "draw deck size: 0";

    @Before
    public final void setUp() {
        drawDeck = new DrawDeck();
    }

    @Test
    public final void testInitializeCollection() throws Exception {
        assertFalse(drawDeck.hasCards());
    }

    @Test
    public final void testToString() throws Exception {
        assertEquals(TO_STRING_MESSAGE, drawDeck.toString());
    }

}
