package bohnanza.gameplay;

import static org.mockito.Mockito.mock;

import org.junit.Before;

import bohnanza.view.View;

public abstract class TurnTest extends GamePlayTest {

    @Override
    @Before
    public void setUp() {

        super.setUp();

        getGameContext().getPlayers().get(FIRST_PLAYER).setName(NAME_ONE);
        getGameContext().getPlayers().get(SECOND_PLAYER).setName(NAME_TWO);

        getGameContext().getPlayers().get(FIRST_PLAYER)
                .setPlayerNumber(FIRST_PLAYER + 1);
        getGameContext().getPlayers().get(SECOND_PLAYER)
                .setPlayerNumber(SECOND_PLAYER + 2);

        getGameContext()
                .getPlayers()
                .get(FIRST_PLAYER)
                .setLeftPlayer(getGameContext().getPlayers().get(SECOND_PLAYER));
        getGameContext().getPlayers().get(SECOND_PLAYER)
                .setLeftPlayer(getGameContext().getPlayers().get(FIRST_PLAYER));

        getGameContext().setCurrentPlayer(
                getGameContext().getPlayers().get(FIRST_PLAYER));

        getGameContext().getCurrentPlayer().shuffle();
    }

    @Override
    protected View setView() {
        return mock(View.class);
    }

}
