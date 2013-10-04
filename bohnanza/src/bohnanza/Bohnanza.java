package bohnanza;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import bohnanza.game.player.Player;
import bohnanza.gameplay.GameContext;

import com.google.inject.Inject;
import com.google.inject.Provider;

public abstract class Bohnanza {

    public static final String LONG_OPTION_PLAYERS = "players";
    public static final String OPTION_PLAYERS = "p";
    public static final String OPTION_PLAYERS_DESCRIPTION = "Number of players";

    public static final String LONG_OPTION_HELP = "help";
    public static final String OPTION_HELP = "h";
    public static final String OPTION_HELP_DESCRIPTION = "Prints this message";

    public static final String PARSE_EXCEPTION_MESSAGE = "Parsing of command line options failed, reason: %s, try '%s -h' to see help.";

    public static final String NOT_A_NUMBER = "Could not parse value, reason %s";

    private static final Logger LOGGER = Logger.getLogger(Bohnanza.class
            .getName());
    private static final String PLAYER_RANGE = "Amount of players should be between %d and %d, %d players given.";

    private final GameContext gameContext;

    private final Provider<Player> playerProvider;

    @Inject
    protected Bohnanza(GameContext gameContext, Provider<Player> playerProvider) {

        this.gameContext = gameContext;
        this.playerProvider = playerProvider;
    }

    protected void run(String[] args) {

        Options options = new Options();

        Option playersOption = new Option(OPTION_PLAYERS, LONG_OPTION_PLAYERS,
                true, OPTION_PLAYERS_DESCRIPTION);
        playersOption.setRequired(true);
        options.addOption(playersOption);

        options.addOption(new Option(OPTION_HELP, LONG_OPTION_HELP, false,
                OPTION_HELP_DESCRIPTION));

        CommandLineParser commandLineParser = new GnuParser();

        LOGGER.setLevel(Level.INFO);

        try {
            CommandLine commandLine = commandLineParser.parse(options, args);

            HelpFormatter helpFormatter = new HelpFormatter();

            if (commandLine.hasOption(OPTION_HELP)) {
                helpFormatter.printHelp(getRun(), options);
            } else {

                int playerCount = Integer.parseInt(commandLine
                        .getOptionValue(OPTION_PLAYERS));

                if (getMinPlayers() > playerCount
                        || playerCount > getMaxPlayers()) {
                    LOGGER.log(Level.SEVERE, String.format(PLAYER_RANGE,
                            getMinPlayers(), getMaxPlayers(), playerCount));
                } else {

                    for (int i = 0; i < playerCount; i++) {

                        Player player = playerProvider.get();
                        gameContext.setPlayer(player);
                    }

                    while (gameContext.getState() != null) {
                        gameContext.execute();
                    }

                    System.exit(gameContext.getExitStatus());
                }
            }
        } catch (ParseException e) {
            LOGGER.log(
                    Level.SEVERE,
                    String.format(PARSE_EXCEPTION_MESSAGE, getRun(),
                            e.getMessage()));
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE,
                    String.format(NOT_A_NUMBER, e.getMessage()));
        }
        System.exit(1);
    }

    protected abstract String getRun();

    protected abstract int getMinPlayers();

    protected abstract int getMaxPlayers();
}
