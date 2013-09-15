package bohnanza.game.gameplay;

import bohnanza.game.player.FarmException;

public class FirstTurn extends GameState {

    private static FirstTurn instance = null;

    private FirstTurn() {
        super();
    }

    public static FirstTurn getInstance() {
        if (instance == null) {
            instance = new FirstTurn();
        }

        return instance;
    }

    @Override
    public void execute(GameContext context) {

        if (context.getCurrentPlayer().getHand().hasCards()) {

            int beanFieldNumber = context.getView().mustPlant(
                    context.getCurrentPlayer());

            try {

                context.getCurrentPlayer().plant(beanFieldNumber);

                if (context.getCurrentPlayer().getHand().hasCards()) {
                    beanFieldNumber = context.getView().mayPlant(
                            context.getCurrentPlayer());

                    context.getCurrentPlayer().plant(beanFieldNumber);

                }

                context.changeState(SecondTurn.getInstance());

            } catch (FarmException e) {
                context.changeState(Fail.getInstance(e));
            }
        }

    }
}
