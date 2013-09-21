package bohnanza.game.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Set;

import bohnanza.game.Bean;
import bohnanza.game.Type;

public class Player extends Observable {

    private String name;

    private Player leftPlayer;

    private final Hand hand;

    private int playerNumber;

    private final PlayerArea playerArea;

    private final SharedArea sharedArea;

    private static final String TO_STRING_MESSAGE = "hand: %s, %s";

    public Player(SharedArea sharedArea) {
        hand = new Hand();
        playerArea = new PlayerArea();
        this.sharedArea = sharedArea;
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

        if (!playerArea.isType(beanFieldNumber, Type.getType(bean))) {
            sharedArea.discard(playerArea.harvestAndSell(beanFieldNumber));
        }
        playerArea.plant(beanFieldNumber, bean);
        notifyObservers();
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

    public boolean hasThirdBeanField() {
        return playerArea.hasThirdBeanField();
    }

    public void drawTwoCards() {
        drawOneCard();
        drawOneCard();
    }

    public void drawOneCard() {
        playerArea.showCard(sharedArea.draw());
    }

    public void drawThreeCards() {
        hand.add(sharedArea.draw());
        hand.add(sharedArea.draw());
        hand.add(sharedArea.draw());
    }

    public Set<Bean> getDrawAreaCards() {
        return playerArea.getDrawAreaCards();
    }

    public boolean hasDrawAreaCards() {
        return getDrawAreaCards().size() > 0;
    }

    public Bean getDrawAreaCard(Type type) {
        return playerArea.getDrawAreaCard(type);
    }

    public void receiveFromHand(Collection<Bean> counterProposal, Player player) {

        playerArea.setAside(counterProposal);
        player.removeFromHand(counterProposal);

    }

    private void removeFromHand(Collection<Bean> beans) {
        hand.remove(beans);
    }

    public void receiveFromDrawArea(Collection<Bean> cardsFromDrawArea,
            Player player) {
        playerArea.setAside(cardsFromDrawArea);
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

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, hand, playerArea);
    }
}
