package bohnanza.gameplay;

import bohnanza.game.player.Player;

public abstract class GameState {

    private final String name;

    private static final String TO_STRING_MESSAGE = "State: %s, players: %s (%d), draw deck shuffled: %d times, current player: %s";

    private static final String PLAYER_SEPERATOR = ", ";

    protected GameState(String name) {
        this.name = name;
    }

    public abstract void execute(GameContext context);

    @Override
    public String toString() {
        return name;
    }

    public String getToString(GameContext context) {

        String names = new String();

        Player currentPlayer = context.getCurrentPlayer();
        do {

            names = names.concat(currentPlayer.getName()).concat(
                    PLAYER_SEPERATOR);

            currentPlayer = currentPlayer.getLeftPlayer();

        } while (!currentPlayer.equals(context.getCurrentPlayer()));

        names = names.substring(0, names.length() - 2);

        return String
                .format(TO_STRING_MESSAGE, context.getState(), names, context
                        .getPlayers().size(), context
                        .getDrawDeckExhaustedCount(), context
                        .getCurrentPlayer());
    }
}
