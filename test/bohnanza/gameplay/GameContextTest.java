package bohnanza.gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mockito;

import bohnanza.game.player.Player;
import bohnanza.view.TUIView;
import bohnanza.view.View;

public class GameContextTest extends GamePlayTest {

    public static final String TO_STRING_MESSAGE = "State: prepare, players: 2, draw deck shuffled: 0 times, current player: test";

    @Test
    public final void testGameContext() throws Exception {
        assertEquals(PLAYERS, getGameContext().getPlayers().size());
        assertFalse(getGameContext().isDrawDeckExhaustedThreeTimes());
        assertEquals(1, getGameContext().countObservers());
        assertEquals(1, getDiscardPile().countObservers());
        assertEquals(1, getBox().countObservers());
        assertEquals(1, getDrawDeck().countObservers());

        for (Player player : getGameContext().getPlayers()) {
            assertEquals(1, player.countObservers());
            assertEquals(0, player.getHand().size());
            assertEquals(0, player.getDrawArea().size());
            assertEquals(0, player.getKeepArea().size());
            assertEquals(0, player.getTreasury());

        }

        assertEquals(Prepare.getInstance(), getGameContext().getState());

    }

    @Test
    public final void testChangeState() throws Exception {
        getGameContext().changeState(Prepare.getInstance());
        assertEquals(Prepare.getInstance(), getGameContext().getState());
    }

    @Test
    public final void testGetState() throws Exception {
        getGameContext().changeState(Prepare.getInstance());
        assertEquals(Prepare.getInstance(), getGameContext().getState());
    }

    @Test
    public final void testExecute() throws Exception {
        GameState mock = mock(GameState.class);

        Mockito.doNothing().when(mock).execute(getGameContext());

    }

    @Test
    public final void testGetView() throws Exception {
        assertEquals(getView(), getGameContext().getView());
    }

    @Test
    public final void testGetPlayers() throws Exception {
        assertEquals(PLAYERS, getGameContext().getPlayers().size());
    }

    @Test
    public final void testSetCurrentPlayer() throws Exception {
        Player player = getGameContext().getPlayers().get(0);

        getGameContext().setCurrentPlayer(player);

        assertEquals(player, getGameContext().getCurrentPlayer());
    }

    @Test
    public final void testGetCurrentPlayer() throws Exception {
        Player player = getGameContext().getPlayers().get(0);

        getGameContext().setCurrentPlayer(player);

        assertEquals(player, getGameContext().getCurrentPlayer());
    }

    @Test
    public final void testSetExitStatus() throws Exception {
        getGameContext().setExitStatus(0);
        assertEquals(0, getGameContext().getExitStatus());
    }

    @Test
    public final void testGetExitStatus() throws Exception {
        getGameContext().setExitStatus(0);
        assertEquals(0, getGameContext().getExitStatus());
    }

    @Test
    public final void testIncreaseDrawDeckExhausted() throws Exception {
        getGameContext().increaseDrawDeckExhausted();
        getGameContext().increaseDrawDeckExhausted();
        getGameContext().increaseDrawDeckExhausted();

        assertTrue(getGameContext().isDrawDeckExhaustedThreeTimes());
    }

    @Test
    public final void testIsDrawDeckExhaustedThreeTimes() throws Exception {

        assertFalse(getGameContext().isDrawDeckExhaustedThreeTimes());

        getGameContext().increaseDrawDeckExhausted();
        getGameContext().increaseDrawDeckExhausted();
        getGameContext().increaseDrawDeckExhausted();

        assertTrue(getGameContext().isDrawDeckExhaustedThreeTimes());
    }

    @Test
    public final void testToString() throws Exception {
        getGameContext().setCurrentPlayer(getGameContext().getPlayers().get(0));
        getGameContext().getPlayers().get(0).setName("test");
        assertEquals(TO_STRING_MESSAGE, getGameContext().toString());
    }

    @Override
    protected View setView() {
        return new TUIView();
    }

}
