package bohnanza.gameplay;

public class End extends GameState {

    private static End instance = null;

    private End() {
        super();
    }

    @Override
    public void execute(GameContext context) {
        context.setExitStatus(0);
        context.changeState(null);

    }

    public static End getInstance() {
        if (instance == null) {
            instance = new End();
        }

        return instance;
    }

}
