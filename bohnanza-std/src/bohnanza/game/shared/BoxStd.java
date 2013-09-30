package bohnanza.game.shared;

import java.util.List;

import bohnanza.game.factory.ThirdBeanField;
import bohnanza.game.factory.ThirdBeanFieldCreator;

public class BoxStd extends Box {

    @Override
    protected void initializeCollection() {

        List<ThirdBeanField> cards = ThirdBeanFieldCreator.getInstance()
                .createCards();

        add(cards);
    }

}
