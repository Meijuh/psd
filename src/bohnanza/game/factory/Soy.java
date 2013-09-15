package bohnanza.game.factory;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;

public class Soy extends Bean {

    public static final String TYPE = "soy";

    Soy(Beanometer beanometer) {
        super(TYPE, beanometer);
    }

}
