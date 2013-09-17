package bohnanza.gameplay;

import bohnanza.game.Bean;
import bohnanza.game.player.FarmException;
import bohnanza.game.player.Player;

public class ThirdTurn extends GameState {

    private static final String NAME = "third turn";

    private static ThirdTurn instance = null;

    private ThirdTurn() {
        super(NAME);
    }

    @Override
    public void execute(GameContext context) {

        try {

            Player plantingPlayer = context.getCurrentPlayer();
            do {

                while (plantingPlayer.hasKeepAreaCards()) {

                    if (plantingPlayer.hasThirdBeanField()) {
                        boolean wantsBuy = context.getView().confirmBuy();

                        if (wantsBuy) {
                            plantingPlayer.buy();
                        }

                    }

                    Bean bean = context.getView().getOptionFromKeepArea(
                            plantingPlayer.getKeepAreaCards());

                    int beanFieldNumber = context.getView().mustPlant(
                            plantingPlayer);
                    plantingPlayer.plant(beanFieldNumber, bean);
                }

                plantingPlayer = plantingPlayer.getLeftPlayer();

            } while (!plantingPlayer.equals(context.getCurrentPlayer()));

        } catch (FarmException e) {
            context.changeState(Fail.getInstance(e));
        }

        if (context.isDrawDeckExhaustedThreeTimes()) {
            context.changeState(End.getInstance());
        } else {

            context.changeState(FourthTurn.getInstance());
        }

    }

    public static ThirdTurn getInstance() {
        if (instance == null) {
            instance = new ThirdTurn();
        }

        return instance;
    }

}
