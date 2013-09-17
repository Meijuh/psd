package bohnanza.game.shared;

import java.util.Collection;

import bohnanza.game.Bean;
import bohnanza.game.Field;
import bohnanza.game.factory.BlackEyedCreator;
import bohnanza.game.factory.BlueCreator;
import bohnanza.game.factory.ChiliCreator;
import bohnanza.game.factory.CocoaCreator;
import bohnanza.game.factory.CoffeeCreator;
import bohnanza.game.factory.GardenCreator;
import bohnanza.game.factory.GreenCreator;
import bohnanza.game.factory.RedCreator;
import bohnanza.game.factory.SoyCreator;
import bohnanza.game.factory.StinkCreator;
import bohnanza.game.factory.WaxCreator;

public class DiscardPile extends Field {

    private static final String TO_STRING_MESSAGE = "discarded: %d";

    DiscardPile() {
        super();
    }

    @Override
    protected void initializeCollection() {
        addAll(BlackEyedCreator.getInstance().createCards());
        addAll(BlueCreator.getInstance().createCards());
        addAll(ChiliCreator.getInstance().createCards());
        addAll(CocoaCreator.getInstance().createCards());
        addAll(CoffeeCreator.getInstance().createCards());
        addAll(GardenCreator.getInstance().createCards());
        addAll(GreenCreator.getInstance().createCards());
        addAll(RedCreator.getInstance().createCards());
        addAll(SoyCreator.getInstance().createCards());
        addAll(StinkCreator.getInstance().createCards());
        addAll(WaxCreator.getInstance().createCards());
    }

    public void discard(Collection<Bean> beans) {
        getCards().addAll(beans);
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, getCards().size());
    }

}
