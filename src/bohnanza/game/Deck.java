package bohnanza.game;

import java.util.LinkedList;

public class Deck<E extends Card> extends CardCollection<E, LinkedList<E>> {

    protected Deck() {
        super(new LinkedList<E>());
    }

    public E draw() {
        return getCards().remove();
    }

    @Override
    public LinkedList<E> getCards() {
        return super.getCards();
    }

    @Override
    protected void initializeCollection() {
        // TODO Auto-generated method stub

    }
}
