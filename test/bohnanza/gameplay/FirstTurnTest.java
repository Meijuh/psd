package bohnanza.gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import bohnanza.game.Bean;
import bohnanza.game.player.Player;

public class FirstTurnTest extends GamePlayTest {

    private FirstTurn firstTurn;

    private static final int MUST_PLANT = 1;

    private static final int MAY_PLANT = 2;

    private static final int NO_FIELD = 1337;

    @Override
    @Before
    public final void setUp() {

        super.setUp();

        firstTurn = FirstTurn.getInstance();

    }

    @Test
    public final void testExecute() throws Exception {

        when(getView().mustPlant(any(Player.class))).thenReturn(MUST_PLANT);
        when(getView().mayPlant(any(Player.class))).thenReturn(MAY_PLANT);

        getGameContext().getCurrentPlayer().drawIntoHand();
        getGameContext().getCurrentPlayer().drawIntoHand();

        Bean beanOne = getGameContext().getCurrentPlayer().getHand().get(0);
        Bean beanTwo = getGameContext().getCurrentPlayer().getHand().get(1);

        firstTurn.execute(getGameContext());

        assertFalse(getGameContext().getCurrentPlayer().isHandNotEmpty());

        assertTrue(getFirstFirstBeanField().getCardsUnmodifiable().contains(
                beanOne));
        assertTrue(getFirstSecondBeanField().getCardsUnmodifiable().contains(
                beanTwo));

        assertEquals(SecondTurn.getInstance(), getGameContext().getState());

        getGameContext().getCurrentPlayer().drawIntoHand();
        getGameContext().getCurrentPlayer().drawIntoHand();

        when(getView().mustPlant(any(Player.class))).thenReturn(NO_FIELD);

        firstTurn.execute(getGameContext());
        assertEquals(Fail.getInstance(), getGameContext().getState());

    }

    @Test
    public final void testGetInstance() throws Exception {
        assertEquals(firstTurn, FirstTurn.getInstance());
    }

}
