package bohnanza.game;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Deck<E extends Card> extends CardCollection<E, Queue<E>> {

    protected Deck() {
        super(new LinkedList<E>());
    }

    public E draw() {
        return getCards().remove();
    }
}
