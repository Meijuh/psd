package bohnanza.game.factory;

import java.util.Collection;
import java.util.HashSet;

import bohnanza.game.Card;

public abstract class CardCreator<E extends Card> {

    private final int amount;

    private final boolean cardsCreated;

    protected CardCreator(int amount) {
        this.amount = amount;
        cardsCreated = false;
    }

    protected abstract E createCard();

    public Collection<E> createCards() {

        Collection<E> cards = new HashSet<E>();

        if (!cardsCreated) {

            for (int i = 0; i < amount; i++) {
                cards.add(createCard());
            }
        }

        return cards;

    }
}
