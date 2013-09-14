package bohnanza.game.shared;

import bohnanza.game.Deck;
import bohnanza.game.factory.CardsAlreadyCreatedException;
import bohnanza.game.factory.ThirdBeanField;
import bohnanza.game.factory.ThirdBeanFieldCreator;

public class Box extends Deck<ThirdBeanField> {

    Box() throws CardsAlreadyCreatedException {
        super();
    }

    @Override
    protected void initializeCollection() throws CardsAlreadyCreatedException {
        addAll(ThirdBeanFieldCreator.getInstance().createCards());
    }

}
