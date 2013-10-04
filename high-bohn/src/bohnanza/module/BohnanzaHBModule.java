package bohnanza.module;

import bohnanza.Bohnanza;
import bohnanza.game.player.Player;
import bohnanza.game.player.Treasury;
import bohnanza.game.shared.Box;
import bohnanza.game.shared.DiscardPile;
import bohnanza.game.shared.DrawDeck;
import bohnanza.gameplay.End;
import bohnanza.gameplay.GameContext;
import bohnanza.view.View;

import com.google.inject.Provider;

public class BohnanzaHBModule extends BohnanzaModule {

    @Override
    protected Class<? extends Provider<? extends Player>> getPlayerProviderClass() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Class<? extends Box> getBoxClass() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Class<? extends GameContext> getGameContextClass() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Class<? extends DrawDeck> getDrawDeckClass() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Class<? extends DiscardPile> getDiscardPileClass() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Class<? extends View> getViewClass() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Class<? extends Bohnanza> getBohnanzaClass() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Class<? extends End> getEndClass() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Class<? extends Treasury> getTreasuryClass() {
        // TODO Auto-generated method stub
        return null;
    }

}
