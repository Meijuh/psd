package bohnanza.view;

import java.util.Collection;
import java.util.HashSet;
import java.util.Observable;
import java.util.Scanner;

import bohnanza.game.Bean;
import bohnanza.game.Type;
import bohnanza.game.player.Player;

public class TUIView extends View {

    private static final String EMPTY_STRING = "";

    private static final String YES = "y";

    private static final String NO = "n";

    private static final String NAME = "Enter player name %d:";

    private static final String MUST_PLANT = "You must plant your first card. Type the bean field number (1..%d) to plant in. Non empty bean fields will be harvested and sold.";

    private static final String MAY_PLANT = "You may plant your next first card. Type the bean field number (1..%d) to plant in. Non empty bean fields will be harvested and sold. Press enter to skip.";

    private static final String SELECT_DRAW_AREA = "Select the type of beans from your draw area (seperate them by an enter, blank line ends selection, may select none):";

    private static final String SHOW_OPTION = "%s = %d, ";

    private static final String SELECT_HAND = "Select the card numbers from your hand (seperate them by an enter, blank line ends selection, may select none):";

    private static final String OFFER_PROPOSAL = "Player %s would like '%s' cards for '%s' cards from hand and '%s' cards from draw area, do you want to trade? (y/n):";

    private static final String ASK_TRADE = "Do you want to trade? (y/n):";

    private static final String CONFIRM_TRADE = "Do you accept the cards '%s' from player %s for your '%s' cards in your hand and '%s' in your draw area? (y/n):";

    private static final String SELECT_TYPE = "Select the type of beans (seperate them by an enter, blank line ends selection, may select none):";

    private static final String SELECT_KEEP_CARD = "Select the type of bean from your keep area (1..n):";

    private static final String BUY = "Do you want to buy a third bean field? (y/n):";

    private final Scanner scanner;

    public TUIView() {
        scanner = new Scanner(System.in);
    }

    /*
     * (non-Javadoc)
     * 
     * @see bohnanza.View#getName(int)
     */
    @Override
    public String getName(int player) {
        System.out.println(String.format(NAME, player));

        return scanner.nextLine();
    }

    /*
     * (non-Javadoc)
     * 
     * @see bohnanza.View#mustPlant(bohnanza.game.player.Player)
     */
    @Override
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

    /*
     * (non-Javadoc)
     * 
     * @see bohnanza.View#mayPlant(bohnanza.game.player.Player)
     */
    @Override
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

    private boolean confirm(String message) {
        String line = null;

        while (line == null || (!line.equals(YES) && !line.equals(NO))) {
            System.out.println(message);

            line = scanner.nextLine();

        }

        return line == YES;

    }

    /*
     * (non-Javadoc)
     * 
     * @see bohnanza.View#getOptionsFromHand(java.util.Collection)
     */
    @Override
    public Collection<Bean> getOptionsFromHand(Collection<Bean> options) {
        return getOptions(options, SELECT_HAND);
    }

    /*
     * (non-Javadoc)
     * 
     * @see bohnanza.View#getOptionsFromDrawArea(java.util.Collection)
     */
    @Override
    public Collection<Bean> getOptionsFromDrawArea(Collection<Bean> options) {
        return getOptions(options, SELECT_DRAW_AREA);
    }

    /*
     * (non-Javadoc)
     * 
     * @see bohnanza.View#getOptionFromKeepArea(java.util.Collection)
     */
    @Override
    public Bean getOptionFromKeepArea(Collection<Bean> options) {
        Bean result = null;

        while (result == null) {
            System.out.println(SELECT_KEEP_CARD);

            showOptions(options);

            String line = scanner.nextLine();

            try {
                int number = Integer.parseInt(line);

                if (0 < number && number < options.size()) {

                    int i = 1;
                    while (options.iterator().hasNext()) {

                        if (i == number) {
                            result = options.iterator().next();
                        }

                        i++;
                    }
                }

            } catch (NumberFormatException e) {
                // try again
            }
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see bohnanza.View#getOptionsFromType(java.util.Collection)
     */
    @Override
    public Collection<Type> getOptionsFromType(Type[] options) {
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

    /*
     * (non-Javadoc)
     * 
     * @see bohnanza.View#getTradePartner(java.util.Collection,
     * java.util.Collection, java.util.Collection, bohnanza.game.player.Player)
     */
    @Override
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

    /*
     * (non-Javadoc)
     * 
     * @see bohnanza.View#askTrade()
     */
    @Override
    public boolean askTrade() {
        return confirm(ASK_TRADE);
    }

    /*
     * (non-Javadoc)
     * 
     * @see bohnanza.View#confirmTrade(java.util.Collection,
     * java.util.Collection, bohnanza.game.player.Player, java.util.Collection)
     */
    @Override
    public boolean confirmTrade(Collection<Bean> cardsFromDrawArea,
            Collection<Bean> cardsFromHand, Player acceptingPlayer,
            Collection<Bean> counterProposal) {

        return confirm(String.format(CONFIRM_TRADE, counterProposal,
                acceptingPlayer, cardsFromHand, cardsFromDrawArea));

    }

    /*
     * (non-Javadoc)
     * 
     * @see bohnanza.View#confirmBuy()
     */
    @Override
    public boolean confirmBuy() {
        return confirm(BUY);
    }

    @Override
    public void update(Observable o, Object arg) {

        System.out.println(o);

    }
}
