package bohnanza.game.player;

import java.util.Collection;
import java.util.Set;

import bohnanza.game.Bean;
import bohnanza.game.Field;

public class KeepArea extends Field {

    protected KeepArea() {
        super();
    }

    @Override
    protected void initializeCollection() {
        // keep area is initially empty.
    }

    @Override
    public Set<Bean> getCards() {
        return super.getCards();
    }

    public void add(Collection<Bean> counterProposal) {
        getCards().addAll(counterProposal);
    }

}
