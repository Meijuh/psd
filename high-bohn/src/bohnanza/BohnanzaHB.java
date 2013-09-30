package bohnanza;

import bohnanza.game.player.Player;
import bohnanza.gameplay.GameContext;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class BohnanzaHB extends Bohnanza {

    private static final int MIN_PLAYERS = 3;

    private static final int MAX_PLAYERS = 5;

    private static final String RUN = "java bohnanza.BohnanzaHB";

    @Inject
    protected BohnanzaHB(String[] args, GameContext gameContext,
            Provider<Player> playerProvider) {
        super(args, gameContext, playerProvider);
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BohnanzaHBModule());
        injector.injectMembers(args);
        injector.getInstance(Bohnanza.class);
    }

    @Override
    protected String getRun() {
        return RUN;
    }

    @Override
    protected int getMinPlayers() {
        return MIN_PLAYERS;
    }

    @Override
    protected int getMaxPlayers() {
        return MAX_PLAYERS;
    }

}
