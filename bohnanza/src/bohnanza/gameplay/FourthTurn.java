package bohnanza.gameplay;

public class FourthTurn extends GameState {

    private static FourthTurn instance = null;

    public static final int THREE_CARDS = 3;

    private static final String NAME = "fourth turn";

    private FourthTurn() {
        super(NAME);
    }

    @Override
    public void execute(GameContext context) {

        if (context.getDrawDeck().getSize() < THREE_CARDS) {
            context.increaseDrawDeckExhausted();

            if (context.isDrawDeckMaxExhausted()) {
                context.changeState(context.getEndState());
            } else {
                context.getCurrentPlayer().shuffle();

                drawAndContinue(context);
            }
        } else {
            drawAndContinue(context);
        }

    }

    private void drawAndContinue(GameContext context) {

        context.getCurrentPlayer().drawIntoHand();
        context.getCurrentPlayer().drawIntoHand();
        context.getCurrentPlayer().drawIntoHand();

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
