package bohnanza.game;

import java.util.LinkedList;

import bohnanza.game.factory.CardsAlreadyCreatedException;

public abstract class Deck<E extends Card> extends
        CardCollection<E, LinkedList<E>> {

    protected Deck() throws CardsAlreadyCreatedException {
        super(new LinkedList<E>());
    }

    public E draw() {
        return getCards().pop();
    }
}
