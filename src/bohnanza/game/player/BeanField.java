package bohnanza.game.player;

import bohnanza.game.Bean;
import bohnanza.game.Field;

public class BeanField extends Field {

    public static final String EMPTY = "x";

    public static final String BAR = "|";

    private Bean aCard;

    BeanField() {
        super();
        aCard = null;
    }

    @Override
    protected void initializeCollection() {
        // bean field is initially empty
    }

    public Bean peek() {
        return aCard;
    }

    public void plant(Bean bean) {
        aCard = bean;
        getCards().add(bean);
    }

    @Override
    public String toString() {
        return BAR + (aCard == null ? EMPTY : aCard.toString()) + BAR;
    }
}
