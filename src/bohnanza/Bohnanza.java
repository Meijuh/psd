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

import bohnanza.gameplay.GameContext;

public class Bohnanza {

    public static final String LONG_OPTION_PLAYERS = "players";
    public static final String OPTION_PLAYERS = "p";
    public static final String OPTION_PLAYERS_DESCRIPTION = "Number of players";

    public static final String LONG_OPTION_HELP = "help";
    public static final String OPTION_HELP = "h";
    public static final String OPTION_HELP_DESCRIPTION = "Prints this message";

    public static final String PARSE_EXCEPTION_MESSAGE = "Parsing of command line options failed, reason: %s, try 'java bohnanza.Bohnanza -h' to see help.";

    public static final String NOT_A_NUMBER = "Could not parse value, reason %s";

    private static final String RUN = "java bohnanza.Bohnanza";

    private static final int MIN_PLAYERS = 2;

    private static final int MAX_PLAYERS = 7;

    private static final Logger LOGGER = Logger.getLogger(Bohnanza.class
            .getName());
    private static final String PLAYER_RANGE = "Amount of players should be between 2 and 7, %d players given.";

    public static void main(String[] args) {
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
                helpFormatter.printHelp(RUN, options);
            } else {

                int playerCount = Integer.parseInt(commandLine
                        .getOptionValue(OPTION_PLAYERS));

                if (MIN_PLAYERS > playerCount || playerCount > MAX_PLAYERS) {
                    LOGGER.log(Level.SEVERE,
                            String.format(PLAYER_RANGE, playerCount));
                } else {

                    GameContext gameContext = new GameContext(playerCount);

                    while (gameContext.getState() != null) {
                        gameContext.execute();
                    }

                    System.exit(gameContext.getExitStatus());
                }

            }
        } catch (ParseException e) {
            LOGGER.log(Level.SEVERE,
                    String.format(PARSE_EXCEPTION_MESSAGE, e.getMessage()));
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE,
                    String.format(NOT_A_NUMBER, e.getMessage()));
        }
        System.exit(1);
    }
}
