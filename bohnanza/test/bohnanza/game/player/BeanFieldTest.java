package bohnanza.game.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;
import bohnanza.game.Type;
import bohnanza.game.factory.BlackEyed;

public class BeanFieldTest {

    private BeanField beanField;

    public static final String TO_STRING_MESSAGE_NULL = "|(0)|";

    public static final String TO_STRING_MESSAGE = "|%s (1)|";

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

        Beanometer beanometer = new Beanometer();
        beanometer.setCardsForFourCoins(0);

        Bean bean = new BlackEyed(beanometer);

        beanField.add(bean);

        assertEquals(String.format(TO_STRING_MESSAGE, bean.toString()),
                beanField.toString());
    }

    @Test
    public final void testToStringNull() {
        assertEquals(TO_STRING_MESSAGE_NULL, beanField.toString());
    }

    @Test
    public final void testIsType() {
        assertTrue(beanField.isType(Type.BLACK_EYED));
    }

}
