package bohnanza.game;

public class Card<E> {

    private final E type;

    protected Card(E type) {
        this.type = type;
    }

    public E getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.toString();
    }

}
