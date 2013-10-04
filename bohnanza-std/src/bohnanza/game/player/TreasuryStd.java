package bohnanza.game.player;

public class TreasuryStd extends Treasury {
    private static final String TO_STRING_MESSAGE = "treasury %d coins";

    @Override
    public String toString() {

        return String.format(TO_STRING_MESSAGE, getSize());
    }

}
