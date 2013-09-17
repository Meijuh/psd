package bohnanza.gameplay;

import java.util.HashSet;
import java.util.Set;

import bohnanza.game.player.Player;
import bohnanza.game.shared.SharedArea;
import bohnanza.view.TUIView;
import bohnanza.view.View;

public class GameContext {

    private static final int THREE = 3;

    private GameState current;

    private static GameContext instance = null;

    private final Set<Player> players;

    private final View view;

    private final SharedArea sharedArea;

    private Player currentPlayer;

    private int exitStatus;

    private int drawDeckExhaustedCount;

    private GameContext(int playerCount) {
        players = new HashSet<Player>(playerCount);
        drawDeckExhaustedCount = 0;

        for (int i = 0; i < playerCount; i++) {
            players.add(new Player());
        }

        view = new TUIView();
        sharedArea = SharedArea.getInstance();
        current = Prepare.getInstance();

        sharedArea.addObserver(view);
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

    public static GameContext getInstance(int players) {
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

    public Set<Player> getPlayers() {
        return players;
    }

    public SharedArea getSharedArea() {
        return sharedArea;
    }

    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setExitStatus(int exitStatus) {
        this.exitStatus = exitStatus;
    }

    public int getExitStatus() {
        return this.exitStatus;
    }

    public void increaseDrawDeckExhausted() {
        drawDeckExhaustedCount++;
    }

    public boolean isDrawDeckExhaustedThreeTimes() {
        return drawDeckExhaustedCount == THREE;
    }

}
