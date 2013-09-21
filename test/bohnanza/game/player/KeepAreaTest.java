package bohnanza.game.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import bohnanza.game.Bean;
import bohnanza.game.BeanMock;

public class KeepAreaTest {

    private KeepArea keepArea;

    @Before
    public final void setUp() {
        keepArea = new KeepArea();
    }

    @Test
    public final void testInitializeCollection() {
        assertFalse(keepArea.hasCards());
    }

    @Test
    public final void testKeepArea() {
        assertFalse(keepArea.hasCards());
    }

    @Test
    public final void testGetCards() {
        assertEquals(0, keepArea.getCards().size());
    }

    @Test
    public final void testAdd() {

        BeanMock beanMock = new BeanMock();

        Set<Bean> set = new HashSet<Bean>();
        set.add(beanMock);

        keepArea.add(set);

        assertTrue(keepArea.getCards().contains(beanMock));
    }
}
