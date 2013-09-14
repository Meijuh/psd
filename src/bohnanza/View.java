package bohnanza;

import java.util.Scanner;

public class View {

    private static final String NAME = "Enter player name %d:";

    private final Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public String getName(int player) {
        System.out.println(String.format(NAME, player));

        return scanner.nextLine();
    }

}
