package bohnanza.game.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import bohnanza.game.Bean;
import bohnanza.game.Type;
import bohnanza.game.shared.DiscardPile;

public class BeanFieldTest {

    private BeanField beanField;

    @Before
    public final void setUp() {
        beanField = new BeanField();
    }

    @Test
    public final void testInitializeCollection() {
        assertEquals(0, beanField.getSize());
    }

    @Test
    public final void testToString() {

        DiscardPile discardPile = new DiscardPile();

        Bean bean = discardPile.peek();

        beanField.add(bean);

        assertEquals(BeanField.BAR + bean.toString() + BeanField.BAR,
                beanField.toString());
    }

    @Test
    public final void testToStringNull() {
        assertEquals(BeanField.BAR + BeanField.EMPTY + BeanField.BAR,
                beanField.toString());
    }

    @Test
    public final void testIsType() {
        assertTrue(beanField.isType(Type.BLACK_EYED));
    }

}
