package bohnanza.game.player;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class DrawAreaTest {

    private DrawArea drawArea;

    @Before
    public final void setUp() {
        drawArea = new DrawArea();
    }

    @Test
    public final void testInitializeCollection() {
        assertFalse(drawArea.hasCards());
    }

}
