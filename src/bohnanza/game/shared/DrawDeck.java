package bohnanza.game.shared;

import java.util.Collection;
import java.util.List;

import bohnanza.game.Bean;
import bohnanza.game.Deck;

public class DrawDeck extends Deck<Bean> {

    private static DrawDeck instance = null;

    private DrawDeck() {
        super();
    }

    @Override
    protected void initializeCollection() {
    }

    static final DrawDeck getInstance() {
        if (instance == null) {
            instance = new DrawDeck();
        }

        return instance;
    }

    void addShuffledCards(List<Bean> beans) {
        getCards().addAll(beans);
    }

    public boolean canDraw(int amount) {
        return getCards().size() == amount;
    }

}
