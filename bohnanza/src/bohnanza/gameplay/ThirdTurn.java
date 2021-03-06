package bohnanza.gameplay;

import bohnanza.game.Bean;
import bohnanza.game.player.BohnanzaException;
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

                while (plantingPlayer.isKeepAreaNotEmpty()) {

                    if (!plantingPlayer.hasThirdBeanField()
                            && plantingPlayer.getTreasury() >= Player.THIRD_BEAN_FIELD_COST) {
                        boolean wantsBuy = context.getView().confirmBuy();

                        if (wantsBuy) {
                            plantingPlayer.buy();
                        }

                    }

                    Bean bean = context.getView().getOptionFromKeepArea(
                            plantingPlayer.getKeepArea());

                    int beanFieldNumber = context.getView().mustPlant(
                            plantingPlayer);
                    plantingPlayer.plantKeepArea(beanFieldNumber, bean);
                }

                plantingPlayer = plantingPlayer.getLeftPlayer();

            } while (!plantingPlayer.equals(context.getCurrentPlayer()));

        } catch (BohnanzaException e) {
            context.changeState(Fail.getInstance());
            Fail.getInstance().setException(e);
        }

        if (context.isDrawDeckMaxExhausted()) {
            context.changeState(context.getEndState());
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
