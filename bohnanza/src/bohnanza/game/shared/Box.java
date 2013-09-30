package bohnanza.game.shared;

import bohnanza.game.CardList;
import bohnanza.game.factory.ThirdBeanField;

public abstract class Box extends CardList<ThirdBeanField> {

    private static final String TO_STRING_MESSAGE = "3rd bean field cards: %d";

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, getSize());
    }

}
