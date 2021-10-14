package factories;

import models.tickets.TicketQueueSystem;
import models.tickets.TicketType;
import models.tickets.Ticket;
import models.tickets.strategies.ChangeLanguageTicketResolutionStartegy;
import models.tickets.strategies.CheckWalletBalanceTicketResolutionStartegy;
import models.tickets.strategies.DefaultResolveTicketStrategy;
import models.tickets.strategies.TicketResolutionStrategy;

import java.util.HashMap;
import java.util.Map;

public class TicketFactory {

    private int lastId = 0;

    private final Map<TicketType, TicketResolutionStrategy> resolutionStartegies;

    public TicketFactory(TicketQueueSystem ticketQueueSystem) {
        this.resolutionStartegies = new HashMap<>();
        this.resolutionStartegies.put(TicketType.CHANGE_LANGUAGE, new ChangeLanguageTicketResolutionStartegy(ticketQueueSystem));
        this.resolutionStartegies.put(TicketType.CHECK_WALLET_BALANCE, new CheckWalletBalanceTicketResolutionStartegy(ticketQueueSystem));
        this.resolutionStartegies.put(TicketType.OTHERS, new DefaultResolveTicketStrategy(ticketQueueSystem));
    }

    public Ticket create(TicketType type, String description) {
        return new Ticket(++lastId, type, description, this.resolutionStartegies.get(type));
    }

}
