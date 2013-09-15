package bohnanza.game.factory;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;

public class Green extends Bean {

    public static final String TYPE = "green";

    Green(Beanometer beanometer) {
        super(TYPE, beanometer);
    }

}
