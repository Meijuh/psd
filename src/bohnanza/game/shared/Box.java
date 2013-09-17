package bohnanza.game.shared;

import bohnanza.game.Deck;
import bohnanza.game.factory.ThirdBeanField;
import bohnanza.game.factory.ThirdBeanFieldCreator;

public class Box extends Deck<ThirdBeanField> {

    private static Box instance = null;

    private Box() {
        super();
    }

    @Override
    protected void initializeCollection() {
        addAll(ThirdBeanFieldCreator.getInstance().createCards());
    }

    static final Box getInstance() {
        if (instance == null) {
            instance = new Box();
        }

        return instance;
    }

}
