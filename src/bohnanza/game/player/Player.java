package bohnanza.game.player;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

import bohnanza.game.Bean;
import bohnanza.game.shared.Box;
import bohnanza.game.shared.DiscardPile;
import bohnanza.game.shared.DrawDeck;

public class Player extends Observable {

    private String name;

    private Player leftPlayer;

    private final Hand hand;

    private int playerNumber;

    private final DrawArea drawArea;

    private final BeanField firstBeanField;

    private final BeanField secondBeanField;

    private BeanField thirdBeanField;

    private final DrawDeck drawDeck;

    private final DiscardPile discardPile;

    private final KeepArea keepArea;

    private final Treasury treasury;

    private final Box box;

    private static final String TO_STRING_MESSAGE = "name: %s\nhand: %s\ndraw area: %s\nkeep area: %s\nbean fields: %s %s %s";

    public static final int FIRST_BEAN_FIELD = 1;

    public static final int SECOND_BEAN_FIELD = 2;

    public static final int THIRD_BEAN_FIELD = 3;

    public static final int THIRD_BEAN_FIELD_COST = 3;

    public static final String EMPTY = "x";

    public Player(Hand hand, DrawArea drawArea, KeepArea keepArea,
            Treasury treasury, BeanField firstBeanField,
            BeanField secondBeanField, DrawDeck drawDeck,
            DiscardPile discardPile, Box box) {
        this.hand = hand;
        this.drawArea = drawArea;
        this.keepArea = keepArea;
        this.treasury = treasury;
        this.firstBeanField = firstBeanField;
        this.secondBeanField = secondBeanField;
        this.drawDeck = drawDeck;
        this.discardPile = discardPile;
        this.thirdBeanField = null;
        this.box = box;
    }

    public void setLeftPlayer(Player player) {
        leftPlayer = player;
    }

    public Player getLeftPlayer() {
        return leftPlayer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;

    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void plantHand(int beanFieldNumber) throws BohnanzaException {
        plant(beanFieldNumber, hand.remove());
    }

    public void plantKeepArea(int beanFieldNumber, Bean bean)
            throws BohnanzaException {
        keepArea.remove(bean);
        plant(beanFieldNumber, bean);
    }

    private void plant(int beanFieldNumber, Bean bean) throws BohnanzaException {

        BeanField beanField = getBeanField(beanFieldNumber);

        if (!beanField.isType(bean.getType())) {
            harvestAndSell(beanField);
        }
        beanField.add(bean);
        setChanged();
        notifyObservers(this);
    }

    public void harvestAndSellAll() throws BohnanzaException {
        harvestAndSell(getBeanField(FIRST_BEAN_FIELD));
        harvestAndSell(getBeanField(SECOND_BEAN_FIELD));
        if (hasThirdBeanField()) {
            harvestAndSell(getBeanField(THIRD_BEAN_FIELD));
        }
    }

    private void harvestAndSell(BeanField beanField) {

        if (beanField.hasCards()) {

            List<Bean> beans = beanField.empty();

            int i = 0;
            for (Bean bean : beans) {
                if (i < bean.getBeanometer().getWorth(beans.size())) {
                    treasury.add(bean);
                } else {
                    discardPile.add(bean);
                }
                i++;
            }
        }

    }

    public boolean hasThirdBeanField() {
        return thirdBeanField != null;
    }

    public void drawIntoDrawArea() {
        drawArea.add(drawDeck.remove());
    }

    public void drawIntoHand() {
        hand.add(drawDeck.remove());
    }

    public List<Bean> getDrawArea() {
        return drawArea.getCardsUnmodifiable();
    }

    public boolean isDrawAreaNotEmpty() {
        return drawArea.hasCards();
    }

    public void receiveFromHand(Collection<Bean> hand, Player player) {

        keepArea.add(hand);
        player.removeFromHand(hand);

    }

    private void removeFromHand(Collection<Bean> beans) {
        hand.remove(beans);
    }

    public void receiveFromDrawArea(Collection<Bean> drawArea, Player player) {
        keepArea.add(drawArea);
        player.removeFromDrawArea(drawArea);
    }

    public void removeFromDrawArea(Collection<Bean> cardsFromDrawArea) {
        drawArea.remove(cardsFromDrawArea);
    }

    public List<Bean> getKeepArea() {
        return keepArea.getCardsUnmodifiable();
    }

    public boolean isKeepAreaNotEmpty() {
        return keepArea.hasCards();
    }

    public void buy() throws BohnanzaException {

        if (getTreasury() >= THIRD_BEAN_FIELD_COST) {

            int i = 0;
            while (i < THIRD_BEAN_FIELD_COST) {

                discardPile.add(treasury.remove());

                i++;
            }

            thirdBeanField = new BeanField();

            box.remove();
        } else {
            throw new BohnanzaException(BohnanzaException.NOT_ENOUGH_MONEY);
        }
    }

    public int getTreasury() {
        return treasury.getSize();
    }

    public boolean isHandNotEmpty() {
        return hand.hasCards();
    }

    public List<Bean> getHand() {
        return hand.getCardsUnmodifiable();
    }

    public void shuffle() {
        List<Bean> temp = drawDeck.empty();
        temp.addAll(discardPile.empty());

        Collections.shuffle(temp);

        drawDeck.add(temp);
    }

    private BeanField getBeanField(int nr) throws BohnanzaException {
        BeanField beanField = null;
        switch (nr) {
        case FIRST_BEAN_FIELD:
            beanField = firstBeanField;
            break;
        case SECOND_BEAN_FIELD:
            beanField = secondBeanField;
            break;
        case THIRD_BEAN_FIELD:
            if (hasThirdBeanField()) {
                beanField = thirdBeanField;
            } else {
                throw new BohnanzaException(BohnanzaException.THIRD_FIELD);
            }
            break;
        default:
            throw new BohnanzaException(BohnanzaException.NO_FIELD);
        }
        return beanField;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, name, hand, drawArea, keepArea,
                firstBeanField, secondBeanField,
                hasThirdBeanField() ? thirdBeanField : EMPTY);
    }

    public void keep() {
        keepArea.add(drawArea.empty());
    }
}
