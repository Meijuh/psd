package bohnanza.game.factory;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;

public class BlackEyed extends Bean {

    private static final String TYPE = "Black-eyed";

    BlackEyed(Beanometer beanometer) {
        super(TYPE, beanometer);
    }

}
