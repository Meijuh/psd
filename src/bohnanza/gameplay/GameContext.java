package bohnanza.gameplay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

import bohnanza.game.player.Player;
import bohnanza.game.shared.Box;
import bohnanza.game.shared.DiscardPile;
import bohnanza.game.shared.DrawDeck;
import bohnanza.view.View;

public class GameContext extends Observable {

    private static final int THREE = 3;

    private GameState current;

    private final List<Player> players;

    private final View view;

    private Player currentPlayer;

    private int exitStatus;

    private int drawDeckExhaustedCount;

    private final DiscardPile discardPile;

    private final DrawDeck drawDeck;

    private final Box box;

    private static final String TO_STRING_MESSAGE = "State: %s, players: %d, draw deck shuffled: %d times, current player: %s";

    public GameContext(View view, DiscardPile discardPile, DrawDeck drawDeck,
            Box box) {
        players = new ArrayList<Player>();
        drawDeckExhaustedCount = 0;

        addObserver(view);
        this.view = view;

        discardPile.addObserver(view);
        drawDeck.addObserver(view);
        box.addObserver(view);

        this.discardPile = discardPile;
        this.drawDeck = drawDeck;
        this.box = box;

        for (Player player : players) {
            player.addObserver(view);
        }

        current = Prepare.getInstance();
    }

    public DrawDeck getDrawDeck() {
        return drawDeck;
    }

    public DiscardPile getDiscardPile() {
        return discardPile;
    }

    public Box getBox() {
        return box;
    }

    public void changeState(GameState gameState) {
        current = gameState;
        notifyObservers();
    }

    public void setPlayer(Player... players) {

        this.players.addAll(Arrays.asList(players));
    }

    public GameState getState() {
        return current;
    }

    public void execute() {
        current.execute(this);
    }

    public View getView() {
        return view;
    }

    public List<Player> getPlayers() {
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
                drawDeckExhaustedCount, currentPlayer.getName());
    }

}
