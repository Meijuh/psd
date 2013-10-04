package bohnanza;

import bohnanza.game.player.Player;
import bohnanza.gameplay.GameContext;
import bohnanza.module.BohnanzaStdModule;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class BohnanzaStd extends Bohnanza {

    private static final int MIN_PLAYERS = 2;

    private static final int MAX_PLAYERS = 7;

    private static final String RUN = "java bohnanza.BohnanzaStd";

    @Inject
    protected BohnanzaStd(GameContext gameContext,
            Provider<Player> playerProvider) {
        super(gameContext, playerProvider);
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BohnanzaStdModule());
        injector.injectMembers(args);
        Bohnanza bohnanza = injector.getInstance(Bohnanza.class);
        bohnanza.run(args);
    }

    @Override
    protected int getMinPlayers() {
        return MIN_PLAYERS;
    }

    @Override
    protected int getMaxPlayers() {
        return MAX_PLAYERS;
    }

    @Override
    protected String getRun() {
        return RUN;
    }

}
