package bohnanza.game.player;

import bohnanza.game.Field;
import bohnanza.game.factory.CardsAlreadyCreatedException;

public class Bean extends Field {

    protected Bean() throws CardsAlreadyCreatedException {
        super();
    }

    @Override
    protected void initializeCollection() throws CardsAlreadyCreatedException {
        // bean field is initially empty
    }

}
