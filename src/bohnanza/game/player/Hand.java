package bohnanza.game.player;

import java.util.LinkedList;

import bohnanza.game.Bean;
import bohnanza.game.Deck;

public class Hand extends Deck<Bean, LinkedList<Bean>> {

    Hand() {
        super(new LinkedList<Bean>());
    }

    @Override
    protected void initializeCollection() {
        // hand is initially empty
    }

    public void add(Bean card) {
        getCards().add(card);
    }

}
