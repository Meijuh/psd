package bohnanza.gameplay;

import java.util.Collection;
import java.util.HashSet;

import bohnanza.game.Bean;
import bohnanza.game.Type;
import bohnanza.game.player.Player;
import bohnanza.game.shared.SharedArea;

public class SecondTurn extends GameState {

    private static SecondTurn instance = null;

    private SecondTurn() {
        super();
    }

    @Override
    public void execute(GameContext context) {

        Collection<Bean> cardsFromHand = new HashSet<Bean>();
        Collection<Bean> cardsFromDrawArea = new HashSet<Bean>();
        Collection<Type> proposal;

        if (SharedArea.getInstance().canDrawTwoCards()) {
            context.getCurrentPlayer().drawTwoCards();
        } else if (SharedArea.getInstance().canDrawOneCard()) {
            context.getCurrentPlayer().drawOneCard();
        } else {
            context.increaseDrawDeckExhausted();
            SharedArea.getInstance().shuffle();
        }

        if (context.getCurrentPlayer().hasDrawAreaCards()) {
            cardsFromDrawArea = context.getView().getOptionsFromDrawArea(
                    context.getCurrentPlayer().getDrawAreaCards());
        }

        if (context.getCurrentPlayer().getHand().hasCards()) {
            cardsFromHand = context.getView().getOptionsFromHand(
                    context.getCurrentPlayer().getHand().getCards());
        }

        proposal = context.getView().getOptionsFromType(Type.getList());

        while (cardsFromDrawArea.size() != 0 || cardsFromHand.size() != 0
                || proposal.size() != 0) {

            Player tradepartner = context.getView().getTradePartner(proposal,
                    cardsFromDrawArea, cardsFromHand,
                    context.getCurrentPlayer());

            Collection<Bean> counterProposal = context.getView()
                    .getOptionsFromHand(tradepartner.getHand().getCards());

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

            if (context.getCurrentPlayer().getHand().hasCards()) {
                cardsFromHand = context.getView().getOptionsFromHand(
                        context.getCurrentPlayer().getHand().getCards());
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
