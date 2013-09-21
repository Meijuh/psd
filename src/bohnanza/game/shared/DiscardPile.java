package bohnanza.game.shared;

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

    @Override
    protected void initializeCollection() {
        getCards().addAll(BlackEyedCreator.getInstance().createCards());
        getCards().addAll(BlueCreator.getInstance().createCards());
        getCards().addAll(ChiliCreator.getInstance().createCards());
        getCards().addAll(CocoaCreator.getInstance().createCards());
        getCards().addAll(CoffeeCreator.getInstance().createCards());
        getCards().addAll(GardenCreator.getInstance().createCards());
        getCards().addAll(GreenCreator.getInstance().createCards());
        getCards().addAll(RedCreator.getInstance().createCards());
        getCards().addAll(SoyCreator.getInstance().createCards());
        getCards().addAll(StinkCreator.getInstance().createCards());
        getCards().addAll(WaxCreator.getInstance().createCards());
    }

    public void discard(Bean bean) {
        getCards().add(bean);
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, getCards().size());
    }

}
