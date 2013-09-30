package bohnanza.game.factory;

import bohnanza.game.Beanometer;

public class GardenCreator extends BeanCreator {

    private static GardenCreator instance = null;

    private static final int AMOUNT = 6;

    public GardenCreator() {
        super(AMOUNT);
    }

    @Override
    protected void initializeBeanometer() {
        getBeanometer().setCardsForTwoCoins(Beanometer.TWO_CARDS);
        getBeanometer().setCardsForThreeCoins(Beanometer.THREE_CARDS);
    }

    @Override
    protected Garden createCard() {
        return new Garden(getBeanometer());
    }

    public static final GardenCreator getInstance() {
        if (instance == null) {
            instance = new GardenCreator();
        }

        return instance;
    }

}
