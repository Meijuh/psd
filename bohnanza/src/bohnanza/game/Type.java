package bohnanza.game;

import java.util.ArrayList;
import java.util.Collection;

public enum Type {

    BLACK_EYED("black-eyed"), BLUE("blue"), CHILI("chili"), COCOA("cocoa"), COFFEE(
            "coffee"), GARDEN("garden"), GREEN("green"), RED("red"), SOY("soy"), STINK(
            "stink"), WAX("wax");

    private final String name;

    private Type(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static ArrayList<Type> getArrayList(Collection<Bean> collection) {
        ArrayList<Type> types = new ArrayList<Type>();

        for (Bean bean : collection) {
            types.add(bean.getType());
        }

        return types;
    }

}
