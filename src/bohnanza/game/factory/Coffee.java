package bohnanza.game.factory;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;

public class Coffee extends Bean {

    private static final String TYPE = "coffee";

    Coffee(Beanometer beanometer) {
        super(TYPE, beanometer);
    }

}
