package bohnanza.game;

public abstract class Card implements CardType {

    private final String type;

    protected Card(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }

}
