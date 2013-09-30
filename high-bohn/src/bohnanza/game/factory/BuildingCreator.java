package bohnanza.game.factory;

import bohnanza.game.Beanometer;

public abstract class BuildingCreator extends CardCreator<Building> {

    private final Beanometer beanometer;

    protected BuildingCreator(int amount) {
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
