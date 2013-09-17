package bohnanza.gameplay;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

import bohnanza.game.player.Player;
import bohnanza.game.shared.SharedArea;
import bohnanza.view.TUIView;
import bohnanza.view.View;

public class GameContext extends Observable {

    private static final int THREE = 3;

    private GameState current;

    private final Set<Player> players;

    private final View view;

    private Player currentPlayer;

    private int exitStatus;

    private int drawDeckExhaustedCount;

    private static final String TO_STRING_MESSAGE = "State: %s, players: %d, draw deck shuffled: %d times, current player: %s";

    public GameContext(int playerCount) {
        players = new HashSet<Player>(playerCount);
        drawDeckExhaustedCount = 0;

        view = new TUIView();
        addObserver(view);

        SharedArea sharedArea = new SharedArea();
        sharedArea.addObserver(view);

        for (int i = 0; i < playerCount; i++) {
            Player player = new Player(sharedArea);
            player.addObserver(view);
            players.add(player);
        }
        current = Prepare.getInstance();
    }

    public void changeState(GameState gameState) {
        current = gameState;
        notifyObservers();
    }

    public GameState getState() {
        return current;
    }

    public void execute() {
        current.execute(this);
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

    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
        notifyObservers();
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
        notifyObservers();
    }

    public boolean isDrawDeckExhaustedThreeTimes() {
        return drawDeckExhaustedCount == THREE;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, current, players.size(),
                drawDeckExhaustedCount, currentPlayer);
    }

}
