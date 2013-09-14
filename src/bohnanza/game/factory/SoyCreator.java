package bohnanza.game.factory;

import bohnanza.game.Beanometer;

public class SoyCreator extends BeanCreator<Soy> {

    private static SoyCreator instance = null;

    private static final int AMOUNT = 12;

    public SoyCreator() {
        super(AMOUNT);
    }

    @Override
    protected void initializeBeanometer() {
        getBeanometer().setCardsForOneCoin(Beanometer.TWO_CARDS);
        getBeanometer().setCardsForTwoCoins(Beanometer.FOUR_CARDS);
        getBeanometer().setCardsForThreeCoins(Beanometer.SIX_CARDS);
        getBeanometer().setCardsForFourCoins(Beanometer.SEVEN_CARDS);
    }

    @Override
    protected Soy createCard() {
        return new Soy(getBeanometer());
    }

    public static final SoyCreator getInstance() {
        if (instance == null) {
            instance = new SoyCreator();
        }

        return instance;
    }

}
