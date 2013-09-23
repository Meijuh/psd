package bohnanza.game;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

public abstract class CardList<E extends Card<?>> extends Observable {

    private final List<E> cards;

    public static final int CARDS_PER_LINE = 4;

    public static final String SEMICOLON = "; ";

    public static final String NEWLINE = "\n";

    protected CardList() {
        cards = new LinkedList<E>();
        initializeCollection();
    }

    protected abstract void initializeCollection();

    public List<E> getCardsUnmodifiable() {
        return Collections.unmodifiableList(cards);
    }

    public void remove(Collection<E> cards) {
        this.cards.removeAll(cards);
    }

    public void remove(E card) {
        cards.remove(card);
    }

    public boolean hasCards() {
        return cards.size() > 0;
    }

    public List<E> empty() {

        List<E> result = new LinkedList<E>(cards);
        cards.clear();
        return result;
    }

    public boolean isType(Type type) {
        return peek().getType().equals(type);
    }

    public E peek() {
        return cards.get(0);
    }

    public void add(E card) {
        cards.add(card);
    }

    public void add(Collection<E> cards) {
        this.cards.addAll(cards);
    }

    public E remove() {
        return cards.remove(0);
    }

    public int getSize() {
        return cards.size();
    }

    @Override
    public String toString() {
        String string = new String();

        int i = 1;
        for (Card<?> card : cards) {
            string = string.concat(card.toString()).concat(SEMICOLON);

            if (i % CARDS_PER_LINE == 0) {
                string = string.concat(NEWLINE);
            }

            i++;

        }
        if (cards.size() > 0) {
            string = string.substring(0, string.length() - 2);
        }

        return string;
    }

}
