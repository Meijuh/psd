package bohnanza.game.factory;

import java.util.Collection;
import java.util.HashSet;

import bohnanza.game.Card;

public abstract class CardCreator<E extends Card> {

    private final int amount;
    private boolean cardsCreated;

    protected CardCreator(int amount) {
        this.amount = amount;
        cardsCreated = false;
    }

    protected abstract E createCard();

    public Collection<E> createCards() throws CardsAlreadyCreatedException {

        if (cardsCreated) {
            throw new CardsAlreadyCreatedException();
        } else {

            Collection<E> cards = new HashSet<E>();

            for (int i = 0; i < amount; i++) {
                cards.add(createCard());
            }

            cardsCreated = true;

            return cards;
        }

    }
}
