package bohnanza.game.player;

import bohnanza.game.Bean;
import bohnanza.game.Field;
import bohnanza.game.Type;

public class DrawArea extends Field {

    DrawArea() {
        super();
    }

    @Override
    protected void initializeCollection() {
        // draw area is initially empty
    }

    public void showCard(Bean bean) {
        getCards().add(bean);
    }

    public Bean getBean(Type type) {
        Bean bean = null;

        while (bean == null) {
            Bean next = getCards().iterator().next();

            if (type.isType(next)) {
                bean = next;
            }
        }

        return bean;
    }

}
