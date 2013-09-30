package bohnanza.module;

import bohnanza.Bohnanza;
import bohnanza.game.player.Player;
import bohnanza.game.shared.Box;
import bohnanza.game.shared.DiscardPile;
import bohnanza.game.shared.DrawDeck;
import bohnanza.gameplay.End;
import bohnanza.gameplay.GameContext;
import bohnanza.view.View;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Singleton;

public abstract class BohnanzaModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Bohnanza.class).to(getBohnanzaClass());
        bind(View.class).to(getViewClass());
        bind(GameContext.class).to(getGameContextClass());
        bind(DiscardPile.class).to(getDiscardPileClass()).in(Singleton.class);
        bind(DrawDeck.class).to(getDrawDeckClass()).in(Singleton.class);
        bind(Box.class).to(getBoxClass()).in(Singleton.class);
        bind(End.class).to(getEndClass());
        bind(Player.class).toProvider(getPlayerProviderClass());

    }

    protected abstract Class<? extends Provider<? extends Player>> getPlayerProviderClass();

    protected abstract Class<? extends Box> getBoxClass();

    protected abstract Class<? extends GameContext> getGameContextClass();

    protected abstract Class<? extends DrawDeck> getDrawDeckClass();

    protected abstract Class<? extends DiscardPile> getDiscardPileClass();

    protected abstract Class<? extends View> getViewClass();

    protected abstract Class<? extends Bohnanza> getBohnanzaClass();

    protected abstract Class<? extends End> getEndClass();

}
