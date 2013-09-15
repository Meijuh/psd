package bohnanza.game.player;

import java.util.HashSet;

import bohnanza.game.Bean;
import bohnanza.game.factory.CardsAlreadyCreatedException;

public class PlayerArea {

    private final Farm farm;
    private final DrawArea drawArea;
    private final KeepArea keepArea;
    private final Treasury treasury;

    public PlayerArea() throws CardsAlreadyCreatedException {
        farm = new Farm();
        drawArea = new DrawArea();
        keepArea = new KeepArea();
        treasury = new Treasury();
    }

    public Farm getFarm() {
        return farm;
    }

    public HashSet<Bean> harvestAndSell(int beanFieldNumber)
            throws FarmException {
        BeanField beanField = farm.getBeanField(beanFieldNumber);

        HashSet<Bean> discard = new HashSet<Bean>();
        HashSet<Bean> profit = new HashSet<Bean>();

        beanField.harvest(profit, discard);

        treasury.makeProfit(profit);

        return discard;

    }

    public void showCard(Bean bean) {
        drawArea.showCard(bean);
    }

    public HashSet<Bean> getDrawAreaCards() {
        return keepArea.getCards();
    }

    public void keep(Bean bean) {
        drawArea.remove(bean);
        keepArea.add(bean);
    }

}
