package bohnanza.game;

import java.util.Collection;

import bohnanza.game.factory.CardsAlreadyCreatedException;

public abstract class CardCollection<ECard extends Card, ECollection extends Collection<ECard>> {

    private final ECollection cards;

    protected CardCollection(ECollection cards)
            throws CardsAlreadyCreatedException {
        this.cards = cards;
        initializeCollection();
    }

    protected ECollection getCards() {
        return cards;
    }

    protected abstract void initializeCollection()
            throws CardsAlreadyCreatedException;

    protected void addAll(Collection<? extends ECard> cards) {
        this.cards.addAll(cards);
    }

    public boolean hasCards() {
        return cards.size() > 0;
    }

}
