package bohnanza.game.player;

import bohnanza.game.Field;
import bohnanza.game.factory.CardsAlreadyCreatedException;

public class Treasury extends Field {

    public Treasury() throws CardsAlreadyCreatedException {
        super();
    }

    @Override
    protected void initializeCollection() throws CardsAlreadyCreatedException {
        // treasury is initially empty
    }

}
