package bohnanza;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

import bohnanza.game.Bean;
import bohnanza.game.Type;
import bohnanza.game.player.Player;

public class View {

    private static final String EMPTY_STRING = "";

    public static final String KEEP = "Do you want to keep the '%s' card? (y/n)";

    public static final String YES = "y";

    public static final String NO = "n";

    private static final String NAME = "Enter player name %d:";

    private static final String MUST_PLANT = "You must plant your first card. Type the bean field number (1..%d) to plant in. Non empty bean fields will be harvested and sold.";

    private static final String MAY_PLANT = "You may plant your next first card. Type the bean field number (1..%d) to plant in. Non empty bean fields will be harvested and sold. Press enter to skip.";

    private static final String SELECT_AREA = "Select an area; h = hand, d = draw area:";

    private static final String SELECT_DRAW_AREA = "Select the type of beans from your draw area (seperate them by an enter, blank line ends selection, may select none):";

    private static final String SHOW_OPTION = "%s = %d, ";

    private static final String SELECT_HAND = "Select the card numbers from your hand (seperate them by an enter, blank line ends selection, may select none):";

    private static final String OFFER_PROPOSAL = "Player %s would like '%s' cards for '%s' cards from hand and '%s' cards from draw area, do you want to trade? (y/n):";

    private static final String ASK_TRADE = "Do you want to trade? (y/n):";

    private static final String CONFIRM_TRADE = "Do you accept the cards '%s' from player %s for your '%s' cards in your hand and '%s' in your draw area? (y/n):";

    private static final String SELECT_TYPE = "Select the type of beans (seperate them by an enter, blank line ends selection, may select none):";

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

        String line = null;

        while (line == null || (!line.equals(HAND) && !line.equals(DRAW_AREA))) {
            System.out.println(SELECT_AREA);
            line = scanner.nextLine();
        }

        return line;
    }

    public boolean askKeepCard(Player currentPlayer, Bean bean) {
        return confirm(String.format(KEEP, bean));
    }

    private boolean confirm(String message) {
        String line = null;

        while (line == null || (!line.equals(YES) && !line.equals(NO))) {
            System.out.println(message);

            line = scanner.nextLine();

        }

        return line == YES;

    }

    public Collection<Bean> getOptionsFromHand(Collection<Bean> options) {
        return getOptions(options, SELECT_HAND);
    }

    public Collection<Bean> getOptionsFromDrawArea(Collection<Bean> options) {
        return getOptions(options, SELECT_DRAW_AREA);
    }

    public Collection<Type> getOptionsFromType(Collection<Type> options) {
        return getOptions(options, SELECT_TYPE);
    }

    private <E extends Object> Collection<E> getOptions(Collection<E> options,
            String message) {

        String line = null;

        HashSet<E> result = new HashSet<E>();

        HashSet<Integer> numbers = new HashSet<Integer>();

        while (!line.equals(EMPTY_STRING)) {
            System.out.println(message);

            showOptions(options);

            line = scanner.nextLine();

            try {

                int number = Integer.parseInt(line) - 1;

                if (0 < number && number < options.size()) {
                    numbers.add(number);
                }

            } catch (NumberFormatException e) {
                // try again
            }
        }

        int i = 0;
        for (E option : options) {

            if (numbers.contains(i)) {
                result.add(option);
            }

            i++;
        }

        return result;
    }

    private void showOptions(Collection<? extends Object> options) {

        int i = 1;
        for (Object option : options) {
            System.out.println(String.format(SHOW_OPTION, option, i));
            i++;
        }

    }

    public Player getTradePartner(Collection<Type> proposal,
            Collection<Bean> cardsFromDrawArea, Collection<Bean> cardsFromHand,
            Player currentPlayer) {

        Player tradepartner = null;

        Player askPlayer = currentPlayer.getLeftPlayer();

        while (tradepartner == null && !askPlayer.equals(currentPlayer)) {

            boolean wantsTrade = confirm(String.format(OFFER_PROPOSAL,
                    currentPlayer, proposal, cardsFromHand, cardsFromDrawArea));

            if (wantsTrade) {
                tradepartner = askPlayer;
            } else {
                askPlayer = askPlayer.getLeftPlayer();
            }

        }

        return tradepartner;

    }

    public boolean askTrade() {
        return confirm(ASK_TRADE);
    }

    public boolean confirmTrade(Collection<Bean> cardsFromDrawArea,
            Collection<Bean> cardsFromHand, Player acceptingPlayer,
            Collection<Bean> counterProposal) {

        return confirm(String.format(CONFIRM_TRADE, counterProposal,
                acceptingPlayer, cardsFromHand, cardsFromDrawArea));

    }
}
