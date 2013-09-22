package bohnanza.game.shared;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import bohnanza.game.factory.ThirdBeanFieldCreator;

public class BoxTest {

    private Box box;

    public static final String TO_STRING_MESSAGE = "3rd bean field cards: 7";

    @Before
    public final void setUp() {
        box = new Box();
    }

    @Test
    public final void testInitializeCollection() throws Exception {
        assertTrue(box.hasCards());
        assertEquals(ThirdBeanFieldCreator.AMOUNT, box.getSize());
    }

    @Test
    public final void testToString() throws Exception {
        assertEquals(TO_STRING_MESSAGE, box.toString());
    }

}
