package bohnanza.game.player;

import java.util.Collection;
import java.util.HashSet;
import java.util.Observable;

import bohnanza.game.Bean;
import bohnanza.game.Type;
import bohnanza.game.shared.SharedArea;

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
        sharedArea.discard(playerArea.harvestAndSell(beanFieldNumber));
        playerArea.plant(beanFieldNumber, bean);
        notifyObservers();
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

    public HashSet<Bean> getDrawAreaCards() {
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
        sharedArea.shuffle();
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, hand, playerArea);
    }
}
