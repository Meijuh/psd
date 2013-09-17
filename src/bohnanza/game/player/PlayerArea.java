package bohnanza.game.player;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import bohnanza.game.Bean;
import bohnanza.game.Type;

public class PlayerArea {

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

    public Farm getFarm() {
        return farm;
    }

    public Collection<Bean> harvestAndSell(int beanFieldNumber)
            throws FarmException {
        BeanField beanField = farm.getBeanField(beanFieldNumber);

        Collection<Bean> discard = new HashSet<Bean>();
        Collection<Bean> profit = new HashSet<Bean>();

        if (beanField.hasCards()) {

            Collection<Bean> beans = beanField.empty();

            int i = 0;
            for (Bean bean : beans) {
                if (i < bean.getBeanometer().getWorth(beans.size())) {
                    profit.add(bean);
                } else {
                    discard.add(bean);
                }
                i++;
            }
        }

        treasury.makeProfit(profit);

        return discard;

    }

    public void showCard(Bean bean) {
        drawArea.showCard(bean);
    }

    public Set<Bean> getDrawAreaCards() {
        return keepArea.getCards();
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

}
