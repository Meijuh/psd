package bohnanza.game.player;

import java.util.HashSet;

import bohnanza.game.Bean;
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

    @Override
    public HashSet<Bean> getCards() {
        return super.getCards();
    }

    public void add(Bean bean) {
        getCards().add(bean);
    }

}
