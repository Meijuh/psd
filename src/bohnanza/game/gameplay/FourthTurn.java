package bohnanza.game.gameplay;

public class FourthTurn extends GameState {

    private static FourthTurn instance = null;

    private FourthTurn() {
        super();
    }

    @Override
    public void execute(GameContext context) {
        // TODO Auto-generated method stub

    }

    public static FourthTurn getInstance() {
        if (instance == null) {
            instance = new FourthTurn();
        }

        return instance;
    }

}
