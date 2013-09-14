package bohnanza.game.factory;

import bohnanza.game.Beanometer;

public class BlackEyedCreator extends BeanCreator<BlackEyed> {

    private static BlackEyedCreator instance = null;

    private static final int AMOUNT = 10;

    private BlackEyedCreator() {
        super(AMOUNT);
    }

    @Override
    protected void initializeBeanometer() {
        getBeanometer().setCardsForOneCoin(Beanometer.TWO_CARDS);
        getBeanometer().setCardsForTwoCoins(Beanometer.FOUR_CARDS);
        getBeanometer().setCardsForThreeCoins(Beanometer.FIVE_CARDS);
        getBeanometer().setCardsForFourCoins(Beanometer.SIX_CARDS);
    }

    @Override
    protected BlackEyed createCard() {
        return new BlackEyed(getBeanometer());
    }

    public static final BlackEyedCreator getInstance() {
        if (instance == null) {
            instance = new BlackEyedCreator();
        }

        return instance;
    }

}
