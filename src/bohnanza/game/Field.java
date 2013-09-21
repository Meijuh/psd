package bohnanza.game;

import java.util.HashSet;
import java.util.Set;

public abstract class Field extends CardCollection<Set<Bean>> {

    protected Field() {
        super(new HashSet<Bean>());
    }

    public Set<Type> getTypes() {
        Set<Type> types = new HashSet<Type>();

        for (Bean bean : getCards()) {
            types.add(bean.getType());
        }

        return types;
    }
}
