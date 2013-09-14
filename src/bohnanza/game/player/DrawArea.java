package bohnanza.game.player;

import bohnanza.game.Field;
import bohnanza.game.factory.CardsAlreadyCreatedException;

public class DrawArea extends Field {

    protected DrawArea() throws CardsAlreadyCreatedException {
        super();
    }

    @Override
    protected void initializeCollection() throws CardsAlreadyCreatedException {
        // draw area is initially empty
    }

}
