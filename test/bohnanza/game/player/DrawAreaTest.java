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
import bohnanza.game.Type;

public class DrawAreaTest {

    private DrawArea drawArea;

    @Before
    public final void setUp() {
        drawArea = new DrawArea();
    }

    @Test
    public final void testInitializeCollection() {
        assertEquals(0, drawArea.getCards().size());
    }

    @Test
    public final void testDrawArea() {
        assertEquals(0, drawArea.getCards().size());
    }

    @Test
    public final void testShowCard() {
        BeanMock beanMock = new BeanMock();
        drawArea.showCard(beanMock);

        assertTrue(drawArea.getCards().contains(beanMock));

    }

    @Test
    public final void testRemove() {
        BeanMock beanMock = new BeanMock();
        drawArea.showCard(beanMock);
        Set<Bean> set = new HashSet<Bean>();
        set.add(beanMock);
        drawArea.remove(set);

        assertFalse(drawArea.getCards().contains(beanMock));

    }

    @Test
    public final void testGetBean() {
        BeanMock beanMock = new BeanMock();
        drawArea.showCard(beanMock);

        assertEquals(beanMock, drawArea.getBean(Type.BLACK_EYED));

    }

    @Test
    public final void testGetCards() {
        BeanMock beanMock = new BeanMock();
        drawArea.showCard(beanMock);

        assertEquals(1, drawArea.getCards().size());
        assertTrue(drawArea.getCards().contains(beanMock));
    }

}
