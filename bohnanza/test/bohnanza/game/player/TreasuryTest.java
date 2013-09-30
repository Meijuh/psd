package bohnanza.game.player;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class TreasuryTest {

    private Treasury treasury;

    @Before
    public final void setUp() {
        treasury = new Treasury();
    }

    @Test
    public final void testInitializeCollection() {
        assertFalse(treasury.hasCards());
    }
}
