package bohnanza.game.player;

import java.util.HashSet;

import bohnanza.game.Bean;
import bohnanza.game.Type;
import bohnanza.game.factory.CardsAlreadyCreatedException;
import bohnanza.game.shared.SharedArea;

public class Player {

    private String name;

    private Player leftPlayer;

    private final Hand hand;

    private int playerNumber;

    private final PlayerArea playerArea;

    private final SharedArea sharedArea;

    public Player() throws CardsAlreadyCreatedException {
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
        sharedArea.discard(playerArea.harvestAndSell(beanFieldNumber));
    }

    public boolean hasThirdBeanField() {
        return playerArea.getFarm().hasThirdBeanField();
    }

    public void drawTwoCards() {

        playerArea.showCard(sharedArea.getDrawDeck().draw());
        playerArea.showCard(sharedArea.getDrawDeck().draw());

    }

    public HashSet<Bean> getDrawAreaCards() {
        return playerArea.getDrawAreaCards();
    }

    public void keep(Bean bean) {
        playerArea.keep(bean);
    }

    public boolean hasDrawAreaCards() {
        return getDrawAreaCards().size() > 0;
    }

    public Bean getDrawAreaCard(Type type) {
        return playerArea.getDrawAreaCard(type);
    }
}
