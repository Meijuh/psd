package bohnanza.gameplay;

public abstract class GameState {

    private final String name;

    protected GameState(String name) {
        this.name = name;
    }

    public abstract void execute(GameContext context);

    @Override
    public String toString() {
        return name;
    }

}
