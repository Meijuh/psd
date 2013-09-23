package bohnanza.gameplay;

import bohnanza.game.player.Player;

public class End extends GameState {

    private static End instance = null;

    private static final String NAME = "end";

    private static final String TO_STRING_MESSAGE = "Game ended, winner(s): %s.";

    private End() {
        super(NAME);
    }

    @Override
    public void execute(GameContext context) {

        try {

            for (Player player : context.getPlayers()) {
                player.harvestAndSellAll();
            }

            context.setExitStatus(0);
            context.changeState(null);
        } catch (Exception e) {
            context.changeState(Fail.getInstance());
            Fail.getInstance().setException(e);
        }

    }

    public static End getInstance() {
        if (instance == null) {
            instance = new End();
        }

        return instance;
    }

    @Override
    public String getToString(GameContext context) {
        return String
                .format(TO_STRING_MESSAGE, context.getWinners().toString());
    }
}
