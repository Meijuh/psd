package bohnanza.game.player;

import java.util.Collection;
import java.util.HashSet;

import bohnanza.game.Bean;
import bohnanza.game.Type;
import bohnanza.game.shared.SharedArea;

public class Player {

    private String name;

    private Player leftPlayer;

    private final Hand hand;

    private int playerNumber;

    private final PlayerArea playerArea;

    private final SharedArea sharedArea;

    public Player() {
        hand = new Hand();
        playerArea = new PlayerArea();
        sharedArea = SharedArea.getInstance();
    }

    public void setLeftPlayer(Player player) {
        leftPlayer = player;
    }

    public Player getLeftPlayer() {
        return leftPlayer;
    }

    @Override
    public String toString() {
        return getName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;

    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void plant(int beanFieldNumber) throws FarmException {
        plant(beanFieldNumber, getHand().draw());
    }

    public void plant(int beanFieldNumber, Bean bean) throws FarmException {
        sharedArea.discard(playerArea.harvestAndSell(beanFieldNumber));
        playerArea.getFarm().plant(beanFieldNumber, bean);
    }

    public boolean hasThirdBeanField() {
        return playerArea.getFarm().hasThirdBeanField();
    }

    public void drawTwoCards() {
        drawOneCard();
        drawOneCard();
    }

    public void drawOneCard() {
        playerArea.showCard(sharedArea.draw());
    }

    public void drawThreeCards() {
        getHand().add(sharedArea.draw());
        getHand().add(sharedArea.draw());
        getHand().add(sharedArea.draw());
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
        player.getHand().remove(counterProposal);

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

        SharedArea.getInstance().discard(playerArea.buy());

        playerArea.getFarm().setThirdBeanFieldCard(
                SharedArea.getInstance().buy());
    }
}
