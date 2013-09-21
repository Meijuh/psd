package bohnanza.game.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import bohnanza.game.Bean;
import bohnanza.game.BeanMock;
import bohnanza.game.factory.BlackEyed;

public class BeanFieldTest {

    private BeanField beanField;

    public static final String TO_STRING_MESSAGE = "2->1, 4->2, 6->3, 8->4";

    @Before
    public final void setUp() {
        beanField = new BeanField();
    }

    @Test
    public final void testInitializeCollection() {
        assertNull(beanField.peek());
    }

    @Test
    public final void testToString() {

        BeanMock beanMock = new BeanMock();

        beanField.plant(beanMock);

        assertEquals(BlackEyed.TYPE + Bean.SPACE + TO_STRING_MESSAGE,
                beanField.toString());
    }

    @Test
    public final void testToStringNull() {
        assertEquals(BeanField.EMPTY, beanField.toString());
    }

    @Test
    public final void testBeanField() {
        assertNull(beanField.peek());
    }

    @Test
    public final void testPeekNull() {
        assertNull(beanField.peek());
    }

    @Test
    public final void testPeek() {

        BeanMock beanMock = new BeanMock();

        beanField.plant(beanMock);

        assertEquals(beanMock, beanField.peek());
    }

    @Test
    public final void testPlant() {
        assertNull(beanField.peek());

        BeanMock beanMock = new BeanMock();

        beanField.plant(beanMock);

        assertEquals(beanMock, beanField.peek());

        beanMock = new BeanMock();

        beanField.plant(beanMock);

        assertEquals(beanMock, beanField.peek());
    }

}
