package bohnanza.game.player;

import java.util.Collection;
import java.util.Set;

import bohnanza.game.Bean;
import bohnanza.game.Type;
import bohnanza.game.factory.ThirdBeanField;

public class PlayerArea {

    private static final String TO_STRING_MESSAGE = "%s, %s, %s, %s";
    private final Farm farm;
    private final DrawArea drawArea;
    private final KeepArea keepArea;
    private final Treasury treasury;

    PlayerArea() {
        farm = new Farm();
        drawArea = new DrawArea();
        keepArea = new KeepArea();
        treasury = new Treasury();
    }

    public void showCard(Bean bean) {
        drawArea.showCard(bean);
    }

    public Set<Bean> getDrawAreaCards() {
        return drawArea.getCards();
    }

    public void setAside(Collection<Bean> counterProposal) {
        keepArea.add(counterProposal);
    }

    public Bean getDrawAreaCard(Type type) {
        return drawArea.getBean(type);
    }

    public void removeFromDrawArea(Collection<Bean> cardsFromDrawArea) {
        drawArea.remove(cardsFromDrawArea);
    }

    public Collection<Bean> getKeepAreaCards() {
        return keepArea.getCards();
    }

    public Collection<Bean> buy() {
        return treasury.buy();
    }

    public void setThirdBeanFieldCard(ThirdBeanField buy) {
        farm.setThirdBeanFieldCard(buy);
    }

    public boolean hasThirdBeanField() {
        return farm.hasThirdBeanField();
    }

    public void plant(int beanFieldNumber, Bean bean) throws FarmException {
        farm.plant(beanFieldNumber, bean);
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, treasury, farm, drawArea,
                keepArea);
    }

    public boolean isType(int beanFieldNumber, Type type) throws FarmException {
        return type.isType(farm.getBeanField(beanFieldNumber).peek());
    }

}
