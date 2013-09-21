package bohnanza.game.factory;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;
import bohnanza.game.Type;

public class Garden extends Bean {

    Garden(Beanometer beanometer) {
        super(Type.GARDEN, beanometer);
    }

}
