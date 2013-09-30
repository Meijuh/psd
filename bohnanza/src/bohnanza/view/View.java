package bohnanza.view;

import java.util.Collection;
import java.util.List;
import java.util.Observer;

import bohnanza.game.Bean;
import bohnanza.game.Type;
import bohnanza.game.player.Player;

public abstract class View implements Observer {

    public abstract String getName(int player);

    public abstract int mustPlant(Player player);

    public abstract int mayPlant(Player player);

    public abstract Collection<Bean> getOptionsFromHand(Collection<Bean> options);

    public abstract Collection<Bean> getOptionsFromDrawArea(
            Collection<Bean> options);

    public abstract Bean getOptionFromKeepArea(List<Bean> options);

    public abstract Collection<Type> getOptionsFromType(Collection<Type> options);

    public abstract Player getTradePartner(Collection<Type> proposal,
            Collection<Bean> cardsFromDrawArea, Collection<Bean> cardsFromHand,
            Player currentPlayer);

    public abstract boolean askTrade();

    public abstract boolean confirmTrade(Collection<Bean> cardsFromDrawArea,
            Collection<Bean> cardsFromHand, Player acceptingPlayer,
            Collection<Bean> counterProposal);

    public abstract boolean confirmBuy();

}