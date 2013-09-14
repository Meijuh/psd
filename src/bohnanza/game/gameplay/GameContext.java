package bohnanza.game.gameplay;

import java.util.HashSet;

import bohnanza.View;
import bohnanza.game.factory.CardsAlreadyCreatedException;
import bohnanza.game.player.Player;
import bohnanza.game.shared.SharedArea;

public class GameContext {

    private GameState current;

    private static GameContext instance = null;

    private final HashSet<Player> players;

    private final View view;

    private final SharedArea sharedArea;

    private GameContext(int playerCount) throws CardsAlreadyCreatedException {
        players = new HashSet<Player>(playerCount);

        for (int i = 0; i < playerCount; i++) {
            players.add(new Player());
        }

        view = new View();
        sharedArea = SharedArea.getInstance();
        current = Prepare.getInstance();
    }

    public void changeState(GameState gameState) {
        current = gameState;
    }

    public GameState getState() {
        return current;
    }

    public void execute() {
        current.execute(this);
    }

    public static GameContext getInstance(int players)
            throws CardsAlreadyCreatedException {
        if (instance == null) {
            instance = new GameContext(players);
        }

        return instance;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public View getView() {
        return view;
    }

    public HashSet<Player> getPlayers() {
        return players;
    }

    public SharedArea getSharedArea() {
        return sharedArea;
    }

}
