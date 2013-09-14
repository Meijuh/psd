package bohnanza.game.factory;

import bohnanza.game.Beanometer;

public class CocoaCreator extends BeanCreator<Cocoa> {

    private static CocoaCreator instance = null;

    private static final int AMOUNT = 4;

    public CocoaCreator() {
        super(AMOUNT);
    }

    @Override
    protected void initializeBeanometer() {
        getBeanometer().setCardsForTwoCoins(Beanometer.TWO_CARDS);
        getBeanometer().setCardsForThreeCoins(Beanometer.THREE_CARDS);
        getBeanometer().setCardsForFourCoins(Beanometer.FOUR_CARDS);
    }

    @Override
    protected Cocoa createCard() {
        return new Cocoa(getBeanometer());
    }

    public static final CocoaCreator getInstance() {
        if (instance == null) {
            instance = new CocoaCreator();
        }

        return instance;
    }

}
