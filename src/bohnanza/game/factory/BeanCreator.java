package bohnanza.game.factory;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;

public abstract class BeanCreator<E extends Bean> extends CardCreator<E> {

    private final Beanometer beanometer;

    protected BeanCreator(int amount) {
        super(amount);
        beanometer = new Beanometer();
        initializeBeanometer();
    }

    protected abstract void initializeBeanometer();

    /**
     * @return the beanometer
     */
    Beanometer getBeanometer() {
        return beanometer;
    }
}
