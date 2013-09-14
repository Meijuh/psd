package bohnanza.game.gameplay;

import java.util.ArrayList;
import java.util.Collections;

import bohnanza.game.player.Player;

public class Prepare extends GameState {

    private static Prepare instance = null;

    private Prepare() {
        super();
    }

    public static Prepare getInstance() {
        if (instance == null) {
            instance = new Prepare();
        }

        return instance;
    }

    @Override
    public void execute(GameContext context) {

        ArrayList<Player> players = new ArrayList<Player>(context.getPlayers());

        int playerNumber = 1;
        for (Player player : players) {

            String name = context.getView().getName(playerNumber);

            player.setName(name);

            playerNumber++;
        }

        Collections.shuffle(players);

        playerNumber = 0;
        for (Player player : players) {

            player.setLeftPlayer(players.get(playerNumber + 1 % players.size()));

            playerNumber++;
        }

        context.changeState(Deal.getInstance());

    }
}
