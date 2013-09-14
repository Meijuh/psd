package bohnanza.game.player;

import bohnanza.game.factory.CardsAlreadyCreatedException;

public class Player {

    private String name;

    private Player leftPlayer;

    private final Hand hand;

    public Player() throws CardsAlreadyCreatedException {
        hand = new Hand();
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
}
