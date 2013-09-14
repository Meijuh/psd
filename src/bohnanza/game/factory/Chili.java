package bohnanza.game.factory;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;

public class Chili extends Bean {

    private static final String TYPE = "chili";

    Chili(Beanometer beanometer) {
        super(TYPE, beanometer);
    }

}
