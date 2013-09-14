package bohnanza.game;

import java.util.HashSet;

import bohnanza.game.factory.CardsAlreadyCreatedException;

public abstract class Field extends CardCollection<Bean, HashSet<Bean>> {

    protected Field() throws CardsAlreadyCreatedException {
        super(new HashSet<Bean>());
    }

}
