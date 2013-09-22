package bohnanza.gameplay;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import bohnanza.game.Bean;

public class SecondTurnTest extends TurnTest {

    private SecondTurn secondTurn;

    @Override
    @Before
    public void setUp() {
        super.setUp();

        secondTurn = SecondTurn.getInstance();
    }

    @Test
    public final void testExecute() throws Exception {

        when(
                getView().getOptionsFromDrawArea(
                        Matchers.<Collection<Bean>> any())).thenReturn(value);

        when(getView().getOptionsFromHand(Matchers.<Collection<Bean>> any()))
                .thenReturn(value);

        when(getView().getOptionsFromHand(Matchers.<Collection<Bean>> any()))
                .thenReturn(value);

    }

    @Test
    public final void testGetInstance() throws Exception {
        assertEquals(secondTurn, SecondTurn.getInstance());
    }

}
