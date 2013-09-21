package bohnanza.game;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class CardCollection<ECollection extends Collection<? extends Card<?>>> {

    private final ECollection cards;

    protected CardCollection(ECollection cards) {
        this.cards = cards;
        initializeCollection();
    }

    protected ECollection getCards() {
        return cards;
    }

    public Set<Bean> remove(Set<Integer> counterProposal) {
        Set<Bean> set = new HashSet<Bean>();

        for (int i : counterProposal) {
            set.add(getCards().remove(i));
        }

        return set;
    }

    protected abstract void initializeCollection();

    public boolean hasCards() {
        return cards.size() > 0;
    }

    public ECollection empty() {

        ECollection result = getCards();
        getCards().clear();
        return result;
    }

    @Override
    public String toString() {
        return getCards().toString();
    }

}
