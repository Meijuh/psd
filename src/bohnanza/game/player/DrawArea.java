package bohnanza.game.player;

import bohnanza.game.Bean;
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

    public void showCard(Bean bean) {
        getCards().add(bean);
    }

    public void remove(Bean bean) {
        getCards().remove(bean);
    }

}
