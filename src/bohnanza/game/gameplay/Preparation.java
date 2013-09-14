package bohnanza.game.gameplay;

import java.util.ArrayList;
import java.util.Collections;

import bohnanza.game.player.Age;
import bohnanza.game.player.Player;

public class Preparation extends GameState {

    private static Preparation instance = null;

    private Preparation() {
        super();
    }

    public static Preparation getInstance() {
        if (instance == null) {
            instance = new Preparation();
        }

        return instance;
    }

    @Override
    public void execute(GameContext context) {

        ArrayList<Player> players = new ArrayList<Player>(
                context.getPlayerCount());

        Player player;
        Player oldestPlayer = null;
        Age age;

        for (int i = 0; i < context.getPlayerCount(); i++) {

            int playerNumber = i + 1;

            String name = context.getView().getName(playerNumber);
            String year = context.getView().getYear(playerNumber);
            String month = context.getView().getMonth(playerNumber);
            String day = context.getView().getDay(playerNumber);

            age = new Age(year, month, day);

            player = new Player(age, name);

            players.add(player);

            if (oldestPlayer == null) {
                oldestPlayer = player;
            } else {
                if (player.getAge().isOlderThan(oldestPlayer.getAge())) {
                    oldestPlayer = player;
                }
            }

        }

        context.setOldestPlayer(oldestPlayer);

        Collections.shuffle(players);

        for (int i = 0; i < context.getPlayerCount(); i++) {
            player = players.get(i);
            player.setLeftPlayer(players.get(i + 1 % context.getPlayerCount()));
        }

        context.getView().shuffleCards(oldestPlayer);

    }
}
