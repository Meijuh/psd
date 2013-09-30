package bohnanza.game.player;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class KeepAreaTest {

    private KeepArea keepArea;

    @Before
    public final void setUp() {
        keepArea = new KeepArea();
    }

    @Test
    public final void testInitializeCollection() {
        assertFalse(keepArea.hasCards());
    }
}
