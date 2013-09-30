package bohnanza.game.player;

public class BohnanzaException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -7220446163815240050L;

    public static final String NO_FIELD = "There are only three bean fields.";

    public static final String THIRD_FIELD = "Player does not have a third bean field.";

    public static final String NOT_ENOUGH_MONEY = "Player does not have enough money to buy third bean field.";

    public BohnanzaException(String message) {
        super(message);
    }

}
