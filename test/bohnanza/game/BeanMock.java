package bohnanza.game;

import bohnanza.game.factory.BlackEyed;

public class BeanMock extends Bean {

    private static final int HASHCODE = 1337;

    public BeanMock() {
        super(BlackEyed.TYPE, getABeanometer());
    }

    private static final Beanometer getABeanometer() {
        Beanometer beanometer = new Beanometer();

        beanometer.setCardsForOneCoin(Beanometer.TWO_CARDS);
        beanometer.setCardsForTwoCoins(Beanometer.FOUR_CARDS);
        beanometer.setCardsForThreeCoins(Beanometer.SIX_CARDS);
        beanometer.setCardsForFourCoins(Beanometer.EIGHT_CARDS);

        return beanometer;
    }

    @Override
    public int hashCode() {
        return HASHCODE;
    }
}
