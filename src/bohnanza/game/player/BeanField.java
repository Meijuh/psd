package bohnanza.game.player;

import java.util.HashSet;

import bohnanza.game.Bean;
import bohnanza.game.Field;
import bohnanza.game.factory.CardsAlreadyCreatedException;

public class BeanField extends Field {

    protected BeanField() throws CardsAlreadyCreatedException {
        super();
    }

    @Override
    protected void initializeCollection() throws CardsAlreadyCreatedException {
        // bean field is initially empty
    }

    public void harvest(HashSet<Bean> treasury, HashSet<Bean> discardPile) {

        if (hasCards()) {
            int worth = peek().getBeanometer().getWorth(getCards().size());

            int i = 0;
            for (Bean bean : getCards()) {
                if (i < worth) {
                    treasury.add(bean);
                } else {
                    discardPile.add(bean);
                }
                getCards().remove(bean);
                i++;
            }
        }
    }

    public Bean peek() {
        return getCards().iterator().next();
    }
}
