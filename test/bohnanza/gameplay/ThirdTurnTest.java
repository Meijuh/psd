package bohnanza.gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;
import bohnanza.game.factory.Red;
import bohnanza.game.player.Player;

public class ThirdTurnTest extends GamePlayTest {

    private ThirdTurn thirdTurn;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        thirdTurn = ThirdTurn.getInstance();
    }

    @Test
    public final void testExecute() throws Exception {
        Bean bean = new Red(new Beanometer());
        getFirstKeepArea().add(bean);
        getFirstTreasury().add(new Red(new Beanometer()));
        getFirstTreasury().add(new Red(new Beanometer()));
        getFirstTreasury().add(new Red(new Beanometer()));

        when(getView().confirmBuy()).thenReturn(true);
        when(getView().getOptionFromKeepArea(Matchers.<List<Bean>> any()))
                .thenReturn(bean);
        when(getView().mustPlant(any(Player.class))).thenReturn(
                Player.FIRST_BEAN_FIELD);

        thirdTurn.execute(getGameContext());

        assertTrue(getGameContext().getCurrentPlayer().hasThirdBeanField());
        assertEquals(0, getGameContext().getCurrentPlayer().getTreasury());
        assertEquals(0, getGameContext().getCurrentPlayer().getKeepArea()
                .size());
        assertFalse(getGameContext().getCurrentPlayer().getKeepArea()
                .contains(bean));
        assertEquals(1, getFirstFirstBeanField().getCardsUnmodifiable().size());
        assertTrue(getFirstFirstBeanField().getCardsUnmodifiable().contains(
                bean));

        assertEquals(FourthTurn.getInstance(), getGameContext().getState());
    }

    @Test
    public final void testGetInstance() throws Exception {
        assertEquals(ThirdTurn.getInstance(), thirdTurn);
    }

}
