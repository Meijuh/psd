package bohnanza.game.player;

import bohnanza.game.Bean;
import bohnanza.game.CardList;

public class Treasury extends CardList<Bean> {
    private static final String TO_STRING_MESSAGE = "treasury %d coins";

    @Override
    protected void initializeCollection() {
        // treasury is initially empty
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, getSize());
    }

}
