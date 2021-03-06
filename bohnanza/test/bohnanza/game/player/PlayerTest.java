package bohnanza.game.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.runners.MockitoJUnitRunner;

import bohnanza.game.Bean;
import bohnanza.game.Beanometer;
import bohnanza.game.factory.BlackEyed;
import bohnanza.game.factory.Red;
import bohnanza.game.factory.Soy;
import bohnanza.game.shared.Box;
import bohnanza.game.shared.DiscardPile;
import bohnanza.game.shared.DrawDeck;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    private static final String TO_STRING_MESSAGE = "name: blaat\nhand: \ndraw area: \nkeep area: \nbean fields: |(0)| |(0)| x";

    private final Hand hand = new Hand();

    private final DrawArea drawArea = new DrawArea();

    private final KeepArea keepArea = new KeepArea();

    private final BeanField firstBeanField = new BeanField();

    private final BeanField secondBeanField = new BeanField();

    private final DrawDeck drawDeck = mock(DrawDeck.class);

    private final DiscardPile discardPile = mock(DiscardPile.class);

    private final Treasury treasury = mock(Treasury.class);

    private final Box box = mock(Box.class);

    private Player player;

    public static final int DECK_SIZE = 154;

    public static final String BLAAT = "blaat";

    @Before
    public final void setUp() {
        player = new Player(hand, drawArea, keepArea, treasury, firstBeanField,
                secondBeanField, drawDeck, discardPile, box);
    }

    @Test
    public final void testPlayer() throws Exception {

        assertEquals(0, player.getHand().size());
        assertEquals(0, player.getDrawArea().size());
    }

    @Test
    public final void testSetLeftPlayer() throws Exception {

        player.setLeftPlayer(player);

        assertEquals(player.getLeftPlayer(), player);
    }

    @Test
    public final void testGetLeftPlayer() throws Exception {

        player.setLeftPlayer(player);

        assertEquals(player.getLeftPlayer(), player);
    }

    @Test
    public final void testSetName() throws Exception {
        player.setName(null);

        assertNull(player.getName());
    }

    @Test
    public final void testGetName() throws Exception {
        player.setName(null);

        assertNull(player.getName());
    }

    @Test
    public final void testSetPlayerNumber() throws Exception {
        player.setPlayerNumber(0);
        assertEquals(0, player.getPlayerNumber());
    }

    @Test
    public final void testGetPlayerNumber() throws Exception {
        player.setPlayerNumber(0);
        assertEquals(0, player.getPlayerNumber());
    }

    @Test
    public final void testPlantHandInt() throws Exception {

        Beanometer beanometer = new Beanometer();
        beanometer.setCardsForOneCoin(Beanometer.TWO_CARDS);

        // Test that a Bean is moved from the hand to the bean field.
        Bean bean = new BlackEyed(beanometer);

        when(drawDeck.remove()).thenReturn(bean);

        int oldDiscardPileSize = discardPile.getSize();

        player.drawIntoHand();

        player.plantHand(Player.FIRST_BEAN_FIELD);

        assertFalse(player.getHand().contains(bean));
        assertEquals(oldDiscardPileSize, discardPile.getSize());
        assertEquals(bean, firstBeanField.peek());

        // Test that the Bean is moved from the hand to the bean field. Also
        // tests if the bean field is emptied.
        Bean otherBean = new Red(beanometer);

        when(drawDeck.remove()).thenReturn(otherBean);

        player.drawIntoHand();
        player.plantHand(Player.FIRST_BEAN_FIELD);

        assertFalse(player.getHand().contains(otherBean));
        assertEquals(otherBean, firstBeanField.peek());

        ArgumentCaptor<Bean> captor = ArgumentCaptor.forClass(Bean.class);

        verify(discardPile).add(captor.capture());

        assertEquals(bean, captor.getValue());

        // Test that a second Bean is moved from the hand to the bean field.
        Bean otherOtherBean = new Red(beanometer);

        when(drawDeck.remove()).thenReturn(otherOtherBean);
        player.drawIntoHand();
        player.plantHand(Player.FIRST_BEAN_FIELD);
        assertEquals(2, firstBeanField.getSize());
        assertTrue(firstBeanField.getCardsUnmodifiable().contains(
                otherOtherBean));
        assertFalse(player.getHand().contains(otherOtherBean));

        // Test if the treasury is increased, since the Red beans are harvested
        // and sold.
        Bean soy = new Soy(beanometer);

        when(drawDeck.remove()).thenReturn(soy);
        player.drawIntoHand();
        player.plantHand(Player.FIRST_BEAN_FIELD);

        verify(treasury).add(captor.capture());

        assertFalse(player.getHand().contains(soy));
        assertEquals(otherBean, captor.getValue());
        assertEquals(1, firstBeanField.getSize());

        verify(discardPile, times(2)).add(captor.capture());
        assertEquals(otherOtherBean, captor.getValue());
        assertTrue(firstBeanField.getCardsUnmodifiable().contains(soy));

    }

    @Test
    public final void testHarvestAndSellAll() throws Exception {
    }

    @Test
    public final void testHasThirdBeanField() throws Exception {

        assertFalse(player.hasThirdBeanField());

    }

    @Test
    public final void testDrawIntoDrawArea() throws Exception {

        Bean bean = new BlackEyed(new Beanometer());

        when(drawDeck.remove()).thenReturn(bean);

        player.drawIntoDrawArea();

        assertEquals(bean, player.getDrawArea().get(0));

    }

    @Test
    public final void testDrawIntoHand() throws Exception {

        Bean bean = new BlackEyed(new Beanometer());

        when(drawDeck.remove()).thenReturn(bean);

        player.drawIntoHand();

        assertEquals(bean, player.getHand().get(0));
    }

    @Test
    public final void testGetDrawArea() throws Exception {

        Bean bean = new BlackEyed(new Beanometer());

        when(drawDeck.remove()).thenReturn(bean);

        player.drawIntoHand();

        assertEquals(drawArea.getCardsUnmodifiable(), player.getDrawArea());

        thrown.expect(UnsupportedOperationException.class);
        player.getDrawArea().add(hand.peek());
    }

    @Test
    public final void testIsDrawAreaNotEmpty() throws Exception {
        assertEquals(drawArea.hasCards(), player.isDrawAreaNotEmpty());
    }

    @Test
    public final void testReceiveFromHand() throws Exception {

        Bean bean = new BlackEyed(new Beanometer());

        when(drawDeck.remove()).thenReturn(bean);

        player.drawIntoHand();

        List<Bean> hand = new LinkedList<Bean>(player.getHand());

        player.receiveFromHand(player.getHand(), player);

        assertEquals(hand, player.getKeepArea());

        assertFalse(player.isHandNotEmpty());
    }

    @Test
    public final void testReceiveFromDrawArea() throws Exception {

        Bean bean = new BlackEyed(new Beanometer());

        when(drawDeck.remove()).thenReturn(bean);

        player.drawIntoDrawArea();

        List<Bean> drawArea = new LinkedList<Bean>(player.getDrawArea());

        player.receiveFromDrawArea(drawArea, player);

        assertEquals(drawArea, player.getKeepArea());

        assertFalse(player.isDrawAreaNotEmpty());
    }

    @Test
    public final void testRemoveFromDrawArea() throws Exception {

        Bean bean = new BlackEyed(new Beanometer());

        when(drawDeck.remove()).thenReturn(bean);

        player.drawIntoDrawArea();

        List<Bean> drawArea = new LinkedList<Bean>(player.getDrawArea());

        assertEquals(1, drawArea.size());

        player.removeFromDrawArea(player.getDrawArea());

        assertFalse(player.getDrawArea().containsAll(drawArea));
    }

    @Test
    public final void testGetKeepArea() throws Exception {

        Bean bean = new BlackEyed(new Beanometer());

        when(drawDeck.remove()).thenReturn(bean);

        player.drawIntoHand();

        assertEquals(keepArea.getCardsUnmodifiable(), player.getKeepArea());

        thrown.expect(UnsupportedOperationException.class);
        player.getKeepArea().add(hand.peek());
    }

    @Test
    public final void testIsKeepAreaNotEmpty() throws Exception {
        assertEquals(keepArea.hasCards(), player.isKeepAreaNotEmpty());
    }

    @Test
    public final void testBuy() throws Exception {

        when(drawDeck.remove()).thenReturn(new BlackEyed(new Beanometer()))
                .thenReturn(new BlackEyed(new Beanometer()))
                .thenReturn(new BlackEyed(new Beanometer()));
        player.drawIntoHand();

        treasury.add(player.getHand());

        thrown.expect(BohnanzaException.class);
        player.buy();

    }

    @Test
    public final void testBuyException() throws Exception {

        when(drawDeck.remove()).thenReturn(new BlackEyed(new Beanometer()))
                .thenReturn(new BlackEyed(new Beanometer()))
                .thenReturn(new BlackEyed(new Beanometer()));
        player.drawIntoHand();

        assertFalse(player.hasThirdBeanField());

        player.drawIntoHand();
        player.drawIntoHand();

        treasury.add(player.getHand());

        when(treasury.remove()).thenReturn(new BlackEyed(new Beanometer()))
                .thenReturn(new BlackEyed(new Beanometer()))
                .thenReturn(new BlackEyed(new Beanometer()));

        when(treasury.getSize()).thenReturn(3).thenReturn(0);

        player.buy();

        assertTrue(player.hasThirdBeanField());
        assertEquals(0, player.getTreasury());
    }

    @Test
    public final void testGetTreasury() throws Exception {
        assertEquals(treasury.getSize(), player.getTreasury());
    }

    @Test
    public final void testIsHandNotEmpty() throws Exception {
        assertEquals(hand.hasCards(), player.isHandNotEmpty());
    }

    @Test
    public final void testGetHand() throws Exception {

        Bean bean = new BlackEyed(new Beanometer());

        when(drawDeck.remove()).thenReturn(bean);

        player.drawIntoHand();

        assertEquals(hand.getCardsUnmodifiable(), player.getHand());

        thrown.expect(UnsupportedOperationException.class);
        player.getHand().add(hand.peek());
    }

    @Captor
    private ArgumentCaptor<List<Bean>> shuffleCaptor;

    @Test
    public final void testShuffle() throws Exception {

        List<Bean> list = new ArrayList<Bean>();
        list.add(new Red(new Beanometer()));

        when(discardPile.empty()).thenReturn(list);
        player.shuffle();

        verify(drawDeck).add(shuffleCaptor.capture());

        assertTrue(shuffleCaptor.getValue().containsAll(list));
        assertEquals(list.size(), shuffleCaptor.getValue().size());

    }

    @Test
    public final void testToString() throws Exception {

        player.setName(BLAAT);
        assertEquals(TO_STRING_MESSAGE, player.toString());
    }

}
