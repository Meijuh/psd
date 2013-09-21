package bohnanza.game.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Set;

import bohnanza.game.Bean;
import bohnanza.game.Type;
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

    private final BeanField thirdBeanField;

    private final DrawDeck drawDeck;

    private final DiscardPile discardPile;

    private final KeepArea keepArea;

    private final Treasury treasury;

    private static final String TO_STRING_MESSAGE = "hand: %s, %s";

    public static final int FIRST_BEAN_FIELD = 1;

    public static final int SECOND_BEAN_FIELD = 2;

    public static final int THIRD_BEAN_FIELD = 3;

    public Player(Hand hand, DrawArea drawArea, KeepArea keepArea,
            Treasury treasury, BeanField firstBeanField,
            BeanField secondBeanField, DrawDeck drawDeck,
            DiscardPile discardPile) {
        this.hand = hand;
        this.drawArea = drawArea;
        this.keepArea = keepArea;
        this.treasury = treasury;
        this.firstBeanField = firstBeanField;
        this.secondBeanField = secondBeanField;
        this.drawDeck = drawDeck;
        this.discardPile = discardPile;
        this.thirdBeanField = null;
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

    public void plant(int beanFieldNumber) throws FarmException {
        plant(beanFieldNumber, hand.draw());
    }

    public void plant(int beanFieldNumber, Bean bean) throws FarmException {

        BeanField beanField = getBeanField(beanFieldNumber);

        if (!beanField.isType(bean.getType())) {
            harvestAndSell(beanField);
        }
        beanField.plant(bean);
        notifyObservers();
    }

    private void harvestAndSell(BeanField beanField) {

        if (beanField.hasCards()) {

            Collection<Bean> beans = beanField.empty();

            int i = 0;
            for (Bean bean : beans) {
                if (i < bean.getBeanometer().getWorth(beans.size())) {
                    treasury.makeProfit(bean);
                } else {
                    discardPile.discard(bean);
                }
                i++;
            }
        }

    }

    public boolean hasThirdBeanField() {
        return thirdBeanField != null;
    }

    public void drawTwoCards() {
        drawOneCard();
        drawOneCard();
    }

    public void drawOneCard() {
        drawArea.showCard(drawDeck.draw());
    }

    public void drawThreeCards() {
        hand.add(drawDeck.draw());
        hand.add(drawDeck.draw());
        hand.add(drawDeck.draw());
    }

    public Set<Type> getDrawAreaTypes() {
        return drawArea.getTypes();
    }

    public boolean hasDrawAreaTypes() {
        return getDrawAreaTypes().size() > 0;
    }

    public void receiveFromHand(Collection<Bean> counterProposal, Player player) {

        keepArea.add(counterProposal);
        player.removeFromHand(counterProposal);

    }

    private void removeFromHand(Collection<Bean> beans) {
        hand.remove(beans);
    }

    public void receiveFromDrawArea(Collection<Bean> cardsFromDrawArea,
            Player player) {
        keepArea.add(cardsFromDrawArea);
        player.removeFromDrawArea(cardsFromDrawArea);
    }

    public void removeFromDrawArea(Collection<Bean> cardsFromDrawArea) {
        playerArea.removeFromDrawArea(cardsFromDrawArea);
    }

    public Collection<Bean> getKeepAreaCards() {
        return playerArea.getKeepAreaCards();
    }

    public boolean hasKeepAreaCards() {
        return getKeepAreaCards().size() > 0;
    }

    public void buy() {

        sharedArea.discard(playerArea.buy());

        playerArea.setThirdBeanFieldCard(sharedArea.buy());
    }

    public boolean hasCardsInHand() {
        return hand.hasCards();
    }

    public Collection<Bean> getCardsFromHand() {
        return hand.getCards();
    }

    public void drawFromSharedArea() {
        sharedArea.draw();
    }

    public boolean canDrawThreeCards() {
        return sharedArea.canDrawThreeCards();
    }

    public boolean canDrawTwoCards() {
        return sharedArea.canDrawTwoCards();
    }

    public boolean canDrawOneCard() {
        return sharedArea.canDrawOneCard();
    }

    public void shuffle() {
        List<Bean> temp = new ArrayList<Bean>(drawDeck.empty());
        temp.addAll(discardPile.empty());

        Collections.shuffle(temp);

        drawDeck.addShuffledCards(temp);
    }

    private BeanField getBeanField(int nr) throws FarmException {
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
                throw new FarmException(FarmException.THIRD_FIELD);
            }
            break;
        default:
            throw new FarmException(FarmException.NO_FIELD);
        }
        return beanField;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, hand, playerArea);
    }
}
