package bohnanza.game.shared;

import java.util.Collections;

import bohnanza.game.Bean;
import bohnanza.game.Deck;
import bohnanza.game.factory.BlackEyedCreator;
import bohnanza.game.factory.BlueCreator;
import bohnanza.game.factory.CardsAlreadyCreatedException;
import bohnanza.game.factory.ChiliCreator;
import bohnanza.game.factory.CocoaCreator;
import bohnanza.game.factory.CoffeeCreator;
import bohnanza.game.factory.GardenCreator;
import bohnanza.game.factory.GreenCreator;
import bohnanza.game.factory.RedCreator;
import bohnanza.game.factory.SoyCreator;
import bohnanza.game.factory.StinkCreator;
import bohnanza.game.factory.WaxCreator;

public class DrawDeck extends Deck<Bean> {

    private static DrawDeck instance = null;

    private DrawDeck() throws CardsAlreadyCreatedException {
        super();
    }

    public void shuffle() {
        Collections.shuffle(getCards());
    }

    @Override
    protected void initializeCollection() throws CardsAlreadyCreatedException {
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

        shuffle();
    }

    static final DrawDeck getInstance() throws CardsAlreadyCreatedException {
        if (instance == null) {
            instance = new DrawDeck();
        }

        return instance;
    }

}
