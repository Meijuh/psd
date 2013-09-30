package bohnanza.gameplay;

import bohnanza.game.shared.Box;
import bohnanza.game.shared.DiscardPile;
import bohnanza.game.shared.DrawDeck;
import bohnanza.view.View;

import com.google.inject.Inject;

public class GameContextHB extends GameContext {

    @Inject
    public GameContextHB(End endState, View view, DiscardPile discardPile,
            DrawDeck drawDeck, Box box) {
        super(endState, view, discardPile, drawDeck, box);
    }

    private static final int EXHAUSTED_THREE = 3;
    private static final int EXHAUSTED_FOUR = 4;

    private static final int PLAYERS_THREE = 3;
    private static final int PLAYERS_FOUR = 4;
    private static final int PLAYERS_FIVE = 5;

    @Override
    protected int getDrawDeckMaxExhausted() {

        int result = -1;

        switch (getPlayers().size()) {
        case PLAYERS_FIVE:
            result = EXHAUSTED_FOUR;
            break;
        case PLAYERS_FOUR:
        case PLAYERS_THREE:
            result = EXHAUSTED_THREE;
            break;

        }

        return result;

    }
}
