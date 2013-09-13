package game.bean;

import game.Bean;
import game.Beanometer;

public class Chili extends Bean {

    private static final int AMOUNT = 18;

    public Chili() {
        super(AMOUNT);
    }

    @Override
    protected void initializeBeanometer() {
        getBeanometer().setCardsForOneCoin(Beanometer.THREE_CARDS);
        getBeanometer().setCardsForTwoCoins(Beanometer.SIX_CARDS);
        getBeanometer().setCardsForThreeCoins(Beanometer.EIGHT_CARDS);
        getBeanometer().setCardsForFourCoins(Beanometer.TEN_CARDS);

    }

}
