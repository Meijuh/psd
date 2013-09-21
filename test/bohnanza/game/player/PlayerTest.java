package bohnanza.game.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import bohnanza.game.shared.DiscardPile;
import bohnanza.game.shared.DrawDeck;

public class PlayerTest {

    @Mock
    private final Hand hand = mock(Hand.class);

    @Mock
    private final DrawArea drawArea = mock(DrawArea.class);

    @Mock
    private final KeepArea keepArea = mock(KeepArea.class);

    @Mock
    private final BeanField firstBeanField = mock(BeanField.class);

    @Mock
    private final BeanField secondBeanField = mock(BeanField.class);

    @Mock
    private final DrawDeck drawDeck = mock(DrawDeck.class);

    @Mock
    private final DiscardPile discardPile = mock(DiscardPile.class);

    @InjectMocks
    private Player player;

    @Test
    public final void testPlayer() {
        assertEquals(0, player.getCardsFromHand().size());
        assertEquals(0, player.getDrawAreaCards().size());
        assertFalse(player.canDrawOneCard());
    }

    @Test
    public final void testSetLeftPlayer() {

        player.setLeftPlayer(player);

        assertEquals(player.getLeftPlayer(), player);

    }

    @Test
    public final void testGetLeftPlayer() {

        player.setLeftPlayer(player);

        assertEquals(player.getLeftPlayer(), player);
    }

    @Test
    public final void testSetName() {
        player.setName(null);

        assertNull(player.getName());
    }

    @Test
    public final void testGetName() {
        player.setName(null);

        assertNull(player.getName());
    }

    @Test
    public final void testSetPlayerNumber() {
        player.setPlayerNumber(0);
        assertEquals(0, player.getPlayerNumber());
    }

    @Test
    public final void testGetPlayerNumber() {
        player.setPlayerNumber(0);
        assertEquals(0, player.getPlayerNumber());
    }

    @Test
    public final void testPlantInt() throws FarmException {
        
        Bean bean = new 

    }

    @Test
    public final void testPlantIntBean() {

    }

    @Test
    public final void testHasThirdBeanField() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testDrawTwoCards() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testDrawOneCard() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testDrawThreeCards() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testGetDrawAreaCards() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testHasDrawAreaCards() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testGetDrawAreaCard() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testReceiveFromHand() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testReceiveFromDrawArea() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testRemoveFromDrawArea() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testGetKeepAreaCards() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testHasKeepAreaCards() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testBuy() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testHasCardsInHand() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testGetCardsFromHand() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testDrawFromSharedArea() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testCanDrawThreeCards() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testCanDrawTwoCards() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testCanDrawOneCard() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testShuffle() {
        // TODO
        fail("not yet implemented");
    }

    @Test
    public final void testToString() {
        // TODO
        fail("not yet implemented");
    }

}
