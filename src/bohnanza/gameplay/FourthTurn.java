package bohnanza.gameplay;

import bohnanza.game.shared.SharedArea;

public class FourthTurn extends GameState {

    private static FourthTurn instance = null;

    private FourthTurn() {
        super();
    }

    @Override
    public void execute(GameContext context) {

        if (!SharedArea.getInstance().canDrawThreeCards()) {
            context.increaseDrawDeckExhausted();

            if (context.isDrawDeckExhaustedThreeTimes()) {
                context.changeState(End.getInstance());
            } else {
                SharedArea.getInstance().shuffle();

                drawAndContinue(context);
            }
        } else {
            drawAndContinue(context);
        }

    }

    private void drawAndContinue(GameContext context) {

        context.getCurrentPlayer().drawThreeCards();

        context.setCurrentPlayer(context.getCurrentPlayer().getLeftPlayer());

        context.changeState(FirstTurn.getInstance());

    }

    public static FourthTurn getInstance() {
        if (instance == null) {
            instance = new FourthTurn();
        }

        return instance;
    }

}
