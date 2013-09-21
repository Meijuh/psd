package bohnanza.game.shared;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import bohnanza.game.Bean;
import bohnanza.game.Deck;

public class DrawDeck extends Deck<Bean, Queue<Bean>> {

    public static final int ONE_CARD = 1;

    public static final int TWO_CARDS = 2;

    public static final int THREE_CARDS = 3;

    private static final String TO_STRING_MESSAGE = "draw deck size: %d";

    DrawDeck() {
        super(new LinkedList<Bean>());
    }

    @Override
    protected void initializeCollection() {
    }

    void addShuffledCards(List<Bean> beans) {
        getCards().addAll(beans);
    }

    public boolean canDraw(int amount) {
        return getCards().size() == amount;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, getCards().size());
    }

}
