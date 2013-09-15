package bohnanza.game.player;

import bohnanza.game.factory.CardsAlreadyCreatedException;
import bohnanza.game.factory.ThirdBeanField;

public class Farm {

    public static final int FIRST = 1;

    public static final int SECOND = 2;

    public static final int THIRD = 3;

    private final BeanField firstBeanField;

    private final BeanField secondBeanField;

    private final BeanField thirdBeanField;

    private ThirdBeanField thirdBeanFieldCard;

    public Farm() throws CardsAlreadyCreatedException {
        firstBeanField = new BeanField();
        secondBeanField = new BeanField();
        thirdBeanField = null;
        thirdBeanFieldCard = null;
    }

    public BeanField getBeanField(int nr) throws FarmException {
        BeanField beanField = null;
        switch (nr) {
        case FIRST:
            beanField = firstBeanField;
            break;
        case SECOND:
            beanField = secondBeanField;
            break;
        case THIRD:
            if (hasThirdBeanField()) {
                beanField = thirdBeanField;
            } else {
                throw new FarmException(FarmException.THIRD_FIELD);
            }
            break;
        default:
            throw new FarmException(FarmException.NO_FIELD);
        }
        return beanField;
    }

    public void setThirdBeanField(ThirdBeanField thirdBeanField) {
        this.thirdBeanFieldCard = thirdBeanField;
    }

    public boolean hasThirdBeanField() {
        return this.thirdBeanFieldCard != null;
    }

}
