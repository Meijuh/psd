package bohnanza.gameplay;

import bohnanza.game.player.Player;

public abstract class End extends GameState {

    private static final String NAME = "end";

    private static final String TO_STRING_MESSAGE = "Game ended, winner(s): %s.";

    protected End() {
        super(NAME);
    }

    protected abstract void doEnd(GameContext context);

    @Override
    public void execute(GameContext context) {

        try {

            for (Player player : context.getPlayers()) {
                player.harvestAndSellAll();
            }

            doEnd(context);
        } catch (Exception e) {
            context.changeState(Fail.getInstance());
            Fail.getInstance().setException(e);
        }

    }

    @Override
    public String getToString(GameContext context) {
        return String
                .format(TO_STRING_MESSAGE, context.getWinners().toString());
    }
}
