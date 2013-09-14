/**
 * 
 */
package bohnanza.game.shared;

import bohnanza.game.factory.CardsAlreadyCreatedException;

/**
 * @author jeroen
 * 
 */
public class SharedArea {

    private static SharedArea instance = null;

    private final DrawDeck drawDeck;

    private final DiscardPile discardPile;

    private SharedArea() throws CardsAlreadyCreatedException {
        drawDeck = DrawDeck.getInstance();
        discardPile = DiscardPile.getInstance();
    }

    public static final SharedArea getInstance()
            throws CardsAlreadyCreatedException {
        if (instance == null) {
            instance = new SharedArea();
        }

        return instance;
    }

}
