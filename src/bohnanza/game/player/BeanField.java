package bohnanza.game.player;

import bohnanza.game.Bean;
import bohnanza.game.CardList;
import bohnanza.game.Type;

public class BeanField extends CardList<Bean> {

    public static final String EMPTY = "x";

    public static final String BAR = "|";

    @Override
    protected void initializeCollection() {
        // bean field is initially empty
    }

    @Override
    public boolean isType(Type type) {
        return getSize() == 0 || super.isType(type);
    }

    @Override
    public String toString() {
        return BAR + (!hasCards() ? EMPTY : peek().toString()) + BAR;
    }
}
