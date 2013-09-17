package bohnanza.game.player;

import java.util.Collection;

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

    public void remove(Collection<Bean> beans) {
        getCards().remove(beans);
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

    @Override
    public Collection<Bean> getCards() {
        return super.getCards();
    }

}
