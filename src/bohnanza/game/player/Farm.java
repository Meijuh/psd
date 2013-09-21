package bohnanza.game.player;

import bohnanza.game.Bean;
import bohnanza.game.factory.ThirdBeanField;

public class Farm {

    public static final int FIRST = 1;

    public static final int SECOND = 2;

    public static final int THIRD = 3;

    public static final String TO_STRING_MESSAGE = "farm: %s, %s, %s";

    public static final String NO_THIRD_BEAN_FIELD = "x";

    private final BeanField firstBeanField;

    private final BeanField secondBeanField;

    private BeanField thirdBeanField;

    private ThirdBeanField thirdBeanFieldCard;

    Farm() {
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

    public void setThirdBeanFieldCard(ThirdBeanField thirdBeanFieldCard) {
        this.thirdBeanFieldCard = thirdBeanFieldCard;
        thirdBeanField = new BeanField();
    }

    public boolean hasThirdBeanField() {
        return this.thirdBeanFieldCard != null;
    }

    public void plant(int beanFieldNumber, Bean bean) throws FarmException {
        getBeanField(beanFieldNumber).plant(bean);
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, firstBeanField,
                secondBeanField, hasThirdBeanField() ? thirdBeanField
                        : NO_THIRD_BEAN_FIELD);
    }

}
