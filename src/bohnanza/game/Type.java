package bohnanza.game;

import java.util.ArrayList;
import java.util.Collection;
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

public enum Type {

    BLACK_EYED, BLUE, CHILI, COCOA, COFFEE, GARDEN, GREEN, RED, SOY, STINK, WAX;

    public static String getType(Type bean) {

        String type;
        switch (bean) {
        case BLACK_EYED:
            type = BlackEyed.TYPE;
            break;
        case BLUE:
            type = Blue.TYPE;
            break;
        case CHILI:
            type = Chili.TYPE;
            break;
        case COCOA:
            type = Cocoa.TYPE;
            break;
        case COFFEE:
            type = Coffee.TYPE;
            break;
        case GARDEN:
            type = Garden.TYPE;
        case GREEN:
            type = Green.TYPE;
            break;
        case RED:
            type = Red.TYPE;
            break;
        case SOY:
            type = Soy.TYPE;
            break;
        case STINK:
            type = Stink.TYPE;
        case WAX:
            type = Wax.TYPE;
            break;
        default:
            type = null;
            break;
        }

        return type;
    }

    public static Type getType(String type) {

        Type beans;
        switch (type) {
        case BlackEyed.TYPE:
            beans = BLACK_EYED;
            break;
        case Blue.TYPE:
            beans = BLUE;
            break;
        case Chili.TYPE:
            beans = CHILI;
            break;
        case Cocoa.TYPE:
            beans = COCOA;
            break;
        case Coffee.TYPE:
            beans = COFFEE;
            break;
        case Garden.TYPE:
            beans = GARDEN;
            break;
        case Green.TYPE:
            beans = GREEN;
            break;
        case Red.TYPE:
            beans = RED;
            break;
        case Soy.TYPE:
            beans = SOY;
            break;
        case Stink.TYPE:
            beans = STINK;
        case Wax.TYPE:
            beans = WAX;
            break;
        default:
            beans = null;
            break;
        }

        return beans;

    }

    @Override
    public String toString() {
        return getType(this);
    }

    public static ArrayList<Type> getArrayList(Collection<Bean> collection) {
        ArrayList<Type> types = new ArrayList<Type>();

        for (Bean bean : collection) {
            types.add(getType(bean.getType()));
        }

        return types;
    }

    public boolean isType(Bean next) {
        return equals(Type.getType(next));
    }

    public static Type getType(Bean bean) {
        return getType(bean.getType());
    }

    public static Collection<Type> getList() {
        HashSet<Type> types = new HashSet<Type>();

        types.add(BLACK_EYED);
        types.add(BLUE);
        types.add(CHILI);
        types.add(COCOA);
        types.add(COFFEE);
        types.add(GARDEN);
        types.add(GREEN);
        types.add(RED);
        types.add(SOY);
        types.add(STINK);
        types.add(WAX);

        return types;
    }

}
