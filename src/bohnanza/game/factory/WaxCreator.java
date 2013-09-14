package bohnanza.game.factory;

import bohnanza.game.Beanometer;

public class WaxCreator extends BeanCreator<Wax> {

    private static WaxCreator instance = null;

    private static final int AMOUNT = 22;

    public WaxCreator() {
        super(AMOUNT);
    }

    @Override
    protected void initializeBeanometer() {
        getBeanometer().setCardsForOneCoin(Beanometer.FOUR_CARDS);
        getBeanometer().setCardsForTwoCoins(Beanometer.SEVEN_CARDS);
        getBeanometer().setCardsForThreeCoins(Beanometer.NINE_CARDS);
        getBeanometer().setCardsForFourCoins(Beanometer.ELEVEN_CARDS);
    }

    @Override
    protected Wax createCard() {
        return new Wax(getBeanometer());
    }

    public static final WaxCreator getInstance() {
        if (instance == null) {
            instance = new WaxCreator();
        }

        return instance;
    }

}
