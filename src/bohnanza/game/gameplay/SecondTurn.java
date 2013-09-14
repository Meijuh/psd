package bohnanza.game.gameplay;

public class SecondTurn extends GameState {

    private static SecondTurn instance = null;

    private SecondTurn() {
        super();
    }

    @Override
    public void execute(GameContext context) {
        // TODO Auto-generated method stub

    }

    public static SecondTurn getInstance() {
        if (instance == null) {
            instance = new SecondTurn();
        }

        return instance;
    }

}
