package bohnanza.game.factory;

import bohnanza.game.Beanometer;

public class ChiliCreator extends BeanCreator<Chili> {

    private static ChiliCreator instance = null;

    private static final int AMOUNT = 18;

    public ChiliCreator() {
        super(AMOUNT);
    }

    @Override
    protected void initializeBeanometer() {
        getBeanometer().setCardsForOneCoin(Beanometer.THREE_CARDS);
        getBeanometer().setCardsForTwoCoins(Beanometer.SIX_CARDS);
        getBeanometer().setCardsForThreeCoins(Beanometer.EIGHT_CARDS);
        getBeanometer().setCardsForFourCoins(Beanometer.NINE_CARDS);

    }

    @Override
    protected Chili createCard() {
        return new Chili(getBeanometer());
    }

    public static final ChiliCreator getInstance() {
        if (instance == null) {
            instance = new ChiliCreator();
        }

        return instance;
    }

}
