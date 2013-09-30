package bohnanza.module;

import bohnanza.game.player.Player;
import bohnanza.game.shared.Box;
import bohnanza.game.shared.DiscardPile;
import bohnanza.game.shared.DrawDeck;

import com.google.inject.Provider;

public abstract class PlayerProvider implements Provider<Player> {

    private final DrawDeck drawDeck;

    private final DiscardPile discardPile;

    private final Box box;

    public PlayerProvider(DrawDeck drawDeck, DiscardPile discardPile, Box box) {
        this.drawDeck = drawDeck;
        this.discardPile = discardPile;
        this.box = box;
    }

    protected DrawDeck getDrawDeck() {
        return drawDeck;
    }

    protected DiscardPile getDiscardPile() {
        return discardPile;
    }

    protected Box getBox() {
        return box;
    }

}
