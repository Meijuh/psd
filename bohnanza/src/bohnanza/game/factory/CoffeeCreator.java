package bohnanza.game.factory;

import bohnanza.game.Beanometer;

public class CoffeeCreator extends BeanCreator {

    private static CoffeeCreator instance = null;

    private static final int AMOUNT = 24;

    public CoffeeCreator() {
        super(AMOUNT);
    }

    @Override
    protected void initializeBeanometer() {
        getBeanometer().setCardsForOneCoin(Beanometer.FOUR_CARDS);
        getBeanometer().setCardsForTwoCoins(Beanometer.SEVEN_CARDS);
        getBeanometer().setCardsForThreeCoins(Beanometer.TEN_CARDS);
        getBeanometer().setCardsForFourCoins(Beanometer.TWELVE_CARDS);
    }

    @Override
    protected Coffee createCard() {
        return new Coffee(getBeanometer());
    }

    public static final CoffeeCreator getInstance() {
        if (instance == null) {
            instance = new CoffeeCreator();
        }

        return instance;
    }

}
