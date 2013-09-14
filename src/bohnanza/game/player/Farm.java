package bohnanza.game.player;

import bohnanza.game.factory.CardsAlreadyCreatedException;

public class Farm {

    private final Bean firstField;

    private final Bean secondField;

    private final Bean thirdField;

    public Farm() throws CardsAlreadyCreatedException {
        firstField = new Bean();
        secondField = new Bean();
        thirdField = null;
    }

}
