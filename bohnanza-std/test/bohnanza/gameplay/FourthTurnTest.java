package bohnanza.gameplay;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FourthTurnTest extends GamePlayTest {

    private FourthTurn fourthTurn;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        fourthTurn = FourthTurn.getInstance();
    }

    @Test
    public final void testExecute() throws Exception {
        getGameContext().getCurrentPlayer().shuffle();

        fourthTurn.execute(getGameContext());

        assertEquals(getGameContext().getPlayers().get(1), getGameContext()
                .getCurrentPlayer());
        assertEquals(FourthTurn.THREE_CARDS, getGameContext()
                .getCurrentPlayer().getLeftPlayer().getHand().size());
        assertEquals(FirstTurn.getInstance(), getGameContext().getState());
        assertEquals(0, getGameContext().getDrawDeckExhaustedCount());

        getDiscardPile().add(getDrawDeck().empty());
        fourthTurn.execute(getGameContext());
        assertEquals(1, getGameContext().getDrawDeckExhaustedCount());

        getDiscardPile().add(getDrawDeck().empty());
        fourthTurn.execute(getGameContext());
        assertEquals(2, getGameContext().getDrawDeckExhaustedCount());

        getDiscardPile().add(getDrawDeck().empty());
        fourthTurn.execute(getGameContext());
        assertEquals(3, getGameContext().getDrawDeckExhaustedCount());

        assertEquals(getGameContext().getEndState(), getGameContext()
                .getState());

    }

    @Test
    public final void testGetInstance() throws Exception {
        assertEquals(FourthTurn.getInstance(), fourthTurn);
    }

}
