package bohnanza.game.factory;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;

public class Stink extends Bean {

    private static final String TYPE = "stink";

    Stink(Beanometer beanometer) {
        super(TYPE, beanometer);
    }

}