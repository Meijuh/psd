package bohnanza.gameplay;

public class FourthTurn extends GameState {

    private static FourthTurn instance = null;

    private static final String NAME = "fourth turn";

    private FourthTurn() {
        super(NAME);
    }

    @Override
    public void execute(GameContext context) {

        if (!context.getCurrentPlayer().canDrawThreeCards()) {
            context.increaseDrawDeckExhausted();

            if (context.isDrawDeckExhaustedThreeTimes()) {
                context.changeState(End.getInstance());
            } else {
                context.getCurrentPlayer().shuffle();

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
