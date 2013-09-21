package bohnanza.game.factory;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;
import bohnanza.game.Type;

public class Coffee extends Bean {

    Coffee(Beanometer beanometer) {
        super(Type.COFFEE, beanometer);
    }

}
