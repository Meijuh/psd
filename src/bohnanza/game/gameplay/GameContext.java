package bohnanza.game.gameplay;

import java.util.HashSet;

import bohnanza.View;
import bohnanza.game.player.Player;

public class GameContext implements Context {

    private GameState current;

    private static GameContext instance = null;

    private final int playerCount;

    private final HashSet<Player> players;

    private final View view;

    private Player oldestPlayer;

    private GameContext(int playerCount) {
        this.playerCount = playerCount;
        players = new HashSet<Player>();
        view = new View();
        current = Preparation.getInstance();
    }

    public void changeState(GameState gameState) {
        current = gameState;
    }

    public void execute() {
        current.execute(this);
    }

    public static GameContext getInstance(int players) {
        if (instance == null) {
            instance = new GameContext(players);
        }

        return instance;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public View getView() {
        return view;
    }

    public void setOldestPlayer(Player player) {
        oldestPlayer = player;
    }
}
