package bohnanza;

import java.util.Scanner;

import bohnanza.game.player.Player;

public class View {

    private static final String YEAR = "Birth year player %d (as yyyy):";

    private static final String MONTH = "Birth month player %d (as mm):";

    private static final String DAY = "Birth day player %d (as dd):";

    private static final String NAME = "Name player %d:";

    private static final String SHUFFLE = "Player '%s' press enter to shuffle cards:";

    private final Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public String getYear(int player) {
        System.out.println(String.format(YEAR, player));

        return scanner.nextLine();

    }

    public String getMonth(int player) {
        System.out.println(String.format(MONTH, player));

        return scanner.nextLine();
    }

    public String getDay(int player) {
        System.out.println(String.format(DAY, player));

        return scanner.nextLine();
    }

    public String getName(int player) {
        System.out.println(String.format(NAME, player));

        return scanner.nextLine();
    }

    public void shuffleCards(Player player) {
        System.out.println(String.format(SHUFFLE, player));

    }

}
