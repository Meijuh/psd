package bohnanza.gameplay;

public class End extends GameState {

    private static End instance = null;

    private static final String NAME = "end";

    private End() {
        super(NAME);
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
