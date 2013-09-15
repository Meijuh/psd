package bohnanza;

import java.util.Scanner;

import bohnanza.game.Bean;
import bohnanza.game.player.Player;

public class View {

    public static final String HAND = "h";

    public static final String DRAW_AREA = "d";

    public static final String KEEP = "Do you want to keep the '%s' card? (y/n)";

    public static final String YES = "y";

    public static final String NO = "n";

    private static final String NAME = "Enter player name %d:";

    private static final String MUST_PLANT = "You must plant your first card. Type the bean field number (1..%d) to plant in. Non empty bean fields will be harvested and sold.";

    private static final String MAY_PLANT = "You may plant your next first card. Type the bean field number (1..%d) to plant in. Non empty bean fields will be harvested and sold. Press enter to skip.";

    private static final String SELECT_AREA = "Select an area; h = hand, d = draw area:";

    private final Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public String getName(int player) {
        System.out.println(String.format(NAME, player));

        return scanner.nextLine();
    }

    public int mustPlant(Player player) {

        int beanField = -1;

        while (beanField == -1) {
            System.out.println(String.format(MUST_PLANT,
                    player.hasThirdBeanField() ? 3 : 2));

            try {
                beanField = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // ask again
            }
        }

        return beanField;

    }

    public int mayPlant(Player player) {

        int beanField = -1;

        boolean validInput = false;

        while (!validInput) {
            System.out.println(String.format(MAY_PLANT,
                    player.hasThirdBeanField() ? 3 : 2));

            try {
                beanField = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                // ask again
            }
        }

        return beanField;

    }

    public String selectCollection(Player currentPlayer) {

        String area = null;

        while (area == null) {
            String line = scanner.nextLine();

            if (line.equals(HAND) || line.equals(DRAW_AREA)) {
                area = line;
            }
        }

        return area;
    }

    public Bean selectCard(Player currentPlayer) {
        Bean card = null;

        while (card == null) {
            System.out.println(SELECT_PLANT);

            String line = scanner.nextLine();

            try {
                int number = Integer.parseInt(line);

                if (0 < number && currentPlayer.getHand().size() > number) {
                    card = currentPlayer.getFromHand(number - 1);
                }
            } catch (NumberFormatException e) {
                if (Bean.getBeanTypes().contains(line)) {
                    card = currentPlayer.getFromDrawArea(line);
                }
            }
        }
    }

    public boolean askKeepCard(Player currentPlayer, Bean bean) {
        String line = null;

        while (line != YES && line != NO) {
            System.out.println(String.format(KEEP, bean));

            line = scanner.nextLine();

        }

        return line == YES;
    }
}
