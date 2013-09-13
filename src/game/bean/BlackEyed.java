package game.bean;

import game.Bean;
import game.Beanometer;

public class BlackEyed extends Bean {

    private static final int AMOUNT = 10;

    public BlackEyed() {
        super(AMOUNT);
    }

    @Override
    protected void initializeBeanometer() {
        getBeanometer().setCardsForOneCoin(Beanometer.TWO_CARDS);
        getBeanometer().setCardsForTwoCoins(Beanometer.FOUR_CARDS);
        getBeanometer().setCardsForThreeCoins(Beanometer.FIVE_CARDS);
        getBeanometer().setCardsForFourCoins(Beanometer.SIX_CARDS);

    }

}
