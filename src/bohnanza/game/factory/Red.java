package bohnanza.game.factory;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;

public class Red extends Bean {

    private static final String TYPE = "red";

    Red(Beanometer beanometer) {
        super(TYPE, beanometer);
    }

}