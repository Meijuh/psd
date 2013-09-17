package bohnanza.game;

import java.util.Collection;

public abstract class CardCollection<ECard extends Card, ECollection extends Collection<ECard>> {

    private final ECollection cards;

    protected CardCollection(ECollection cards) {
        this.cards = cards;
        initializeCollection();
    }

    protected ECollection getCards() {
        return cards;
    }

    protected abstract void initializeCollection();

    protected void addAll(Collection<? extends ECard> cards) {
        this.cards.addAll(cards);
    }

    public boolean hasCards() {
        return cards.size() > 0;
    }

    public Collection<ECard> empty() {

        Collection<ECard> result = getCards();
        getCards().clear();
        return result;
    }

    @Override
    public String toString() {
        return getCards().toString();
    }

}
