package bohnanza.gameplay;

import bohnanza.game.player.BohnanzaException;

public class FirstTurn extends GameState {

    private static FirstTurn instance = null;

    private static final String NAME = "first turn";

    private FirstTurn() {
        super(NAME);
    }

    public static FirstTurn getInstance() {
        if (instance == null) {
            instance = new FirstTurn();
        }

        return instance;
    }

    @Override
    public void execute(GameContext context) {

        if (context.getCurrentPlayer().getHand().size() > 0) {

            int beanFieldNumber = context.getView().mustPlant(
                    context.getCurrentPlayer());

            try {

                context.getCurrentPlayer().plantHand(beanFieldNumber);

                if (context.getCurrentPlayer().getHand().size() > 0) {
                    beanFieldNumber = context.getView().mayPlant(
                            context.getCurrentPlayer());

                    context.getCurrentPlayer().plantHand(beanFieldNumber);

                }

                context.changeState(SecondTurn.getInstance());

            } catch (BohnanzaException e) {
                context.changeState(Fail.getInstance());
                Fail.getInstance().setException(e);
            }
        }
    }
}
