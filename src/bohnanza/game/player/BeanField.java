package bohnanza.game.player;

import bohnanza.game.Bean;
import bohnanza.game.CardList;
import bohnanza.game.Type;

public class BeanField extends CardList<Bean> {

    public static final String BAR = "|";

    public static final String LPAREN = "(";

    public static final String RPAREN = ")";

    public static final String EMPTY_STRING = "";

    public static final String SPACE = " ";

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
        return BAR
                + (hasCards() ? peek().toString().concat(SPACE) : EMPTY_STRING)
                + LPAREN + getSize() + RPAREN + BAR;
    }
}
