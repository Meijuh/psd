package bohnanza.game.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import bohnanza.game.BeanMock;
import bohnanza.game.shared.SharedArea;

public class FarmTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public static final String TO_STRING_MESSAGE = "farm: |x|, |x|, x";

    public static final String TO_STRING_MESSAGE_THIRD = "farm: |x|, |x|, |x|";

    private Farm farm;

    @Before
    public final void setUp() {
        farm = new Farm();
    }

    @Test
    public final void testFarm() throws FarmException {
        assertNotNull(farm.getBeanField(Farm.FIRST));
        assertNotNull(farm.getBeanField(Farm.SECOND));

        thrown.expect(FarmException.class);
        farm.getBeanField(Farm.THIRD);
    }

    @Test
    public final void testGetBeanField() throws FarmException {
        assertNotNull(farm.getBeanField(Farm.FIRST));
        assertNotNull(farm.getBeanField(Farm.SECOND));

        thrown.expect(FarmException.class);
        farm.getBeanField(Farm.THIRD);

        farm.setThirdBeanFieldCard(new SharedArea().buy());
        assertNotNull(farm.getBeanField(Farm.THIRD));
    }

    @Test
    public final void testSetThirdBeanFieldCard() throws FarmException {
        farm.setThirdBeanFieldCard(new SharedArea().buy());
        assertNotNull(farm.getBeanField(Farm.THIRD));
    }

    @Test
    public final void testHasThirdBeanField() {
        assertFalse(farm.hasThirdBeanField());
        farm.setThirdBeanFieldCard(new SharedArea().buy());
        assertTrue(farm.hasThirdBeanField());

    }

    @Test
    public final void testPlant() throws FarmException {

        BeanMock beanMock = new BeanMock();

        farm.plant(Farm.FIRST, beanMock);

        assertEquals(beanMock, farm.getBeanField(Farm.FIRST).peek());

        beanMock = new BeanMock();

        farm.plant(Farm.SECOND, beanMock);

        assertEquals(beanMock, farm.getBeanField(Farm.SECOND).peek());

        thrown.expect(FarmException.class);

        beanMock = new BeanMock();
        farm.plant(Farm.THIRD, beanMock);
        farm.setThirdBeanFieldCard(new SharedArea().buy());
        farm.plant(Farm.THIRD, new BeanMock());

        assertEquals(beanMock, farm.getBeanField(Farm.THIRD).peek());
    }

    @Test
    public final void testToString() {
        assertEquals(TO_STRING_MESSAGE, farm.toString());
        farm.setThirdBeanFieldCard(new SharedArea().buy());
        assertEquals(TO_STRING_MESSAGE_THIRD, farm.toString());
    }

}
