package bohnanza.game.shared;

import bohnanza.game.Deck;
import bohnanza.game.factory.ThirdBeanField;
import bohnanza.game.factory.ThirdBeanFieldCreator;

public class Box extends Deck<ThirdBeanField> {

    private static final String TO_STRING_MESSAGE = "3rd bean field cards: %d";

    Box() {
        super();
    }

    @Override
    protected void initializeCollection() {
        addAll(ThirdBeanFieldCreator.getInstance().createCards());
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, getCards().size());
    }

}
