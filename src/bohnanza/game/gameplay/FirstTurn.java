package bohnanza.game.gameplay;

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
        // TODO Auto-generated method stub

    }

}
