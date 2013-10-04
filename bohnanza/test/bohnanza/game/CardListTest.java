package bohnanza.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import bohnanza.game.factory.BlackEyed;

public class CardListTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private CardList<Bean> cardList;

    @Before
    public final void setUp() {
        cardList = new CardListMock();
    }

    @Test
    public final void testCardList() throws Exception {
        assertFalse(cardList.hasCards());
    }

    @Test
    public final void testInitializeCollection() throws Exception {
        assertFalse(cardList.hasCards());
    }

    @Test
    public final void testGetCardsUnmodifiable() throws Exception {

        thrown.expect(UnsupportedOperationException.class);
        cardList.getCardsUnmodifiable().add(new BlackEyed(new Beanometer()));
    }

    @Test
    public final void testHasCards() throws Exception {
        assertFalse(cardList.hasCards());
    }

    @Test
    public final void testEmpty() throws Exception {
        Bean bean = new BlackEyed(new Beanometer());
        cardList.add(bean);

        List<Bean> beans = new LinkedList<Bean>();
        beans.add(bean);

        assertEquals(cardList.empty(), beans);

    }

    @Test
    public final void testIsType() throws Exception {
        Bean bean = new BlackEyed(new Beanometer());

        cardList.add(bean);

        cardList.isType(bean.getType());
    }

    @Test
    public final void testPeek() throws Exception {
        Bean bean = new BlackEyed(new Beanometer());

        cardList.add(bean);

        assertEquals(bean, cardList.peek());

    }

    @Test
    public final void testAddE() throws Exception {
        Bean bean = new BlackEyed(new Beanometer());

        cardList.add(bean);

        assertEquals(bean, cardList.peek());
    }

    @Test
    public final void testRemove() throws Exception {
        Bean bean = new BlackEyed(new Beanometer());

        cardList.add(bean);

        assertEquals(bean, cardList.remove());
    }

    @Test
    public final void testGetSize() throws Exception {
        assertEquals(0, cardList.getSize());
    }

    @Test
    public final void testToString() throws Exception {

        Beanometer beanometer = new Beanometer();
        beanometer.setCardsForFourCoins(0);

        Bean bean = new BlackEyed(beanometer);

        cardList.add(bean);

        assertEquals(bean.toString(), cardList.toString());
    }

}
