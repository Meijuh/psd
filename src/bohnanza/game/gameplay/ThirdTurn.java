package bohnanza.game.gameplay;

public class ThirdTurn extends GameState {

    private static ThirdTurn instance = null;

    private ThirdTurn() {
        super();
    }

    @Override
    public void execute(GameContext context) {
        // TODO Auto-generated method stub

    }

    public static ThirdTurn getInstance() {
        if (instance == null) {
            instance = new ThirdTurn();
        }

        return instance;
    }

}
