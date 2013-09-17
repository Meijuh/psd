package bohnanza.game.player;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import bohnanza.game.Bean;
import bohnanza.game.Deck;

public class Hand extends Deck<Bean> {

    protected Hand() {
        super();
    }

    @Override
    protected void initializeCollection() {
        // hand is initially empty
    }

    public void add(Bean card) {
        getCards().add(card);
    }

    public int size() {
        return getCards().size();
    }

    public Bean get(int number) {
        return getCards().get(number);
    }

    @Override
    public LinkedList<Bean> getCards() {
        return getCards();
    }

    public Collection<Bean> get(Collection<Integer> numbers) {
        Collection<Bean> result = new HashSet<Bean>();

        for (Integer number : numbers) {
            result.add(get(number));
        }

        return result;
    }

    public void remove(Collection<Bean> counterProposal) {
        getCards().removeAll(counterProposal);
    }

}
