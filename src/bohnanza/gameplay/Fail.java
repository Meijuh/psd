package bohnanza.gameplay;

public class Fail extends GameState {

    private static Fail instance = null;

    private final Exception exception;

    private Fail(Exception exception) {
        super();
        this.exception = exception;
    }

    @Override
    public void execute(GameContext context) {
        context.setExitStatus(1);
        context.changeState(null);
    }

    public static Fail getInstance(Exception e) {
        if (instance == null) {
            instance = new Fail(e);
        }

        return instance;
    }

}
