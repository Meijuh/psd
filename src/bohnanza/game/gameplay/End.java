package bohnanza.game.gameplay;

public class End extends GameState {

    private static End instance = null;

    private End() {
        super();
    }

    @Override
    public void execute(GameContext context) {
        // TODO Auto-generated method stub

    }

    public static End getInstance() {
        if (instance == null) {
            instance = new End();
        }

        return instance;
    }

}
