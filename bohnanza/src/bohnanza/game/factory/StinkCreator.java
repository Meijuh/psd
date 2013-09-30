package bohnanza.game.factory;

import bohnanza.game.Beanometer;

public class StinkCreator extends BeanCreator {

    private static StinkCreator instance = null;

    private static final int AMOUNT = 16;

    public StinkCreator() {
        super(AMOUNT);
    }

    @Override
    protected void initializeBeanometer() {
        getBeanometer().setCardsForOneCoin(Beanometer.THREE_CARDS);
        getBeanometer().setCardsForTwoCoins(Beanometer.SIX_CARDS);
        getBeanometer().setCardsForThreeCoins(Beanometer.EIGHT_CARDS);
        getBeanometer().setCardsForFourCoins(Beanometer.TEN_CARDS);
    }

    @Override
    protected Stink createCard() {
        return new Stink(getBeanometer());
    }

    public static final StinkCreator getInstance() {
        if (instance == null) {
            instance = new StinkCreator();
        }

        return instance;
    }

}
