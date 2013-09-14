package bohnanza.game.factory;

import bohnanza.game.Beanometer;

public class RedCreator extends BeanCreator<Red> {

    private static RedCreator instance = null;

    private static final int AMOUNT = 8;

    public RedCreator() {
        super(AMOUNT);
    }

    @Override
    protected void initializeBeanometer() {
        getBeanometer().setCardsForOneCoin(Beanometer.TWO_CARDS);
        getBeanometer().setCardsForTwoCoins(Beanometer.THREE_CARDS);
        getBeanometer().setCardsForThreeCoins(Beanometer.FOUR_CARDS);
        getBeanometer().setCardsForFourCoins(Beanometer.FIVE_CARDS);
    }

    @Override
    protected Red createCard() {
        return new Red(getBeanometer());
    }

    public static final RedCreator getInstance() {
        if (instance == null) {
            instance = new RedCreator();
        }

        return instance;
    }

}
