package bohnanza.gameplay;

import bohnanza.game.shared.Box;
import bohnanza.game.shared.DiscardPile;
import bohnanza.game.shared.DrawDeck;
import bohnanza.view.View;

import com.google.inject.Inject;

public class GameContextStd extends GameContext {

    @Inject
    public GameContextStd(End endState, View view, DiscardPile discardPile,
            DrawDeck drawDeck, Box box) {
        super(endState, view, discardPile, drawDeck, box);
    }

    private static final int THREE = 3;

    @Override
    protected int getDrawDeckMaxExhausted() {
        return THREE;
    }

}
