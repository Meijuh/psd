package bohnanza.game.gameplay;

import bohnanza.View;
import bohnanza.game.Bean;
import bohnanza.game.Type;

public class SelectCard extends GameState {

    @Override
    public void execute(GameContext context) {

        Bean card;

        String area;
        if (context.getCurrentPlayer().hasDrawAreaCards()) {
            area = context.getView().selectCollection(
                    context.getCurrentPlayer());
        } else {
            area = View.HAND;
        }

        switch (area) {
        case View.DRAW_AREA:
            if (context.getCurrentPlayer().getDrawAreaCards().size() == 1) {
                card = context.getCurrentPlayer().getDrawAreaCards().iterator()
                        .next();
            } else {
                Type type = context.getView().getType(
                        Type.getArrayList(context.getCurrentPlayer()
                                .getDrawAreaCards()));

                card = context.getCurrentPlayer().getDrawAreaCard(type);
            }
            break;
        case View.HAND:
            int number = context.getView().getNumber(
                    context.getCurrentPlayer().getHand().getCards());

            card = context.getCurrentPlayer().getHand().get(number);

            break;
        default:
            card = null;
        }

        context.setActiveCard(card);
    }

}
