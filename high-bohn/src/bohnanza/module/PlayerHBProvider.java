package bohnanza.module;

import bohnanza.game.player.BeanField;
import bohnanza.game.player.DrawArea;
import bohnanza.game.player.Hand;
import bohnanza.game.player.KeepArea;
import bohnanza.game.player.Player;
import bohnanza.game.player.Treasury;
import bohnanza.game.shared.Box;
import bohnanza.game.shared.DiscardPile;
import bohnanza.game.shared.DrawDeck;

import com.google.inject.Inject;

public class PlayerHBProvider extends PlayerProvider {

    @Inject
    public PlayerHBProvider(DrawDeck drawDeck, DiscardPile discardPile, Box box) {
        super(drawDeck, discardPile, box);
    }

    @Override
    public Player get() {
        return new Player(new Hand(), new DrawArea(), new KeepArea(),
                new Treasury(), new BeanField(), new BeanField(),
                getDrawDeck(), getDiscardPile(), getBox());
    }
}
