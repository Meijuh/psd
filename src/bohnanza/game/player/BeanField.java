package bohnanza.game.player;

import bohnanza.game.Bean;
import bohnanza.game.Field;

public class BeanField extends Field {

    BeanField() {
        super();
    }

    @Override
    protected void initializeCollection() {
        // bean field is initially empty
    }

    public Bean peek() {
        return getCards().iterator().next();
    }

    public void plant(Bean bean) {
        getCards().add(bean);
    }
}
