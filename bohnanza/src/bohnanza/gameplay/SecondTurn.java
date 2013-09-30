package bohnanza.gameplay;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;

import bohnanza.game.Bean;
import bohnanza.game.Type;
import bohnanza.game.player.Player;

public class SecondTurn extends GameState {

    private static final String NAME = "second turn";

    public static final int TWO_CARDS = 2;

    public static final int ONE_CARD = 1;

    private static SecondTurn instance = null;

    private SecondTurn() {
        super(NAME);
    }

    @Override
    public void execute(GameContext context) {

        Collection<Bean> cardsFromHand = new HashSet<Bean>();
        Collection<Bean> cardsFromDrawArea = new HashSet<Bean>();
        Collection<Type> proposal;

        if (context.getDrawDeck().getSize() >= TWO_CARDS) {
            context.getCurrentPlayer().drawIntoDrawArea();
            context.getCurrentPlayer().drawIntoDrawArea();
        } else if (context.getDrawDeck().getSize() >= ONE_CARD) {
            context.getCurrentPlayer().drawIntoDrawArea();
        } else {
            context.increaseDrawDeckExhausted();
            context.getCurrentPlayer().shuffle();
        }

        if (context.getCurrentPlayer().isDrawAreaNotEmpty()) {
            cardsFromDrawArea = context.getView().getOptionsFromDrawArea(
                    context.getCurrentPlayer().getDrawArea());
        }

        if (context.getCurrentPlayer().isHandNotEmpty()) {
            cardsFromHand = context.getView().getOptionsFromHand(
                    context.getCurrentPlayer().getHand());
        }

        proposal = context.getView().getOptionsFromType(
                EnumSet.allOf(Type.class));

        while (cardsFromDrawArea.size() != 0 || cardsFromHand.size() != 0
                || proposal.size() != 0) {

            Player tradepartner = context.getView().getTradePartner(proposal,
                    cardsFromDrawArea, cardsFromHand,
                    context.getCurrentPlayer());

            Collection<Bean> counterProposal = context.getView()
                    .getOptionsFromHand(tradepartner.getHand());

            boolean confirmTrade = context.getView().confirmTrade(
                    cardsFromDrawArea, cardsFromHand, tradepartner,
                    counterProposal);

            if (confirmTrade) {
                context.getCurrentPlayer().receiveFromHand(counterProposal,
                        tradepartner);
                tradepartner.receiveFromHand(cardsFromHand,
                        context.getCurrentPlayer());
                tradepartner.receiveFromDrawArea(cardsFromDrawArea,
                        context.getCurrentPlayer());
            }

            cardsFromDrawArea = new HashSet<Bean>();
            if (context.getCurrentPlayer().isDrawAreaNotEmpty()) {
                cardsFromDrawArea = context.getView().getOptionsFromDrawArea(
                        context.getCurrentPlayer().getDrawArea());
            }

            cardsFromHand = new HashSet<Bean>();
            if (context.getCurrentPlayer().isHandNotEmpty()) {
                cardsFromHand = context.getView().getOptionsFromHand(
                        context.getCurrentPlayer().getHand());
            }

            proposal = context.getView().getOptionsFromType(
                    EnumSet.allOf(Type.class));
        }

        context.getCurrentPlayer().keep();

        context.changeState(ThirdTurn.getInstance());

    }

    public static SecondTurn getInstance() {
        if (instance == null) {
            instance = new SecondTurn();
        }

        return instance;
    }

}
