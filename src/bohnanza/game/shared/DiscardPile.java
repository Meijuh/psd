package bohnanza.game.shared;

import bohnanza.game.Bean;
import bohnanza.game.CardList;
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

public class DiscardPile extends CardList<Bean> {

    private static final String TO_STRING_MESSAGE = "discarded: %d";

    @Override
    protected void initializeCollection() {
        add(BlackEyedCreator.getInstance().createCards());
        add(BlueCreator.getInstance().createCards());
        add(ChiliCreator.getInstance().createCards());
        add(CocoaCreator.getInstance().createCards());
        add(CoffeeCreator.getInstance().createCards());
        add(GardenCreator.getInstance().createCards());
        add(GreenCreator.getInstance().createCards());
        add(RedCreator.getInstance().createCards());
        add(SoyCreator.getInstance().createCards());
        add(StinkCreator.getInstance().createCards());
        add(WaxCreator.getInstance().createCards());
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, getSize());
    }

}
