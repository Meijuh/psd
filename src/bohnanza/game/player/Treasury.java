package bohnanza.game.player;

import java.util.HashSet;

import bohnanza.game.Bean;
import bohnanza.game.Field;
import bohnanza.game.factory.CardsAlreadyCreatedException;

public class Treasury extends Field {

    public Treasury() throws CardsAlreadyCreatedException {
        super();
    }

    @Override
    protected void initializeCollection() throws CardsAlreadyCreatedException {
        // treasury is initially empty
    }

    public void makeProfit(HashSet<Bean> profit) {
        addAll(profit);
    }

}
