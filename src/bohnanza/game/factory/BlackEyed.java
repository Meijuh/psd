package bohnanza.game.factory;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;

public class BlackEyed extends Bean {

    public static final String TYPE = "black-eyed";

    BlackEyed(Beanometer beanometer) {
        super(TYPE, beanometer);
    }

}
