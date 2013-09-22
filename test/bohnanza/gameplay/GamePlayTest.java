package bohnanza.gameplay;

import org.junit.Before;

import bohnanza.game.player.BeanField;
import bohnanza.game.player.DrawArea;
import bohnanza.game.player.Hand;
import bohnanza.game.player.KeepArea;
import bohnanza.game.player.Player;
import bohnanza.game.player.Treasury;
import bohnanza.game.shared.Box;
import bohnanza.game.shared.DiscardPile;
import bohnanza.game.shared.DrawDeck;
import bohnanza.view.View;

public abstract class GamePlayTest {

    protected static final String NAME_ONE = "name1";

    protected static final String NAME_TWO = "name2";

    protected static final int FIRST_PLAYER = 0;

    protected static final int SECOND_PLAYER = 1;

    protected static final int PLAYERS = 2;

    private final DiscardPile discardPile = new DiscardPile();

    private final Box box = new Box();

    private final DrawDeck drawDeck = new DrawDeck();

    private View view;

    private GameContext gameContext;

    private Hand firstHand;
    private DrawArea firstDrawArea;
    private KeepArea firstKeepArea;
    private Treasury firstTreasury;
    private BeanField firstFirstBeanField;
    private BeanField firstSecondBeanField;

    private Hand secondHand;
    private DrawArea secondDrawArea;
    private KeepArea secondKeepArea;
    private Treasury secondTreasury;
    private BeanField secondFirstBeanField;
    private BeanField secondSecondBeanField;

    protected Hand getFirstHand() {
        return firstHand;
    }

    protected DrawArea getFirstDrawArea() {
        return firstDrawArea;
    }

    protected KeepArea getFirstKeepArea() {
        return firstKeepArea;
    }

    protected Treasury getFirstTreasury() {
        return firstTreasury;
    }

    protected BeanField getFirstFirstBeanField() {
        return firstFirstBeanField;
    }

    protected BeanField getFirstSecondBeanField() {
        return firstSecondBeanField;
    }

    protected Hand getSecondHand() {
        return secondHand;
    }

    protected DrawArea getSecondDrawArea() {
        return secondDrawArea;
    }

    protected KeepArea getSecondKeepArea() {
        return secondKeepArea;
    }

    protected Treasury getSecondTreasury() {
        return secondTreasury;
    }

    protected BeanField getSecondFirstBeanField() {
        return secondFirstBeanField;
    }

    protected BeanField getSecondSecondBeanField() {
        return secondSecondBeanField;
    }

    protected GameContext getGameContext() {
        return gameContext;
    }

    protected Box getBox() {
        return box;
    }

    protected DrawDeck getDrawDeck() {
        return drawDeck;
    }

    protected DiscardPile getDiscardPile() {
        return discardPile;
    }

    protected View getView() {
        return view;
    }

    protected abstract View setView();

    @Before
    public void setUp() {

        view = setView();

        gameContext = new GameContext(view, discardPile, drawDeck, box);

        Player player;

        firstHand = new Hand();
        firstDrawArea = new DrawArea();
        firstKeepArea = new KeepArea();
        firstTreasury = new Treasury();
        firstFirstBeanField = new BeanField();
        firstSecondBeanField = new BeanField();

        player = new Player(firstHand, firstDrawArea, firstKeepArea,
                firstTreasury, firstFirstBeanField, firstSecondBeanField,
                drawDeck, discardPile, box);
        gameContext.setPlayer(player);

        secondHand = new Hand();
        secondDrawArea = new DrawArea();
        secondKeepArea = new KeepArea();
        secondTreasury = new Treasury();
        secondFirstBeanField = new BeanField();
        secondSecondBeanField = new BeanField();

        player = new Player(secondHand, secondDrawArea, secondKeepArea,
                secondTreasury, secondFirstBeanField, secondSecondBeanField,
                drawDeck, discardPile, box);
        gameContext.setPlayer(player);

    }
}
