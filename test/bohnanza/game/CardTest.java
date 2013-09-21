/**
 * 
 */
package bohnanza.game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author jeroen
 * 
 */
public class CardTest {

    private final Card card = new CardMock(CardMock.TYPE);

    @Test
    public void testCard() {
        assertEquals(CardMock.TYPE, new CardMock(CardMock.TYPE).getType());
    }

    @Test
    public void testGetType() {
        assertEquals(CardMock.TYPE, card.getType());
    }

    @Test
    public void testToString() {
        assertEquals(CardMock.TYPE, card.toString());
    }

}
