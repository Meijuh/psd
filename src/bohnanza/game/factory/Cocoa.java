package bohnanza.game.factory;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;

public class Cocoa extends Bean {

    public static final String TYPE = "cocoa";

    Cocoa(Beanometer beanometer) {
        super(TYPE, beanometer);
    }

}
