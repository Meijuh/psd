package bohnanza.gameplay;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Fail extends GameState {

    private static Fail instance = null;

    private Exception exception;

    private static final String NAME = "fail";

    private static final String FAIL = "Bohnanza ended abnormally, reason: %s";

    private static final Logger LOGGER = Logger.getLogger(Fail.class.getName());

    private Fail() {
        super(NAME);
    }

    @Override
    public void execute(GameContext context) {
        context.setExitStatus(1);
        context.changeState(null);
        LOGGER.log(Level.SEVERE, String.format(FAIL, exception.getMessage()));
    }

    public static Fail getInstance() {
        if (instance == null) {
            instance = new Fail();
        }

        return instance;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

}
