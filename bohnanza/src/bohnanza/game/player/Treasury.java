package bohnanza.game.player;

import bohnanza.game.Bean;
import bohnanza.game.CardList;

public abstract class Treasury extends CardList<Bean> {

    @Override
    protected void initializeCollection() {
        // treasury is initially empty
    }

}
