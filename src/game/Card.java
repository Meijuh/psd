package game;

public abstract class Card {

    private final int amount;

    protected Card(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

}
