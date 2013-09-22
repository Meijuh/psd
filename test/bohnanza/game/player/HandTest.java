package bohnanza.game.player;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class HandTest {

    private Hand hand;

    @Before
    public final void setUp() {
        hand = new Hand();
    }

    @Test
    public final void testInitializeCollection() {
        assertFalse(hand.hasCards());
    }

}
