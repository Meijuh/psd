package bohnanza.game;

import java.util.HashSet;
import java.util.Set;

public abstract class Field extends CardCollection<Bean, Set<Bean>> {

    protected Field() {
        super(new HashSet<Bean>());
    }

}
