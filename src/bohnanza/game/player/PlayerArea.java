package bohnanza.game.player;

import bohnanza.game.factory.CardsAlreadyCreatedException;

public class PlayerArea {

    private final Farm farm;
    private final DrawArea drawArea;
    private final KeepArea keepArea;
    private final Treasury treasury;

    public PlayerArea() throws CardsAlreadyCreatedException {
        farm = new Farm();
        drawArea = new DrawArea();
        keepArea = new KeepArea();
        treasury = new Treasury();
    }

}
