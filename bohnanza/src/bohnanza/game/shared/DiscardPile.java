package bohnanza.game.shared;

import bohnanza.game.Bean;
import bohnanza.game.CardList;

public abstract class DiscardPile extends CardList<Bean> {

    private static final String TO_STRING_MESSAGE = "discarded: %d";

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, getSize());
    }

}
