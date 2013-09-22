package bohnanza.game.factory;

import java.util.LinkedList;
import java.util.List;

import bohnanza.game.Card;

public abstract class CardCreator<E extends Card<?>> {

    private final int amount;

    private final boolean cardsCreated;

    protected CardCreator(int amount) {
        this.amount = amount;
        cardsCreated = false;
    }

    protected abstract E createCard();

    public List<E> createCards() {

        List<E> cards = new LinkedList<E>();

        if (!cardsCreated) {

            for (int i = 0; i < amount; i++) {
                cards.add(createCard());
            }
        }

        return cards;

    }
}
