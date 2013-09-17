package bohnanza.gameplay;

import java.util.Collection;
import java.util.HashSet;

import bohnanza.game.Bean;
import bohnanza.game.Type;
import bohnanza.game.player.Player;

public class SecondTurn extends GameState {

    private static final String NAME = "second turn";

    private static SecondTurn instance = null;

    private SecondTurn() {
        super(NAME);
    }

    @Override
    public void execute(GameContext context) {

        Collection<Bean> cardsFromHand = new HashSet<Bean>();
        Collection<Bean> cardsFromDrawArea = new HashSet<Bean>();
        Collection<Type> proposal;

        if (context.getCurrentPlayer().canDrawTwoCards()) {
            context.getCurrentPlayer().drawTwoCards();
        } else if (context.getCurrentPlayer().canDrawOneCard()) {
            context.getCurrentPlayer().drawOneCard();
        } else {
            context.increaseDrawDeckExhausted();
            context.getCurrentPlayer().shuffle();
        }

        if (context.getCurrentPlayer().hasDrawAreaCards()) {
            cardsFromDrawArea = context.getView().getOptionsFromDrawArea(
                    context.getCurrentPlayer().getDrawAreaCards());
        }

        if (context.getCurrentPlayer().hasCardsInHand()) {
            cardsFromHand = context.getView().getOptionsFromHand(
                    context.getCurrentPlayer().getCardsFromHand());
        }

        proposal = context.getView().getOptionsFromType(Type.getList());

        while (cardsFromDrawArea.size() != 0 || cardsFromHand.size() != 0
                || proposal.size() != 0) {

            Player tradepartner = context.getView().getTradePartner(proposal,
                    cardsFromDrawArea, cardsFromHand,
                    context.getCurrentPlayer());

            Collection<Bean> counterProposal = context.getView()
                    .getOptionsFromHand(tradepartner.getCardsFromHand());

            if (counterProposal != null) {
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

            }

            if (context.getCurrentPlayer().hasDrawAreaCards()) {
                cardsFromDrawArea = context.getView().getOptionsFromDrawArea(
                        context.getCurrentPlayer().getDrawAreaCards());
            }

            if (context.getCurrentPlayer().hasCardsInHand()) {
                cardsFromHand = context.getView().getOptionsFromHand(
                        context.getCurrentPlayer().getCardsFromHand());
            }

            proposal = context.getView().getOptionsFromType(Type.getList());
        }

        context.changeState(ThirdTurn.getInstance());

    }

    public static SecondTurn getInstance() {
        if (instance == null) {
            instance = new SecondTurn();
        }

        return instance;
    }

}
