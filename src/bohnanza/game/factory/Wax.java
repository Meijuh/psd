package bohnanza.game.factory;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;

public class Wax extends Bean {

    public static final String TYPE = "wax";

    Wax(Beanometer beanometer) {
        super(TYPE, beanometer);
    }

}
