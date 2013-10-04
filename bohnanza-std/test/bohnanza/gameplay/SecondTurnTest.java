package bohnanza.gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;
import bohnanza.game.Type;
import bohnanza.game.factory.Red;
import bohnanza.game.player.Player;

public class SecondTurnTest extends GamePlayTest {

    private SecondTurn secondTurn;

    @Override
    @Before
    public void setUp() {
        super.setUp();

        secondTurn = SecondTurn.getInstance();
    }

    @Test
    public final void testExecute() throws Exception {

        // Move cards from the discard pile to the draw deck.
        getGameContext().getCurrentPlayer().shuffle();

        getGameContext().getCurrentPlayer().drawIntoHand();
        getGameContext().getCurrentPlayer().drawIntoHand();

        // Select the cards to trade from the current player's hand. Trade only
        // once.
        Collection<Bean> cardsFromHand = new ArrayList<Bean>();
        cardsFromHand.add(getFirstHand().getCardsUnmodifiable().get(0));
        cardsFromHand.add(getFirstHand().getCardsUnmodifiable().get(1));

        // Fix the trade partner's hand.
        Bean red = new Red(new Beanometer());
        getSecondHand().add(red);

        Collection<Bean> tradePartnerHand = new ArrayList<Bean>();
        tradePartnerHand.add(red);

        when(getView().getOptionsFromHand(Matchers.<Collection<Bean>> any()))
                .thenReturn(cardsFromHand).thenReturn(tradePartnerHand)
                .thenReturn(new ArrayList<Bean>());

        // We first configure the View mock.
        // Select the cards to trade from the current player's draw area. Trade
        // only once.
        Collection<Bean> cardsFromDrawArea = new ArrayList<Bean>();
        cardsFromDrawArea.add(getDrawDeck().getCardsUnmodifiable().get(0));
        cardsFromDrawArea.add(getDrawDeck().getCardsUnmodifiable().get(1));

        when(
                getView().getOptionsFromDrawArea(
                        Matchers.<Collection<Bean>> any())).thenReturn(
                cardsFromDrawArea).thenReturn(new ArrayList<Bean>());

        // Select the type of cards the player wants to have. Trade only once.
        Collection<Type> types = EnumSet.of(Type.RED);

        when(getView().getOptionsFromType(Matchers.<Collection<Type>> any()))
                .thenReturn(types).thenReturn(new ArrayList<Type>());

        // Select the trade partner.
        Player tradePartner = getGameContext().getCurrentPlayer()
                .getLeftPlayer();

        when(
                getView().getTradePartner(Matchers.<Collection<Type>> any(),
                        Matchers.<Collection<Bean>> any(),
                        Matchers.<Collection<Bean>> any(), any(Player.class)))
                .thenReturn(tradePartner);

        // Confirm the trade.
        when(
                getView().confirmTrade(Matchers.<Collection<Bean>> any(),
                        Matchers.<Collection<Bean>> any(), any(Player.class),
                        Matchers.<Collection<Bean>> any())).thenReturn(true);

        secondTurn.execute(getGameContext());

        assertEquals(0, getGameContext().getCurrentPlayer().getHand().size());
        assertEquals(0, getGameContext().getCurrentPlayer().getDrawArea()
                .size());
        assertEquals(1, getGameContext().getCurrentPlayer().getKeepArea()
                .size());
        assertTrue(getGameContext().getCurrentPlayer().getKeepArea()
                .contains(red));

        assertEquals(4, tradePartner.getKeepArea().size());
        assertTrue(tradePartner.getKeepArea().containsAll(cardsFromDrawArea));
        assertTrue(tradePartner.getKeepArea().containsAll(cardsFromHand));

        assertEquals(ThirdTurn.getInstance(), getGameContext().getState());

    }

    @Test
    public final void testGetInstance() throws Exception {
        assertEquals(secondTurn, SecondTurn.getInstance());
    }

}
