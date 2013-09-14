package bohnanza.game.factory;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;

public class Blue extends Bean {

    private static final String TYPE = "blue";

    Blue(Beanometer beanometer) {
        super(TYPE, beanometer);
    }

}
