package game.bean;

import game.Bean;
import game.Beanometer;

public class Blue extends Bean {

    private static final int AMOUNT = 20;

    public Blue() {
        super(AMOUNT);
    }

    @Override
    protected void initializeBeanometer() {
        getBeanometer().setCardsForOneCoin(Beanometer.FOUR_CARDS);
        getBeanometer().setCardsForTwoCoins(Beanometer.SIX_CARDS);
        getBeanometer().setCardsForThreeCoins(Beanometer.EIGHT_CARDS);
        getBeanometer().setCardsForFourCoins(Beanometer.TEN_CARDS);

    }
}
