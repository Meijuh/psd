package bohnanza.game;

import java.util.Queue;

public abstract class Deck<ECard extends Card<?>, E extends Queue<ECard>>
        extends CardCollection<E> {

    protected Deck(E collection) {
        super(collection);
    }

    public ECard draw() {
        return getCards().remove();
    }

    @Override
    protected void initializeCollection() {
        // TODO Auto-generated method stub

    }
}
