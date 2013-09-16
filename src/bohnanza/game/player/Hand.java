package bohnanza.game.player;

import java.util.HashSet;
import java.util.LinkedList;

import bohnanza.game.Bean;
import bohnanza.game.Deck;
import bohnanza.game.factory.CardsAlreadyCreatedException;

public class Hand extends Deck<Bean> {

    protected Hand() throws CardsAlreadyCreatedException {
        super();
    }

    @Override
    protected void initializeCollection() throws CardsAlreadyCreatedException {
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

    public HashSet<Bean> get(HashSet<Integer> numbers) {
        HashSet<Bean> result = new HashSet<Bean>();

        for (Integer number : numbers) {
            result.add(get(number));
        }

        return result;
    }

}
