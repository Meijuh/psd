package bohnanza.gameplay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Set;

import bohnanza.game.player.Player;
import bohnanza.game.shared.Box;
import bohnanza.game.shared.DiscardPile;
import bohnanza.game.shared.DrawDeck;
import bohnanza.view.View;

public abstract class GameContext extends Observable {

    private GameState current;

    private final List<Player> players;

    private final View view;

    private Player currentPlayer;

    private int exitStatus;

    private int drawDeckExhaustedCount;

    private final DiscardPile discardPile;

    private final DrawDeck drawDeck;

    private final Box box;

    private final End endState;

    public GameContext(End endState, View view, DiscardPile discardPile,
            DrawDeck drawDeck, Box box) {
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
        this.endState = endState;

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
        this.setChanged();
        notifyObservers(this);
    }

    public void setPlayer(Player... players) {

        for (Player player : players) {
            player.addObserver(view);
        }

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
        notifyObservers(this);
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
        notifyObservers(this);
    }

    public boolean isDrawDeckMaxExhausted() {
        return drawDeckExhaustedCount == getDrawDeckMaxExhausted();
    }

    protected abstract int getDrawDeckMaxExhausted();

    @Override
    public String toString() {

        return current.getToString(this);
    }

    public Set<Player> getWinners() {

        HashSet<Player> winners = new HashSet<Player>();

        int highest = -1;

        for (Player player : players) {
            if (player.getTreasury() > highest) {
                highest = player.getTreasury();
            }
        }

        for (Player player : players) {
            if (player.getTreasury() == highest) {
                winners.add(player);
            }
        }

        return winners;

    }

    public int getDrawDeckExhaustedCount() {
        return drawDeckExhaustedCount;
    }

    public End getEndState() {
        return endState;
    }
}
