package bohnanza.game.player;

public class FarmException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -7220446163815240050L;

    public static final String NO_FIELD = "There are only three bean fields.";

    public static final String THIRD_FIELD = "Farm does not have a third bean field yet.";

    public FarmException(String message) {
        super(message);
    }

}
