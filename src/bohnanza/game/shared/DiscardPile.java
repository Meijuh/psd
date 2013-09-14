package bohnanza.game.shared;

import bohnanza.game.Field;
import bohnanza.game.factory.CardsAlreadyCreatedException;

public class DiscardPile extends Field {

    private static DiscardPile instance = null;

    private DiscardPile() throws CardsAlreadyCreatedException {
        super();
    }

    @Override
    protected void initializeCollection() throws CardsAlreadyCreatedException {
        // The discard pile is initially empty.
    }

    static final DiscardPile getInstance() throws CardsAlreadyCreatedException {
        if (instance == null) {
            instance = new DiscardPile();
        }

        return instance;
    }

}
