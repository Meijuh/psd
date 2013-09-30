package bohnanza.game.shared;

import bohnanza.game.factory.BlackEyedCreator;
import bohnanza.game.factory.BlueCreator;
import bohnanza.game.factory.ChiliCreator;
import bohnanza.game.factory.GardenCreator;
import bohnanza.game.factory.GreenCreator;
import bohnanza.game.factory.RedCreator;
import bohnanza.game.factory.SoyCreator;
import bohnanza.game.factory.StinkCreator;

public class DiscardPileHB extends DiscardPile {

    @Override
    protected void initializeCollection() {
        add(BlackEyedCreator.getInstance().createCards());
        add(BlueCreator.getInstance().createCards());
        add(ChiliCreator.getInstance().createCards());
        add(GardenCreator.getInstance().createCards());
        add(GreenCreator.getInstance().createCards());
        add(RedCreator.getInstance().createCards());
        add(SoyCreator.getInstance().createCards());
        add(StinkCreator.getInstance().createCards());
    }
}
