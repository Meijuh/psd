package bohnanza.game.player;

public class Player {

    private final Age age;

    private final String name;

    private Player leftPlayer;

    public Player(Age age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setLeftPlayer(Player player) {
        leftPlayer = player;
    }

    public Player getLeftPlayer() {
        return leftPlayer;
    }

    public Age getAge() {
        return age;
    }

    @Override
    public String toString() {
        return getName();
    }

    public String getName() {
        return name;
    }
}
