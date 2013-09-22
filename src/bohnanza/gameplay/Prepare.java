package bohnanza.gameplay;

import java.util.Collections;

import bohnanza.game.player.Player;

public class Prepare extends GameState {

    private static Prepare instance = null;

    private static final String NAME = "prepare";

    public static final int HAND_SIZE = 5;

    private Prepare() {
        super(NAME);
    }

    public static Prepare getInstance() {
        if (instance == null) {
            instance = new Prepare();
        }

        return instance;
    }

    @Override
    public void execute(GameContext context) {

        int playerNumber = 1;
        for (Player player : context.getPlayers()) {

            String name = context.getView().getName(playerNumber);

            player.setName(name);

            playerNumber++;
        }

        Collections.shuffle(context.getPlayers());

        context.setCurrentPlayer(context.getPlayers().get(0));

        playerNumber = 0;
        for (Player player : context.getPlayers()) {

            player.setLeftPlayer(context.getPlayers().get(
                    playerNumber % context.getPlayers().size()));
            player.setPlayerNumber(playerNumber + 1);

            playerNumber++;
        }

        context.getCurrentPlayer().shuffle();

        for (Player player : context.getPlayers()) {
            for (int i = 0; i < HAND_SIZE; i++) {
                player.drawIntoHand();
            }
        }

        context.changeState(FirstTurn.getInstance());

    }
}
