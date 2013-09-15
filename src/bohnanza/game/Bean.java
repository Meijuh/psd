package bohnanza.game;

import java.util.HashSet;

import bohnanza.game.factory.BlackEyed;
import bohnanza.game.factory.Blue;
import bohnanza.game.factory.Chili;
import bohnanza.game.factory.Cocoa;
import bohnanza.game.factory.Coffee;
import bohnanza.game.factory.Garden;
import bohnanza.game.factory.Green;
import bohnanza.game.factory.Red;
import bohnanza.game.factory.Soy;
import bohnanza.game.factory.Stink;
import bohnanza.game.factory.Wax;

public abstract class Bean extends Card {

    private final Beanometer beanometer;

    protected Bean(String type, Beanometer beanometer) {
        super(type);
        this.beanometer = beanometer;
    }

    public Beanometer getBeanometer() {
        return beanometer;
    }

    public static final HashSet<String> getBeanTypes() {

        HashSet<String> result = new HashSet<String>();

        result.add(BlackEyed.TYPE);
        result.add(Blue.TYPE);
        result.add(Chili.TYPE);
        result.add(Cocoa.TYPE);
        result.add(Coffee.TYPE);
        result.add(Garden.TYPE);
        result.add(Green.TYPE);
        result.add(Red.TYPE);
        result.add(Soy.TYPE);
        result.add(Stink.TYPE);
        result.add(Wax.TYPE);

        return result;
    }

}
