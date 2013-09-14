package bohnanza.game.gameplay;

public abstract class GameState implements State {

    public abstract void execute(GameContext context);

}
