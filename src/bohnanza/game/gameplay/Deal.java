package bohnanza.game.gameplay;

import bohnanza.game.player.Player;

public class Deal extends GameState {

    private static Deal instance = null;

    private static final int HAND_SIZE = 5;

    private Deal() {
        super();
    }

    @Override
    public void execute(GameContext context) {

        for (Player player : context.getPlayers()) {
            for (int i = 0; i < HAND_SIZE; i++) {
                player.getHand().add(
                        context.getSharedArea().getDrawDeck().draw());
            }
        }

        context.changeState(FirstTurn.getInstance());

    }

    public static Deal getInstance() {
        if (instance == null) {
            instance = new Deal();
        }

        return instance;
    }

}
