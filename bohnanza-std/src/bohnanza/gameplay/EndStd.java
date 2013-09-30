package bohnanza.gameplay;

public class EndStd extends End {

    @Override
    protected void doEnd(GameContext context) {
        context.setExitStatus(0);
        context.changeState(null);

    }

}
