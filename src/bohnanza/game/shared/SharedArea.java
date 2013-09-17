/**
 * 
 */
package bohnanza.game.shared;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

import bohnanza.game.Bean;
import bohnanza.game.factory.ThirdBeanField;

/**
 * @author jeroen
 * 
 */
public class SharedArea extends Observable {

    private final DrawDeck drawDeck;

    private final DiscardPile discardPile;

    private final Box box;

    private static final int ONE = 1;

    private static final int TWO = 2;

    private static final int THREE = 3;

    private static final String TO_STRING_MESSAGE = "%s, %s, %s";

    public SharedArea() {
        drawDeck = new DrawDeck();
        discardPile = new DiscardPile();
        box = new Box();
    }

    public void discard(Collection<Bean> beans) {
        discardPile.discard(beans);
    }

    public void shuffle() {
        List<Bean> temp = new ArrayList<Bean>(drawDeck.empty());
        temp.addAll(discardPile.empty());

        Collections.shuffle(temp);

        drawDeck.addShuffledCards(temp);

    }

    public ThirdBeanField buy() {
        return box.draw();
    }

    public Bean draw() {
        return drawDeck.draw();
    }

    public boolean canDrawOneCard() {
        return canDraw(ONE);
    }

    public boolean canDrawTwoCards() {
        return canDraw(TWO);
    }

    public boolean canDrawThreeCards() {
        return canDraw(THREE);
    }

    private boolean canDraw(int amount) {
        return drawDeck.canDraw(amount);
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_MESSAGE, box, discardPile, drawDeck);
    }
}
