package bohnanza.gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import bohnanza.view.View;

public class PrepareTest extends GamePlayTest {

    private Prepare prepare;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        prepare = Prepare.getInstance();
    }

    @Test
    public final void testExecute() throws Exception {

        when(getView().getName(any(Integer.class))).thenReturn(NAME_ONE)
                .thenReturn(NAME_TWO);

        prepare.execute(getGameContext());

        assertTrue(getGameContext().getPlayers().get(FIRST_PLAYER).getName()
                .equals(NAME_ONE)
                || getGameContext().getPlayers().get(SECOND_PLAYER).getName()
                        .equals(NAME_ONE));

        assertTrue(getGameContext().getPlayers().get(FIRST_PLAYER).getName()
                .equals(NAME_TWO)
                || getGameContext().getPlayers().get(SECOND_PLAYER).getName()
                        .equals(NAME_TWO));

        assertEquals(FIRST_PLAYER + 1,
                getGameContext().getPlayers().get(FIRST_PLAYER)
                        .getPlayerNumber());
        assertEquals(SECOND_PLAYER + 1,
                getGameContext().getPlayers().get(SECOND_PLAYER)
                        .getPlayerNumber());

        assertEquals(getGameContext().getPlayers().get(FIRST_PLAYER).getName(),
                getGameContext().getPlayers().get(SECOND_PLAYER)
                        .getLeftPlayer().getName());
        assertEquals(
                getGameContext().getPlayers().get(SECOND_PLAYER).getName(),
                getGameContext().getPlayers().get(FIRST_PLAYER).getLeftPlayer()
                        .getName());

        assertEquals(Prepare.HAND_SIZE,
                getGameContext().getPlayers().get(FIRST_PLAYER).getHand()
                        .size());
        assertEquals(Prepare.HAND_SIZE,
                getGameContext().getPlayers().get(SECOND_PLAYER).getHand()
                        .size());

        assertNotNull(getGameContext().getCurrentPlayer());

        assertEquals(FirstTurn.getInstance(), getGameContext().getState());
    }

    @Test
    public final void testGetInstance() throws Exception {
        assertNotNull(prepare);
    }

    @Override
    protected View setView() {
        return mock(View.class);
    }

}
