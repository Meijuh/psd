package bohnanza.game.factory;

public class ThirdBeanFieldCreator extends CardCreator<ThirdBeanField> {

    private static final int AMOUNT = 7;
    private static ThirdBeanFieldCreator instance = null;

    private ThirdBeanFieldCreator() {
        super(AMOUNT);
    }

    @Override
    protected ThirdBeanField createCard() {
        return new ThirdBeanField();
    }

    public static ThirdBeanFieldCreator getInstance() {
        if (instance == null) {
            instance = new ThirdBeanFieldCreator();
        }

        return instance;
    }
}
