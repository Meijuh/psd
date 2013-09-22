package bohnanza.game.shared;

import bohnanza.game.Bean;
import bohnanza.game.CardList;

public class DrawDeck extends CardList<Bean> {

    public static final int ONE_CARD = 1;

    public static final int TWO_CARDS = 2;

    public static final int THREE_CARDS = 3;

    private static final String TO_STRING_MESSAGE = "draw deck size: %d";

    @Override
    protected void initializeCollection() {
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, getSize());
    }

}
