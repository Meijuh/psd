package bohnanza.game.player;

import java.util.Collection;
import java.util.HashSet;

import bohnanza.game.Bean;
import bohnanza.game.Field;

public class Treasury extends Field {

    public static final int THIRD_BEAN_FIELD_COST = 3;

    public Treasury() {
        super();
    }

    @Override
    protected void initializeCollection() {
        // treasury is initially empty
    }

    public void makeProfit(Collection<Bean> profit) {
        addAll(profit);
    }

    public int countProfit() {
        return getCards().size();
    }

    public Collection<Bean> buy() {
        int i = 0;

        Collection<Bean> beans = new HashSet<Bean>();

        while (getCards().iterator().hasNext() && i < THIRD_BEAN_FIELD_COST) {

            Bean bean = getCards().iterator().next();

            beans.add(bean);

            getCards().remove(bean);

            i++;
        }

        return beans;
    }

}
