package bohnanza.game.factory;

public class CardsAlreadyCreatedException extends Exception {

    private static final String MESSAGE = "Could not create cards; cards are already created.";

    CardsAlreadyCreatedException() {
        super(MESSAGE);
    }

}
