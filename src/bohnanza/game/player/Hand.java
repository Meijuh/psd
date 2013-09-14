package bohnanza.game.player;

import bohnanza.game.Bean;
import bohnanza.game.Deck;
import bohnanza.game.factory.CardsAlreadyCreatedException;

public class Hand extends Deck<Bean> {

    protected Hand() throws CardsAlreadyCreatedException {
        super();
    }

    @Override
    protected void initializeCollection() throws CardsAlreadyCreatedException {
        // hand is initially empty
    }

}
