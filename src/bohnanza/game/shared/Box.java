package bohnanza.game.shared;

import java.util.List;

import bohnanza.game.CardList;
import bohnanza.game.factory.ThirdBeanField;
import bohnanza.game.factory.ThirdBeanFieldCreator;

public class Box extends CardList<ThirdBeanField> {

    private static final String TO_STRING_MESSAGE = "3rd bean field cards: %d";

    @Override
    protected void initializeCollection() {

        List<ThirdBeanField> cards = ThirdBeanFieldCreator.getInstance()
                .createCards();

        add(cards);
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, getSize());
    }

}
