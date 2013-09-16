package bohnanza.game.gameplay;

import java.util.Collection;
import java.util.HashSet;

import bohnanza.game.Bean;
import bohnanza.game.Type;
import bohnanza.game.player.Player;

public class SecondTurn extends GameState {

    private static SecondTurn instance = null;

    private SecondTurn() {
        super();
    }

    @Override
    public void execute(GameContext context) {

        Collection<Bean> cardsFromHand;
        Collection<Bean> cardsFromDrawArea;

        if (context.getCurrentPlayer().hasDrawAreaCards()) {
            cardsFromDrawArea = context.getView().getOptionsFromDrawArea(
                    context.getCurrentPlayer().getDrawAreaCards());
        } else {
            cardsFromDrawArea = new HashSet<Bean>();
        }

        if (context.getCurrentPlayer().getHand().hasCards()) {
            cardsFromHand = context.getView().getOptionsFromHand(
                    context.getCurrentPlayer().getHand().getCards());
        } else {
            cardsFromHand = new HashSet<Bean>();
        }

        Collection<Type> proposal = context.getView().getOptionsFromType(
                Type.getList());

        Player tradepartner = context.getView().getTradePartner(proposal,
                cardsFromDrawArea, cardsFromHand, context.getCurrentPlayer());

        Collection<Bean> counterProposal = context.getView()
                .getOptionsFromHand(tradepartner.getHand().getCards());

        if (counterProposal != null) {
            boolean confirmTrade = context.getView().confirmTrade(
                    cardsFromDrawArea, cardsFromHand, tradepartner,
                    counterProposal);

            context.getCurrentPlayer().receiveFromHand(counterProposal,
                    tradepartner);
            tradepartner.receiveFromHand(cardsFromHand,
                    context.getCurrentPlayer());
            tradepartner.receiveFromDrawArea(cardsFromDrawArea,
                    context.getCurrentPlayer());

        }

    }

    public static SecondTurn getInstance() {
        if (instance == null) {
            instance = new SecondTurn();
        }

        return instance;
    }

}
