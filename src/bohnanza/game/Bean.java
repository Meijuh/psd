package bohnanza.game;

import java.util.HashMap;

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

    public static final String SPACE = " ";

    protected Bean(String type, Beanometer beanometer) {
        super(type);
        this.beanometer = beanometer;
    }

    public Beanometer getBeanometer() {
        return beanometer;
    }

    public static final HashMap<Integer, String> getBeanTypes() {

        HashMap<Integer, String> result = new HashMap<Integer, String>();

        result.put(1, BlackEyed.TYPE);
        result.put(2, Blue.TYPE);
        result.put(3, Chili.TYPE);
        result.put(4, Cocoa.TYPE);
        result.put(5, Coffee.TYPE);
        result.put(6, Garden.TYPE);
        result.put(7, Green.TYPE);
        result.put(8, Red.TYPE);
        result.put(9, Soy.TYPE);
        result.put(10, Stink.TYPE);
        result.put(11, Wax.TYPE);

        return result;
    }

    @Override
    public int hashCode() {
        return Type.getType(getType()).ordinal();
    }

    @Override
    public String toString() {
        return super.toString() + SPACE + beanometer.toString();
    }

}
