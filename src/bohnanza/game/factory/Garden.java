package bohnanza.game.factory;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;

public class Garden extends Bean {

    public static final String TYPE = "garden";

    Garden(Beanometer beanometer) {
        super(TYPE, beanometer);
    }

}
