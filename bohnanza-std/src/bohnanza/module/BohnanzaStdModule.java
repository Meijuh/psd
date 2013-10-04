package bohnanza.module;

import bohnanza.Bohnanza;
import bohnanza.BohnanzaStd;
import bohnanza.game.player.Player;
import bohnanza.game.player.Treasury;
import bohnanza.game.player.TreasuryStd;
import bohnanza.game.shared.Box;
import bohnanza.game.shared.BoxStd;
import bohnanza.game.shared.DiscardPile;
import bohnanza.game.shared.DiscardPileStd;
import bohnanza.game.shared.DrawDeck;
import bohnanza.gameplay.End;
import bohnanza.gameplay.EndStd;
import bohnanza.gameplay.GameContext;
import bohnanza.gameplay.GameContextStd;
import bohnanza.view.TUIView;
import bohnanza.view.View;

import com.google.inject.Provider;

public class BohnanzaStdModule extends BohnanzaModule {

    @Override
    protected Class<? extends Provider<? extends Player>> getPlayerProviderClass() {
        return PlayerStdProvider.class;
    }

    @Override
    protected Class<? extends Box> getBoxClass() {
        return BoxStd.class;
    }

    @Override
    protected Class<? extends GameContext> getGameContextClass() {
        return GameContextStd.class;
    }

    @Override
    protected Class<? extends DrawDeck> getDrawDeckClass() {
        return DrawDeck.class;
    }

    @Override
    protected Class<? extends DiscardPile> getDiscardPileClass() {
        return DiscardPileStd.class;
    }

    @Override
    protected Class<? extends View> getViewClass() {
        return TUIView.class;
    }

    @Override
    protected Class<? extends Bohnanza> getBohnanzaClass() {
        return BohnanzaStd.class;
    }

    @Override
    protected Class<? extends End> getEndClass() {
        return EndStd.class;
    }

    @Override
    protected Class<? extends Treasury> getTreasuryClass() {
        return TreasuryStd.class;
    }
}
