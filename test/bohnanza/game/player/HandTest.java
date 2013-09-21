package bohnanza.game.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import bohnanza.game.Bean;
import bohnanza.game.BeanMock;

public class HandTest {

    private Hand hand;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public final void setUp() {
        hand = new Hand();
    }

    @Test
    public final void testInitializeCollection() {
        thrown.expect(NoSuchElementException.class);
        hand.draw();
    }

    @Test
    public final void testHand() {
        thrown.expect(NoSuchElementException.class);
        hand.draw();
    }

    @Test
    public final void testAdd() {
        BeanMock beanMock = new BeanMock();
        hand.add(beanMock);

        assertEquals(beanMock, hand.draw());

    }

    @Test
    public final void testSize() {
        assertEquals(0, hand.size());
        hand.add(new BeanMock());
        assertEquals(1, hand.size());
    }

    @Test
    public final void testGetInt() {
        thrown.expect(IndexOutOfBoundsException.class);
        hand.get(0);
        BeanMock beanMock = new BeanMock();
        hand.add(beanMock);
        assertEquals(beanMock, hand.get(0));
    }

    @Test
    public final void testGetCards() {
        BeanMock beanMock = new BeanMock();
        hand.add(beanMock);
        Queue<Bean> queue = hand.getCards();

        assertEquals(1, queue.size());
        assertTrue(queue.contains(beanMock));
    }

    @Test
    public final void testRemove() {
        BeanMock beanMock = new BeanMock();
        hand.add(beanMock);
        Queue<Bean> queue = new LinkedList<Bean>();
        queue.add(beanMock);

        hand.remove(queue);

        assertFalse(hand.getCards().contains(beanMock));

    }

}
