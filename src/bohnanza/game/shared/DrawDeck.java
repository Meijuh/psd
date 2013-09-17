package bohnanza.game.shared;

import java.util.List;

import bohnanza.game.Bean;
import bohnanza.game.Deck;

public class DrawDeck extends Deck<Bean> {

    private static final String TO_STRING_MESSAGE = "draw deck size: %d";

    DrawDeck() {
        super();
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
