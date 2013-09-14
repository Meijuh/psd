package bohnanza.game.factory;

import bohnanza.game.Beanometer;

public class GreenCreator extends BeanCreator<Green> {

    private static GreenCreator instance = null;

    private static final int AMOUNT = 14;

    public GreenCreator() {
        super(AMOUNT);
    }

    @Override
    protected void initializeBeanometer() {
        getBeanometer().setCardsForOneCoin(Beanometer.THREE_CARDS);
        getBeanometer().setCardsForTwoCoins(Beanometer.FIVE_CARDS);
        getBeanometer().setCardsForThreeCoins(Beanometer.SIX_CARDS);
        getBeanometer().setCardsForFourCoins(Beanometer.SEVEN_CARDS);
    }

    @Override
    protected Green createCard() {
        return new Green(getBeanometer());
    }

    public static final GreenCreator getInstance() {
        if (instance == null) {
            instance = new GreenCreator();
        }

        return instance;
    }

}
