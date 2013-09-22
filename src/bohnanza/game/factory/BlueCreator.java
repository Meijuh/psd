package bohnanza.game.factory;

import bohnanza.game.Beanometer;

public class BlueCreator extends BeanCreator {

    private static BlueCreator instance = null;

    private static final int AMOUNT = 20;

    public BlueCreator() {
        super(AMOUNT);
    }

    @Override
    protected void initializeBeanometer() {
        getBeanometer().setCardsForOneCoin(Beanometer.FOUR_CARDS);
        getBeanometer().setCardsForTwoCoins(Beanometer.SIX_CARDS);
        getBeanometer().setCardsForThreeCoins(Beanometer.EIGHT_CARDS);
        getBeanometer().setCardsForFourCoins(Beanometer.TEN_CARDS);

    }

    @Override
    protected Blue createCard() {
        return new Blue(getBeanometer());
    }

    public static final BlueCreator getInstance() {
        if (instance == null) {
            instance = new BlueCreator();
        }

        return instance;
    }
}
