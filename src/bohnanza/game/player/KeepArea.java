package bohnanza.game.player;

import bohnanza.game.Field;
import bohnanza.game.factory.CardsAlreadyCreatedException;

public class KeepArea extends Field {

    protected KeepArea() throws CardsAlreadyCreatedException {
        super();
    }

    @Override
    protected void initializeCollection() throws CardsAlreadyCreatedException {
        // keep area is initially empty.
    }

}
