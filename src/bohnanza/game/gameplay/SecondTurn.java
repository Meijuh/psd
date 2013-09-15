package bohnanza.game.gameplay;

import java.util.HashSet;

import bohnanza.View;
import bohnanza.game.Bean;

public class SecondTurn extends GameState {

    private static SecondTurn instance = null;

    private SecondTurn() {
        super();
    }

    @Override
    public void execute(GameContext context) {

        context.getCurrentPlayer().drawTwoCards();

        HashSet<Bean> beansInDrawArea = context.getCurrentPlayer()
                .getDrawAreaCards();

        for (Bean bean : beansInDrawArea) {
            if (context.getView().askKeepCard(context.getCurrentPlayer(), bean)) {
                context.getCurrentPlayer().keep(bean);
            }
        }
        
        if ()

        String area = context.getView().selectCollection(
                context.getCurrentPlayer());

        switch (area) {
        case View.DRAW_AREA:

            break;
        case View.HAND:
            break;
        }

    }

    public static SecondTurn getInstance() {
        if (instance == null) {
            instance = new SecondTurn();
        }

        return instance;
    }

}
